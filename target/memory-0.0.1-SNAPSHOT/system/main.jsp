<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>memory系统</title>
<meta charset="utf-8" />
<link href="/common/css/common.css" rel="stylesheet" type="text/css" />
<link href="css/system.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/jquery-ui.structure.min.css" rel="stylesheet" type="text/css" />
<link href="/common/js/jquery-ui-1.11.4/myUI.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 头部 -->
<div class="top">
	<!-- 左边 -->
	<div class="top_left"></div>
	
	<!-- 右边 -->
	<div class="top_right"></div>
</div>

<!-- 标签 -->
<div class="nav"></div>

<!-- main -->
<div class="main" id="main">
	<!-- 左边 -->
	<div class="main_left">
		<a class="left_a" href="/user/updateUserInfo.do" target="iframe">资料修改</a>
		<a class="left_a" href="/bookType/addBookType.do" target="iframe">添加账单类型</a>
		<a class="left_a" href="/bookType/getByRange.do" target="iframe">查看账单类型</a>
		<a class="left_a" href="/books/addBook.do" target="iframe">添加账单</a>
		<a class="left_a" href="/books/getByRange.do" target="iframe">查看账单</a>
		<a class="left_a" href="/note/add.do" target="iframe">添加留言</a>
		<a class="left_a" href="/note/list.do" target="iframe">留言簿</a>
		<a class="left_a" href="/system/menu/edit.do" target="iframe">添加菜单</a>
	</div>
	<!-- 右边 -->
	<div class="main_right">
		<iframe name="iframe" id="iframe" src="/user/updateUserInfo.do" marginWidth="0" marginHeight="0" frameBorder="0" width="100%" height="100%" scrolling="no" onload="setHeight()"></iframe>
	</div>
</div>

<!-- 尾部 -->
<div class="bottom"></div>
</body>
<script type="text/javascript" src="/common/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/common/js/jquery-ui-1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript">
	/**
	 * @description: 初始化iframe高度
	 * @author: cheng_bo
	 * @date: 2015年7月6日 13:22:40
	 */
	function setHeight(){
		var iframe = document.getElementById("iframe");
		var con = iframe.contentWindow;
		if (con && con.document && con.document.body) {
		    var height = con.document.body.offsetHeight + 20;
		    iframe.height =  height;
		}
	}
	
	/**
	 * @description: 初始化iframe高度
	 * @author: cheng_bo
	 * @date: 2015年7月6日 13:26:39
	 */
	function refreshIframe(){
		var iframe = document.getElementById("iframe");
		iframe.contentWindow.refresh();
	}
	
	/**
	 * @description: 弹框
	 * @author: cheng_bo
	 * @date: 2015年7月6日 15:03:47
	 */
	var dialog = $('<div>').dialog({
		width: 600,
		autoOpen: false
	});
	
	$.post('/user/updateUserInfo.do', function (res) {
		dialog.html(res);
		dialog.dialog('option', 'title', '信息修改');
		dialog.dialog('open');
	});
</script>
</html>
