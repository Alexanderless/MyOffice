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
   	<form action="dom/query.do" method="post">
  		<table  cellpadding="10px" cellspacing="0px">
  		<tr>
  		<td>用户名</td>
  		<td><input type="text" name="userName"></td>  		
  		</tr>
  		<tr>
  		<td>密码</td>
  		<td><input type="password" name="password"></td>  		
  		</tr> 		
  		<tr>
  		<td><input type="submit" name="登录"></td>
  		<td><input type="reset" name="重置"></td>  		
  		</tr> 		
  		</table>
  	</form>
   
  </body>
</html>
