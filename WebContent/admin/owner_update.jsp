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
		var pageNum = $("#pageNum").val();
		button.bind("click", function() {
			if (check()) {
				$.ajax({
					type : "post",
					url : "owner_update",
					data : {
						"owner.id" : $("#id").val(),
						"owner.name" : $("#name").html(),
						"owner.houseNo" : $("#houseNo").html(),
						"owner.tel" : $("#tel").val(),
						"owner.population" : $("#population").val(),
						"enterDate" : $("#enterDate").val()
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							// 跳转
							alert("修改成功");
							window.location.href = "owner_list?currentPageNum="
									+ pageNum;
						} else if (obj.respCode == '01') {
							alert("不存在该条记录，无法进行修改.");
						} else if (obj.respCode == '02') {
							alert("房间号错误.");
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
		var population = $("#population").val();
		var enterDate = $("#enterDate").val();

		if (tel.length > 0 && population.length > 0
				&& enterDate.length > 0) {
			return confirm("确定修改业主信息？");
		} else {
			alert("输入不能为空.");
			return false;
		}
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<s:set var="owner" value="#request.owner" />
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">修改业主信息</span><input type="hidden" id="id"
						value=<s:property value="#owner.id" />><input
						type="hidden" id="pageNum"
						value=<s:property value="#request.currentPageNum" />></td>
				</tr>
				<tr>
					<td id="td_color">姓名</td>
					<td id="td_none"><label id="name"><s:property
								value="#owner.name" /></label></td>
					<td id="td_color">房号</td>
					<td id="td_none"><label id="houseNo"><s:property
								value="#owner.houseNo" /></label><span id="example">&nbsp;(**不可修改**)</span></td>
				</tr>
				<tr>
					<td id="td_color">联系电话</td>
					<td id="td_none"><input id="tel" type="text"
						value=<s:property value="#owner.tel" />></td>
					<td id="td_color">家庭人口</td>
					<td id="td_none"><input id="population" type="text"
						value=<s:property value="#owner.population" />></td>
				</tr>
				<tr>
					<td id="td_color">入住时间</td>
					<td colspan="3" id="td_none"><input id="enterDate" type="text"
						value=<s:date format="yyyy-MM-dd" name="#owner.enterDate" />><span
						id="example">如：2016-01-01</span>
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