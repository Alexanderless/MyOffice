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
    
    <title>My JSP 'manualsign.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/Clock.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/jquery-form.js"></script>
	 <script type="text/javascript">
        $(function(){
            $("#down").css("display","none");
            $("#qt").attr("disabled","false");
           
        });
        $(document).ready(function(){
        	
            var clock=new Clock();
                $("#qd").click(function(){
                    $("#down").css("display","block");
                    $("#qdqt").text("你的签到时间是：");
                     $("#leg").text("你的签到信息");
                     $("#tag").val("1");//签卡标记
                    clock.displays(document.getElementById("time"));//输出系统时间
                    clock.displayed(document.getElementById("times"));
                    $("#qd").attr("disabled","false");
                    $("#qt").removeAttr("disabled");
              	   
	               	$("#top").ajaxSubmit({
	               		url:"insertManualSign.do", 
			     		type: "POST",
			      		dataType:'json',
			      		data:{
			      			'signTag': signTag,
			      			'signTime': signTime,
			      			'userInfo.userId':userId,
			      			'signDesc':signDesc	
			      		},
						error:function(){
						            alert(1);
						},	
		                success: function(data) {
		                    $(data).each(function(i,n){
		                    	$("#userId").val(n.userInfo.userId);
		                    	$("#name").val(n.userInfo.userName);
		                    	$("#depart").val(n.departInfo.departName);
		                    	$("#branch").val(n.branchInfo.branchName);
		                    });
		                }	                	
	                });
	                       
                });
            $("#qt").click(function(){
                $("#qt").attr("disabled","false");
                $("#qd").removeAttr("disabled");
                $("#qdqt").text("你的签退时间是：");
                $("#tag").val("2");
                clock.displays(document.getElementById("time"));
                clock.displayed(document.getElementById("times"));
                $("#down").css("display","block");
                 $("#leg").text("你的签退信息");
               /* $("#top").on('submit', function() {
               	var signTag=$("#tag").val();
               	var signTime=$("#time").text();
               	var userId=$("#userId").val();
               	var signDesc=$("#desc").val(); */
			     	$("#top").ajaxSubmit({
			     	/*  url:"insertManualSign.do", */ 
			     		type: "POST",
			      		dataType:'json',
			      		data:{
			      			'signTag': signTag,
			      			'signTime': signTime,
			      			'userInfo.userId':userId,
			      			'signDesc':signDesc	
			      		},
						error:function(){
						            alert(1);
						        	},			   
		                success: function(data) {
		                alert(data);
		                    $(data).each(function(i,n){
		                    	$("#userId").val(n.userInfo.userId);
		                    	$("#name").val(n.userInfo.userName);
		                    	$("#depart").val(n.departInfo.departName);
		                    	$("#branch").val(n.branchInfo.branchName);
		                    });
		                }	                	
	                });             
            	/* }); */           
        	});
        });
    </script>
    <style type="text/css">
        #data{width:68px;}
        textarea{width:400px;height:180px;}
 
    </style>
  </head>
  	
  <body>
    	 <h1 align="center">员工签到、签退</h1>


    <form id="top" action="insertManualSign.do" method="post" >
        <fieldset>
            <legend>员工填写区</legend>
            &nbsp;&nbsp;<span >签卡日期：</span><input type="text" id="data" />&nbsp;
            <button id="qd">签到</button>&nbsp;&nbsp;<button id="qt">签退</button>
            <br><br>&nbsp;&nbsp;<span >签卡备注：</span><textarea name="signDesc" id="desc"></textarea>
            <span>签卡标记</span>：<input type="text" name="signTag" id="tag">
            <span>签卡时间：</span><input type="text" name="signTime" id="times">
            <span>userId:</span><input type="text" name="userInfo.userId" id="userId" value="<%=request.getParameter("userId")%>">
            <!-- <span>signId:</span><input type="text" name="signId" id="cre"> -->
        </fieldset>
    </form>
    
    <form id="down">
        <fieldset>
            <legend id="leg"></legend>
            <br>
            <table>
                <tr>
                    <td>用户号：</td><td><input type="text" name="userInfo.userId" id="userId"></td>
                    <td>姓&nbsp;&nbsp;名：</td><td><input type="text" id="name" ></td>
                </tr>
                <tr>
                    <td>所属部门：</td><td><input type="text"  id="depart"></td>
                    <td>所属机构：</td><td><input type="text" id="branch"></td>
                </tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td id="qdqt"></td><td id="time"></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
                <tr><td></td></tr>
            </table>
            <span>签卡备注：</span><textarea style="height: 100px" name="signDesc"></textarea>
        </fieldset>
    </form>
    <script type="text/javascript">
        var clock=new Clock();
        /*alert(clock.year);*/
        clock.display(document.getElementById("data"));
    </script>
  </body>
</html>
