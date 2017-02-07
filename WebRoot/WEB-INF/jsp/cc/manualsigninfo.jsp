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
    
    <title>My JSP 'manualsign.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/Clock.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

    <style type="text/css">
        #data{width:68px;}
        textarea{width:400px;height:180px;}
 
    </style>
  </head>
  	
  <body>
    	 <h1 align="center">统计签卡信息</h1>

    <form id="down">
        <fieldset>
            <legend id="leg">统计签卡信息</legend>
            <br>
            <table border="1px">
                <tr>
                	<th>签卡员工</th>
                	<th>签卡时间</th>
                	<th>签卡标记</th>
                	<th>签卡备注</th>
                	<th>所属部门</th>
                	<th>所属机构</th>
                </tr>
                <c:forEach items="${list }" var="manual">
                <tr>
                	<td>${manual.userInfo.userId}</td>
                	<td><fmt:formatDate value="${manual.signTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
                	<td>${manual.signTag}</td>
                	<td>${manual.signDesc}</td>
                   	<td>${manual.departInfo.departName}</td>
                    <td>${manual.branchInfo.branchName}</td>
                </tr>
                </c:forEach>
            </table>
        </fieldset>
    </form>
  </body>
</html>
