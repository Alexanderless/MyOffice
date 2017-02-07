<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'FileInfo.jsp' starting page</title>
    
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
			margin:0;
			padding: 0;
		}
		span{
		font-style: italic;
		font-size: 14px;
		color: #EE9A00;
		margin:0 20px;
		}
		#title{
			font-size: 20px;
			font-weight: bold;
		}
		table{
			width:650px;
			margin:0px 35px;
		}
		div{
			margin-top:5px;
			margin-left: 50px;
			width:650px;
		}
		input{
			font-size: 18px;
		}
			
	</style>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
	</script>
  </head>

<body style="border:solid 1px #CFCFCF">
	<br />
	<span id="title">文件夹</span>
	<br />
	<br />
	<form action="addFileIn.do?parentId=${fileInfo.fileId}&&fileTypeInfo.fileTypeId=1" method="post" enctype="multipart/form-data">
		<table id="tad" cellpadding="3px" cellspacing="30">
			<tr>
				<td width="70px">文件夹名</td>
				<td width="580px"><input type="text" name="fileName" style="width: 350px;height: 30px"></td>
			</tr>
			<tr>
				<td>位置</td>
				<td><input type="text" name="filePath"
					value="${fileInfo.filePath }" 
					style="width: 350px;height: 30px;border-style:none"readonly="readonly"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><textarea rows="5" name="remark" cols="30"
						style="width: 350px; height: 100px"></textarea></td>
			</tr>	
			</table>
			
			<div id="div2">
			创建时间：<input type="text" readonly="readonly" name="createDate" style="border-style:none">所有者：<input type="text" name="fileOwner"value="${fileInfo.fileOwner }" readonly="readonly"style="border-style:none;">
				<br/><br/>
			</div>
				<HR style="border:5 dashed #987cb9" width="95%" color=#987cb9 SIZE=2>
				<br/>
				<div>
			<input type="submit" value="保存" style="margin-left: 50px"><input type="reset" value="退出" style="margin-left: 200px">
		</div>
	</form>
</body>
</html>
