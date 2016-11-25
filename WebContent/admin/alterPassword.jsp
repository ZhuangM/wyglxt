<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/alter_password.css">
<script type="text/javascript">
	function check() {
		var op = document.getElementById("oldPassword").value;
		var np = (document.getElementsByName("newPassword"))[0].value;
		var npr = (document.getElementsByName("newPasswordRepeat"))[0].value;
		if (op.length > 0 && np.length > 0 && npr.length > 0) {
			if (np == npr) {
				return true;
			} else {
				alert("两次密码输入不同");
			}
		} else {
			alert("输入不能为空");
		}
		return false;
	}
</script>
</head>
<body>
	<s:set var="account" value="#session.account" />
	<center>
		<form action="account_alter" method="post" onSubmit="return check()">
			<table>
				<tr>
					<td id="td_color">姓名：</td>
					<td id="td_none"><s:property value="#account.name" /></td>
				</tr>
				<tr>
					<td id="td_color">账号：</td>
					<td id="td_none"><s:property value="#account.username" /></td>
				</tr>
				<tr>
					<td id="td_color">原密码：</td>
					<td id="td_none"><input type="password" id="oldPassword"
						name="account.password" /></td>
				</tr>
				<tr>
					<td id="td_color">新密码：</td>
					<td id="td_none"><input type="password" name="newPassword" /></td>
				</tr>
				<tr>
					<td id="td_color">重复新密码：</td>
					<td id="td_none"><input type="password"
						name="newPasswordRepeat" /></td>
				</tr>
				<tr>
					<td id="td_none" colspan="2" align="center"><input
						type="submit" value="提交" />&nbsp;<input type="reset" value="重置" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>