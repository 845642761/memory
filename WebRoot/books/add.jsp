<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/books/save.do" method="post">
		名称:<input type="text" name="strName" /><br>
		<c:forEach var="items" items="${BookTypes}" varStatus="index">
			${index.count}:${items.strName}<input name="nTypeId" type="radio" value="${items.nId}" /><br>	
		</c:forEach>		
		
		现金：<input type="range" name="fMoney" /><br>
		备注：<input type="text" name="strNote" /><br>
		地址：<input type="text" name="strAddress" /><br>
		时间：<input type="text" name="dtTime" /><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>
