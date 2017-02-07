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
    <title>My JSP 'RoleManager.jsp' starting page</title>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">	
		#title{
			padding-top:20px;
			font:normal 22px bold;
			color:#6495ED;
			margin-left: 400px;
		}
		#inp{
			margin-left: 135px
		}
		form {
			margin: 20 200px;
		}	
		table{
			width: 820px;
			text-align: center;
		}
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#update").click(function(){
				var v=$("#update").val();
				$("iframe").attr("src", "sm/queryByroleId.do?roleId="+v);
			});
			
			$("#delete").click(function(){
				alert("aaaaaaaa");
				var v=$("#delete").val();
				window.location.href="<%=path%>/sm/delete.do?roleId="+v; 
			});
		});
	</script>
  </head>
  <body>
  	 <div id="title">角色功能设置</div>
    <HR style="border:1 dashed #987cb9" width="95%" color=#987cb9 SIZE=1>
    <div id="inp">
    	<iframe  frameborder="0" width="800px" height="220px" src="<%=path%>/Roleinp"></iframe>
    </div>
     <HR style="border:1 dashed #987cb9" width="95%" color=#987cb9 SIZE=1>
    <center>
    <c:if test="${list!=null }">
    <table border="1px" bordercolor="#EAEAEA" cellpadding="5px" cellspacing="0px">
    	<caption>角色信息表</caption>
    	<tr>
    		<th>角色名称</th>
    		<th>角色说明</th>
    		<th>修改</th>
    		<th>删除</th>
    		<th>分配角色权限</th>   	
    	</tr>
    	<c:forEach items="${list }" var="lst">
    	<tr>
    		<td>${lst.roleName }</td>
    		<td>${lst.roleDesc }</td>
    		<td><button id="update" value="${lst.roleId }">修改</button></td>
    		<td><button id="delete" value="${lst.roleId }">删除</button></td>
    		<td><button id="distribute" value="${lst.roleId }">分配角色权限</button></td>   	
    	</tr>
    	</c:forEach>
    </table>  
    </c:if> 
    </center>    
  </body>
</html>
