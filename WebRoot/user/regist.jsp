<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统注册</title>
<meta charset="utf-8" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
<link href="/user/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body class="login_bg">
	<div class="login_wrapper">
		<div class="login_box">
			<!-- 左边 -->
			<form class="loginForm" id="form" method="post">
				<input type="text" name="strLoginId" placeholder="请输入登录帐号" msg="请输入有效的邮箱地址，如：xx@memory.org" class="required userName"/>
				<input type="password" name="strPassword" placeholder="请输入密码" msg="请输入6-16位密码，字母区分大小写" class="required" minlength="6" maxlength="16"/>
				<label class="fl">
					<input id="yhxy" type="checkbox"/>
					<a target="_blank" class="fr">《memory用户协议》</a>
				</label>
				<input type="submit" class="submit required" value="注&nbsp; &nbsp; 册" />
			</form>
			
			<!-- 右边 -->
			<div class="login_right">
				<div>已有memory帐号？</div>
				<a href="/user/login.do" class="registor_now">立即登录</a>
			</div>
		</div>
	</div>
</body>
<jsp:include page="/common/plug-in.html" />
<script type="text/javascript" src="/user/js/regist.js"></script>
</html>