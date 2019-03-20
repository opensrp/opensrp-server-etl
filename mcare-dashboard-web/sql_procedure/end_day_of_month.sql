-- FUNCTION: public.end_day_of_month(double precision, double precision)

-- DROP FUNCTION public.end_day_of_month(double precision, double precision);

CREATE OR REPLACE FUNCTION public.end_day_of_month(
	month double precision,
	year double precision)
    RETURNS date
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE 
AS $BODY$

DECLARE
day_from_month text := year::text || '-' || month::text || '-' || '01';
val date;
  BEGIN
    select (date_trunc('month', day_from_month::date) + interval '1 month' - interval '1 day')::date into val;
    return val;
END;

$BODY$;

ALTER FUNCTION public.end_day_of_month(double precision, double precision)
    OWNER TO postgres;

