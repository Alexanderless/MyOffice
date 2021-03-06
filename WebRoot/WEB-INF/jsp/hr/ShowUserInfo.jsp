<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSP 'ShowUserInfo.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			if(${userInfo.gender}==0){
				$("#sex").text("男");
			}
			if(${userInfo.gender}==1){
				$("#sex").text("女");
			}
			$("table tr td:first-child").attr("align", "right");
		});

	</script>
	<style type="text/css">	
		img{
			float:left;
			margin-right:50px;
			margin-top:8px;
		}
		#showUser{
			float:left;
		}
		h2{
			padding-top:30px;
			padding-bottom:30px;
			text-align: center;
		}
		body{
			margin:0 auto;
			width:450px;
		}
		#goback{
			width:90px;
			height:34px;
			margin-top:30px;
		}
		#goBot{
			width:80px;
			height:30px;
			margin-top:30px;
		}
		button{
			width:100px;
			height:26px;
			margin-right:10px;
			margin-left:10px;
			font-size: 12px;
		}
	</style>
</head>

<body>
<center>
<h2>用户详细信息</h2>
<img src="${userInfo.picPath }" width="160px" height="250px"/>
<div id="showUser">
	<table cellpadding="9" cellspacing="0">
		<tr>
			<td>用户名:</td>
			<td>${userInfo.userId }</td>
		</tr>
		<tr>
			<td>姓名:</td>
			<td>${userInfo.userName }</td>
		</tr>
		<tr>
			<td>密码:</td>
			<td>${userInfo.passWord }</td>
		</tr>
		<tr>
			<td>部门:</td>
			<td>${userInfo.departInfo.departName }</td>
		</tr>
		<tr>
			<td>性别:</td>
			<td id="sex"></td>
		</tr>
		<tr>
			<td>角色:</td>
			<td>${userInfo.roleInfo.roleName }</td>
		</tr>
		<tr>
			<td>用户状态:</td>
			<td>${userInfo.userState.userStateName }</td>
		</tr>
	</table>
</div>
	<div id="goback"><a href="queryFindUserInfo.do"><button id="goBot">返回</button></a></div>
</center>
</body>
</html>
