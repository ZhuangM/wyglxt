<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/admin_top.css">
<script language="javascript" src="js/admin_top.js"></script>

</head>
<body>
	<!-- 背景图片 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		background="image/top.jpg" style="border: 1px solid black;">
		<tr>
			<td width="20%" height="60"><h1>物业管理系统</h1></td>
			<td width="80%" align="right" valign="bottom">
				<table width="750" border="0" cellpadding="0">
					<tr>
						<td align="right" height="26"
							style="padding-right: 10px; line-height: 26px;">您好：<span
							class="username"><s:property value="#session.name" /></span>，欢迎登录物业管理系统！
							[<a href="<%=request.getContextPath()%>/index.html"
							target="_blank">登录界面</a>] <!-- 配置struts.xml文件 --> [<a
							href="redirect_admin_alterPassword" target="main">修改密码</a>] [<a
							href="clear" target="_top">注销退出</a>] &nbsp;
						</td>
					</tr>
					<tr>
						<td align="right" height="34" class="rmain">
							<dl id="tpa">
								<dd>
									<div class="itemsel" id="iteml"
										onmousemove="mv(this,'move',1);" onmouseout="mv(this,'o',1);">
										<a href="admin/menu.jsp" target="menu" onclick="changeSel(1)">主菜单</a>
									</div>
								</dd>
							</dl>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
