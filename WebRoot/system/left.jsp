<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	a{ width:100%; float: left; text-align: center; line-height: 20px; height: 20px;}
</style>
</head>
<body>
	<a href="/user/updateUserInfo.do" target="right">资料修改</a><br>
	<a href="/bookType/addBookType.do" target="right">添加账单类型</a><br>
	<a href="/bookType/getByRange.do" target="right">查看账单类型</a><br>
	<a href="/books/addBook.do" target="right">添加账单</a><br>
	<a href="/books/getByRange.do" target="right">查看账单</a><br>
</body>
</html>
