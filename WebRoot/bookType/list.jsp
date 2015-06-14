<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ include file="../common/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/bookType/getByRange.do" method="post">
		
	</form>
	
	<table>
		<tr>
			<td>序号</td>
			<td>名称</td>
		</tr>
		<c:forEach var="items" items="${btList}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${items.strName}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
