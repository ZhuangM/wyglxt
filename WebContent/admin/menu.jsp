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
			<td><a href="redirect_admin_main" target="main">首页</a></td>
		</tr>

		<tr class="title">
			<td>基本信息管理</td>
		</tr>
		<tr class="nav">
			<td><a href="house_list?currentPageNum=1" target="main">查看全部房产</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_house_query" target="main">查找房产</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_house_add" target="main">新增房产</a></td>
		</tr>
		<tr class="nav">
			<td><a href="owner_list?currentPageNum=1" target="main">查看全部业主</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_owner_query" target="main">查找业主</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_owner_add" target="main">新增业主</a></td>
		</tr>

		<tr class="title">
			<td>信息统计与管理</td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_charge_list" target="main">查看缴费情况</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_price_create" target="main">收费标准</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_waterElecGas_create" target="main">录入月用量</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_report" target="main">统计用量</a></td>
		</tr>
		<tr class="nav">
			<td><a href="redirect_admin_jiaofei" target="main">人工缴费</a></td>
		</tr>

		<tr class="title">
			<td>公告管理</td>
		</tr>
		<!-- <tr class="nav">
			<td><a href="redirect_admin_announce_list" target="main">查看公告</a></td>
		</tr> -->
		<tr class="nav">
			<td><a href="redirect_admin_announce_create" target="main">添加公告</a></td>
		</tr>
	</table>
</body>
</html>
