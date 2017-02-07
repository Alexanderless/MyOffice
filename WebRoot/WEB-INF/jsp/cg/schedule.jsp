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
	  	<display:table class="imagetable" name="list" pagesize="5" requestURI="queryScheduleListByName.do?" >
	  		<display:column property="title" title="日程标题"/>
	  		<display:column property="address" title="会议地址"/>
	  		<display:column property="meetingInfo.meetingName" title="会议类型"/>
	  		<display:column property="beginTime" title="日程开始时间" format="{0,date,yyyy-MM-dd hh:mm:ss}"/>
	  		<display:column property="endTime" title="日程结束时间" format="{0,date,yyyy-MM-dd hh:mm:ss}"/>
	  		<display:column property="schContent" title="日程内容"/>
	  		<display:column property="userInfo.userName" title="创建者"/>
	  		<display:column property="createTime" title="创建时间" format="{0,date,yyyy-MM-dd hh:mm:ss}"/>
	  		<display:column property="ifPrivate" title="是否私有"/>
	  		<display:column style="width:30px" href="goEdit.do" paramId="createUser" paramProperty="userInfo.userId" value="添加" title="添加"/>
	  		<display:column style="width:30px" href="queryScheduleById.do" paramId="scheduleId" paramProperty="scheduleId" value="修改" title="修改"/>
	  		<display:column style="width:30px" href="delSchedule.do" paramId="scheduleId" paramProperty="scheduleId" value="删除" title="删除"/>
	  		
	  		
	  	</display:table>
  	</div>
  	<%-- <h2>我的日程</h2>
     <table align="center" border="1px" cellpadding="10" cellspacing="0" bordercolor="gray">
     <tr>
   		<th>日程id</th>
   		<th>日程标题</th>
   		<th>会议地址</th>
   		<th>会议类型</th>
   		<th>日程开始时间</th>
   		<th>日程结束时间</th>
   		<th>日程内容</th>
   		<th>创建者</th>
   		<th>创建时间</th>
   		<th>是否私有</th>
   		<th>操作</th>
     </tr>
     <c:forEach items="${list }" var="sche">
     	<tr>
	     	<td>${sche.scheduleId }</td>
	     	<td>${sche.title }</td>
	     	<td>${sche.address }</td>
	     	<td>${sche.meetingInfo.meetingName }</td>
	     	<td><fmt:formatDate value="${sche.beginTime}" pattern="yyyy-MM-dd"/></td>
	     	<td><fmt:formatDate value="${sche.endTime}" pattern="yyyy-MM-dd"/></td>
	     	<td>${sche.schContent }</td>
	     	<td>${sche.userInfo.userName}</td>
	     	<td><fmt:formatDate value="${sche.createTime}" pattern="yyyy-MM-dd"/></td>
	     	<td>${sche.ifPrivate }</td>
	     	<td><a href="queryScheduleById.do?scheduleId=${sche.scheduleId}">修改</a>
	     		<a href="goEdit.do?createUser=${sche.userInfo.userId}">添加</a>
	     		<a href="delSchedule.do?scheduleId=${sche.scheduleId}" onclick="return confirm('是否删除【${sche.title}】？')">删除</a>
	     	</td>
     	</tr>
     </c:forEach>
     </table> --%>
  </body>
</html>
