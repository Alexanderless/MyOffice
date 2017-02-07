<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/showdate.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".btn1").click(function(){
				var allContent = $(this).next().children().val();
                var txt = allContent;
                window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.info);
            });		
			$("table tr td:first-child").attr("align", "right");
			$("form input[type='text']").css("width","160px");
			$("form input[type='text']").css("height","26px");
			$(".branch").change(function(){
				var branchId = $(this).val();
				if(branchId!=null){
					$.ajax({
						url:"queryDepartById.do?branchId="+branchId,
						dataType:'json',
						success:function(data){
								$(".depart option").remove();
								$(data).each(function(index){
									var name = $("<option value="+data[index].departId+">"+data[index].departName+"</option>");
								$(".depart").append(name);
							});						
						}
					});
				}
			});
			
			$("input[name='toUser']").change(function(){
				if($(this).is(':checked')){
					var touser = $(this).val();
					if(touser=="anyUser"){
						$("#find").css("display","block");
					}
					if(touser=="allUser"){
						$("#find").css("display","none");			
					}
				};			
			});
			
			$("#choose").click(function(){
				$("#addInput span").remove();
				$("#addInput input").remove();
				 var departId = $("#selector").find("option:selected").val();
				 if(departId!=null&&departId.length<4){
					 $("#chooseUser").css("display","block");
					 $("#find").css("height","180px");
					 $.ajax({
						 url:"queryUserInfoByDeparId.do?id="+departId,
						 dataType:'json',
						 type:'get',
						 success:function(data){
							 $(data).each(function(index){
								 var addCheck = $("<input type='checkbox' name='userName'/><span>"+data[index].userName+"</span>");
								 $("#addInput").append(addCheck);
							 });						 			
						}
					 });
					 return;
				 }
				 var userId = $(".user").val();
				 
				 if(userId!=null&&userId.length==4){
					 $("#chooseUser").css("display","block");
					 $("#find").css("height","180px");
					 var udd="麦迪";
					 var addCheck = $("<input type='checkbox' name='userName'/><span>"+udd+"</span>");
					 $("#addInput").append(addCheck);
				 }
		});		
			
			$("input[name='seach']").change(function(){
				if($(this).is(':checked')){
					var seachVal = $(this).val();
					if(seachVal=="branch"){
						$(".branch").attr("disabled",false);
					}
					if(seachVal=="depart"){
						$(".depart").attr("disabled",false);
					}
					if(seachVal=="user"){
						$(".user").attr("disabled",false);
					}
					if(seachVal=="name"){
						$(".name").attr("disabled",false);
					}
				}else{
					$(".branch").attr("disabled",true);
					$(".depart").attr("disabled",true);
					$(".user").attr("disabled",true);
					$(".name").attr("disabled",true);
				}				
			});		
		});
	</script>
	<style type="text/css">
		body{
			overflow-y:scroll;
		}
		*{
			margin:0;
		}
		#find{
			margin-top:10px;
			background-color:rgb(102,150,183);
			height:130px; 
		}
		#find span,p{
			color:#fff;
		}
		#find input{
			margin-top:8px;
		}
		span{
			font-size:14px;
			margin-left:6px;
		}
		h6{
			font-size:14px;
			font-weight: normal;
			margin-top:18px;
			margin-bottom:4px;
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
		#addInput input{
			margin-left:8px;
		}
		h2{
			padding:16px 0;
		}
		td{
			font-size:14px;
		}
	</style>
  </head>
  
  <body>  	
    	<form action="" method="post">
    		<center>
    		<h2>消息填写区</h2 >
    		<table cellpadding="10" cellspacing="0">
    			<tr>
    				<td>消息标题:</td>
    				<td><input type="text" name=""/></td>
    			</tr>
    			<tr>
    				<td>消息类型:</td>
    				<td>
    					<select style="height:26px;width:160px">
    						<option>一般消息</option>
    						<option>紧急消息</option>
    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>开始有效时间:</td>
    				<%Date currentTime = new Date(); 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String dateString = formatter.format(currentTime); %>
    				<td><input type="text" value="" name="beginTime" id="time" placeholder="<%=dateString %>" onClick="return Calendar('time');" class="text_time"/></td>
    				
    			</tr>
    			<tr>
    				<td>结束有效时间:</td>
    				<td><input type="text" value="" name="endTime" id="time1" placeholder="<%=dateString %>" onClick="return Calendar('time1');" class="text_time"/></td>
    				
    			</tr>	
    		</table>
    		<span>发送对象:</span>
    		<input type="radio" name="toUser" value="allUser"><span>所有人</span>
    		<input type="radio" name="toUser" value="anyUser"><span>选择特定对象</span>
    		</center>
    	  	 </form>		
    		<div id="find" style="display:none">
	    		<p style="text-align: center">筛选范围</p>	
	    		<input style="margin-left:6px" value="branch" type="checkbox" name="seach"><span>按机构</span>
	    		<input type="checkbox" value="depart" name="seach"><span>按部门</span>
	    		<input type="checkbox" value="user" name="seach"><span>按员工号</span>
	    		<input type="checkbox" value="name" name="seach"><span>按姓名</span><br/>
	    		<span>机构：</span>
	    		<select class="branch" disabled="true">
	    			<option>===请选择===</option>
	    			<c:forEach var="ls" items="${list }">
	    				<option value="${ls.branchId }">${ls.branchName }</option>
	    			</c:forEach>
	    		</select>
	    		<span>部门：</span>
	    		<select id="selector" style="width:150px" class="depart" disabled="true">
	    			<option>===请选择===</option>
	    		</select>
	    		<span>员工号：</span>
	    		<input class="user" type="text" disabled="true" name=""/>
	    		<span>姓名：</span>
	    		<input class="name" type="text" disabled="true" name=""/>
	    		<button id="choose">确定选择范围</button>
	    		<div id="chooseUser" style="display:none;">
		    		<p style="font-size:14px;margin-left:8px;">请选择发送对象</p>
			    	<input style="margin-left:8px" type="checkbox"><span>全选</span>
			    	<span id="addInput">
			    		
			    	</span>
			    </div>
	    	</div>
	    	 <div id="text" style="margin-left:434px">
			   	<h6>消息内容:</h6>
			   	<textarea rows="6" cols="30"></textarea>
			  </div>
			<center>
			<a href="queryPageMessage.do"><button style="width:90px;height:28px;margin-top:12px;">返回</button></a>
			<a href="queryPageMessage.do"><button style="width:90px;height:28px;margin-left:10px" onclick="save()">保存消息</button></a>
			</center>
  </body>
</html>
