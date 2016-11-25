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
					url : "house_queryByNo",
					data : {
						"house.houseNo" : $("#condition").val()
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						//alert(obj.house.ownerName);
						if (obj.respCode == '00') {
							$("#area").html(obj.house.area + '㎡');
							$("#ownerName").html(obj.house.ownerName);
							$("#ownerTel").html(obj.house.ownerTel);
							$("#description").html(obj.house.description);
							$("#houseNo").html(obj.house.houseNo);
							$("#floorId").html(obj.house.floorId);
							$("#cellId").html(obj.house.cellId);
							$("#shape").html(obj.house.shape);
							$("#buildDate").html(obj.house.buildDate);
							var id = obj.house.id;
							var update_btn = $("#update_btn");
							update_btn.bind("click", function() {
								window.location.href = "house_load?house.id="
										+ id;
							});
							var del_btn = $("#delete_btn");
							del_btn.bind("click", function() {
								window.location.href = "house_delete?house.id="
										+ id;
							});
						} else {
							alert("不存在 " + $("#conditon").val() + " 住房信息");
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
			<label style="font-weight: bold;">房号：</label><input type="text"
				id="condition">&nbsp;<input type="button" id="find_btn"
				value="查找">
		</div>
		<hr>
		<table>
			<tr>
				<td colspan="4" id="td_color" style="text-align: center;"><span
					class="title">住房信息</span></td>
			</tr>
			<tr>
				<td id="td_color">房号</td>
				<td id="td_none"><span id="houseNo"></span></td>
				<td id="td_color">面积</td>
				<td id="td_none"><span id="area"></span></td>
			</tr>
			<tr>
				<td id="td_color">楼号</td>
				<td id="td_none"><span id="floorId"></span></td>
				<td id="td_color">户主姓名</td>
				<td id="td_none"><span id="ownerName"></span></td>
			</tr>
			<tr>
				<td id="td_color">单元号</td>
				<td id="td_none"><span id="cellId"></span></td>
				<td id="td_color">户主电话</td>
				<td id="td_none"><span id="ownerTel"></span></td>
			</tr>
			<tr>
				<td id="td_color">户型</td>
				<td id="td_none"><span id="shape"></span></td>
				<td id="td_color">建筑年代</td>
				<td id="td_none"><span id="buildDate"></span></td>
			</tr>
			<tr>
				<td id="td_color">描述</td>
				<td colspan="3" id="td_none"><span id="description"></span>
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