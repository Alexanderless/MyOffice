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
    
    <title>My JSP 'InboxInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="js/bootstrap/bootstrap.min.css">
    <script src="js/bootstrap/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript">
	 $(function () { 
		 $("#chkAll").click(function(){
				if(this.checked){
					$("input[type='checkbox']").prop("checked","checked");			
				}
				else{
					$("input[type='checkbox']").prop("checked",false);				
				}
		});
		//删除收件箱信息
		 $("#delBot").click(function(){
			 var ids =[];
			 var j = 0;
			 $("input[name='checkOne']").each(function(i,n){
				 if($(n).is(":checked")){
					 ids[j++]=$(n).val();
				 }
				 location.href="delSend.do?ids="+ids.join(",");
			 });
		 });	
		
	 });
	 function show(id,title,messageType,content,userName,recordTime){
		 $(".modal-body table tr").find("td").eq(1).css("text-align","left");
		 $(".modal-body table").find("tr").eq(0).find("td").eq(1).text(title);
		 $(".modal-body table").find("tr").eq(1).find("td").eq(1).text(messageType);
		 $(".modal-body table").find("tr").eq(2).find("td").eq(1).text(userName);
		 $(".modal-body table").find("tr").eq(3).find("td").eq(1).text(recordTime);
		 $("button[type='button']").val(id);
		 $("textarea").text(content);
	 }
	</script>
	<style type="text/css">
		table{
			margin-top:28px;
			width:800px;
		}
		th,td{
			font-size:16px;
			text-align: center;
		}
		.line{width:740px;}
		.modal-body span{
			margin-top:12px;
		}
		.modal-footer{margin-top:10px;}
		.modal-body table tr td{
			padding:6px 0;
		}
		.title:HOVER{
			color:rgb(102,150,183);
		}
	</style>
  </head>
  	
  <body>
  	<center>
  	<h2>发件箱</h2>
  	<div class="line"><hr/></div>
  	<form action="">
     <table border="1" cellpadding="20" cellspacing="0">
    	<tr>
    		<th style="padding:10px 10px"><input id="chkAll" type="checkbox" name="checkAll">全选</th>
    		<th>收件人</th>
    		<th>主题</th>
    		<th>发送时间</th>
    		<th>紧急程度</th>
    	</tr>
    	<c:forEach var="ls" items="${list }">
    		<tr>
    			<td><input value="${ls.message.messageId }" class="cheOne" type="checkbox" name="checkOne"/></td>
    			<td>${ls.toUser }</td>
    			<td class="title" onclick="show('${ls.message.messageId}','${ls.message.title}','${ls.message.messageType.messageTypeName}','${ls.message.content}','${ls.message.userInfo.userName}','<fmt:formatDate value="${ls.message.recordTime }" pattern="yyyy-MM-dd"/>')" style="cursor:pointer;padding:10px 10px;" data-toggle="modal" data-target="#myModal">${ls.message.title }</td>
    			<td><fmt:formatDate value="${ls.message.recordTime }" pattern="yyyy-MM-dd"/></td>   			
    			<td>${ls.message.messageType.messageTypeName }</td>
    		</tr>
    	</c:forEach>	
     </table>
     </form>
     </center>
     <a href="getAllCount.do"><button style="width:100px;height:30px;margin-left:147px;font-size: 12px;margin-top:8px;">返回</button></a>
     <button id="delBot" style="width:100px;height:30px;margin-left:10px;font-size: 12px;margin-left:10px"">删除选定项</button>
     
     
     <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">
                </button>
            </div>
            <div class="modal-body">
            	<table>
            		<tr>
            			<td>消息主题：</td>
            			<td></td>
            		</tr>
            		<tr>
            			<td>重要程度：</td>
            			<td style="text-align:left"></td>
            		</tr>
            		<tr>
            			<td>发件人：</td>
            			<td style="text-align:left"></td>
            		</tr>
            		<tr>
            			<td>发件时间：</td>
            			<td style="text-align:left"></td>
            		</tr>
            		<tr>
            			<td>消息内容：</td>
            			<td><textarea style="float:left" rows="6" cols="40"></textarea></td>
            		</tr>
            	</table>
            </div>
            <div class="modal-footer">
                <button type="button" value="" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
  </body>
</html>
