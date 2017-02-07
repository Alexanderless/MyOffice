<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updataMsg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/showdate.js"></script>
	<script type="text/javascript">
		$(function(){
			$("table tr td:first-child").attr("align", "right");
			$(".btn1").click(function(){
				var allContent = $(this).next().children().val();
                var txt = allContent;
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
            });
			$("#messageType option[value='"+${message.messageType.messageTypeId}+"']").attr("selected",true);
			var bTime = $("#beginTime").html();
			var eTime = $("#endTime").html();
			$("#time").val(bTime);
			$("#time1").val(eTime);
		})
		
		function save(){
			$("form").attr("action","updataMsg.do?messageId="+${message.messageId}).submit();
		}
	</script>
	<style type="text/css">
		*{
			margin:0;
		}
		span{
			font-size:14px;
			margin-left:6px;
		}
		h6{
			font-size:14px;
			font-weight: normal;
			margin-top:8px;
		}
		.left,.right{
			margin-top:3px;
			width:330px;		
		}
		p{
			padding-top:6px;
		}
		#choose{
			margin-left:404px;
			margin-top:12px;
			width:100px;
			height:28px;
			font-size: 12px;
		}
		h3{
			padding:10px 0;
			font-weight: normal;
		}
		td{
			font-size:14px;
		}
	</style>
  </head>
  
  <body>
    <form action="" method="post">
    		<center>
    		<h3>消息填写区</h3>
    		<table cellpadding="6" cellspacing="0">
    			<tr>
    				<td>消息标题:</td>
    				<td><input type="text" value="${message.title }" name="title"/></td>
    			</tr>
    			<tr>
    				<td>消息类型:</td>
    				<td>
    					<select name="messageType.messageTypeId" id="messageType" style="height:26px;width:160px">
    						<option value="1001">一般消息</option>
    						<option value="1002">紧急消息</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>开始有效时间:</td>
    				<td><input type="text" value="" name="beginTime" id="time" placeholder="" onClick="return Calendar('time');" class="text_time"/></td>				
    			</tr>
    			<div hidden="true" id="beginTime"><fmt:formatDate value="${message.beginTime }" pattern="yyyy-MM-dd"/></div>
	    		<div hidden="true" id="endTime"><fmt:formatDate value="${message.endTime }" pattern="yyyy-MM-dd"/></div>
    			<tr>
    				<td>结束有效时间:</td>
    				<td><input type="text" value="" name="endTime" id="time1" placeholder="" onClick="return Calendar('time1');" class="text_time"/></td>				
    			</tr>	
    		</table>
    		<span disabled="true">发送对象:</span>
    		<input disabled="true" type="radio" name="toUser" value="allUser"><span style="color:#666">所有人</span>
    		<input disabled="true" type="radio" name="toUser" value="anyUser"><span style="color:#666">选择特定对象</span>
    		
    		</center>
    		 <div id="text" style="margin-left:354px">
			   	<h6>消息内容:</h6>
			   	<textarea name="allContent"  rows="6" cols="30">${message.content }</textarea>
			  </div>
    	  	 </form>
    	  	 <center>
			<a href="queryPageMessage.do"><button style="width:80px;height:24px;margin-top:8px;">返回</button></a>
			<button style="width:80px;height:24px;margin-left:10px" onclick="save()">保存消息</button>
			</center>
  </body>
</html>
