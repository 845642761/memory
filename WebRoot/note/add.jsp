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
	<form action="/note/save.do" method="post">
		标题:<input type="text" name="strTitle" /><br>
		内容：<textarea name="tNote"></textarea><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>