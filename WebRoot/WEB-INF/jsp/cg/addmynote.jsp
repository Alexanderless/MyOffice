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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<style type="text/css">
		table.imagetable {
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #999999;
		border-collapse: collapse;
		}
		table.imagetable th {
		background:#b5cfd2 url('../../../images/cell-blue.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
		}
		table.imagetable td {
		background:#dcddc0 url('../../../imagescell-grey.jpg');
		border-width: 1px;
		padding: 8px;
		border-style: solid;
		border-color: #999999;
		}
	</style>
  </head>
  
  <body>
  		
   <div  align="center" >
   <h2>添加便签</h2>
    <form action="addMyNote.do" method="post">
	     <table class="imagetable">
		    <!--  <tr><td>便签id:</td><td><input type="text" name="noteId"/></td></tr> -->
		     <tr><td>便签标题:</td><td><input type="text" name="noteTitle"/></td></tr>
		     <tr><td>便签内容:</td><td><textarea name="noteContent" rows="5" cols="20"></textarea></td></tr>
		     <tr ><td>创建时间:</td><td><input type="date" name="createTime"/></td></tr>
		     <tr><td></td><td><input type="hidden" readonly="readonly" name="userInfo.userId" value="${createUser }"/></td></tr>
	     	<tr >
	     		<td colspan="2" align="center"><input type="submit" value="保存"/></td>	
	     	</tr>
	     </table>
	 </form>
	 </div>
  </body>
</html>
