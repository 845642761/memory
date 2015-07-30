<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统登录</title>
<meta charset="utf-8" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
<link href="/user/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body class="login_bg">
	<div class="login_wrapper">
		<div class="login_box">
			<!-- 左边 -->
			<form action="/user/ssoLogin.do" class="loginForm" id="form">
				<input type="text" name="strLoginId" placeholder="请输入登录邮箱地址" msg="请输入有效的邮箱地址，如：xx@memory.org" class="required userName"/>
				<input type="password" name="strPassword" placeholder="请输入6-16位密码，字母区分大小写" msg="请输入6-16位密码，字母区分大小写" class="required" minlength="6" maxlength="16"/>
				<label class="fl">
					<input type="checkbox" />&nbsp;记住我
				</label>
				<label class="fl">
					<a target="_blank" style="margin-left: 155px;">忘记密码？</a>
				</label>
				<input type="submit" class="submit" value="登 &nbsp; &nbsp; 录" />
			</form>
			
			<!-- 右边 -->
			<div class="login_right">
				<div>还没有memory帐号？</div>
				<a href="/user/regist.do" class="registor_now">立即注册</a>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/common/plug-in.html" />
<script type="text/javascript" src="/user/js/login.js"></script>
</html>