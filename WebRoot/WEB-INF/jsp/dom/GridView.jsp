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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#tab1{
		width:250px;
		margin-left:10px;
		height: 400px;
	}
	#tab1 td{
		border: none;
	}
	#tab2{
		width: 750px;
	}
	#tab2 tr{
		height: 35px;
	}
	th{
		background-color: rgb(107,155,189);
	}
	#div2{	
		margin-left:20px;
		margin-top: 20px
	}
	div{
		float: left;
	}
	</style>
	<script type="text/javascript" src="jquery-1.8.3.js"></script>
	<script type="text/javascript">
		//分页跳转
		$(function(){
			function fy(i){
				var ps=${pageSize};
				location.href="search.do?pageSize="+(parseInt(ps)+i);
			}
		});
	</script>

  </head>
  
  <body>
    <center>
 		<h2>文件搜索</h2>
 		<HR style="border:1 dashed #987cb9" width="95%" color=#987cb9 SIZE=2>
 	</center>
  	<div>
  		<form action="search.do" method="post">
	    <table id="tab1" border="2px" bordercolor="#36648B">
 			<tr>
  				<td><span>要搜索的文件名：</span><br/> <input type="text" name="fileName"></td> 				
  			</tr>
  			<tr>
				<td><span>附件包含的文字：</span><br/><input type="text" name="content" ></td>				
			</tr>
			<tr>
				<td><span>创建者的姓名：</span><br/><input type="text" name="fileOwner" ></td>				
			</tr>
			<tr>	
				<td><input  type="submit" value="检索">
				<input type="reset" value="退出"></td>
			</tr>				
		</table>
		</form>
  	</div>
  	<div id="div2">
  		<c:if test="${list!=null}">
		<table id="tab2" border="1px" cellpadding="3px" cellspacing="0px">
			<tr>
				<th>序号</th>
				<th>文件名称</th>
				<th>所在文件夹</th>
				<th>类型</th>
				<th>所有者</th>
				<th>创建日期</th>
			</tr>
			<%int i=1; %>
			<c:forEach items="${list }" var="ls">
				<tr>
					<td><%=i++ %></td>
					<td>${ls.fileName }</td>
					<td>${ls.filePath }</td>
					<td>${ls.fileTypeInfo.fileTypeName }</td>
					<td>${ls.fileOwner}</td>
					<td><fmt:formatDate value='${ls.createDate }' pattern='yyyy-MM-dd' /></td>
				</tr>
			</c:forEach>
			<tfoot>
			<tr>
				<td colspan="6" align="right">
				<c:if test="${pageSize!=1 }">
				<a href="search.do?pageSize=${pageSize-1 }">上一页</a>
				</c:if>
				&nbsp;
				<c:if test="${pageSize!=count }">
				<a href="search.do?pageSize=${pageSize+1 }">下一页</a>
				</c:if>
			</tr>
		</tfoot>
		</table>		
	</c:if>
	<c:if test="${list==null}">
		 你查询的文件不存在
	 </c:if>
  	</div>
  	
 
  </body>
</html>
