CREATE OR REPLACE FUNCTION generate_provider_wise_report(filterArray text[])
RETURNS TABLE(visitcode character varying, schedulecount integer
              , completecount integer, expiredCount integer
              , expiredPercentage float)
AS $$
DECLARE
  filterString text := '';
  completeCountFilterString text := '';
  expiredConditionString text := '';
  formConditionString text := '';
  div text := '';
  dis text := '';
  upa text := '';
  uni text := '';
  war text := '';
  sub text := '';
  mau text := '';
  form text := '';
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
  form := filterArray[8];
  start_date := filterArray[9];
  end_date := filterArray[10];

  /*Generating Temporary Table to populate aggregated values*/
  DROP TABLE IF EXISTS provider_temp_table;
  EXECUTE format('
   CREATE TEMPORARY TABLE IF NOT EXISTS %I (
    provider varchar(70),
    scheduleCount int,
    completeCount int,
    expiredCount int,
    expiredPercentage float
   )', 'provider_temp_table');

   /*Creating a helper Temporary Table to populate aggregated values*/
   DROP TABLE IF EXISTS helper_table;
   CREATE TABLE helper_table (
    provider varchar(70),
    counts int
   );

   /*Creating location conditions query string*/
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

   completeCountFilterString := filterString;

   /*Creating date conditions query string*/
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

   /*Creating form conditions query string only for sheduled and expired count*/
   IF (form != '') THEN
       IF(filterString != '') THEN
           filterString := filterString || E' and visit_code=\'' || form || E'\'';
       ELSE
           filterString := filterString || E' where visit_code=\'' || form || E'\'';
       END IF;
   END IF;

   /*Creating expired count conditions query string */
   IF(filterString != '') THEN
       expiredConditionString := E' and alert_status = \'urgent\' and expiry_date < current_date';
   ELSE
       expiredConditionString := E' where alert_status = \'urgent\' and expiry_date < current_date';
   END IF;

   /*inserting all the provider name into temporary table */
   insert into provider_temp_table(provider) select p.provider from provider p;

   /*inserting schedule count into helper table*/
   EXECUTE 'insert into helper_table(provider, counts)
   select provider, count(*) 
   from "viewANCPNCNotSubmitted" '
   || filterString
   || ' group by provider union select provider, count(*) from "viewENCCNotSubmitted"'
   || filterString
   || ' group by provider
   order by provider';

    /*updating temporary table with schedule count*/
    update provider_temp_table
    set scheduleCount = scheduled.counts from
    (select provider, SUM(counts) from helper_table
     group by provider) as scheduled(providername, counts)
    where provider_temp_table.provider = scheduled.providername;

    TRUNCATE helper_table;

    /*inserting completed count into helper table*/
    IF(form != '') THEN
        IF(completeCountFilterString != '') THEN
            IF (form = 'ancrv_1' OR form = 'ancrv_2' OR form = 'ancrv_3' OR form = 'ancrv_4') THEN
               formConditionString := E' and ancname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewANCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF(form = 'pncrv_1' OR form = 'pncrv_2' OR form = 'pncrv_3') THEN
               formConditionString := E' and pncname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewPNCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF(form = 'enccrv_1' OR form = 'enccrv_2' OR form = 'enccrv_3') THEN
               formConditionString := E' and enccname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewENCCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF (form = 'BirthNotificationPregnancyStatusFollowUp') THEN
               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewBNFSubmitted" '
               || completeCountFilterString
               || ' group by provider';
            END IF;
            IF (form = 'ELCO PSRF') THEN
               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewPSRFSubmitted" '
               || completeCountFilterString
               || ' group by provider';
            END IF;
       ELSE
           IF (form = 'ancrv_1' OR form = 'ancrv_2' OR form = 'ancrv_3' OR form = 'ancrv_4') THEN
               formConditionString := E' where ancname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewANCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF(form = 'pncrv_1' OR form = 'pncrv_2' OR form = 'pncrv_3') THEN
               formConditionString := E' where pncname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewPNCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF(form = 'enccrv_1' OR form = 'enccrv_2' OR form = 'enccrv_3') THEN
               formConditionString := E' where enccname = \'' || form || E'\'';

               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewENCCSubmitted" '
               || completeCountFilterString
               || formConditionString
               || ' group by provider';
            END IF;
            IF (form = 'BirthNotificationPregnancyStatusFollowUp') THEN
               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewBNFSubmitted" '
               || completeCountFilterString
               || ' group by provider';
            END IF;
            IF (form = 'ELCO PSRF') THEN
               EXECUTE 'insert into helper_table(provider, counts)
               select provider, count(*)
               from "viewPSRFSubmitted" '
               || completeCountFilterString
               || ' group by provider';
            END IF;
        END IF;
    ELSE
        EXECUTE 'insert into helper_table(provider, counts)
        select provider, count(*)
        from "viewENCCSubmitted" '
        || completeCountFilterString
        || ' group by provider
        union
        select provider, count(*) from "viewANCSubmitted" '
        || completeCountFilterString
        || ' group by provider
        union
        select provider, count(*) from "viewPNCSubmitted" '
        || completeCountFilterString
        || ' group by provider
        union
        select provider, count(*) from "viewBNFSubmitted" '
        || completeCountFilterString
        || ' group by provider
        union
        select provider, count(*) from "viewPSRFSubmitted" '
        || completeCountFilterString
        || ' group by provider
        order by provider';
    END IF;

    /*updating temporary table with completed count*/
    update provider_temp_table
    set completeCount = completed.counts from
    (select provider, SUM(counts) from helper_table
      group by provider) as completed(providername, counts)
    where provider_temp_table.provider = completed.providername;

    TRUNCATE helper_table;

    /*inserting expired count into helper table*/
    EXECUTE 'insert into helper_table(provider, counts)
    select provider, count(*) from "viewANCPNCNotSubmitted" '
    || filterString
    || expiredConditionString
    || ' group by provider
    union 
    select provider, count(*) from "viewENCCNotSubmitted" '
    || filterString
    || expiredConditionString
    || ' group by provider';

    /*updating temporary table with expired count*/
    update provider_temp_table
    set expiredCount = expired.counts from
    (select provider, SUM(counts) from helper_table
      group by provider) as expired(providername, counts)
    where provider_temp_table.provider = expired.providername;

    DROP table helper_table;

    /*Query to update temporary table with expired percentage values*/
    UPDATE provider_temp_table
    SET expiredPercentage=(SELECT round(cast (subquery.expire_count as numeric)/cast ((subquery.schedule_count + subquery.complete_count + subquery.expire_count)as numeric)*100, 2))
    FROM (SELECT t.provider, t.scheduleCount, t.completeCount, t.expiredCount FROM provider_temp_table t)
    AS subquery(provider, schedule_count, complete_count, expire_count)
    WHERE provider_temp_table.provider = subquery.provider;

   /*Return whole temporary table data*/
   RETURN QUERY SELECT ttable.provider
       , coalesce(ttable.scheduleCount, 0) as scheduleCount
       , coalesce(ttable.completeCount, 0) as completeCount
       , coalesce(ttable.expiredCount, 0) as expiredCount
       , coalesce(ttable.expiredPercentage, 0) as expiredPercentage
       from provider_temp_table ttable;

END;
$$ LANGUAGE plpgsql;