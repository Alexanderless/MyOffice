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
	 <script src="js/bootstrap/jquery-2.1.4.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			margin:0;
			pardding:0;
		}
		body {
		background-image: url(images/bg_login.png);  
		background-repeat: repeat-x;
		background-size:contain;
		position:relative;
    }
	#root{
		
		background-image: url(images/login_root.png);
		height:104px;
		width:800px;
		position:absolute;
		bottom:7px;
		left:154px;
	}
	#login{
		background-image: url(images/login_main.png);
		width:800px;
		height:424px;
		position:absolute;
		top:0px;
		left:154px;
	}
	#loginInfo{
		position:absolute;
		top:230px;
		right:172px;
	}
	td{
		color:#fff;
	}
	button{
		font-size:14px;
		height:30px;
		width:100px;
		
		margin-left:110px;
	}
	input{
		height:28px;
		width: 180px;
	}
	span{
		font-size:14px;
	}
	</style>
	<script type="text/javascript">
		$(function(){
			$("button").click(function(){
				var userId = $("input[name='userId']").val();
				var passWord = $("input[name='passWord']").val();
				if(userId!=""&&passWord!=""){
				    $.ajax({
				    	url:"getJson.do?userId="+userId+"&passWord="+passWord,
				    	dataType:'json',
				    	success:function(data){
				    		if(data!=""){	
				    			$("form").submit();
				    		}else{
				    			$("span").css("color","rgb(249,144,111)").text("用户名或密码输入错误！");
				    		}
				    	}
				    });
				}			
			});
			$("input[name='userId']").focus(function(){
				$("span").css("color","rgb(249,144,111)").text("");
			});
			$("input[name='passWord']").focus(function(){
				$("span").css("color","rgb(249,144,111)").text("");
			});
		});
	</script>
 </head>
  
<body>
	<div id="login">
		<div id="loginInfo">
			<form action="queryUserInf.do">
				<table cellpadding="10" cellspacing="0">
					<tr>
						<td>用户名 :</td>
						<td><input type="text" name="userId"></td>
					</tr>
					<tr>
						<td>密&nbsp码 :</td>
						<td><input type="password" name="passWord"></td>
					</tr>
					<tr>
						<td colspan="2">
							<span></span>
						</td>
					</tr>
				</table>
			</form>
			<button>登录</button>
		</div>
	</div>
	<div id="root"></div>
</body>
</html>
