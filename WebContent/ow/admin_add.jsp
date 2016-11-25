<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update house</title>
<link rel="stylesheet" type="text/css" href="css/admin_owner_update.css">
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
					url : "account_add",
					data : {
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
							alert("添加成功");
							$("#name").val("");
							$("#tel").val("");
							$("#username").val("");
							$("#password").val("");
						} else if (obj.respCode == '01') {
							alert("姓名已存在.");
						} else {
							alert("添加失败.");
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
		var name = $("#name").val();
		var tel = $("#tel").val();
		var username = $("#username").val();
		var password = $("#password").val();

		if (name.length > 0 && tel.length > 0 && username.length > 0
				&& password.length > 0) {
			if (tel.length == 11) {
				return confirm("确定添加管理员信息？");
			} else {
				alert("电话号格式错误");
				return false;
			}
		} else {
			alert("输入不能为空.");
			return false;
		}
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">新增管理员信息</span></td>
				</tr>
				<tr>
					<td id="td_color">姓名</td>
					<td id="td_none"><input id="name" type="text" /></td>
					<td id="td_color">电话</td>
					<td id="td_none"><input id="tel" type="text" /><span
						id="example">如：13888888888</span></td>
				</tr>
				<tr>
					<td id="td_color">登录账号</td>
					<td id="td_none"><input id="username" type="text"></td>
					<td id="td_color">登录密码</td>
					<td id="td_none"><input id="password" type="text"></td>
				</tr>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><input
						type="button" id="btn" value="确认添加">&nbsp;&nbsp;<input
						type="reset" value="还原数据"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>