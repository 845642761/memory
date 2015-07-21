<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/books/getByRange.do" method="post">
		
	</form>
	<div class="table">
		<table>
			<thead>
			<tr>
				<th>序号</th>
				<th>现金</th>
				<th>地址</th>
				<th>备注</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
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
			</tbody>
			<tr>
				<td>总计</td>
				<td colspan="5">${total}</td>
			</tr>
		</table>
	</div>
</body>
</html>
