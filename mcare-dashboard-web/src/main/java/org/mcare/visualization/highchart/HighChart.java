package org.mcare.visualization.highchart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.mcare.common.util.DateUtil;
import org.mcare.common.util.DateUtil.Months;

public class HighChart {

    public static JSONArray getMonthWiseSeriesData(List<Object[]> monthWiseCountData) throws JSONException {

        JSONArray monthWiseSeriesData = new JSONArray();
        for (Object[] row : monthWiseCountData) {
            Double monthNumber = Double.parseDouble(row[0].toString());
            JSONObject monthWiseData = new JSONObject();
            monthWiseData.put("name", DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
            monthWiseData.put("y", row[1]);
            monthWiseData.put("drilldown", DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
            monthWiseSeriesData.put(monthWiseData);

        }
        return monthWiseSeriesData;
    }

    public static JSONArray getMultiBarChartData(List<Object[]> monthWiseCountData) throws JSONException {
        JSONArray lineChartSeriesData = new JSONArray();
        String scheduleType = "";
        JSONArray array = new JSONArray();
        JSONObject dataJsonObject = new JSONObject();

        if (monthWiseCountData != null) {
            for (Object[] row : monthWiseCountData) {
                if (scheduleType.equalsIgnoreCase("")
                        || String.valueOf(row[0]).equalsIgnoreCase(scheduleType)) {
                    array.put(row[2]);
                    scheduleType = String.valueOf(row[0]);
                } else {
                    dataJsonObject.put("name", scheduleType);
                    dataJsonObject.put("data", array);
                    lineChartSeriesData.put(dataJsonObject);

                    array = new JSONArray();
                    dataJsonObject = new JSONObject();
                    array.put(row[2]);
                    scheduleType = String.valueOf(row[0]);
                }
            }
            dataJsonObject.put("name", scheduleType);
            dataJsonObject.put("data", array);
            lineChartSeriesData.put(dataJsonObject);
        }
        return lineChartSeriesData;
    }

    public static JSONObject getTypeWiseData(List<Object[]> monthWiseCountData, String scheduleType, String color) throws JSONException {
        JSONObject typeWiseData = new JSONObject();
        JSONArray monthWiseArrayData = new JSONArray();
        for (Object[] row: monthWiseCountData) {
            if (String.valueOf(row[0]).equalsIgnoreCase(scheduleType)) {
                JSONObject monthWiseData = new JSONObject();
                Double monthNumber = Double.parseDouble(row[1].toString());
                monthWiseData.put("name", DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseData.put("y", row[2]);
                monthWiseData.put("drilldown", scheduleType + "_" + DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseArrayData.put(monthWiseData);
            }
        }

        typeWiseData.put("name", scheduleType);
        typeWiseData.put("color", color);
        typeWiseData.put("data", monthWiseArrayData);
        if (scheduleType.equalsIgnoreCase("pending")) typeWiseData.put("colorByPoint", false);
        return typeWiseData;
    }

    public static JSONArray getMonthWiseSeriesDataForMultiBarWithDrillDownNew(List<Object[]> monthWiseCountData) throws JSONException {
        JSONArray monthWiseSeriesData = new JSONArray();
        monthWiseSeriesData.put(getTypeWiseData(monthWiseCountData, "completed", "#008000"));
        monthWiseSeriesData.put(getTypeWiseData(monthWiseCountData, "expired", "#FF0000"));
        monthWiseSeriesData.put(getTypeWiseData(monthWiseCountData, "pending", "#FFFF00"));

        return monthWiseSeriesData;
    }

    public static JSONArray getMonthWiseSeriesDataForMultiBarWithDrillDown(List<Object[]> monthWiseCountData) throws JSONException {
        JSONArray monthWiseSeriesData = new JSONArray();
        JSONObject typeWiseData = new JSONObject();
        JSONArray monthWiseArrayData = new JSONArray();
        JSONObject monthWiseData = new JSONObject();
        String scheduleType = "";

        for (Object[] row : monthWiseCountData) {
            if (scheduleType.equalsIgnoreCase("")
                    || String.valueOf(row[0]).equalsIgnoreCase(scheduleType)) {

                scheduleType = String.valueOf(row[0]);
                Double monthNumber = Double.parseDouble(row[1].toString());
                monthWiseData = new JSONObject();
                monthWiseData.put("name", DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseData.put("y", row[2]);
                monthWiseData.put("drilldown", scheduleType + "_" + DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseArrayData.put(monthWiseData);

            } else {
                typeWiseData.put("name", scheduleType);
                if (scheduleType.equalsIgnoreCase("completed")) {
                    typeWiseData.put("color", "#008000");
                }
                if (scheduleType.equalsIgnoreCase("pending")) {
                    typeWiseData.put("color", "#FFFF00");
                }
                if (scheduleType.equalsIgnoreCase("expired")) {
                    typeWiseData.put("color", "#FF0000");
                }
                typeWiseData.put("data", monthWiseArrayData);

                monthWiseSeriesData.put(typeWiseData);

                scheduleType = String.valueOf(row[0]);
                monthWiseArrayData = new JSONArray();
                typeWiseData = new JSONObject();
                Double monthNumber = Double.parseDouble(row[1].toString());
                monthWiseData = new JSONObject();
                monthWiseData.put("name", DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseData.put("y", row[2]);
                monthWiseData.put("drilldown", scheduleType + "_" + DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
                monthWiseArrayData.put(monthWiseData);

            }

        }
        typeWiseData.put("name", scheduleType);
        if (scheduleType.equalsIgnoreCase("completed")) {
            typeWiseData.put("color", "#008000");
        }
        if (scheduleType.equalsIgnoreCase("pending")) {
            typeWiseData.put("color", "#FFFF00");
        }
        if (scheduleType.equalsIgnoreCase("expired")) {
            typeWiseData.put("color", "#FF0000");
        }
        typeWiseData.put("data", monthWiseArrayData);
        typeWiseData.put("colorByPoint", false);
        monthWiseSeriesData.put(typeWiseData);

        return monthWiseSeriesData;
    }

    public static JSONArray getDayWiseDataObject(List<Object[]> dayWiseCountData, String scheduleType) throws JSONException {
        JSONArray monthWiseDataArray = new JSONArray();
        JSONObject scheduleTypeWiseMonthData = new JSONObject();
        JSONArray monthData = new JSONArray();

        int month = 1;

        for (Object[] row: dayWiseCountData) {
            String date = String.valueOf(row[0]);
            String[] split = date.split("-");
            int monthNumber = Integer.parseInt(split[1]);
            if (monthNumber != month) {
                scheduleTypeWiseMonthData.put("data", monthData);
                scheduleTypeWiseMonthData.put("name", DateUtil.getMonthName(month - 1));
                scheduleTypeWiseMonthData.put("id", scheduleType + "_" + DateUtil.getMonthName(month - 1));
                monthWiseDataArray.put(scheduleTypeWiseMonthData);
                month = monthNumber;
                monthData = new JSONArray();
                scheduleTypeWiseMonthData = new JSONObject();
            }
            if (String.valueOf(row[2]).equalsIgnoreCase(scheduleType)) {
                JSONArray array = new JSONArray();
                array.put(row[0]);
                array.put(row[1]);
                array.put(row[2]);
                monthData.put(array);
            }
        }
        scheduleTypeWiseMonthData.put("data", monthData);
        scheduleTypeWiseMonthData.put("name", DateUtil.getMonthName(month - 1));
        scheduleTypeWiseMonthData.put("id", scheduleType + "_" + DateUtil.getMonthName(month - 1));
        monthWiseDataArray.put(scheduleTypeWiseMonthData);

        return monthWiseDataArray;
    }

    public static JSONArray getDayWiseDrilldownSeriesDataForMultiGraphsNew(List<Object[]> dayWiseCountData) throws JSONException {
        JSONArray dataJsonArray = new JSONArray();
        JSONArray completed = getDayWiseDataObject(dayWiseCountData, "completed");
        JSONArray expired = getDayWiseDataObject(dayWiseCountData, "expired");
        JSONArray pending = getDayWiseDataObject(dayWiseCountData, "pending");

        for (int i = 0; i < completed.length(); i++) {
            JSONObject jsonObject = completed.getJSONObject(i);
            dataJsonArray.put(jsonObject);
        }
        for (int i = 0; i < expired.length(); i++) {
            JSONObject jsonObject = expired.getJSONObject(i);
            dataJsonArray.put(jsonObject);
        }
        for (int i = 0; i < pending.length(); i++) {
            JSONObject jsonObject = pending.getJSONObject(i);
            dataJsonArray.put(jsonObject);
        }

        return dataJsonArray;
    }

    public static JSONArray getDayWiseDrilldownSeriesDataForMultiGraphs(List<Object[]> dayWiseCountData) {

        JSONArray dataJsonArray = new JSONArray();
        try {
            JSONArray DataAsArray = getDayWiseDataAsGroupForMultiGraphs(dayWiseCountData);
            JSONObject dataObject = new JSONObject();
            int monthNumber = 0;
            dataJsonArray = new JSONArray();

            for (int i = 0; i < DataAsArray.length(); i++) {
                JSONArray DayWiseDataAsArray = (JSONArray) DataAsArray.get(i);
                /*
                 * calculate month number
                 * */
                System.err.println("fff;" + DayWiseDataAsArray.toString());
                JSONArray firstData = (JSONArray) DayWiseDataAsArray.get(0);
                String splitData[] = firstData.get(0).toString().split("-");
                monthNumber = Integer.parseInt(splitData[1]);

                String scheduleType = firstData.get(2).toString();

                dataObject = new JSONObject();
                dataObject.put("name", DateUtil.getMonthName(monthNumber - 1));

                if (scheduleType.equalsIgnoreCase("completed")) {
                    dataObject.put("id", scheduleType + "_" + DateUtil.getMonthName(monthNumber - 1));
                } else if (scheduleType.equalsIgnoreCase("pending")) {
                    dataObject.put("id", scheduleType + "_" + DateUtil.getMonthName(monthNumber - 1));
                } else {
                    dataObject.put("id", scheduleType + "_" + DateUtil.getMonthName(monthNumber - 1));
                }

                JSONArray array = new JSONArray();
                for (int j = 0; j < DayWiseDataAsArray.length(); j++) {
                    array.put(DayWiseDataAsArray.get(j));
                }
                dataObject.put("data", array);
                dataJsonArray.put(dataObject);

            }
        }
        catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dataJsonArray;

    }

    public static JSONArray getDayWiseDrilldownSeriesData(List<Object[]> dayWiseCountData) {

        JSONArray dataJsonArray = new JSONArray();
        try {
            JSONArray DataAsArray = getDayWiseDataAsGroup(dayWiseCountData);
            JSONObject dataObject = new JSONObject();
            int monthNumber = 0;
            dataJsonArray = new JSONArray();

            for (int i = 0; i < DataAsArray.length(); i++) {
                JSONArray DayWiseDataAsArray = (JSONArray) DataAsArray.get(i);
                /*
                 * calculate month number
                 * */
                System.err.println("fff;" + DayWiseDataAsArray.toString());
                JSONArray firstData = (JSONArray) DayWiseDataAsArray.get(0);
                String splitData[] = firstData.get(0).toString().split("-");
                monthNumber = Integer.parseInt(splitData[1]);

                dataObject = new JSONObject();
                dataObject.put("name", DateUtil.getMonthName(monthNumber - 1));
                dataObject.put("id", DateUtil.getMonthName(monthNumber - 1));

                JSONArray array = new JSONArray();
                for (int j = 0; j < DayWiseDataAsArray.length(); j++) {
                    array.put(DayWiseDataAsArray.get(j));
                }
                dataObject.put("data", array);
                dataJsonArray.put(dataObject);

            }
        }
        catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dataJsonArray;

    }

    public static JSONArray getLineChartData(List<Object[]> monthWiseCountData, String year) throws JSONException {
        JSONArray lineChartSeriesData = new JSONArray();
        JSONArray array = new JSONArray();
        JSONObject dataJsonObject = new JSONObject();
        for (Object[] row : monthWiseCountData) {
            array.put(row[1]);
        }
        dataJsonObject.put("name", year);
        dataJsonObject.put("data", array);
        lineChartSeriesData.put(dataJsonObject);
        return lineChartSeriesData;
    }

    public static JSONArray getLineChartCategory(List<Object[]> monthWiseCountData) throws JSONException {

        JSONArray lineChartCategory = new JSONArray();

        for (Object[] row : monthWiseCountData) {
            Double monthNumber = Double.parseDouble(row[0].toString());
            lineChartCategory.put(DateUtil.getMonthName((int) Math.round(monthNumber) - 1));
        }

        return lineChartCategory;
    }

    public static JSONArray getDayWiseDataAsGroup(List<Object[]> dayWiseCountData) throws JSONException {
        JSONArray dataGroupArray = new JSONArray();
        JSONArray monthGroupArray = new JSONArray();
        String tempMonthNumber = "";
        int counter = 0;
        int size = dayWiseCountData.size();
        for (Object[] row : dayWiseCountData) {
            counter++;
            //System.err.println(row[0].toString() + " : " + row[1].toString());
            String splitData[] = row[0].toString().split("-");
            String monthNumber = splitData[1];

            List<Object> dayWiseData = new ArrayList<Object>();
            if (monthNumber.equalsIgnoreCase(tempMonthNumber) || tempMonthNumber.isEmpty()) {
                dayWiseData.add(row[0]);
                dayWiseData.add(row[1]);
                monthGroupArray.put(dayWiseData);
                if (counter == size) {
                    dataGroupArray.put(monthGroupArray);
                }

                if (tempMonthNumber.isEmpty()) {
                    tempMonthNumber = monthNumber;
                }
            } else {
                dataGroupArray.put(monthGroupArray);
                tempMonthNumber = monthNumber;
                monthGroupArray = new JSONArray();

                dayWiseData.add(row[0]);
                dayWiseData.add(row[1]);
                monthGroupArray.put(dayWiseData);
            }
        }
        return dataGroupArray;
    }

    public static JSONArray getDayWiseDataAsGroupForMultiGraphs(List<Object[]> dayWiseCountData) throws JSONException {
        JSONArray dataGroupArray = new JSONArray();
        JSONArray monthGroupArray = new JSONArray();
        String tempMonthNumber = "";
        int counter = 0;
        int size = dayWiseCountData.size();
        for (Object[] row : dayWiseCountData) {
            counter++;
            //System.err.println(row[0].toString() + " : " + row[1].toString());
            String splitData[] = row[0].toString().split("-");
            String monthNumber = splitData[1];

            List<Object> dayWiseData = new ArrayList<Object>();
            if (monthNumber.equalsIgnoreCase(tempMonthNumber) || tempMonthNumber.isEmpty()) {
                dayWiseData.add(row[0]);
                dayWiseData.add(row[1]);
                dayWiseData.add(row[2]);
                monthGroupArray.put(dayWiseData);
                if (counter == size) {
                    dataGroupArray.put(monthGroupArray);
                }

                if (tempMonthNumber.isEmpty()) {
                    tempMonthNumber = monthNumber;
                }
            } else {
                dataGroupArray.put(monthGroupArray);
                tempMonthNumber = monthNumber;
                monthGroupArray = new JSONArray();

                dayWiseData.add(row[0]);
                dayWiseData.add(row[1]);
                dayWiseData.add(row[2]);
                monthGroupArray.put(dayWiseData);
            }
        }
        return dataGroupArray;
    }

    public static JSONObject getLineChartObject(List<Object[]> monthWiseCountData, String scheduleType, String color) throws JSONException {
        JSONObject dataJsonObject = new JSONObject();
        JSONArray array = new JSONArray();

        for (Object[] row: monthWiseCountData) {
            if (String.valueOf(row[0]).equalsIgnoreCase(scheduleType)) array.put(row[2]);
        }

        dataJsonObject.put("data", array);
        dataJsonObject.put("color", color);
        dataJsonObject.put("name", scheduleType);
        return dataJsonObject;
    }

    public static JSONArray getMultiLineChartDataNew(List<Object[]> monthWiseCountData) throws JSONException {
        JSONArray lineChartSeriesData = new JSONArray();
        lineChartSeriesData.put(getLineChartObject(monthWiseCountData, "completed", "#008000"));
        lineChartSeriesData.put(getLineChartObject(monthWiseCountData, "expired", "#FF0000"));
        lineChartSeriesData.put(getLineChartObject(monthWiseCountData, "pending", "#FFFF00"));
        return lineChartSeriesData;
    }

    public static JSONArray getMultiLineChartData(List<Object[]> monthWiseCountData, String years) throws JSONException {
        JSONArray lineChartSeriesData = new JSONArray();
        String scheduleType = "";
        JSONArray array = new JSONArray();
        JSONObject dataJsonObject = new JSONObject();

        if (monthWiseCountData != null) {
            for (Object[] row : monthWiseCountData) {
                if (scheduleType.equalsIgnoreCase("")
                        || String.valueOf(row[0]).equalsIgnoreCase(scheduleType)) {
                    array.put(row[2]);
                    scheduleType = String.valueOf(row[0]);
                } else {
                    dataJsonObject.put("name", scheduleType);
                    dataJsonObject.put("data", array);
                    if (scheduleType.equalsIgnoreCase("completed")) {
                        dataJsonObject.put("color", "#008000");
                    }
                    if (scheduleType.equalsIgnoreCase("pending")) {
                        dataJsonObject.put("color", "#FFFF00");
                    }
                    if (scheduleType.equalsIgnoreCase("expired")) {
                        dataJsonObject.put("color", "#FF0000");
                    }
                    lineChartSeriesData.put(dataJsonObject);

                    array = new JSONArray();
                    dataJsonObject = new JSONObject();
                    array.put(row[2]);
                    scheduleType = String.valueOf(row[0]);
                }
            }
            dataJsonObject.put("name", scheduleType);
            dataJsonObject.put("data", array);
            if (scheduleType.equalsIgnoreCase("completed")) {
                dataJsonObject.put("color", "#008000");
            }
            if (scheduleType.equalsIgnoreCase("pending")) {
                dataJsonObject.put("color", "#FFFF00");
            }
            if (scheduleType.equalsIgnoreCase("expired")) {
                dataJsonObject.put("color", "#FF0000");
            }
            lineChartSeriesData.put(dataJsonObject);
        }
        return lineChartSeriesData;
    }

    public static JSONArray getMultiLineChartCategory(List<Object[]> monthWiseCountData) throws JSONException {
        JSONArray lineChartCategory = new JSONArray();
        List<Months> monthList = Arrays.asList(Months.values());

        for (Months month : monthList) {
            lineChartCategory.put(month);
        }

        return lineChartCategory;
    }
}
