CREATE OR REPLACE FUNCTION daywise_data(filterArray text[])
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
    select date(a.received_time) ,count(date(a.received_time)) 
	from anc a 
	join mother m on (a.relationalid = m.case_id)
	where date_part(\'year\', date(a.received_time)) = 2018 '
    || completeCountFilterString
    || E' group by date(a.received_time)
	order by date(a.received_time) asc';

   /*completed scheudule counts*/
   EXECUTE E'update helper_table
   set scheduleType = \'completed\'';

   EXECUTE E'insert into helper_table(days, scheduleCounts)
    select date(a.received_time) ,count(date(a.received_time)) 
	from pnc a 
	join mother m on (a.relationalid = m.case_id)
	where date_part(\'year\', date(a.received_time)) = 2018 '
    || completeCountFilterString
    || E' group by date(a.received_time)
	order by date(a.received_time) asc';
						   
   /*pending scheudule counts*/
   EXECUTE E'update helper_table
   set scheduleType = \'pending\'
   where scheduleType is null';
						   
   EXECUTE E'insert into helper_table(days, scheduleCounts)
    select date(a.received_time) ,count(date(a.received_time)) 
	from encc a 
	join child m on (a.relationalid = m.case_id)
	where date_part(\'year\', date(a.received_time)) = 2018 '
    || completeCountFilterString
    || E' group by date(a.received_time)
	order by date(a.received_time) asc';
						   
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

select * from daywise_data(array['','','','','','','','','']);
