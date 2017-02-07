<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'serach.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<c:if test="${list!=null}">
		<table border="1px" cellpadding="10px" cellspacing="0px">
			<tr>
				<th>文件名称</th>
				<th>所在文件夹</th>
				<th>类型</th>
				<th>所有者</th>
				<th>创建日期</th>
			</tr>
			<c:forEach items="${list }" var="ls">
				<tr>
					<td>${ls.fileName }</td>
					<td>${ls.filePath }</td>
					<td>${ls.fileTypeInfo.fileTypeName }</td>
					<td>${ls.fileOwner}</td>
					<td>${ls.createDate }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${list==null}">
		 你查询的文件不存在
	 </c:if>
</body>
</html>
