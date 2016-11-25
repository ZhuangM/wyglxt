<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>alter_password</title>
<link rel="stylesheet" type="text/css" href="css/alter_password.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	function check() {
		var oldPassword = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		var newPasswordRepeat = $("#newPasswordRepeat").val();

		if (oldPassword.length <= 0 || newPassword.length <= 0
				|| newPasswordRepeat.length <= 0) {
			alert("密码不能为空");
			return false;
		} else {
			if (newPassword != newPasswordRepeat) {
				alert("两次密码输入不同");
				return false;
			}
			if (confirm("确定修改当前密码？")) {
				return true;
			}
		}
		return false;
	}
</script>
</head>
<body>
	<s:set var="account" value="#session.account"></s:set>
	<center>
		<form action="account_alter" method="post" onSubmit="return check()">
			<table>
				<tr>
					<td id="td_color">姓名：</td>
					<td id="td_none"><s:property value="#account.name" /></td>
					<td id="td_color">登录账号：</td>
					<td id="td_none"><s:property value="#account.username" /></td>
				</tr>
				<tr>
					<td id="td_color">原密码：</td>
					<td id="td_none"><input type="password" id="oldPassword"
						name="account.password" /></td>
					<td id="td_color">新密码：</td>
					<td id="td_none"><input type="password" id="newPassword"
						name="newPassword" /></td>
				</tr>
				<tr>
					<td id="td_color">重复新密码：</td>
					<td id="td_none" colspan="3"><input type="password"
						id="newPasswordRepeat" name="newPasswordRepeat" /></td>
				</tr>
				<tr>
					<td id="td_none" colspan="4" align="center"><input
						type="submit" value="提交" id="submit" />&nbsp;&nbsp;<input
						type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>