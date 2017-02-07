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
    <form id="down">
        <fieldset>
            <legend id="leg"></legend>
            <br>
            <table>
                <tr>
                    <td>用户号：</td><td><input type="text" name="userInfo.userId" value="${manualSign.userInfo.userId }"></td>
                    <td>姓&nbsp;&nbsp;名：</td><td><input type="text" value="${manualSign.userInfo.userName}" ></td>
                </tr>
                <tr>
                    <td>所属部门：</td><td><input type="text" name="" value="${manualSign.departInfo.departName }"></td>
                    <td>所属机构：</td><td><input type="text" name="" value="${manualSign.branchInfo.branchName }"></td>
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td id="qdqt"></td><td id="time"></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
            </table>
            <span>签卡备注：</span><textarea style="height: 100px" name="signDesc"></textarea>
        </fieldset>
    </form>
  </body>
</html>
