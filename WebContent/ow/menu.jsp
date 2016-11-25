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

<title>My JSP 'menu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/admin_menu.css">

</head>

<body>
	<table width="99%" height="100%" cellspacing="0" cellpadding="0"
		class="ta">
		<tr class="nav">
			<td><a href="redirect_ow_main" target="main">首页</a></td>
		</tr>

		<tr class="title">
			<td>管理员登录管理</td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_ow_admin_query" target="main">查找管理员</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_ow_admin_add" target="main">新增管理员</a></td>
		</tr>
		<tr class="title">
			<td>demo管理</td>
		</tr>
		<tr>
			<td><a href="demo_list?currentPageNum=1" target="main">查看所有demo</a></td>
		</tr>
		<tr>
			<td><a href="redirect_demo_demo_add" target="main">新增demo</a></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>
