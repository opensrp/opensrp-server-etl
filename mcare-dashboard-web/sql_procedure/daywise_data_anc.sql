CREATE OR REPLACE FUNCTION daywise_data_anc(filterArray text[])
RETURNS TABLE(
    days date
    , scheduleCounts int
	, scheduleType text
    )
AS $$
DECLARE
i text;
  scheduleTypes  text[] := '{"pending", "completed", "expired"}';
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
						   
  /*Generating Temporary Table to populate aggregated values TEMPORARY*/
  DROP TABLE IF EXISTS helper_table;
  CREATE TEMPORARY TABLE IF NOT EXISTS helper_table (
   scheduleType text
   , days date
   , scheduleCounts int
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

   EXECUTE E'insert into helper_table(days, scheduleCounts)
    select date(a.received_time), count(date(a.received_time)) 
	from "viewANCSubmitted" a
	where date_part(\'year\', date(a.received_time)) = '
	|| years
    || completeCountFilterString
    || E' group by date(a.received_time)
	order by date(a.received_time) asc';

   /*completed scheudule counts*/
   EXECUTE E'update helper_table
   set scheduleType = \'completed\'';

   EXECUTE E'insert into helper_table(days, scheduleCounts)
	select date(a.expiry_date - 1) , count(date(a.expiry_date)) 
	from "viewANCPNCNotSubmitted" a
	where a.expiry_date - 1 < a.expiry_date
	and is_action_active = \'true\'
	and visit_code like \'%ancrv_%\'
	and date_part(\'year\', date(a.expiry_date - 1)) = '
    || years
	|| filterString
	|| E' group by date(a.expiry_date - 1)
	order by date(a.expiry_date - 1) asc';
						   
   /*pending scheudule counts*/
   EXECUTE E'update helper_table
   set scheduleType = \'pending\'
   where scheduleType is null';
						   
   EXECUTE E'insert into helper_table(days, scheduleCounts)
	select date(a.expiry_date + 1) , count(date(a.expiry_date)) 
	from "viewANCPNCNotSubmitted" a
	where a.expiry_date < a.expiry_date + 1
	and is_action_active = \'true\'
	and visit_code like \'%ancrv_%\'
	and date_part(\'year\', date(a.expiry_date + 1)) = '
    || years
	|| E' and a.expiry_date < current_date '
	|| filterString
	|| E' group by date(a.expiry_date + 1)
	order by date(a.expiry_date + 1) asc';
						   
   /*pending scheudule counts*/
   EXECUTE E'update helper_table
   set scheduleType = \'expired\'
   where scheduleType is null';

   /*Return whole dashboard_data_count data*/
   RETURN QUERY SELECT 
        ttable.days
       , coalesce(ttable.scheduleCounts, 0) as scheduleCounts
	   , ttable.scheduleType
       from helper_table ttable
       order by scheduleType, days;
END;
$$ LANGUAGE plpgsql;

select * from daywise_data_anc(array['','','','','','','','','']);
