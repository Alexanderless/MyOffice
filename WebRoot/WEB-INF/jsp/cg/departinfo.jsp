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
    
    <title>My JSP 'departinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
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
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showdate.js"></script>
	<script>
		$(function(){//获取机构信息
			$.ajax({
				url:'queryBranch.do',
				dataType:'json',
				success:function(data){
					$("#branch").append("<option>--请选择公司--</option>");
					$(data).each(function(i,n){
						$("#branch").append("<option value="+n.branchId+">"+n.branchName+"</option>");
					});
				}
			});	
		});
			
		//值改变时，获取部门信息
		$(function(){	
			$("#branch").change(function(){
				$("#dep").empty();
				var branch=$("#branch").val();
				
				//alert(branch);
					$.ajax({
					url:'queryDepList.do?branchId='+branch,
					dataType:'json',
					success: function(data){
						$("#dep").append("<option>--请选择部门--</option>");
						$(data).each(function(i,n){
							$("#dep").append("<option value="+n.departId+">"+n.departName+"</option>");
						});
					}
				});
			});
			
		});
		// departId值改变时，获取员工信息
		$(function(){	
			$("#dep").change(function(){
				$("#userName").empty();
				var departId=$("#dep").val();
				
				alert(departId);
					$.ajax({
					url:'queryUserInfo.do?departId='+departId,
					dataType:'json',
					success: function(data){
						$("#userName").append("<option>--请选择员工--</option>");
						$(data).each(function(i,n){
							$("#userName").append("<option value="+n.userId+">"+n.userName+"</option>");
						});
					}
				});
			});
			
		});
		$(function(){
			 $("#tab").css("display","none");
			var depId;
			var branchId;
			var userId;
			
			$("#dep").change(function(){
				depId=$("#dep").val();
				alert(depId);
			});
			$("#branch").change(function(){
				branchId=$("#branch").val();
				alert(branchId);
			});
			$("#userName").change(function(){
				userId=$("#userName").val();
				alert(userId);
			});
			$("#depbtn").click(function(){
				var createTime=$("#createTime").val();
				/* alert("createTime"+createTime); */
			    	$("#tab").empty(); 
				 $.ajax({
					url:'queryScheduleByMany.do' ,
					type: "POST",
					dataType:'json',
					data:{
						'departId':depId,
						'branchId':branchId,
						'userId':userId,
						'createTime':createTime
					},
					error:function(){
						            alert(error);
						        	},
					success:function(data){
						/* alert(data); */
						$("#tab").append("<tr><th>日程主题</th><th>日程内容</th><th>日程开始时间</th><th>会议地址</th><th>会议类型</th><th>机构名称</th><th>部门名称</th><th>创建者</th></tr>");
						$(data).each(function(i,n){						
							$("#tab").append("<tr><td>"+n.title+"</td><td>"
							+n.schContent+"</td><td>"+n.beginTime+"</td><td>"+n.address+"</td><td>"
							+n.meetingInfo.meetingName+"</td><td>"+n.branchInfo.branchName+"</td><td>"
							+n.departInfo.departName+"</td><td>"+n.userInfo.userName+"</td></tr>");
							$("#tab").css("display","block");
						});
					}
				});  
			});
			
		}); 
		
	
	</script>
  </head>
  
  <body>
   	<span >请选择机构--：</span><select id="branch" name="branchInfo.branchName"></select>&nbsp;<span >选择部门--:</span><select id="dep"></select>&nbsp;<span>姓名：</span><select id="userName"></select><br>
   	<span>日期--</span><input id="createTime" type="text" onClick="return Calendar('createTime')" /> <button id="depbtn">搜索</button>
   	<table class="imagetable" id="tab">
   	<tr>
   		<th>日程主题</th>
   		<th>日程内容</th>
   		<th>日程开始时间</th>
   		<th>会议地址</th>
   		<th>会议类型</th>
   		<th>机构名称</th>
   		<th>部门名称</th>
   		<th>创建者</th>
   	</tr>
   		
   	</table>
  </body>
</html>
