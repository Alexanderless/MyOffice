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
	 <style type="text/css">
        .box{ width:600px;height:600px; margin:0 auto;}
        #meetinfo{width:600px;height:200px;}
        textarea{width:120px;height:60px;}
        #datetime{border:none;outline: none;}
        #createUser{border:none;outline: none;}
    </style>
	<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
	
	<script>
		$(function(){
			$.ajax({
					url:'queryMeetInfo.do',
					dateType:'json',
					success:function(data){
						/* $("#meet").append("<option>--请选择--</option>") */
						$(data).each(function(i,n){							
							$("#meet").append("<option value="+n.meetingId+">"+n.meetingName+"</option>");
						});
					}
				});
						$(function(){
					$("#bctc").click(function(){
						$("#schedule").submit();
						});
					});
		
				
					$("#tc").click(function(){
					location.href='queryScheduleListByName.do?userId=1001';	
				
					});
		});
		
		
	</script>
  </head>
  
  <body>
<%--   	<h2>修改日程</h2>
  	<form action="updateSchedule.do" method="post">
	     <table>
	     		<tr><td><input type="hidden" name="scheduleId" value="${list.scheduleId}"/></td></tr>
		     	<tr><td>日程标题:</td><td><input type="text" name="title" value="${list.title}"/></td></tr>
		     	<tr><td>会议地址:</td><td><input type="text" name="address" value="${list.address}"/></td></tr>
		     	<tr><td>会议类型:</td><td><select id="meet" name="meetingInfo.meetingId"><option value="${list.meetingInfo.meetingId}">${list.meetingInfo.meetingName}</option></select></td></tr>
		     	<tr><td>日程开始时间:</td><td><input type="text" name="beginTime" value="<fmt:formatDate value='${list.beginTime}' pattern="yyyy-MM-dd"/>"/></td></tr>
		     	<tr><td>日程结束时间:</td><td><input type="text" name="endTime" value="<fmt:formatDate value='${list.endTime}' pattern="yyyy-MM-dd"/>"/></td></tr>
		     	<tr><td>日程内容:</td><td><input type="text" name="schContent" value="${list.schContent}"/></td></tr>
		     	<tr><td>创建者:</td><td><input type="text" readonly="readonly" name="userInfo.userName" value="${ list.userInfo.userName}"/></td></tr>
		     	<tr><td>创建时间:</td><td><input type="text" name="createTime" value="<fmt:formatDate value='${list.createTime}' pattern="yyyy-MM-dd"/>"/></td></tr>
		     	<tr><td>是否私有:</td><td><input type="text" name="ifPrivate" value="${ list.ifPrivate}"/></td></tr>
		     	<tr>
	     			<td><input type="submit" value="保存退出"/></td>	
	     		</tr>
	     </table>
     </form> --%>
      <div class="box">
        <p id="hTitle">修改日程</p>
        <hr/>
        <form id="schedule" action="updateSchedule.do" method="post">
            <span>主题：</span>
            <input style="width:500px" type="text" name="title" value="${list.title}" />
            <br><br>
            <span>地点：</span>
            <input type="text" name="address" value="${list.address}"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
           <span>会议类型：</span>
          <span>会议类型:</span><select id="meet" name="meetingInfo.meetingId"><option value="${list.meetingInfo.meetingId}">${list.meetingInfo.meetingName}</option></select>
           <br>
            <span>开始时间------</span><input type="text" name="beginTime" value="<fmt:formatDate value='${list.beginTime}' pattern="yyyy-MM-dd"/>"/> 
            <br>
            <span>结束时间------</span><input type="text" name="endTime" value="<fmt:formatDate value='${list.endTime}' pattern="yyyy-MM-dd"/>"/>
            <br>
            <textarea id="meetinfo" name="schContent" >${list.schContent}</textarea>
            <span>预约他人：</span><button>请选择</button><br>
             <textarea name=""></textarea> <button>删除选定预约人</button>
             <br>
            <span>选项：</span>
            <input type="checkbox" name="ifPrivate" value="${ list.ifPrivate}"/>
            <span>是否公开</span>
            &nbsp;&nbsp; 
            <span>创建者：</span >
            <input name="userInfo.userName" id="createUser" style="width:100px" value="${ list.userInfo.userName}"/>
            <span>创建时间：</span>
            <input name="createTime" id="datetime" style="width:78px" value="<fmt:formatDate value='${list.createTime}' pattern="yyyy-MM-dd"/>"/>
        </form>
            <br><br>
            <button id="bctc">保存退出</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	<button id="tc">退出</button>

        
    </div>
  </body>
</html>
