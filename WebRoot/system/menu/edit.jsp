<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/system/menu/save.do" method="post">
		<input type="hidden" name="strId" value="${Menu.strId}">
		<input type="hidden" name="strPid" value="${Menu.strPid}">
		<input type="hidden" name="nLevel" value="${Menu.nLevel}">
		<input type="hidden" name="nHasChild" value="${Menu.nHasChild}">
		名称:<input type="text" name="strName" /><br>
		url:<input type="text" name="strURL" /><br>
		状态:
		<select name="nStatus">
			<option <c:if test="${Menu.strId == '0'}">selected="selected"</c:if> value="0" >开启</option>
			<option <c:if test="${Menu.strId == '1'}">selected="selected"</c:if> value="1" >关闭</option>
		</select><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>