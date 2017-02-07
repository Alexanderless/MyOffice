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
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="<%=path %>/js/Clock.js"></script>
	<script type="text/javascript" src="<%=path %>/js/showdate.js"></script>
	 <style type="text/css">
        .box{ width:600px;height:600px; margin:0 auto;}
        #meetinfo{width:600px;height:200px;}
        textarea{width:120px;height:60px;}
        #datetime{border:none;outline: none;}
        #createUser{border:none;outline: none;}
    </style>
	<script>
		$(function(){
			$.ajax({
					url:'queryMeetInfo.do',
					dateType:'json',
					success:function(data){
						$(data).each(function(i,n){
							$("#meet").append("<option value="+n.meetingId+">"+n.meetingName+"</option>");
						});
					}
				});
			
			//提交表单
			$("#bctc").click(function(){
					//设置是否私有
			if($("#gk").attr('checked')==true){
				$("#gk").val("1");
			}else{
				$("#gk").val("2");
			} 
				$("#schedule").submit();
			});
				
			$("#tc").click(function(){
				location.href='queryScheduleListByName.do?userId=1001';	
			
			});
		
		});
		
	</script>
	

  </head>
  
  <body>
  <%-- 	<h2>我的日程</h2>
  	<form action="addScheduleList.do" method="post">
	     <table>
	     <tr><td></td><td><input type="text" readonly="readonly"  name="createUser" value="${createUser}"/></td></tr>	    	
		     	<tr><td>日程主题:</td><td><input type="text" name="title"/></td></tr>
		     	<tr><td>会议地址:</td><td><input type="text" name="address"/></td></tr>
		     	<tr><td>会议类型:</td><td><select id="meet" name="meetingInfo.meetingId"></select></td></tr>
		     	<tr><td>开始时间:</td><td><input type="date" name="beginTime"/></td></tr>
		     	<tr><td>结束时间:</td><td><input type="date" name="endTime"/></td></tr>
		     	<tr><td>日程内容:</td><td><input type="text" name="schContent"/></td></tr>
		     	<tr><td>创建时间:</td><td><input type="date" name="createTime"/></td></tr>
		     	<tr><td>是否私有:</td><td><input type="text" name="ifPrivate"/></td></tr>
		     	
	     	
	     	<tr>
	     		<td><input type="submit" value="添加"/></td>	
	     	</tr>
	     </table>
     </form> --%>
     <div class="box" align="center">
	     	<div style="width:600px background:url('../../../images/cell-blue.jpg')">
	        	<p id="title" style="font:18px">添加日程</p>
	        </div>
        <hr/>
        <form id="schedule" action="addScheduleList.do" method="post">
            <span>主题：</span>
            <input style="width:500px" type="text" name="title"/>
            <br><br>
            <span>地点：</span>
            <input type="text" name="address" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <span>会议类型:</span><select id="meet" name="meetingInfo.meetingId"><option value="${list.meetingInfo.meetingId}">${list.meetingInfo.meetingName}</option></select>
           <br>
            <span>开始时间------</span><input id="time" type="text" name="beginTime"><!-- onClick="return Calendar('time');" --> 
            <br>
            <span>结束时间------</span><input id="times" type="text" name="endTime" > <!-- onClick="return Calendar('times')"; -->
            <br>
            <textarea id="meetinfo" name="schContent"></textarea>
            <span>预约他人：</span><button>请选择</button><br>
             <textarea name=""></textarea> <button>删除选定预约人</button>
             <br>
            <span>选项：</span>
            <input id="gk" type="checkbox" name="ifPrivate" />
            <span>是否公开</span>
            &nbsp;&nbsp; 
            <span>创建者：</span >
            <input name="userInfo.userId" id="createUser" style="width:55px" value="<%=request.getAttribute("createUser") %>"></input>
            <span>创建时间：</span>
            <input name="createTime" id="datetime"></input>
        </form>
            <br><br>
            <button id="bctc">保存退出</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<button id="tc">退出</button>

        <script type="text/javascript">
            var clock=new Clock();
            /*alert(clock.year);*/
            clock.display(document.getElementById("datetime"));
        </script>
    </div>
    
  </body>
</html>
