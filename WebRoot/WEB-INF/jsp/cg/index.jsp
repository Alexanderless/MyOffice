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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script>
		$(function(){
			$("#btn").click(function(){
				$("#form").submit();
			});
		});
	
	</script>
  </head>

  <body>
  	<form id="form" action="queryScheduleListByName.do" method="post">
  		<input type="hidden" name="createUser" value="admin"/>
  		<button id="btn" >查看日程</button>
  	</form>
    <a href="queryMyNoteList.do?createUser=abc">查看便签</a>
  
  </body>
</html>
