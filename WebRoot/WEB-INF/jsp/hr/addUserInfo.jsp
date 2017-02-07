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
    
    <title>My JSP 'addUserInfo' starting page</title>
    
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
			$("input").css("border-color","#fff");
			$("table tr td:first-child").attr("align", "right");
			$("input[name='userId']").blur(function(){
				var userid = $(this).val();
				if(userid.length<4){
					$(this).css("border-color","red");
					$(this).next().text("登录名长度不得少于4位数！");
				}else{
					$.ajax({
						url:"getJSONForAdd.do?id="+userid,
						dataType:'json',
						success:function(data){
							if(data!=""){
								$("input[name='userId']").css("border-color","red");
								$("input[name='userId']").next().text("该用户名已存在！");
							}else{
								$("input[name='userId']").next().text("此用户名可用！");
							}						
						}
					});
				}
			});
			$("input[name='userId']").focus(function(){
				$(this).css("border-color","#fff");
				$(this).next().text("");
			});		
			$("input[name='passWord']").blur(function(){
				var passWord = $(this).val();
				if(passWord==""){
					$(this).css("border-color","red");
					$(this).next().text("密码不能为空！");
				}
			});		
			$("input[name='passWord']").focus(function(){
				$(this).css("border-color","#fff");
				$(this).next().text("");
			});		
			
		});
		//点击情况全部
		function overwrite(){
			$("input[name='userId']").val("");
			$("input[name='passWord']").val("");
			$("input[name='pw']").val("");
			$("input[name='userName']").val("");
		}
		//提交表达
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
		.save{
			float:left;
		}
		select{
			height:26px;
			width:100px;
		}
		span{
			font-size:12px;
			margin-left:6px;
			color:red;
		}
		#allMsg{
			margin:0 auto;
			width:466px;
		}
		h2{text-align: center;padding-top:20px;}
	</style>
  </head>
  
  <body>
    	<h2>添加用户信息</h2>
	<div id="allMsg">
    	<form action="addUserInfo.do" method="post" enctype="multipart/form-data" >
	    	<table cellpadding="9" cellspacing="0">
	    		<tr>
	    			<td>用户登录名:</td>
	    			<td><input type="text" name="userId"><span></span></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input type="password" name="passWord"><span></span></td>
	    		</tr>
	    		<tr>
	    			<td>确认密码:</td>
	    			<td><input id="pw" type="password" name="pw"><span></span></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td><input type="text" name="userName"></td>
	    		</tr>
	    		<tr>
	    			<td>所在部门:</td>
	    			<td>
	    				<select name="departInfo.departId">
	    					<c:forEach items="${listDep }" var="ld">
	    						<option value="${ld.departId }">${ld.departName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>性别:</td>
	    			<td><input type="radio" value="0" name="gender" checked>男 &nbsp&nbsp
	    			    <input type="radio" value="1" name="gender">女</td>
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
	    		<tr>
	    			<td>角色:</td>
	    			<td>
	    				<select name="roleInfo.roleId">
	    					<c:forEach items="${listRol }" var="lr">
	    						<option value="${lr.roleId }">${lr.roleName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>当前状态:</td>
	    			<td>
	    				<select name="userState.userStateId">
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
	</div>
  </body>
</html>
