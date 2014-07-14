<%--
  Created by IntelliJ IDEA.
  User: troy-kou
  Date: 13-3-25
  Time: 下午5:09
  Email:kouhongyu@163.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/plugins/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/plugins/easyui/themes/icon.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/easyui/jquery.easyui.min.js"></script>

    <script>
        function addPanel(menuid) {

            $.post(
                    "${pageContext.request.contextPath}/manage/frame/getMethod.action",
                    {
                        "menuid": menuid
                    },
                    function (data) {
                        if (data.status == "success") {
                            setPanel(data.resourceMenu.text,
                                    data.resourceMenu.url,
                                    data.resourceMenu.parameter);
                        } else {
                            alert(data.status);
                        }
                    }
            );

        }

        function setPanel(text, url, parameter) {
            var param = "";
            if (parameter != null) {
                param = parameter;
            }

            var html = "<div title='" + text + "' data-options='closable:true' style='padding:2px'>" +
                    "   <iframe src='${pageContext.request.contextPath}" + url + param + "' width='100%' height='100%' style='border-width: 0px;'/>" +
                    "</div>";

            $('#main-tabs').tabs('add', {
                title: text,
                content: html,
                closable: true
            });
        }
    </script>
</head>
<body>
<div class="easyui-layout" style="width:100%;height:100%;">
    <div data-options="region:'north'" style="height:50px;padding:2px;">
        头页面
        <s:iterator value="menuJson">
            <p>${text}</p>
        </s:iterator>
    </div>
    <div data-options="region:'west',split:true" title="菜单" style="width:200px;padding:2px;">
        <ul class="easyui-tree">
            <s:property value="treeString" escape="false"/>
        </ul>
    </div>
    <div id="main-tabs" class="easyui-tabs" data-options="region:'center'">
        <div title="About" style="padding:10px">
            <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
            <ul>
                <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                <li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
                <li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
                <li>complete framework for HTML5 web page.</li>
                <li>easyui save your time and scales while developing your products.</li>
                <li>easyui is very easy but powerful.</li>
            </ul>
        </div>

    </div>
</div>

</body>
</html>