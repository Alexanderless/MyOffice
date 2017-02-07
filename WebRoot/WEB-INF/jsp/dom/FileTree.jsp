<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
	<link rel="stylesheet" href="zTree/css/demo.css" type="text/css">
	<style type="text/css">
	 #one,#two{
	 	float: left;
	 }
	 #two{
	 	margin-left:50px;
	 	margin-top: 10px;
	 }
	</style>
	<link rel="stylesheet" href="zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="zTree//js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="zTree/js/jquery.ztree.core-3.5.js"></script>
	<!--  <script type="text/javascript" src="zTree/js/jquery.ztree.excheck-3.5.js"></script>
	  <script type="text/javascript" src="zTree/jquery.ztree.exedit-3.5.js"></script>-->
	<SCRIPT type="text/javascript">
	var setting = {
		view : {
			selectedMulti : false
		},
		data : {
			key : {
				title : "t"
			},
			simpleData : {
				enable : true
			}
		},
		callback : {	
			onClick: zTreeOnClick,
			beforeCollapse : beforeCollapse,
			beforeExpand : beforeExpand,
			onCollapse : onCollapse,
			onExpand : onExpand
		}
	};
	function zTreeOnClick(event, treeId, node) {
		$("iframe").attr("src", "queryBypid.do?id="+node.id); 
	};
	var log, className = "dark";
	function beforeCollapse(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeCollapse ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ treeNode.name);
		return (treeNode.collapse !== false);
	}
	function onCollapse(event, treeId, treeNode) {
		showLog("[ " + getTime() + " onCollapse ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ treeNode.name);
	}
	function beforeExpand(treeId, treeNode) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeExpand ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ treeNode.name);
		return (treeNode.expand !== false);
	}
	function onExpand(event, treeId, treeNode) {
		showLog("[ " + getTime() + " onExpand ]&nbsp;&nbsp;&nbsp;&nbsp;"
				+ treeNode.name);
	}
	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds(), ms = now.getMilliseconds();
		return (h + ":" + m + ":" + s + " " + ms);
	}

	function expandNode(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), type = e.data.type, nodes = zTree
				.getSelectedNodes();
		if (type.indexOf("All") < 0 && nodes.length == 0) {
			alert("请先选择一个父节点");
		}

		if (type == "expandAll") {
			zTree.expandAll(true);
		} else if (type == "collapseAll") {
			zTree.expandAll(false);
		} else {
			var callbackFlag = $("#callbackTrigger").attr("checked");
			for (var i = 0, l = nodes.length; i < l; i++) {
				zTree.setting.view.fontCss = {};
				if (type == "expand") {
					zTree.expandNode(nodes[i], true, null, null, callbackFlag);
				} else if (type == "collapse") {
					zTree.expandNode(nodes[i], false, null, null, callbackFlag);
				} else if (type == "toggle") {
					zTree.expandNode(nodes[i], null, null, null, callbackFlag);
				} else if (type == "expandSon") {
					zTree.expandNode(nodes[i], true, true, null, callbackFlag);
				} else if (type == "collapseSon") {
					zTree.expandNode(nodes[i], false, true, null, callbackFlag);
				}
			}
		}
	}
	
	var zNodes = null;
	$(document).ready(function() {
		$.ajax({
			url : "dom/tree.do",
			type : "POST",
			data : null,
			dataType : "json",
			success : function(data) {
				zNodes = data;
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				$("#expandBtn").bind("click", {
					type : "expand"
				}, expandNode);
				$("#collapseBtn").bind("click", {
					type : "collapse"
				}, expandNode);
				$("#toggleBtn").bind("click", {
					type : "toggle"
				}, expandNode);
				$("#expandSonBtn").bind("click", {
					type : "expandSon"
				}, expandNode);
				$("#collapseSonBtn").bind("click", {
					type : "collapseSon"
				}, expandNode);
				$("#expandAllBtn").bind("click", {
					type : "expandAll"
				}, expandNode);
				$("#collapseAllBtn").bind("click", {
					type : "collapseAll"
				}, expandNode);
			}
		});
	});
</SCRIPT>
</HEAD>
<BODY>
	<div id="one" class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
	</div>
	<div id="two">
		<iframe width="700px" height="600px" src="<%=path%>/match"></IFRAME>
	</div>

</BODY>
</HTML>