<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add house</title>
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
					url : "demo_add",
					data : {
						"demo.bianma" : $("#bianma").val(),
						"demo.mingcheng" : $("#mingcheng").val(),
						"demo.zerenren" : $("#zerenren").val(),
						"demo.yuanzhi" : $("#yuanzhi").val(),
						"enterDate" : $("#enterDate").val(),
						"demo.nianxian" : $("#nianxian").val()
					},
					datatype : "json",
					success : function(resp) {
						var obj = eval("(" + resp + ")");

						alert("添加成功." + obj.respCode);
						$("#bianma").val('');
						$("#mingcheng").val('');
						$("#zerenren").val('');
						$("#yuanzhi").val('');
						$("#nianxian").val('');
						$(".title").html("新增demo信息");
					},
					error : function() {
						alert("服务器异常,请稍后再试.");
					}
				});
			}
		});
	}

	function check() {
		return true;
	}
</script>
</head>
<body>
	<center>
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">新增demo信息</span></td>
				</tr>
				<tr>
					<td id="td_color">编码</td>
					<td id="td_none"><input type="text" id="bianma"></td>
					<td id="td_color">名称</td>
					<td id="td_none"><input id="mingcheng" type="text"></td>
				</tr>
				<tr>
					<td id="td_color">责任人</td>
					<td id="td_none"><input type="text" id="zerenren"></td>
					<td id="td_color">原值</td>
					<td id="td_none"><input id="yuanzhi" type="text"></td>
				</tr>


				<tr>
					<td id="td_color">年限</td>
					<td id="td_none"><input id="nianxian" type="text"></td>
					<td id="td_color">启用时间</td>
					<td id="td_none"><input id="enterDate" type="text">2016-01-01</td>
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