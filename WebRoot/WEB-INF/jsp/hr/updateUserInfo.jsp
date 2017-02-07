<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateUserInfo.jsp' starting page</title>
    
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
			$("table tr td:first-child").attr("align", "right");
			$("#departID option[value='"+${userInfo.departInfo.departId}+"']").attr("selected",true);
			$("#roleID option[value='"+${userInfo.roleInfo.roleId}+"']").attr("selected",true);
			$("#userStateID option[value='"+${userInfo.userState.userStateId}+"']").attr("selected",true);
			$("input[value='"+${userInfo.gender}+"']").attr("checked",true);
		});
		function overwrite(){
			$("input[name='userId']").val("");
			$("input[name='passWord']").val("");
			$("input[name='pw']").val("");
			$("input[name='userName']").val("");
		}
		function save(){
			$("form").submit();
		}
	</script>
	<style type="text/css">
		td{font-size:16px;font-weight: normal;}
		button{
			width:80px;
			height:24px;
			margin-right:10px;
			margin-left:10px;
			font-size: 12px;
		}
		h2{
			padding-top:20px;
		}
	</style>
  </head>
  
  <body>
     <center>
    	<h2>修改用户信息</h2>
    	<form action="updateUserInfo.do" method="post" enctype="multipart/form-data">
	    	<table cellpadding="11" cellspacing="0">
	    		<tr>
	    			<td>用户登录名:</td>
	    			<td><input type="text" name="userId" value="${userInfo.userId }"></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input type="password" name="passWord" value="${userInfo.passWord }"></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td><input type="text" name="userName" value="${userInfo.userName }"></td>
	    		</tr>
	    		<tr>
	    			<td>所在部门:</td>
	    			<td>
	    				<select id="departID" name="departInfo.departId">
	    					<c:forEach items="${listDep }" var="ld">
	    						<option value="${ld.departId }">${ld.departName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			
	    			<td><input type="radio" value="0" name="gender" checked>男 
	    			<input type="radio" value="1" name="gender"/>女</td>
	    		</tr>
	    		<tr>
	    			<td  style="background:#FFF" onclick="path.click()">浏览:</td>
	    			<td>
					<input type="text" name="upfile" id="upfile" style="border-color: #fff" value="点击浏览上传图片" onclick="path.click()">
					<input type="file" name="file" id="path" style="display:none" onchange="upfile.value=this.value"></td>
<!-- 	    			<td>
					<input type="button" value="浏览" onclick="path.click()" style="border:1px solid #ccc;background:#fff">
	    			<input type="text" size="20" name="upfile" id="upfile" style="border:1px dotted #ccc">
					<input type="file" name="file" id="path" style="display:none" onchange="upfile.value=this.value"></td> -->
	    		</tr>
	    		<!-- <tr>
	    			<td colspan="2">
					<input type="button" value="浏览" onclick="path.click()" style="border:1px solid #ccc;background:#fff">
	    			<input type="text" size="20" name="upfile" id="upfile" style="border:1px dotted #ccc">
					<input type="file" name="file" id="path" style="display:none" onchange="upfile.value=this.value"></td>
	    		</tr> -->
	    		<tr>
	    			<td>角色:</td>
	    			<td>
	    				<select id="roleID" name="roleInfo.roleId">
	    					<c:forEach items="${listRol }" var="lr">
	    						<option value="${lr.roleId }">${lr.roleName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>当前状态:</td>
	    			<td>
	    				<select id="userStateID" name="userState.userStateId">
	    					<c:forEach items="${listUser }" var="lu">
	    						<option value="${lu.userStateId }">${lu.userStateName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    	</table>
    	</form>
    	<a href="queryFindUserInfo.do"><button>返回</button></a>
	    <button onclick="save()">保存</button>
	    <button id="overWrite" onclick="overwrite()">全部重写</button>
    </center>
  </body>
</html>
