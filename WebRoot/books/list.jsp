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
	<form action="/books/getByRange.do" method="post">
		
	</form>
	
	<table>
		<tr>
			<td>序号</td>
			<td>现金</td>
			<td>地址</td>
			<td>备注</td>
			<td>时间</td>
			<td>操作</td>
		</tr>
		<c:forEach var="items" items="${bsList}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${items.fMoney}</td>
				<td>${items.strAddress}</td>
				<td>${items.strNote}</td>
				<td>${items.dtTime}</td>
				<td><a href="">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
