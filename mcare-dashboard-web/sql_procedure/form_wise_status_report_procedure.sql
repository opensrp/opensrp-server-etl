CREATE OR REPLACE FUNCTION generate_form_wise_report(filterArray text[])
RETURNS TABLE(visitcode character varying, schedulecount integer
              , completecount integer, expiredCount integer
              , expiredPercentage float)
AS $$
DECLARE
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
  start_date text := '';
  end_date text := '';
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
  start_date := filterArray[9];
  end_date := filterArray[10];

  /*Generating Temporary Table to populate aggregated values*/
  DROP TABLE IF EXISTS temp_table;
  EXECUTE format('
   CREATE TEMPORARY TABLE IF NOT EXISTS %I (
    visitCode varchar(70),
    scheduleCount int,
    completeCount int,
    expiredCount int,
    expiredPercentage float
   )', 'temp_table');

   /*Inserting all the visit codes except encc codes, to temporary table*/
   insert into temp_table(visitCode)
   select visit_code from "viewANCPNCNotSubmitted"
   where not visit_code = 'mis_elco'
   group by visit_code;

   /*Inserting ENCC visit codes to temporary table*/
   insert into temp_table(visitCode)
   select visit_code from "viewENCCNotSubmitted"
   group by visit_code;

   /*Creating conditional query string*/
   if (div != '') THEN
       filterString := E' where division=\'' || div || E'\'';
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
       IF(filterString != '') THEN
           filterString := filterString || E' and provider=\'' || pro || E'\'';
       ELSE
           filterString := filterString || E' where provider=\'' || pro || E'\'';
       END IF;
   END IF;

   completeCountFilterString := filterString;

   if (start_date != '' AND start_date != '') THEN
       if(filterString != '') THEN
           completeCountFilterString := completeCountFilterString
                             || E' and visit_date between \''|| start_date || E'\' and \''
                             || end_date || E'\'';
           filterString := filterString
                             || E' and start_date between \''|| start_date || E'\' and \''
                             || end_date || E'\'';
        ELSE
           completeCountFilterString := completeCountFilterString
                             || E' where visit_date between \''|| start_date || E'\' and \''
                             || end_date || E'\'';
           filterString := filterString
                             || E' where start_date between \''|| start_date || E'\' and \''
                             || end_date || E'\'';
        END IF;
   END IF;


   IF(filterString != '') THEN
       expiredConditionString := E' and alert_status = \'urgent\' and expiry_date < current_date';
   ELSE
       expiredConditionString := E' where alert_status = \'urgent\' and expiry_date < current_date';
   END IF;

   /*Query to update temp_table with schedule visit counts*/
   EXECUTE 'update temp_table
   set scheduleCount = scheduled.schedule_count from
   (select visit_code, count(*) from "viewANCPNCNotSubmitted" '
   || filterString
   || ' group by visit_code) as scheduled(visit_code, schedule_count)
   where temp_table.visitCode = scheduled.visit_code';

   /*Query to update temp_table with ENCC schedule visit counts*/
    EXECUTE 'update temp_table
   set scheduleCount = scheduled.schedule_count from
   (select visit_code, count(*) from "viewENCCNotSubmitted" '
   || filterString
   || ' group by visit_code) as scheduled(visit_code, schedule_count)
   where temp_table.visitCode = scheduled.visit_code';

   /*Query to update temp_table with completed ANC visit counts*/
   EXECUTE 'update temp_table
   set completeCount = completed.anccount from
   (select ancname, count(*) from "viewANCSubmitted" '
   || completeCountFilterString
   || ' group by ancname) as completed(ancname, anccount)
   where temp_table.visitCode = completed.ancname';

   /*Query to update temp_table with completed PNC visit counts*/
   EXECUTE 'update temp_table
   set completeCount = completed.pnccount from
   (select pncname, count(*) from "viewPNCSubmitted" '
   || completeCountFilterString
   || ' group by pncname) as completed(pncname, pnccount)
   where temp_table.visitCode = completed.pncname';

   /*Query to update temp_table with completed ENCC visit counts*/
   EXECUTE 'update temp_table
   set completeCount = completed.encccount from
   (select enccname, count(*) from "viewENCCSubmitted" '
   || completeCountFilterString
   || ' group by enccname) as completed(enccname, encccount)
   where temp_table.visitCode = completed.enccname';

   /*Query to update temp_table with completed BNF visit counts*/
   EXECUTE 'update temp_table
   set completeCount = completed.bnfcount from
   (select count(*) from "viewBNFSubmitted" '
   || completeCountFilterString
   || ') as completed(bnfcount)'
   || E' where temp_table.visitCode = \'BirthNotificationPregnancyStatusFollowUp\'';

   /*Query to update temp_table with completed PSRF visit counts*/
   EXECUTE 'update temp_table
   set completeCount = completed.psrfcount from
   (select count(*) from "viewPSRFSubmitted" '
   || completeCountFilterString
   || ') as completed(psrfcount)'
   || E' where temp_table.visitCode = \'ELCO PSRF\'';

   /*Query to update temp_table with Expired visit counts*/
   EXECUTE 'update temp_table
   set expiredCount = expired.expire_count from
   (select visit_code, count(*) from "viewANCPNCNotSubmitted"'
   || filterString
   || expiredConditionString
   || ' group by visit_code) as expired(visit_code, expire_count)
   where temp_table.visitCode = expired.visit_code';

   /*Query to update temp_table with only Expired ENCC visit counts*/
   EXECUTE 'update temp_table
   set expiredCount = expired.expire_count from
   (select visit_code, count(*) from "viewENCCNotSubmitted"'
   || filterString
   || expiredConditionString
   || ' group by visit_code) as expired(visit_code, expire_count)
   where temp_table.visitCode = expired.visit_code';

   /*Query to update temp_table with expired percentage values*/
   UPDATE temp_table
   SET expiredPercentage=(SELECT round(cast (subquery.expire_count as numeric)/cast ((subquery.schedule_count + subquery.complete_count + subquery.expire_count)as numeric)*100, 2))
   FROM (SELECT t.visitCode, t.scheduleCount, t.completeCount, t.expiredCount FROM temp_table t)
   AS subquery(visit_code, schedule_count, complete_count, expire_count)
   WHERE temp_table.visitCode = subquery.visit_code;

   /*Return whole temp_table data*/
   RETURN QUERY SELECT ttable.visitCode
       , coalesce(ttable.scheduleCount, 0) as scheduleCount
       , coalesce(ttable.completeCount, 0) as completeCount
       , coalesce(ttable.expiredCount, 0) as expiredCount
       , coalesce(ttable.expiredPercentage, 0) as expiredPercentage
       from temp_table ttable;

END;
$$ LANGUAGE plpgsql;