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
					url : "owner_add",
					data : {
						"owner.name" : $("#name").val(),
						"owner.houseNo" : $("#houseNo").val(),
						"owner.tel" : $("#tel").val(),
						"owner.population" : $("#population").val(),
						"enterDate" : $("#enterDate").val()
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							alert("添加成功");
							$("#name").val("");
							$("#houseNo").val("");
							$("#tel").val("");
							$("#population").val("");
							$("#enterDate").val("");
						} else if (obj.respCode == '01') {
							alert("业主姓名已存在.");
						} else if (obj.respCode == '02') {
							alert("房间号不存在.");
						} else if (obj.respCode == '03') {
							alert($("#houseNo").val() + "已被入住.");
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
		var houseNo = $("#houseNo").val();
		var tel = $("#tel").val();
		var population = $("#population").val();
		var enterDate = $("#enterDate").val();

		if (houseNo.length > 0 && tel.length > 0 && population.length > 0
				&& enterDate.length > 0) {
			return confirm("确定新增业主信息？");
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
						class="title">新增业主信息</span></td>
				</tr>
				<tr>
					<td id="td_color">姓名</td>
					<td id="td_none"><input id="name" type="text" /></td>
					<td id="td_color">房号</td>
					<td id="td_none"><input id="houseNo" type="text" /><span
						id="example">如：1#1-101</span></td>
				</tr>
				<tr>
					<td id="td_color">联系电话</td>
					<td id="td_none"><input id="tel" type="text"></td>
					<td id="td_color">家庭人口</td>
					<td id="td_none"><input id="population" type="text"></td>
				</tr>
				<tr>
					<td id="td_color">入住时间</td>
					<td colspan="3" id="td_none"><input id="enterDate" type="text"><span
						id="example">如：2016-01-01</span>
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