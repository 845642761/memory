<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统用户信息修改</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<link href="/common/css/formUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form action="/user/saveUpdateUserInfo.do" method="post">
		<table>
			<tr>
				<td><label class="required">姓名:</label></td>
				<td><input type="text" name="strName" value="${userInfo.strName}"/><br></td>
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
				<td><label>手机号:</label></td>
				<td><input type="text" name="strMobile" value="${userInfo.strMobile}"/></td>
				<td><label>紧急联系人:</label></td>
				<td><input type="text" name="strPhone" value="${userInfo.strPhone}"/></td>
			</tr>
			<tr>
				<td><label>邮箱:</label></td>
				<td><input type="text" name="strEmail" value="${userInfo.strEmail}"/></td>
				<td><label>QQ:</label></td>
				<td></label><input type="text" name="strQQ" value="${userInfo.strQQ}"/></td>
			</tr>
			<tr>
				<td><label>微信:</label></td>
				<td><input type="text" name="strWeChar" value="${userInfo.strWeChar}"/></td>
				<td><label>出生日期:</label></td>
				<td><input type="text" name="dtBirthday" value="${userInfo.dtBirthday}"/></td>
			</tr>
			<tr>
				<td><label>省:</label></td>
				<td><input type="hidden" name="strProvinceCode" value="${userInfo.strProvinceCode}"/><input type="text" name="strProvinceName" value="${userInfo.strProvinceName}"/></td>
				<td><label>城市:</label></td>
				<td><input type="hidden" name="strCityCode" value="${userInfo.strCityCode}"/><input type="text" name="strCityName" value="${userInfo.strCityName}"/></td>
			</tr>
			<tr>
				<td><label>地址:</label></td>
				<td><input type="text" name="strAddress" value="${userInfo.strAddress}"/></td>
				<td><label>头像:</label></td>
				<td><input type="text" name="strHeadURL" value="${userInfo.strHeadURL}"/</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" class="btn" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>