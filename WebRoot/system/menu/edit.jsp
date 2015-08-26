<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/system/menu/save.do" method="post">
		<input type="hidden" name="strId" value="${Permission.strId}">
		<input type="hidden" name="strPid" value="${Permission.strPId}">
		<input type="hidden" name="nLevel" value="${Permission.nLevel}">
		名称:<input type="text" name="strName" /><br>
		url:<input type="text" name="strURL" /><br>
		状态:
		<select name="nStatus">
			<option <c:if test="${Permission.strId == '0'}">selected="selected"</c:if> value="0" >开启</option>
			<option <c:if test="${Permission.strId == '1'}">selected="selected"</c:if> value="1" >关闭</option>
		</select><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>