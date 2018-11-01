<%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    Map<String, String> selectedFilter = (Map<String, String>) session
            .getAttribute("selectedFilter");

    String start = "";
    if (selectedFilter.containsKey("start")) {
        start = selectedFilter.get("start");
    }

    String end = "";
    if (selectedFilter.containsKey("end")) {
        end = selectedFilter.get("end");
    }
%>


<div class="card mb-3">
    <div class="card-header">
        <i class="fa fa-table"></i> ${title.toString()} Search
    </div>
    <div class="card-body">
        <form id="search-form">

            <div class="form-group">
                <div class="row">
                    <div class="col-3">
                        <label>Start Date</label> <input class="form-control" type=text
                            name="start" id="start" value="<%=start%>">
                    </div>
                    <div class="col-3">
                        <label>End Date</label> <input class="form-control" type="text"
                            name="end" id="end" value="<%=end%>">

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-3">
                    <button name="search" type="submit" id="bth-search"
                        class="btn btn-primary" value="search">Search</button>
                </div>
                 <div class="col-3">
                    <button class="btn btn-primary" id="exportcsv" data-export="export">Export CSV</button>
                </div>
                <div class="col-6">
                    <button class="btn btn-primary" id="exportpdf" data-export="export">Export PDF</button>
                </div>
            </div>
        </form>
    </div>
    <div class="card-footer small text-muted"></div>
</div>