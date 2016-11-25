<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>query house</title>
<link rel="stylesheet" type="text/css" href="css/admin_house_query.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".up").css({
			"height" : "35px"
		});
		$("#condition").css("width", "10%");
		submit();
	});

	function submit() {
		var $btn = $("#find_btn");
		$btn.bind("click", function() {
			if (check()) {
				$.ajax({
					type : "post",
					url : "owner_queryByName",
					data : {
						"owner.name" : $("#condition").val()
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						//alert(obj.house.ownerName);
						if (obj.respCode == '00') {
							$("#name").html(obj.owner.name);
							$("#houseNo").html(obj.owner.houseNo);
							$("#tel").html(obj.owner.tel);
							$("#population").html(obj.owner.population);
							$("#enterDate").html(obj.enterDate);
							var id = obj.owner.id;
							var update_btn = $("#update_btn");
							update_btn.bind("click", function() {
								window.location.href = "owner_load?owner.id="
										+ id;
							});
							var del_btn = $("#delete_btn");
							del_btn.bind("click", function() {
								window.location.href = "owner_delete?owner.id="
										+ id;
							});
						} else {
							alert("不存在 " + $("#conditon").val() + " 业主信息");
						}
					},
					error : function() {
						alert("server exception.");
					}
				});
			}
		});
	}

	function check() {
		var condition = $("#condition").val();
		if (condition.length <= 0) {
			alert("查询条件不能为空");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<center>
		<div class="up">
			<label style="font-weight: bold;">姓名：</label><input type="text"
				id="condition">&nbsp;<input type="button" id="find_btn"
				value="查找">
		</div>
		<hr>
		<table>
			<tr>
				<td colspan="4" id="td_color" style="text-align: center;"><span
					class="title">业主信息</span></td>
			</tr>
			<tr>
				<td id="td_color">姓名</td>
				<td id="td_none"><span id="name"></span></td>
				<td id="td_color">房号</td>
				<td id="td_none"><span id="houseNo"></span></td>
			</tr>
			<tr>
				<td id="td_color">联系电话</td>
				<td id="td_none"><span id="tel"></span></td>
				<td id="td_color">家庭人口</td>
				<td id="td_none"><span id="population"></span></td>
			</tr>
			<tr>
				<td id="td_color">入住时间</td>
				<td colspan="3" id="td_none"><span id="enterDate"></span>
			</tr>
			<tr>
				<td colspan="4" id="td_color" style="text-align: center;"><input
					type="button" id="update_btn" value="修改">&nbsp;&nbsp;<input
					type="button" id="delete_btn" value="删除"></td>
			</tr>
		</table>
	</center>
</body>
</html>