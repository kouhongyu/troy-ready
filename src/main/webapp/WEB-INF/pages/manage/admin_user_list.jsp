<%@ page import="org.troy.core.common.ConstVar" %>
<%@ page import="org.troy.core.common.Pagination" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: troy-kou
  Date: 14-1-27
  Time: 下午4:15
  Email:kouhongyu@163.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="tt" uri="/troy-tags" %>
<%

    /*
    //数据总条数
    int total = 167;
    //当前页
    int currentPage = request.getParameter(ConstVar.Page.CURRENT_PAGE) == null ? 1 : Integer.parseInt(request.getParameter(ConstVar.Page.CURRENT_PAGE));
    //每页数据数量
    int pageSize = 10;
    //分页面码每组显示数量
    int viewPageCount = 5;
    //跳转地址  直接跳页
    String urlToPage = request.getServletPath();

    Map<String, String> paramMap = new HashMap();
    paramMap.put("p1", "v1");
    paramMap.put("p2", "v2");
    paramMap.put("p3", "v3");

    Pagination pagination = new Pagination();
    pagination.setToPage("/manage/permission/adminUserList.action");
    pagination.setTotal(total);
    pagination.setCurrentPage(currentPage);
    pagination.setPageSize(pageSize);
    pagination.setViewPageCount(viewPageCount);
    pagination.setParamMap(paramMap);

    request.setAttribute(ConstVar.Page.PAGINATION, pagination);
       */
%>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/css/bootstrap/js/bootstrap.js"></script>
    <style>
        .table th{
            text-align: center;
        }
    </style>
</head>
<body>





<table class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>EMAIL</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="adminUserList">
    <tr>
        <td><s:property value="adminid"/> </td>
        <td><s:property value="username"/> </td>
        <td><s:property value="email"/> </td>
    </tr>
    </s:iterator>
    </tbody>
</table>
<tt:pagination/>

</body>
</html>