<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统注册</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<link href="/user/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body class="login_bg">
	<div class="login_wrapper">
		<div class="login_box">
			<!-- 左边 -->
			<form class="loginForm" id="form">
				<input type="text" id="strLoginId" name="strLoginId" placeholder="请输入登录帐号" class="input" onblur="loginIdIsExit()" />
				<span class="error" id="strLoginIdTip" msg="请输入有效的登录帐号"></span>
				<input type="password" id="password" name="strPassword" placeholder="请输入密码" class="input" onblur="validation('password')"/>
				<span class="error" id="passwordTip" msg="请输入6-16位密码，字母区分大小写"></span>
				<label class="fl">
					<input name="checkbox" type="checkbox"/>
					<a href="" target="_blank">《memory用户协议》</a>
				</label>
				<input type="button" class="submit" onclick="ajaxSubmit()" value="注&nbsp; &nbsp; 册" />
			</form>
			
			<!-- 右边 -->
			<div class="login_right">
				<div>已有memory帐号？</div>
				<a href="/user/login.do" class="registor_now">立即登录</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/common/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/user/js/regist.js"></script>
</html>