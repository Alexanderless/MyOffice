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
    
    <title>My JSP 'departinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style ></style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

	
  </head>
  
  <body>
   	<table>
   		<th>日程主题</th>
   		<th>日程内容</th>
   		<th>日程开始时间</th>
   		<th>会议地址</th>
   		<th>会议类型</th>
   		<th>机构名称</th>
   		<th>部门名称</th>
   		<th>创建者</th>
   		<c:forEach items="${list}" var="schedule">
   			<tr>	
   				<td>${schedule.title }</td>
   				<td>${schedule.schContent }</td>
   				<td>${schedule.beginTime }</td>
   				<td>${schedule.address }</td>
   				<td>${schedule.meetingInfo.meetingName }</td>
   				<td>${schedule.userInfo.departInfo.branchInfo.branchName }</td>
   				<td>${schedule.userInfo.departInfo.departName }</td>
   				<td>${schedule.userInfo.userName }</td>	
   			</tr>
   		</c:forEach>
   	</table>
   	
  </body>
</html>
