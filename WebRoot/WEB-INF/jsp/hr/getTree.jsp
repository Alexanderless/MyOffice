<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="StyleSheet" href="js/dtree.css" type="text/css" />
	<script type="text/javascript" src="js/dtree.js"></script>
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			$("sans-serif").click(function(){
				alert("aaaa");
			});
		});
	</script>
</head>
<body>
<div class="dtree">

	<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>

	<script type="text/javascript">

		d = new dTree('d');
		d.config.useCookies = false ;
		d.config.useStatusText  = true ;
		d.config.closeSameLevel  = false ;
		
		
		d.add(0,-1,'My example tree');
		<c:forEach items="${departList }" var="depList" varStatus="i">
			d.add('${i.index+1 }',0,'${depList.branchInfo.branchName }');
			d.add('${i.index+7 }','${i.index+1 }','${depList.departName }');
			d.add('${i.index+14 }','${i.index+7 }','${depList.userInfo.userName }');

		</c:forEach>	

		document.write(d);

	</script>

</div>
</body>
</html>