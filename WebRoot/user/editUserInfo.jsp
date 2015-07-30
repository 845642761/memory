<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统信息修改</title>
<meta charset="utf-8" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
<link href="/user/css/userInfo.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/jquery-ui-timepicker-addon.min.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/myUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/user/saveUserInfo.do" method="post" class="form" id="form">
		<input type="hidden" name="strLoginId" value="${user.strLoginId}"/>
		<div class="top">
			<div class="head">
				<input type="hidden" name="strHeadURL" />
				<img src="images/head.png" />
			</div>
		</div>
		<div class="container">
			<table>
				<tr>
					<td><label class="required">姓名:</label></td>
					<td><input type="text" class="required" name="strName" /></td>
					<td><label>性别:</label></td>
					<td>
						<select name="nSex">
							<option value="0">请选择</option>
							<option value="1">男</option>	
							<option value="2">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><label class="required">手机号:</label></td>
					<td><input type="text" class="required cellphone" name="strMobile" /></td>
					<td><label>紧急联系人:</label></td>
					<td><input type="text" name="strPhone cellphone" class="cellphone" /></td>
				</tr>
				<tr>
					<td><label>QQ:</label></td>
					<td><input type="text" class="digits" name="strQQ" /></td>
					<td><label>邮箱:</label></td>
					<td><input type="text" class="required email" name="strEmail" /></td>
				</tr>
				<tr>
					<td><label>微信:</label></td>
					<td><input type="text" name="strWeChar" /></td>
					<td><label>出生日期:</label></td>
					<td><input type="text" id="date" name="dtBirthday" readonly="readonly" /></td>
				</tr>
				<tr>
					<td><label>省:</label></td>
					<td>
						<input type="hidden" name="strProvinceCode" />
						<input type="text" name="strProvinceName" />
					</td>
					<td><label>城市:</label></td>
					<td>
						<input type="hidden" name="strCityCode" />
						<input type="text" name="strCityName" />				
					</td>
				</tr>
				<tr>
					<td><label>地址:</label></td>
					<td colspan="3"><input type="text" name="strAddress" /></td>
				</tr>
				<tr>
					<td colspan="4" class="alignCenter">
						<input type="submit" class="btn" value="提交" />
						<input type="button" class="btn" value="重置" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
<jsp:include page="/common/plug-in.html" />
<jsp:include page="/common/plug-jqueryUI.html" />
<script type="text/javascript" src="/user/js/userInfo.js"></script>
</html>
