<%--
  Created by IntelliJ IDEA.
  User: troy-kou
  Date: 13-3-26
  Time: 下午5:25
  Email:kouhongyu@163.com
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../js/plugins/ext-4.2.0/resources/css/ext-all.css"/>
    <script type="text/javascript" src="../js/plugins/ext-4.2.0/ext-all.js"></script>
    <script type="text/javascript">
        Ext.onReady(function () {

            var myStore = Ext.create("Ext.data.TreeStore", {
                nodeParam: "menucode",
                proxy: {
                    type: "ajax",
                    url: "/manage/tree/loadMenu.action",
                    reader: "json"
                },
                root: {
                    name: "根节点",
                    id: ""

                }
            });

            var tree2 = Ext.create(Ext.tree.Panel, {
                title: "懒加载",
                renderTo: "tree2",
                width: 150,
                store: Ext.create("Ext.data.TreeStore", {
                    nodeParam: "menucode",
                    proxy: {
                        type: "ajax",
                        url: "/manage/tree/loadMenu.action",
                        reader: "json"
                    },
                    root: {
                        name: "根节点",
                        id: ""

                    }
                }),
                listeners: {
                    itemclick: function(v, record, item, index, e, eOpts ){
                             Ext.Msg.alert(record.data.text);
                    }
                },
                rootVisible: false
            });
        });

    </script>

</head>
<body>
<div id="tree1"></div>
<div id="tree2"></div>
<div id="tree3"></div>

</body>
</html>