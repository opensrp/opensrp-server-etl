-- FUNCTION: public.pnc_data(text[])

-- DROP FUNCTION public.pnc_data(text[]);

CREATE OR REPLACE FUNCTION public.pnc_data(
	filterarray text[])
    RETURNS TABLE(ancscheduletype text, month double precision, schedulepercentage double precision) 
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
    ROWS 1000
AS $BODY$

DECLARE
i text;
ancScheduleTypes  text[] := '{"pending", "completed", "expired"}';
monthArray  integer[] := '{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}';
  countPending integer;
  filterString text := '';
  completeCountFilterString text := '';
  expiredConditionString text := '';
  div text := '';
  dis text := '';
  upa text := '';
  uni text := '';
  war text := '';
  sub text := '';
  mau text := '';
  pro text := '';
  years text := '';
  monthToLoop int := 12;
  monthNumber int := 1;
BEGIN
  /*Search Filter Assignments*/
  div := upper(filterArray[1]);
  dis := upper(filterArray[2]);
  upa := filterArray[3];
  uni := filterArray[4];
  war := filterArray[5];
  sub := filterArray[6];
  mau := filterArray[7];
  pro := filterArray[8];
  years := filterArray[9];
  IF (years = '') THEN
      years = date_part('year', current_date);
  END IF;
  RAISE NOTICE '%', years;	
										   
  /*Generating Temporary Table to populate aggregated values TEMPORARY*/
  DROP TABLE IF EXISTS helper_table;
  CREATE TEMPORARY TABLE IF NOT EXISTS helper_table (
   ancScheduleType text
   , month float
   , schedulePercentage float
  );

  DROP TABLE IF EXISTS temp_table;
  CREATE TEMPORARY TABLE IF NOT EXISTS temp_table (
   month date
   , scheduleCount float
  );

   /*Creating conditional query string*/
   if (div != '') THEN
       filterString := E' and division=\'' || div || E'\'';
   END IF;

   if (dis != '') THEN
       filterString := filterString || E' and district=\'' || dis || E'\'';
   END IF;

   if (upa != '') THEN
       filterString := filterString || E' and upazila=\'' || upa || E'\'';
   END IF;

   if (uni != '') THEN
       filterString := filterString || E' and unions=\'' || uni || E'\'';
   END IF;

   if (war != '') THEN
       filterString := filterString || E' and ward=\'' || war || E'\'';
   END IF;

   if (sub != '') THEN
       filterString := filterString || E' and subunit=\'' || sub || E'\'';
   END IF;

   if (mau != '') THEN
       filterString := filterString || E' and mauza_para=\'' || mau || E'\'';
   END IF;

   IF (pro != '') THEN
           filterString := filterString || E' and provider=\'' || pro || E'\'';
   END IF;

   completeCountFilterString := filterString;

   IF (years != '') THEN
           filterString := filterString || E' and date_part(\'year\', date(a.start_date))=\'' || years || E'\'';
           completeCountFilterString := completeCountFilterString
                           || E' and date_part(\'year\', date(a.received_time))=\''
                           || years || E'\'';
   END IF;
						   
    IF (years = CAST(date_part('year', date(current_date)) as text) ) THEN
        monthToLoop = date_part('month', date(current_date));
    END IF;
    RAISE NOTICE '%', monthToLoop;

   FOREACH i IN ARRAY ancScheduleTypes
   LOOP
   /*RAISE NOTICE '%', i; */
   INSERT INTO helper_table (ancScheduleType , month)
   VALUES  (i, 1), (i, 2), (i, 3), (i, 4), (i, 5), (i, 6), (i, 7), (i, 8), (i, 9), (i, 10), (i, 11), (i, 12);
   END LOOP;
			   
	/* pending schedules*/
-- 	LOOP 
--  		EXIT WHEN monthNumber > monthToLoop ;
-- 		RAISE NOTICE '%', monthNumber;
		
-- 		EXECUTE E'UPDATE helper_table 
-- 	SET schedulePercentage = c.pendingCount
-- 	from (
-- 		select count(*)
-- 		from "viewANCPNCNotSubmitted" a
-- 		where is_action_active = \'true\' 
-- 		and expiry_date > end_day_of_month(' || monthNumber || ', ' || years || ')'
-- 		|| E' and visit_code like \'%ancrv_%\' '
--      || filterString
--      || E' ) as c(pendingCount) where helper_table.month = ' || monthNumber			   
-- 	|| E' and helper_table.ancScheduleType = \'pending\' ';
											  
--  		monthNumber := monthNumber + 1 ;
--  	END LOOP ;		
											  
	/* pending schedules*/
	EXECUTE E'insert into temp_table(month, scheduleCount)
	select date(a.expiry_date - 1) , count(date(a.expiry_date)) 
	from "viewANCPNCNotSubmitted" a
	where a.expiry_date - 1 < a.expiry_date
	and is_action_active = \'true\'
	and visit_code like \'%pncrv_%\'
	and date_part(\'year\', date(a.expiry_date - 1)) = '
    || years
	|| E' and date_part(\'month\', date(a.expiry_date - 1)) <= ' || monthToLoop
	|| filterString
	|| E' group by date(a.expiry_date - 1)
	order by date(a.expiry_date - 1) asc';
							   
	EXECUTE E'UPDATE helper_table 
	SET schedulePercentage = c.pendingCount
	from (
		select date_part(\'month\', date(a.month)), sum(schedulecount)
		from temp_table a
		group by  date_part(\'month\', date(a.month))
		order by date_part(\'month\', date(a.month)) asc)
		as c(monthNumber, pendingCount) 
		where helper_table.month = c.monthNumber		   
	    and helper_table.ancScheduleType = \'pending\' ';
	
	TRUNCATE TABLE temp_table;

   /*completed scheudule counts*/
   EXECUTE E'update helper_table
   set schedulePercentage = anc2.schedulePercentage
   from
   (select date_part(\'month\', date(a.received_time)),count(date_part(\'month\', date(a.received_time)))
     from "viewPNCSubmitted" a
     where pncname like \'%pncrv_%\'
	 and date_part(\'year\', date(a.received_time)) = '
     || years
     || completeCountFilterString
     || E' group by  date_part(\'month\', date(a.received_time))
     order by date_part(\'month\', date(a.received_time)) asc)
   as anc2(month, schedulePercentage)
   where helper_table.ancScheduleType = \'completed\'
   and helper_table.month = anc2.month';

   /* expired schedules*/
	EXECUTE E'insert into temp_table(month, scheduleCount)
	select date(a.expiry_date + 1) , count(date(a.expiry_date)) 
	from "viewANCPNCNotSubmitted" a
	where a.expiry_date < a.expiry_date + 1
	and is_action_active = \'true\'
	and visit_code like \'%pncrv_%\'
	and date_part(\'year\', date(a.expiry_date + 1)) = '
    || years
	|| E' and a.expiry_date < current_date '
	|| filterString
	|| E' group by date(a.expiry_date + 1)
	order by date(a.expiry_date + 1) asc';
							   
	EXECUTE E'UPDATE helper_table 
	SET schedulePercentage = c.pendingCount
	from (
		select date_part(\'month\', date(a.month)), sum(schedulecount)
		from temp_table a
		group by  date_part(\'month\', date(a.month))
		order by date_part(\'month\', date(a.month)) asc)
		as c(monthNumber, pendingCount) 
		where helper_table.month = c.monthNumber		   
	    and helper_table.ancScheduleType = \'expired\' ';

   /*Return whole dashboard_data_count data*/
   RETURN QUERY SELECT ttable.ancScheduleType
       , ttable.month
       , coalesce(ttable.schedulePercentage, 0) as schedulePercentage
       from helper_table ttable
        order by ancScheduleType, month;
END;

$BODY$;

ALTER FUNCTION public.pnc_data(text[])
    OWNER TO postgres;
