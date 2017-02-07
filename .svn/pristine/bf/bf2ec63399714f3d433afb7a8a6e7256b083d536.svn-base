<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>操作日志</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#endTime").change(function(){
			var difference=$("#endTime").val()>=$("#beginTime").val();
			if(!difference){
				alert("你输入的结束时间小于开始时间，请重新输入");
			}
		});
		$("#checkAll").change(function(){
			if(this.checked){
				$("[type=checkbox]").attr("checked","checked");
			}
			else
				$("input[type=checkbox]").removeAttr("checked","checked");
		});
		//删除按钮
		$("#delete").click(function(){
				var ids =[];
				var j = 0;
				$("input[name=chkOne]").each(function(i,n){
					if($(n).attr("checked")=="checked")
						ids[j++]=$(n).val();
				});
				location.href="sm/delop.do?ids="+ids.join(",");
			});
	});
	
			
	
	</script>

  </head>
  
  <body>
   <center>
	   <h2>操作日志</h2>
	   <HR style="border:1 dashed #987cb9" width="95%" color=#987cb9 SIZE=1>
</center>
	<form action="sm/searchOpe.do" method="post" enctype="multipart/form-data">
	   <center>
		 输入时间段：<input id="beginTime" type="text" name="beginTime">——<input id="endTime" type="text" name="endTime"><br/><br/>
		</center>
		 <button  value="搜索" style="height: 30px;width: 60px;margin-left: 310px">搜索</button>
		</form>

		<c:if test="${list!=null}">
		<input style="margin-left: 160px;font-size: 19px" type="checkbox" id="checkAll">全选   <button id="delete" style="margin-left: 560px;font-size: 19px">删除选定项</button>
		<center>
		<%int i=1; %>	
		<table border="1px" cellpadding="5px" cellspacing="0px" width="800px">
		<tr>
			<th>选定</th>
			<th>序号</th>
			<th>操作用户</th>
			<th>事件</th>
			<th>操作描述</th>
			<th>操作时间</th>
		</tr>
		<c:forEach items="${list}" var="lst">
		<tr>
			<td><input type="checkbox" value="${lst.operateId }" name="chkOne"></td>
			<td><%=i++ %></td>
			<td>${lst.operateName }</td>
			<td>${lst.objectId }</td>
			<td>${lst.operateDesc }</td>	
			<td><fmt:formatDate value="${lst.operateTime }" pattern="yy-MM-dd hh:mm:ss"/></td>	
		</tr>	
		</c:forEach>	
		</table>
		</center>
		</c:if>
		<c:if test="${msg!=null}">
		<center>没有符合您查询条件的记录存在</center>
		</c:if>
  </body>
</html>
