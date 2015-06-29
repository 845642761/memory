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
	<form action="/note/list.do" method="post">
		<c:set var="note" value="${resoult.object}"/>
		查询码:<input type="text" name="strId" value="${note.strId}"/><br>
		标题:<input type="text" name="strTitle" value="${note.strTitle}"/><br>
		发起人名称:<input type="text" name="strLoginName" value="${note.strLoginName}"/><br>
		<input type="submit" value="查询" />
	</form>
	
	<table border="1" style="width: 100%;" cellpadding="2" cellspacing="0">
		<tr>
			<td>序号</td>
			<td>查询码</td>
			<td>标题</td>
			<td>发起人</td>
			<td>时间</td>
			<td>回复</td>
		</tr>
		<c:forEach var="items" items="${resoult.list}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${items.strId}</td>
				<td>${items.strTitle}</td>
				<td>${items.strLoginName}</td>
				<td>${items.dtTime}</td>
				<td><a href="/noteBack/add.html">回复</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>