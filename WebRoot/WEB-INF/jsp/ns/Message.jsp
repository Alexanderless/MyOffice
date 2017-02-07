<%@page import="java.text.DateFormat"%>
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
    
    <title>My JSP 'Message.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="js/xcConfirm.css"/>
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/showdate.js"></script>
	
	<script type="text/javascript">
		$(function(){
			$(".btn1").click(function(){
				var allContent = $(this).next().children().val();
                var txt = allContent;
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
            });
			
			$("#search").click(function(){
				var beginTime = $("#time").val();
				var endTime = $("#time1").val();
				if(Date.parse(beginTime.replace(/-/g, "/")) > Date.parse(endTime.replace(/-/g, "/")) ){
					alert("结束时间不能早于开始时间！");
					return false;
				}
				if(Date.parse(beginTime.replace(/-/g, "/")) > Date.parse(endTime.replace(/-/g, "/"))){			
					$("form").submit();
					return true;
				}
			});
			
			var bTime = $("#beginTime").html();
			var eTime = $("#endTime").html();
			$("#time").val(bTime);
			$("#time1").val(eTime);
		});
		function page(index){
			var currentPage = ${pm.currentPage};
			$("form").attr("action","querySeaMessage.do?currentPage="+(parseInt(currentPage+index))).submit();	
		}
		function firstPage(){
			
			$("form").attr("action","querySeaMessage.do?currentPage=1").submit();
		}
		function lastPage(){
			var lastPage = ${pm.totalPages};
			$("form").attr("action","querySeaMessage.do?currentPage="+lastPage).submit();	
		}
		function thisPage(index){
			$("form").attr("action","querySeaMessage.do?currentPage="+index).submit();	
		}
	</script>
	
	<style type="text/css">
	.btn1{
		cursor: pointer;
	}
	.btn1:HOVER{
		color:rgb(102,150,183);
	}
	a:HOVER{
		color:rgb(102,150,183);
	}
	h2{
		parddng-top:10px;
	}
	.line{width:940px;}
	.text_time{
        width: 160px;
        height: 26px;
        background: #fff;
        border:1px solid;
    }
    button{
    	width:80px;
		height:24px;
		margin:	5px 5px;	
		font-size: 12px;
    }
    span{
    	font-size:16px;
    	margin-right:4px;
    }
    th{
    	font-size:12px;
    	height:44px;
    }
    td{
    	font-size:12px;
    }
    #page1{
		color:#000;font-size: 20px;
		padding-top:18px;
		padding-bottom: 12px;
		}
	a{ text-decoration:none; color:#000;font-size: 20px;cursor: pointer;}
	P{
		font-size:16px;
		margin-left:78px;
	}
	form{
		margin-bottom: 8px;
	}
	input{
		margin-top:12px;
		margin-right:12px;
	}
	form{
		margin-left:78px;
	}
	table{
		width:1052px;
	}
	</style>
  </head>
  
  <body>
  	<center>
  		<h1 style="padding-top: 10px">消息管理</h1>
  		<div class="line"><hr/></div>
  	</center>
    	<P>请输入填写消息的时间：</P>
    	
    	<form action="querySeaMessage.do" method="post">
	    	<span>开始时间:</span>
	    	<div hidden="true" id="beginTime"><fmt:formatDate value="${pm.beginTime }" pattern="yyyy-MM-dd"/></div>
	    	<div hidden="true" id="endTime"><fmt:formatDate value="${pm.endTime }" pattern="yyyy-MM-dd"/></div>
	    	<input type="text" value="" name="beginTime" id="time" placeholder="选择时间" onClick="return Calendar('time');" class="text_time"/>  	
	    	<span>结束时间:</span>
	    	 <input type="text" value="" name="endTime" id="time1" placeholder="选择时间" onClick="return Calendar('time1');" class="text_time"/>
	    	<input type="radio" name="date"/><span>本日</span>
	    	<input type="radio" name="date"/><span>本周</span>
	    	<input type="radio" name="date"/><span>本月</span>
	    	<button id="search" style="height:24px;width:80px">搜索</button>
    	</form>
    	
    <center>
    	<div style="background-color:rgb(102,150,183); width:1052px;"><a href="addMsgURL.do"><button style="height:28px;width:90px;margin-left:900px">添加新消息</button></a></div>	
    	<table border="1" cellpadding="10" cellspacing="0">
    		<tr>
    			<th>消息标题</th>
    			<th>消息类型</th>
    			<th>消息内容</th>
    			<th>创建者</th>
    			<th>发送对象</th>
    			<th>开始时间</th>
    			<th>结束时间</th>
    			<th>创建时间</th>
    			<th>修改</th>
    			<th>删除</th>
    			<th>发布</th>
    		</tr>
    		<c:forEach var="ls" items="${pm.list }">
    			<tr>
					<td>${ls.message.title}<input class="ifPublish" type="hidden" value="${ls.message.ifPublish}"></td>
					<td>${ls.message.messageType.messageTypeName }</td>
					<td class="btn1">${ls.message.content }</td>
					<td style="display:none"><input type="text" value="${ls.message.allContent}"/></td>
					<td>${ls.message.userInfo.userName}</td>
					<td>${ls.toUser}</td>
					<td><fmt:formatDate value="${ls.message.beginTime}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${ls.message.endTime}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${ls.message.recordTime}" pattern="yyyy-MM-dd"/></td>
					<c:if test="${ls.message.ifPublish==0}">
						<td><a href="updataMsgURL.do?id=${ls.message.messageId}"><button class="delbot">修改</button></a></td>
					</c:if>
					<c:if test="${ls.message.ifPublish==1}">
						<td><a href="updataMsgURL.do?id=${ls.message.messageId}"><button disabled="true">修改</button></a></td>
					</c:if>
					
						<td><a href="delMessage.do?id=${ls.message.messageId}"><button onclick="return confirm('是否删除？')">删除</button></a></td>	
					
					<c:if test="${ls.message.ifPublish==0}">
						<td><a href="ifPublish.do?id=${ls.message.messageId}"><button style="disabled:true" class="ifbut">发布</button></a></td>
					</c:if>
					<c:if test="${ls.message.ifPublish==1}">
						<td><button disabled="true" class="ifbut">发布</button></td>
					</c:if>
				</tr>
			</c:forEach>
    	</table>
    	
    	<div id="page1">第${pm.currentPage }页/总${pm.totalPages }页</div>
    		<div>
			<a onclick="firstPage()">首页</a>
				<c:if test="${pm.currentPage>1}">
	    		<a onclick="page(-1)">上一页</a>
	    	</c:if>
			
			<!-- 分页条的显示 -->
			<c:set var="begin" value="0"></c:set>
			<c:set var="end" value="0"></c:set>
			<%--获取begin 和  end --%>
			<c:if test="${pm.totalPages<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${pm.totalPages }"></c:set>
			</c:if>
			<c:if test="${pm.totalPages>5 }">
				<c:choose>
					<c:when test="${pm.currentPage<3 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="5"></c:set>
					</c:when>
					<c:when test="${pm.currentPage>=pm.totalPages-2 }">
						<c:set var="begin" value="${pm.totalPages-4 }"></c:set>
						<c:set var="end" value="${puInfo.totalPages }"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${pm.currentPage-2 }"></c:set>
						<c:set var="end" value="${pm.currentPage+2 }"></c:set>
					</c:otherwise>
				</c:choose>
			</c:if>
			<%-- 循环创建 --%>
				<c:forEach var="i" begin="${begin}" end="${end }">
					<c:if test="${pm.currentPage==i }">
						<a>${i }</a>
					</c:if>
					<c:if test="${pm.currentPage!=i }">
						<a onclick="thisPage(${i})">${i}</a>
					</c:if>				
				</c:forEach>
			<!-- 分页条的显示 -->
			
			<c:if test="${pm.currentPage<pm.totalPages}">
	    		<a onclick="page(+1)">下一页</a>
    		</c:if>
			<a onclick="lastPage()">末页</a>
		</div>
    </center>
 </body>
</html>
