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
    
    <title>My JSP 'updateDepart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="te	xt/css" href="styles.css">
	-->
	<link rel="stylesheet" href="js/ztree/demo.css" type="text/css">
	<link rel="stylesheet" href="js/ztree/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/ztree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript">
		function script(){
			$("form").submit();
		}
		  <!--
        var setting = {};

        var zNodes =[
            { name:"华北电力科学研究院", open:true,
                children: [
                    { name:"销售部",
                        children: [
                            { name:"钱钟书"},
                            { name:"龙应台"},
                        ]},
            ]},
            { name:"中国科学院声学研究所",open:true,
                children: [
                    { name:"研发部", open:true,
                        children: [
                            { name:"王小波"},
                            { name:"杨绛"},
                        ]},
            ]},
            { name:"上海华育国际", open:true,
                children: [
                    { name:"财务部",
                        children: [
                            { name:"柴静"},
                            { name:"科比"},
                        ]},
            ]},
            { name:"大唐国际盘山发电有限公司",open:true,
                children: [
                    { name:"研发部", open:true,
                        children: [
                            { name:"王小波"},
                            { name:"杨绛"},
                        ]},
            ]},
            { name:"武汉大学", open:true,
                children: [
                    { name:"综合部",
                        children: [
                            { name:"钱钟书"},
                            { name:"龙应台"},
                        ]},
            ]},
        ];
        
        function zTreeOnClick(event, treeId, treeNode) {
        	alert(treeNode.tId + ", " + treeNode.name);
        }

        
        $(document).ready(function(){
        	$("#branchinfo option[value='"+${departInfo.branchInfo.branchId }+"']").attr("selected",true);
        	
        	$("table tr td:first-child").attr("align", "right");
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
            $("img").click(function(){
            	$(".content_wrap").css("display","block");
            });
            
            $(".button.ico_docu+span").click(function(){
            	var name = $(this).text();
            	$("#deparName").val(name).attr("disabled",true);
            	$(".content_wrap").css("display","none");
            });
            
            $("input[name='connectTelNo']").focus(function(){
            	$(".content_wrap").css("display","none");
            });
        });
	</script>
	<style type="text/css">
	h1{
		padding-top:20px;
	}	
		button{
			width:90px;
			height:26px;
			margin-right:10px;
			margin-left:10px;
			font-size: 14px;
		}
		.line{width:940px;margin-bottom:30px;}
		td{font-size: 16px;font-weight: normal;}
		
		.content_wrap{
			position:absolute;
			top:80px;
			left:720px;
			display:none;
		}
		body{
			position:relative;
		}
		input,select{
			height:28px;
			width:210px;
		}
	</style>
  </head>
  
  <body>
    	<div class="content_wrap">
		    <div class="zTreeDemoBackground left">
		   	 <ul id="treeDemo" class="ztree"></ul>
			</div> 
    	</div>
    <center>
    	<h1>保存部门信息</h1>
    	<div class="line"><hr/></div>
    	<form action="addDepartInfo.do" method="post">
	    	<table cellpadding="9" cellspacing="0">
	    		<tr>
	    			<td>部门名称：</td>
	    			<td><input id="departid" type="text" name="departName" value="${departInfo.departName }"></td>
	    		</tr>
	    		<tr>
	    			<td>所属机构：</td>
	    			<td>
	    				<select id="branchinfo" name="branchInfo.branchId">
	    					<c:forEach var="bl" items="${branchlist }">
	    						<option value="${bl.branchId}">${bl.branchName }</option>
	    					</c:forEach>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>部门负责人：</td>
	    			<td><input id="deparName" value="${departInfo.userInfo.userName} " type="text" name="userName">
	    				<img style="margin-top:-5px;margin-left:6px;cursor:pointer" height="20px" src="images/user.png"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>联系电话：</td>
	    			<td><input value="${departInfo.connectTelNo }" type="text" name="connectTelNo"></td>
	    		</tr>
	    		<tr>
	    			<td>移动电话：</td>
	    			<td><input value="${departInfo.connectMobileTelNo }" type="text" name="connectMobileTelNo"></td>
	    		</tr>
	    		<tr>
	    			<td>传真：</td>
	    			<td><input value="${departInfo.faxes }" type="text" name="faxes"></td>
	    		</tr>
	    	</table>
	    </form>
	    	<a href="queryPageDepartInfo.do"><button>返回</button></a>
	    	<a href="queryPageDepartInfo.do"><button>保存信息</button></a>
    </center>
  </body>
</html>
