package org.mcare.visualization.utils;

import org.mcare.common.util.SearchCriteria;
import org.mcare.params.builder.SearchBuilder;

public class DataVisualizationQueryBuilder {

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

    public static String getMonthWiseDataFromProcedure(SearchBuilder searchBuilder, String table, String joinTable) {
        String query = "select * from anc_data" + "(array[:division,:district,:upazila"
                + ",:union,:ward,:subunit,:mauzapara,:provider,:year])";
        return query;
    }
}
