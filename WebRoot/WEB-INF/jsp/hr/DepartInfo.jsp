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
    
    <title>My JSP 'DepartInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{ text-decoration:none; color:#000;font-size: 20px;}
		#page1{
			color:#000;font-size: 20px;
			padding-top:16px;
			padding-bottom:8px;
		}	
		.line{width:940px;}
		#update,#del{
			width:90px;
			height:26px;
			margin-left:20px;
			font-size: 12px;
		}
		#add{	
			width:100px;
			height:26px;
			margin-top:16px;
			margin-bottom:16px;
			margin-right:10px;
			margin-left:842px;
			font-size: 14px;
		}
		td,th{font-size: 16px;font-weight: normal;height:50px;}
		table{width:970px;height:200px;}
		h2{
		padding-top:20px;
	}	
	</style>
  </head>
  
  <body>
  	<center>
  	<h2>部门管理</h2>
    <div class="line"><hr/></div>
  	<a href="goPageURL.do"><button id="add">添加部门</button></a>
  	<table border="1" cellpadding="8" cellspacing="0">
  		<tr>
  			<th>部门名称</th>
  			<th>机构</th>
  			<th>负责人</th>
  			<th>联系电话</th>
  			<th>移动电话</th>
  			<th>传真</th>
  			<th>修改</th>
			<th>删除</th>  			
  		</tr>
    	<c:forEach var="ls" items="${pdepInfo.list}">
    		<tr>
    			<td>${ls.departName}</td>
    			<td>${ls.branchInfo.branchName }</td>
    			<td>${ls.userInfo.userName }</td>
    			<td>${ls.connectTelNo }</td>
    			<td>${ls.connectMobileTelNo }</td>
    			<td>${ls.faxes}</td>
    			<td><a href="updateDepartURL.do?id=${ls.departId }"><button id="update">修改</button></a></td>
    			<td><a href="delDepartInfo.do?id=${ls.departId }"><button id="del" onclick="return confirm('是否删除？')">删除</button></a></td>
    		</tr>
    	</c:forEach>
    </table>
    <div id="page1">第${pdepInfo.currentPage }页/总${pdepInfo.totalPages }页</div>
    		<div>
			<a href="queryPageDepartInfo.do?currentPage=1">首页</a>
				<c:if test="${pdepInfo.currentPage>1}">
	    		<a href="queryPageDepartInfo.do?currentPage=${pdepInfo.currentPage-1}">上一页</a>
	    	</c:if>
			
			<!-- 分页条的显示 -->
			<c:set var="begin" value="0"></c:set>
			<c:set var="end" value="0"></c:set>
			<%--获取begin 和  end --%>
			<c:if test="${pdepInfo.totalPages<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${pdepInfo.totalPages }"></c:set>
			</c:if>
			<c:if test="${pdepInfo.totalPages>5 }">
				<c:choose>
					<c:when test="${pdepInfo.currentPage<3 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="5"></c:set>
					</c:when>
					<c:when test="${pdepInfo.currentPage>=puInfo.totalPages-2 }">
						<c:set var="begin" value="${pdepInfo.totalPages-4 }"></c:set>
						<c:set var="end" value="${pdepInfo.totalPages }"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${pdepInfo.currentPage-2 }"></c:set>
						<c:set var="end" value="${pdepInfo.currentPage+2 }"></c:set>
					</c:otherwise>
				</c:choose>
			</c:if>
			<%-- 循环创建 --%>
				<c:forEach var="i" begin="${begin}" end="${end }">
					<c:if test="${pdepInfo.currentPage==i }">
						<a>${i }</a>
					</c:if>
					<c:if test="${pdepInfo.currentPage!=i }">
						<a href="queryPageDepartInfo.do?currentPage=${i}">${i}</a>
					</c:if>				
				</c:forEach>
			<!-- 分页条的显示 -->
			
			<c:if test="${pdepInfo.currentPage<pdepInfo.totalPages}">
	    		<a href="queryPageDepartInfo.do?currentPage=${pdepInfo.currentPage+1}">下一页</a>
    		</c:if>
			<a href="queryPageDepartInfo.do?currentPage=${pdepInfo.totalPages}">末页</a>
		</div>
    </center>	
  </body>
</html>
