<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FileMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		#div1{
			margin-top: 30px;
		}	
		span{
			margin-left: 30px;
		}
		td,th{
			width:600px;
			height: 20px;
		}
		tr{
			width: 
		}	
		th{
			background-color: rgb(107,155,189);
		}
		a{
			text-align:center;
			text-decoration: none;	
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#sub").click(function(){
			location.href="document.do?fileId=${file.fileId}";
		});
		
		$("#add").click(function(){
			location.href="queryByfileId.do?fileId=${file.fileId}";
		});
	
	});
	</script>

  </head>
<body>
	<div id="div1"> <b style="font-size: 18px;">文件地址:</b>&nbsp;&nbsp;<input type="text" name="filePath" value="${file.filePath }" style="width: 200px;height: 30px;">
			&nbsp;<button id="sub" style="font-size: 18px">新增文件夹</button >&nbsp;&nbsp; <button id="add" style="font-size: 18px">新增文件</button>
	<br />
	</div>
	<br />
	<table border="1px" cellpadding="10px" cellspacing="0px"
		style="text-align: center;">
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>类型</th>
			<th>备注</th>
			<th>所有者</th>
			<th>创建日期</th>
			<th>操作</th>
		</tr>
		<c:if test="${list!=null }">
		<%int i=1; %>
			<c:forEach items="${list }" var="ls">
				<tr>
					<td><%=i++ %></td>
					<td><a href="queryBypid.do?id=${ls.fileId }">${ls.fileName }</a></td>
					<td>${ls.fileTypeInfo.fileTypeName }</td>
					<td>${ls.remark }</td>
					<td>${ls.fileOwner}</td>
					<td><fmt:formatDate value="${ls.createDate}" pattern="yy-MM-dd"/></td>
					<td><a href="update.do?ifDelete=1&&fileId=${ls.fileId }&&id=${pid}">删除</a> </td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${list==null }">
			<%int i=1; %>
			<tr>
				<td><%=i++ %></td>
				<td><a href="queryByfileId.do?fileId=${file.fileId }">${file.fileName }</a></td>
				<td>${file.fileTypeInfo.fileTypeName }</td>
				<td>${file.remark }</td>
				<td>${file.fileOwner}</td>
				<td><fmt:formatDate value='${file.createDate }' pattern='yyyy-MM-dd' /></td>
				<td><a href="update.do?ifDelete=1&&fileId=${file.fileId }&&id=${pid}">删除</a></td>
			</tr>
		</c:if>
	</table>
</body>
</html>
