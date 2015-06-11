<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统信息修改</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/user/saveUserInfo.do">
		<input type="hidden" name="strLoginId" value="${LoginUser.strLoginId}"/>
		姓名:<input type="text" name="strName" /><br>
		性别:<select name="nSex">
			<option value="0">请选择</option>
			<option value="1">男</option>	
			<option value="2">女</option>	
		 </select><br>
		手机号:<input type="text" name="strMobile" /><br>
		紧急联系人:<input type="text" name="strPhone" /><br>
		邮箱:<input type="text" name="strEmail" /><br>
		QQ:<input type="text" name="strQQ" /><br>
		微信:<input type="text" name="strWeChar" /><br>
		出生日期:<input type="text" name="dtBirthday" /><br>
		省:<input type="hidden" name="strProvinceCode" /><br>
		<input type="text" name="strProvinceName" /><br>
		城市:<input type="hidden" name="strCityCode" /><br>
			<input type="text" name="strCityName" /><br>
		地址:<input type="text" name="strAddress" /><br>
		头像:<input type="text" name="strHeadURL" /><br>
		注册时间:<input type="text" name="dtCreateTime" /><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>
