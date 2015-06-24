<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统用户信息修改</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/user/saveUpdateUserInfo.do" method="post">
		姓名:<input type="text" name="strName" value="${userInfo.strName}"/><br>
		性别:<select name="nSex">
			<option value="0">请选择</option>
			<option value="1">男</option>	
			<option value="2">女</option>	
		 </select><br>
		手机号:<input type="text" name="strMobile" value="${userInfo.strMobile}"/><br>
		紧急联系人:<input type="text" name="strPhone" value="${userInfo.strPhone}"/><br>
		邮箱:<input type="text" name="strEmail" value="${userInfo.strEmail}"/><br>
		QQ:<input type="text" name="strQQ" value="${userInfo.strQQ}"/><br>
		微信:<input type="text" name="strWeChar" value="${userInfo.strWeChar}"/><br>
		出生日期:<input type="text" name="dtBirthday" value="${userInfo.dtBirthday}"/><br>
		省:<input type="hidden" name="strProvinceCode" value="${userInfo.strProvinceCode}"/><br>
		<input type="text" name="strProvinceName" value="${userInfo.strProvinceName}"/><br>
		城市:<input type="hidden" name="strCityCode" value="${userInfo.strCityCode}"/><br>
			<input type="text" name="strCityName" value="${userInfo.strCityName}"/><br>
		地址:<input type="text" name="strAddress" value="${userInfo.strAddress}"/><br>
		头像:<input type="text" name="strHeadURL" value="${userInfo.strHeadURL}"/><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>
