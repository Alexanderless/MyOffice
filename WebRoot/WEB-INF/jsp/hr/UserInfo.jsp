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
    
    <title>My JSP 'UserInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	h2{
		padding-top:20px;
	}	
		a{ text-decoration:none; color:#000;font-size: 20px;}
		#page1{
			color:#000;font-size:20px;
			padding-top:14px;
			padding-bottom: 6px;
		}	
    	.line{width:940px;}
    	#addUser{
    		width:90px;
			height:26px;
			margin-top:4px;
			margin-bottom:16px;
			margin-right:-185px;
			margin-left:10px;
			font-size: 12px;
			margin-left:600px;
    	} 
    	#showUser,#updateUser,#delUser{
    		width:90px;
			height:26px;
			margin-right:10px;
			margin-left:10px;
			font-size: 12px;
    	}   
    	table{width:970px;height:200px;}
    	th{font-size: 16px;font-weight: normal;height:50px}
    </style>
  </head>
  
  <body>
  	<center>
  		<h2>用户管理</h2>
  		<div class="line"><hr/></div>
  		<span><a href="goUserInfo.do"><button id="addUser">添加用户</button></a></span>
  		<table border="1" cellpadding="8" cellspacing="0">
  			<tr>
  				<th>用户ID</th>
  				<th>姓名</th>
  				<th>密码</th>
  				<th>角色</th>
  				<th>用户详情</th>
  				<th>修改</th>
  				<th>删除</th> 	
  			</tr>
  			<c:forEach var="ls" items="${puInfo.list }">
    			<tr>
    				<th>${ls.userId }</th>
    				<th>${ls.userName }</th>
    				<th>${ls.passWord }</th>
    				<th>${ls.roleInfo.roleName }</th>
    				<th>	
    					<a href="showUserInfo.do?id=${ls.userId }"><button id="showUser">查看详情</button></a>
					</th>
    				<th><a href="updateUserInfoURL.do?id=${ls.userId }"><button id="updateUser">修改</button></a></th>
    				<th><a href="delUserInfo.do?id=${ls.userId }"><button id="delUser" onclick="return confirm('是否删除？')">删除</button></a></th>
    			</tr>
    		</c:forEach>
  		</table>
  		<div id="page1">第${puInfo.currentPage }页/总${puInfo.totalPages }页</div>
    		<div>
			<a href="queryFindUserInfo.do?currentPage=1">首页</a>
				<c:if test="${puInfo.currentPage>1}">
	    		<a href="queryFindUserInfo.do?currentPage=${puInfo.currentPage-1}">上一页</a>
	    	</c:if>
			
			<!-- 分页条的显示 -->
			<c:set var="begin" value="0"></c:set>
			<c:set var="end" value="0"></c:set>
			<%--获取begin 和  end --%>
			<c:if test="${puInfo.totalPages<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${puInfo.totalPages }"></c:set>
			</c:if>
			<c:if test="${puInfo.totalPages>5 }">
				<c:choose>
					<c:when test="${puInfo.currentPage<3 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="5"></c:set>
					</c:when>
					<c:when test="${puInfo.currentPage>=puInfo.totalPages-2 }">
						<c:set var="begin" value="${puInfo.totalPages-4 }"></c:set>
						<c:set var="end" value="${puInfo.totalPages }"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${puInfo.currentPage-2 }"></c:set>
						<c:set var="end" value="${puInfo.currentPage+2 }"></c:set>
					</c:otherwise>
				</c:choose>
			</c:if>
			<%-- 循环创建 --%>
				<c:forEach var="i" begin="${begin}" end="${end }">
					<c:if test="${puInfo.currentPage==i }">
						<a>${i }</a>
					</c:if>
					<c:if test="${puInfo.currentPage!=i }">
						<a href="queryFindUserInfo.do?currentPage=${i}">${i}</a>
					</c:if>				
				</c:forEach>
			<!-- 分页条的显示 -->
			
			<c:if test="${puInfo.currentPage<puInfo.totalPages}">
	    		<a href="queryFindUserInfo.do?currentPage=${puInfo.currentPage+1}">下一页</a>
    		</c:if>
			<a href="queryFindUserInfo.do?currentPage=${puInfo.totalPages}">末页</a>
		</div>
  	</center>
    	
  </body>
</html>
