<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net"prefix="display" %>
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
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$("#tjbq").click(function(){
		
		});
	</script>
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
		<div align="center">
  		<h2>我的便签</h2>
  		<display:table class="imagetable" name="list" pagesize="3" requestURI="queryMyNoteList.do">
  			<display:column property="noteTitle" title="便签主题"/>
  			<display:column property="noteContent" title="便签内容"/>
  			<display:column property="createTime" title="创建时间" format="{0,date,yyyy-MM-dd}"/>
  			<display:column href="goAddMyNote.do" paramId="createUser" paramProperty="userInfo.userId" value="添加" title="添加"/>
  			<display:column href="delMyNote.do" paramId="noteId" paramProperty="noteId" value="删除" title="删除"/>
  		</display:table>
  		</div>
    <%--  <table class="imagetable" id="myNote" align="center" border="1px" cellpadding="10" cellspacing="0" bordercolor="gray">
     <tr>
   		<th>便签id</th>
   		<th>便签标题</th>
   		<th>便签内容</th>
   		<th>创建时间</th>
   		<th>创建者</th>
   		<th>操作<th>

     </tr>
     <c:forEach items="${list }" var="note">
     	<tr>
	     	<td>${note.noteId }</td>
	     	<td>${note.noteTitle }</td>
	     	<td>${note.noteContent }</td>
	     	<td><fmt:formatDate value="${note.createTime}" pattern="yyyy-MM-dd:hh-mm"/> </td>
	     	<td>${note.userInfo.userName }</td>
	     	<td><a href="goAddMyNote.do?createUser=${note.userInfo.userId}">添加</a>
	     		<a href="delMyNote.do?noteId=${note.noteId}&userId=${note.userInfo.userId}" onclick="return confirm('是否删除【${note.noteTitle }】？')">删除</a>
	     	</td>
     	</tr>
     </c:forEach>
     </table> --%>
  </body>
</html>
