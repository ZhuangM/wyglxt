<%@ page language="java" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>物业管理系统--管理员</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>
<frameset rows="60,*" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="admin/top.jsp" name="topFrame" scrolling="no">
	<frameset cols="180,*" frameborder="no" border="0" framespacing="0">
		<frame src="admin/menu.jsp" noresize="noresize" name="menu"
			scrolling="auto">
		<frame src="admin/main.jsp" noresize="noresize" name="main"
			scrolling="auto">
	</frameset>
</frameset>

<noframes>
	<body>
		您的浏览器不支持框架！
		<br>
	</body>
</noframes>
</html>
