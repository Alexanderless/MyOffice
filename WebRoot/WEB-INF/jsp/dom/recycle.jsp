<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recycle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			margin: 0;
			padding-top:3px;
		}
		table{
			width: 1000px;
		}
		th{
			width:500px;
			background-color:rgb(107,155,189);
		}
		a{
			text-align:center;
			text-decoration: none;
			font-size: 20px;
		}
	</style>

  </head>
  
  <body>
  <center>
     <h2>回收站</h2>
  <c:if test="${list!=null }">
    <table border="1px" cellpadding="10px" cellspacing="0px">
 
		<tr>
		    <th>文件名称</th>
		    <th>所在文件夹</th>
		    <th>类型</th>
		    <th>操作者</th>
		    <th>删除日期</th>
		   	<th>还原</th>
		   	<th>永久删除</th>
	    </tr>
	    <c:forEach items="${list}" var="ls">
	    <tr>
		    <td>${ls.fileName }</td>
		    <td>${ls.filePath }</td>
		    <td>${ls.fileTypeInfo.fileTypeName }</td>
		    <td>${ls.fileOwner}</td>
		    <td><fmt:formatDate value='${ls.createDate }' pattern='yyyy-MM-dd' /></td>
		    <td><a href="restore.do?ifDelete=2&&fileId=${ls.fileId}">还原</a></td>
		    <td><a href="restore.do?ifDelete=2&&fileId=1">永久删除</a></td>
	    </tr>    
	</c:forEach>
    </table>
    </c:if>
    <c:if test="${list==null }">
 	<h2 style="font:italic">  您的回收站空空如也</h2> 
    </c:if>
   </center>
  </body>
</html>
