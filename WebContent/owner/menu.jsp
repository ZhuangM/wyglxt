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
		<tr class="title">
			<td>基本功能</td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_owner_main" target="main">首页</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_owner_query_bill" target="main">查询收费单</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_owner_waterElecGas_query" target="main">查询用量</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_owner_price_query" target="main">查询收费标准</a></td>
		</tr>
		<tr class="title">
			<td>自服务</td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_owner_alter_password" target="main">修改密码</a></td>
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
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
</body>
</html>