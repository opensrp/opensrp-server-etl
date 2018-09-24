CREATE OR REPLACE FUNCTION pnc_data(filterArray text[])
RETURNS TABLE(
    ancScheduleType text
    , month float
    , schedulePercentage float
             )
AS $$
DECLARE
i text; 
ancScheduleTypes  text[] := '{"pending", "completed", "expired"}';
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
   ancScheduleType text
   , month float
   , schedulePercentage float
  );

  DROP TABLE IF EXISTS table_anc_schedule_type_percentage;
  CREATE TEMPORARY TABLE IF NOT EXISTS table_anc_schedule_type_percentage(
   ancScheduleType text
   , month float
   , schedulePercentage float
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

   FOREACH i IN ARRAY ancScheduleTypes
   LOOP 
   RAISE NOTICE '%', i;
   INSERT INTO helper_table (ancScheduleType , month)
   VALUES  (i, 1), (i, 2), (i, 3), (i, 4), (i, 5), (i, 6), (i, 7), (i, 8), (i, 9), (i, 10), (i, 11), (i, 12);
   END LOOP;

   EXECUTE E'update helper_table
   set schedulePercentage = anc2.schedulePercentage 
   from
   (select date_part(\'month\', date(a.start_date)),count(date_part(\'month\', date(a.start_date)))
     from "viewANCPNCNotSubmitted" a
     where visit_code like \'%pncrv_%\' '
     || filterString
     || E' group by  date_part(\'month\', date(a.start_date))
     order by date_part(\'month\', date(a.start_date)) asc) 
   as anc2(month, schedulePercentage)
   where helper_table.ancScheduleType = \'pending\'
   and helper_table.month = anc2.month';

                        
   /*completed scheudule counts*/
   EXECUTE E'update helper_table
   set schedulePercentage = anc2.schedulePercentage 
   from
   (select date_part(\'month\', date(a.received_time)),count(date_part(\'month\', date(a.received_time)))
     from "viewPNCSubmitted" a
     where pncname like \'%pncrv_%\''
     || completeCountFilterString
     || E' group by  date_part(\'month\', date(a.received_time))
     order by date_part(\'month\', date(a.received_time)) asc) 
   as anc2(month, schedulePercentage)
   where helper_table.ancScheduleType = \'completed\'
   and helper_table.month = anc2.month';

   /* expired schedules*/
   EXECUTE E'update helper_table
   set schedulePercentage = anc2.schedulePercentage 
   from
   (select date_part(\'month\', date(a.start_date)),count(date_part(\'month\', date(a.start_date)))
     from "viewANCPNCNotSubmitted" a
     where alert_status = \'urgent\' and expiry_date < current_date '
     || filterString
     || E' and visit_code like \'%pncrv_%\'
     group by  date_part(\'month\', date(a.start_date))
     order by date_part(\'month\', date(a.start_date)) asc) 
   as anc2(month, schedulePercentage)
   where helper_table.ancScheduleType = \'expired\'
   and helper_table.month = anc2.month';
                        
 
   /*insert into table_anc_schedule_type_percentage(ancScheduleType, month, schedulePercentage)
   select ht.ancScheduleType, ht.month, ht.schedulePercentage
   from helper_table ht;
    
   UPDATE table_anc_schedule_type_percentage tt
   SET schedulePercentage=(SELECT round(cast (tt.schedulePercentage as numeric)
                                        /cast (subquery.sum_schedulepercentage as numeric)*100, 2))
   FROM (select ht.month, sum(ht.schedulepercentage)
                             from helper_table ht
                             group by ht.month)
   AS subquery(month, sum_schedulepercentage)
   WHERE tt.month = subquery.month;*/

   /*Return whole dashboard_data_count data*/
   RETURN QUERY SELECT ttable.ancScheduleType
       , ttable.month
       , coalesce(ttable.schedulePercentage, 0) as schedulePercentage
       from helper_table ttable
        order by ancScheduleType, month;
END;
$$ LANGUAGE plpgsql;

select * from pnc_data(array['','','','','','','','','']);
