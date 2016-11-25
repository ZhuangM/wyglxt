<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'main.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		proc();
	});

	function proc() {
		$.ajax({
			type : "post",
			url : "announce_query",
			data : {},
			dataType : "json",
			success : function(resp) {
				//alert(resp);
				var obj = eval("(" + resp + ")");
				if (obj.respCode == '00') {
					var title = obj.announce.title;
					var content = obj.announce.content;
					$("#announce").html("(标题：" + title + ")&nbsp;" + content);
				} else {
					alert("公告加载失败");
					$("#announce").html("公告加载失败...");
				}
			},
			error : function() {
				alert("服务器异常");
			}
		});
	}
</script>
</head>

<body style="background-color: #F3F6FA;">
	<table width="98%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td><div style="float: left;">
					<img src="image/main.gif" height="14" width="20" />&nbsp;欢迎登录物业管理系统
				</div></td>
		</tr>
		<tr>
			<!-- 背景色 -->
			<td height="1" background="#" style="padding: 0px;"></td>
		</tr>
	</table>

	<table width="98%" align="center" cellpadding="3" cellspacing="1"
		bgcolor="#CBD8AC" style="margin-bottom: 8px; margin-top: 8px;">
		<tr>
			<td><span>&nbsp;公告</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td><font size="5" color="#cc0000"><marquee>
						<span id="announce">添加公告处...</span>
					</marquee></font></td>
		</tr>
	</table>

	<table width="98%" align="center" cellpadding="4" cellspacing="1"
		bgcolor="#CBD8AC" style="margin-bottom: 8px;">
		<tr>
			<td><span>&nbsp;快捷操作</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td><a href="redirect_admin_announce_create" target="main"><input
					type="button" value="添加公告"></a></td>
		</tr>
	</table>

	<table width="98%" align="center" cellpadding="4" cellspacing="1"
		bgcolor="#CBD8AC" style="margin-bottom: 8px;">
		<tr bgcolor="#EEF4EA">
			<td><span>&nbsp;系统基本信息</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="25%">&nbsp;您的级别：</td>
			<td width="75%">&nbsp;超级管理员</td>
		</tr>
	</table>

	<table width="98%" align="center" cellpadding="4" cellspacing="1"
		bgcolor="#CBD8AC">
	</table>
</body>
</html>
