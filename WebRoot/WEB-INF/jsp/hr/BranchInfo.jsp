<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		
		//刷新
		function update(branchId,branchName,branchShortName){
			$("input[name='branchId']").val(branchId);
			$("input[name='branchName']").val(branchName);
			$("input[name='branchShortName']").val(branchShortName);
			$("#addBut").attr("disabled",true);
			$("#alterBut").attr("disabled",false);
		}
		//修改
		function alter(){
			$("#form").attr("action","updateBranchInfo.do").submit();
			
		}
		//添加
		function add(){
			var branchName = $("input[name='branchName']").val();
			var branchShortName = $("input[name='branchShortName']").val();
			if (branchName!=""&&branchShortName!=""){
				$("form").attr("action","addBranchInfo.do").submit();
			}
			var branchName = $("input[name='branchName']").val();
			if(branchName==""){
				alert("机构名称不能为空");
			}
			var branchShortName = $("input[name='branchShortName']").val();
			if(branchShortName==""){
				alert("机构简称不能为空");
			}
		}
		//添加输入框验证
		$(function(){
			$("input[name='branchName']").blur(function(){
				var branchName = $("input[name='branchName']").val();
				if(branchName==""){	
					$("input[name='branchName']").addClass("addcolor");
				}
			}).focus(function(){
				$("input[name='branchName']").removeClass("addcolor");
				
			});
			$("input[name='branchShortName']").blur(function(){
				var branchShortName = $("input[name='branchShortName']").val();
				if(branchShortName==""){
					$("input[name='branchShortName']").addClass("addcolor");
				}
			}).focus(function(){
				$("input[name='branchShortName']").removeClass("addcolor");
			});
		})
	</script>
	<style type="text/css">
	a{ text-decoration:none; color:#000;font-size: 20px;}
	#page1{
		color:#000;font-size: 20px;
		padding-top:16px;
		padding-bottom: 8px;
		}	
	.line{width:940px;margin-bottom:20px;}
	#addBut,#alterBut{
			width:100px;
			height:26px;
			margin-bottom:6px;
			margin-right:10px;
			margin-left:10px;
			font-size: 14px;
		}
	#uplo,#del{
			width:100px;
			height:26px;
			margin-right:10px;
			margin-left:10px;
			font-size: 14px;
		}
	table{width:950px;height:200px;}
	td{font-size: 16px;font-weight: normal;}
	th{font-size: 16px;font-weight: normal;height:38px;}
	.addcolor{border-color:red;}
	table{
		height:180px;
	}
	h2{
		padding-top:20px;
	}			
	</style>
  </head>
  	
  <body>
    <center>
    	<h2>机构管理</h2>
    	<div class="line"><hr/></div>

    	<form action="updateBranchInfo.do" method="post">
    			<input type="hidden" name="branchId"/>
	    		<span style="font-size:16px">机构名称：</span>
	    		<input style="height:26px" type="text" name="branchName"/>
	    		<span style="font-size:16px;padding-left:20px">机构简称：</span>
	    		<input style="height:26px" type="text" name="branchShortName"/>
	    		<button id="addBut" onclick="add()">添加</button>
	    		<button id="alterBut" onclick="alter()" disabled="true">保存修改</button>
	    </form>	
	    
	    <table cellpadding="7" cellspacing="0" border="1">
    		<tr>
    			<th>机构名称</th>
    			<th>机构简称</th>
    			<th>修改</th>
    			<th>删除</th>
    		</tr>
	    	<c:forEach var="sl" items="${pbInfo.list}">
	    		<tr>
	    			<th>${sl.branchName}</th>
	    			<th>${sl.branchShortName}</th>
	    			<th>
	    				<button id="uplo" onclick="update('${sl.branchId }','${sl.branchName }','${sl.branchShortName}')">修改</button>
	    			</th>
	    			<th>
	    				<a href="delPageBranchInfo.do?branchId=${sl.branchId }" onclick="return confirm('是否删除？')"><button id="del">删除</button></a>
	    			</th>
	    		</tr>
	    	</c:forEach>
    	
    	</table>
    	
    	
    	
    		<div id="page1">第${pbInfo.currentPage }页/总${pbInfo.totalPages }页</div>
    		<div>
			<a href="queryPageBranchInfo.do?currentPage=1">首页</a>
				<c:if test="${pbInfo.currentPage>1}">
	    		<a href="queryPageBranchInfo.do?currentPage=${pbInfo.currentPage-1}">上一页</a>
	    	</c:if>
			
			<!-- 分页条的显示 -->
			<c:set var="begin" value="0"></c:set>
			<c:set var="end" value="0"></c:set>
			<%--获取begin 和  end --%>
			<c:if test="${pbInfo.totalPages<=5 }">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${pbInfo.totalPages }"></c:set>
			</c:if>
			<c:if test="${pbInfo.totalPages>5 }">
				<c:choose>
					<c:when test="${pbInfo.currentPage<3 }">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="5"></c:set>
					</c:when>
					<c:when test="${pbInfo.currentPage>=pbInfo.totalPages-2 }">
						<c:set var="begin" value="${pbInfo.totalPages-4 }"></c:set>
						<c:set var="end" value="${pbInfo.totalPages }"></c:set>
					</c:when>
					<c:otherwise>
						<c:set var="begin" value="${pbInfo.currentPage-2 }"></c:set>
						<c:set var="end" value="${pbInfo.currentPage+2 }"></c:set>
					</c:otherwise>
				</c:choose>
			</c:if>
			<%-- 循环创建 --%>
				<c:forEach var="i" begin="${begin}" end="${end }">
					<c:if test="${pbInfo.currentPage==i }">
						<a>${i }</a>
					</c:if>
					<c:if test="${pbInfo.currentPage!=i }">
						<a href="queryPageBranchInfo.do?currentPage=${i}">${i}</a>
					</c:if>				
				</c:forEach>
			<!-- 分页条的显示 -->
			
			<c:if test="${pbInfo.currentPage<pbInfo.totalPages}">
	    		<a href="queryPageBranchInfo.do?currentPage=${pbInfo.currentPage+1}">下一页</a>
    		</c:if>
			<a href="queryPageBranchInfo.do?currentPage=${pbInfo.totalPages}">末页</a>
		</div>
    </center>
  </body>
</html>
