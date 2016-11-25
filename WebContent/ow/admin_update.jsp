<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update house</title>
<link rel="stylesheet" type="text/css" href="css/admin_house_update.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		submit();
	});

	function submit() {
		var button = $("#btn");
		button.bind("click", function() {
			if (check()) {
				$.ajax({
					type : "post",
					url : "account_update",
					data : {
						"account.id" : $("#id").val(),
						"account.name" : $("#name").val(),
						"account.tel" : $("#tel").val(),
						"account.username" : $("#username").val(),
						"account.password" : $("#password").val(),
						"account.role" : 1
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							// 跳转
							alert("修改成功");
							window.location.href = "redirect_ow_admin_query";
						} else {
							alert("修改失败.");
						}
					},
					error : function() {
						alert("服务器异常，请稍后重试.");
					}
				});
			}
		});
	}

	function check() {
		var tel = $("#tel").val();
		var username = $("#username").val();
		var password = $("#password").val();

		if (tel.length > 0 && username.length > 0 && password.length > 0) {
			return confirm("确定修改管理员信息？");
		} else {
			alert("输入不能为空.");
			return false;
		}
	}
</script>
</head>
<body>
	<center>
		<s:set var="account" value="#request.account" />
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">修改信息</span><input type="hidden" id="id"
						value=<s:property value="#account.id" />></td>
				</tr>
				<tr>
					<td id="td_color">姓名</td>
					<td id="td_none"><s:property value="#account.name" /><input
						type="hidden" id="name" value=<s:property value="#account.name"/>></td>
					<td id="td_color">电话</td>
					<td id="td_none"><input id="tel" type="text"
						value=<s:property value="#account.tel"/>></td>
				</tr>
				<tr>
					<td id="td_color">登录账号</td>
					<td id="td_none"><input type="text" id="username"
						value=<s:property value="#account.username"/>></td>
					<td id="td_color">登录密码</td>
					<td id="td_none"><input type="text" id="password"
						value=<s:property value="#account.username"/>></td>
				</tr>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><input
						type="button" id="btn" value="确认修改">&nbsp;&nbsp;<input
						type="reset" value="还原数据"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>