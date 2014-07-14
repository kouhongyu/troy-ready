<%--
  Created by IntelliJ IDEA.
  User: troy-kou
  Date: 13-10-23
  Time: 上午11:00
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

    <script type="text/javascript">
        function formatEffective(value) {
            if (value == 0) {
                return "无效";
            } else {
                return "有效";
            }
        }
        var editingId;
        function edit() {

            var tg = $('#tg');
            if (editingId != undefined) {
                tg.treegrid('select', editingId);
                return;
            }
            var row = tg.treegrid('getSelected');
            if (row) {
                editingId = row.id;
                tg.treegrid('beginEdit', editingId);
            }
        }
        function save() {
            if (editingId != undefined) {

                var t = $('#tg');

                t.treegrid('endEdit', editingId);
                editingId = undefined;

                var row = t.treegrid('getSelected');

                var param = {
                    'resourceMenu.id': row.id,
                    'resourceMenu.description': row.description,
                    'resourceMenu.effective': row.effective,
                    'resourceMenu.leaf': row.leaf,
                    'resourceMenu.menucode': row.menucode,
                    'resourceMenu.parameter': row.parameter,
                    'resourceMenu.text': row.text,
                    'resourceMenu.url': row.url
                };
                $.post(
                        "${pageContext.request.contextPath}/manage/permission/saveResourceMenuAjax.action",
                        jQuery.param(param),
                        function (data) {
                            if (data.status == "success") {
                                alert("保存成功");
                            } else {
                                alert(data.status);
                            }
                        }
                );
            }
        }
        function cancel() {
            if (editingId != undefined) {
                $('#tg').treegrid('cancelEdit', editingId);
                editingId = undefined;
            }
        }
        function onContextMenu(e, row) {
            e.preventDefault();
            $(this).treegrid('select', row.id);
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        }
        function append() {

            var tg = $('#tg');
            var node = tg.treegrid('getSelected');
            tg.treegrid('expand',node.id);
            var param = {
                'resourceMenu.effective': 1,
                'resourceMenu.text': '新增菜单',
                'pid': node.id
            };

            if (confirm("确定增加子菜单吗？")) {
                $.post(
                        "${pageContext.request.contextPath}/manage/permission/addResourceMenuAjax.action",
                        jQuery.param(param),
                        function (data) {
                            if (data.status == "success") {
                                tg.treegrid('append', {
                                    parent: node.id,
                                    data: [
                                        {
                                            id: data.resourceMenu.id,
                                            text: data.resourceMenu.text,
                                            menucode: data.resourceMenu.menucode,
                                            url: data.resourceMenu.url,
                                            parameter: data.resourceMenu.parameter,
                                            effective: data.resourceMenu.effective,
                                            description: data.resourceMenu.description
                                        }
                                    ]
                                });
                                editingId = data.resourceMenu.id;

                                tg.treegrid('select',editingId);
                                tg.treegrid('beginEdit', editingId);

                            } else {
                                alert(data.status);
                            }
                        }
                );
            }

        }
        function appendRoot() {

            var tg = $('#tg');
            var param = {
                'resourceMenu.effective': 1,
                'resourceMenu.text': '新增根菜单'
            };

            if (confirm("确定增加根菜单吗？")) {
                $.post(
                        "${pageContext.request.contextPath}/manage/permission/addResourceMenuAjax.action",
                        jQuery.param(param),
                        function (data) {
                            if (data.status == "success") {
                                tg.treegrid('append', {
                                    data: [
                                        {
                                            id: data.resourceMenu.id,
                                            text: data.resourceMenu.text,
                                            menucode: data.resourceMenu.menucode,
                                            url: data.resourceMenu.url,
                                            parameter: data.resourceMenu.parameter,
                                            effective: data.resourceMenu.effective,
                                            description: data.resourceMenu.description
                                        }
                                    ]
                                });
                                editingId = data.resourceMenu.id;

                                tg.treegrid('select',editingId);
                                tg.treegrid('beginEdit', editingId);

                            } else {
                                alert(data.status);
                            }
                        }
                );
            }

        }
        function removeMenu() {
            var tg = $('#tg');
            var node = tg.treegrid('getSelected');

            if (confirm("确定删除菜单吗？")) {

                $.post(
                        "${pageContext.request.contextPath}/manage/permission/removeResourceMenuAjax.action",
                        {
                            "id":node.id
                        },
                        function (data) {
                            if (data.status == "success") {
                                tg.treegrid('remove', node.id);
                            } else {
                                alert(data.status);
                            }
                        }
                );
            }
        }
    </script>
</head>
<body>

<table id="tg" class="easyui-treegrid" style="min-height: 300px;"
       data-options=" url:'${pageContext.request.contextPath}/manage/permission/resourceMenuList.action',
                      method:'get',
                      rownumbers:true,
                      idField:'id',
                      treeField:'text',
                      onContextMenu: onContextMenu"
        >
    <thead>
    <tr>
        <th data-options="field:'text',editor:'text'">名称</th>
        <th data-options="field:'menucode'">编码</th>
        <th data-options="field:'url',editor:'text'">URL</th>
        <th data-options="field:'parameter',editor:'text'">参数</th>
        <th data-options="field:'effective',formatter:formatEffective,editor:{type:'checkbox',options:{on:'1',off:'0'}}">有效</th>
        <th data-options="field:'description',editor:'text'">说明</th>
    </tr>
    </thead>
</table>

<div id="mm" class="easyui-menu" style="width:120px;">
    <div onclick="edit()" data-options="iconCls:'icon-edit'">编辑</div>
    <div onclick="save()" data-options="iconCls:'icon-save'">保存</div>
    <div onclick="cancel()" data-options="iconCls:'icon-undo'">取消</div>
    <div class="menu-sep"></div>
    <div onclick="append()" data-options="iconCls:'icon-add'">增加子菜单</div>
    <div onclick="appendRoot()" data-options="iconCls:'icon-add'">增加根菜单</div>
    <div class="menu-sep"></div>
    <div onclick="removeMenu()" data-options="iconCls:'icon-cancel'">删除</div>
</div>

</body>
</html>