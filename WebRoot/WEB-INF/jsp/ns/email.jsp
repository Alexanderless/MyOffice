<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'email.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function(){
			$("table tr td:first-child").css("cursor","pointer");
		});
	</script>
	<style type="text/css">
		td,th{
			text-align: center;
			font-size:20px;
		}
		a{
			text-decoration: none;
			color:#000;
		}
		a:HOVER {
			color:rgb(102,150,183);
		}
		h2{
			padding-top:40px;
		}
	</style>
  </head>
  
  <body>
  	<center>
	    <h2>个人消息管理区</h2>
	    <table border="1" cellpadding="16" cellspacing="0">
	    	<tr>
	    		<th>本地文件夹</th>
	    		<th>文件个数</th>
	    		<th>未读邮件</th>
	    	</tr>
	    	<tr>
	    		<td><a href="InboxInfo.do">收件箱</a></td>
	    		<td>${email.inboxCount }</td>
	    		<td>${email.unread }</td>
	    	</tr>
	    	<tr>
	    		<td><a href="send.do">已发送</a></td>
	    		<td>${email.send }</td>
	    		<td>--</td>
	    	</tr>
	    </table>
	</center>
  </body>
</html>
