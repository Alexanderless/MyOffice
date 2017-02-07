<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Roleinp.jsp' starting page</title>
    
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
      <form action="sm/update.do?roleId=${roleinfo.roleId }"  method="post">
      <table cellpadding="5px" >
      <tr>
    	<td>角色名称:</td>
    	<td><input type="text" name="roleName" value="${roleinfo.roleName}" style="width: 300px; height: 30px"></td>
    	</tr> 	
    	<tr>
    	<td>角色说明:</td>
    	<td><textarea cols="10" rows="5" name="roleDesc"  style="width: 300px; height: 100px" >${roleinfo.roleDesc}</textarea></td>
    	</tr>
    	<tr>
    	<td><input type="submit" value="添加"></td><td><input type="submit" value="保存修改"></td>
    	</tr>
    	</table>
    </form>
  </body>
</html>
