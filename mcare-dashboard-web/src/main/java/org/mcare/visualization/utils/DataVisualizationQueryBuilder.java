package org.mcare.visualization.utils;

import org.mcare.common.util.SearchCriteria;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class DataVisualizationQueryBuilder {

    @Autowired private LocationServiceImpl locationService;

    public static String getMonthWiseDataQuery(SearchBuilder searchBuilder, String table, String joinTable) {
        String query = "select date_part('month', date(a.received_time)),count(date_part('month', date(a.received_time)))"
                + " from " + table + " a "
                + " join " + joinTable + " m on (a.relationalid = m.case_id) "
                + " where date_part('year', date(a.received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) 
                + " group by  date_part('month', date(a.received_time)) "
                + " order by date_part('month', date(a.received_time)) asc";
        return query;
    }

    public static String getMonthWiseDataQuery(SearchBuilder searchBuilder, String table) {
        String query = "select date_part('month', date(received_time)),count(date_part('month', date(received_time)))"
                + " from " + table
                + " where date_part('year', date(received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) + " group by date_part('month', date(received_time)) "
                + " order by date_part('month', date(received_time)) asc";
        return query;
    }

    public static String getDayWiseDataQuery(SearchBuilder searchBuilder, String table, String joinTable) {
        String query = "select date(a.received_time) ,count(date(a.received_time)) "
                + " from " + table + " a "
                + " join " + joinTable + " m on (a.relationalid = m.case_id) "
                + "  where date_part('year', date(a.received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) 
                + " group by date(a.received_time) "
                + " order by date(a.received_time) asc";
        return query;
    }

    public static String getDayWiseDataQuery(SearchBuilder searchBuilder, String table) {
        String query = "select date(received_time) ,count(date(received_time)) " 
                + " from " + table
                + " where date_part('year', date(received_time)) = " + searchBuilder.getYear() + " "
                + SearchCriteria.getSearchCriteria(searchBuilder) + " group by date(received_time) "
                + " order by date(received_time) asc";
        return query;
    }

    public static String getMonthWiseDataFromProcedure(SearchBuilder searchBuilder, String filterString, String scheduleType) {
//        String query = "select * from " + procedureName + "(array[:division,:district,:upazila"
//                + ",:union,:ward,:subunit,:mauzapara,:provider,:year])";
        String year = searchBuilder.getYear();
        String query = "select *,\n" +
                "( case\n" +
                " when month = date_part('month', now()) and year = date_part('year', now())\n" +
                " then (select sum(due) from schedule_summary where day = now() - INTERVAL '1 DAY' and visit_type like '"+scheduleType+"%' and date_part('year', day) = '"+year+"' "+filterString+" )\n" +
                "else (select sum(due) from schedule_summary where day = to_date(concat('"+year+"-', month, '-01'), 'YYYY-MM-DD') + INTERVAL '1 MONTH' - INTERVAL '1 DAY' and visit_type like '"+scheduleType+"%' and date_part('year', day) = '"+year+"' "+filterString+" ) end) from (\n" +
                "\tselect date_part('year', day) as year, date_part('month', day) as month, sum(submitted) as submitted, sum(expired) as expired from schedule_summary where visit_type like '"+scheduleType+"%' and date_part('year', day) = '"+year+"' "+filterString+" group by date_part('year', day), date_part('month', day) order by year, month\n" +
                ") as temp;";
        return query;
    }
}
