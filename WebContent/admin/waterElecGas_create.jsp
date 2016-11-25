<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		submit();
	});

	function submit() {
		var button = $("#submit");
		button.bind("click", function() {
			if (check()) {
				var houseNo = $("#houseNo").val();
				var water = $("#water").val();
				var electric = $("#electric").val();
				var gas = $("#gas").val();
				var year = $("#year").val();
				var month = $("#month").val();
				var date = year + '-' + month + '-01';

				$.ajax({
					type : "post",
					url : "waterElecGas_create",
					data : {
						"waterElecGas.water" : water,
						"waterElecGas.electric" : electric,
						"waterElecGas.gas" : gas,
						"waterElecGas.houseNo" : houseNo,
						"date" : date
					},
					dataType : "json",
					success : function(resp) {
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							alert("成功");
							clear();
						} else if (obj.respCode == '01') {
							alert("房间号不存在");
						} else if (obj.respCode == '02') {
							alert("该月收费标准为空");
						} else if (obj.respCode == '03') {
							alert("重复录入");
						} else {
							alert("失败");
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
		var houseNo = $("#houseNo").val();
		var water = $("#water").val();
		var electric = $("#electric").val();
		var gas = $("#gas").val();
		if (water.length <= 0 || electric.length <= 0 || gas <= 0
				|| houseNo.length <= 0) {
			alert("data is null.");
			return false;
		}
		return true;
	}

	function clear() {
		$("#houseNo").val('');
		$("#water").val('');
		$("#electric").val('');
		$("#gas").val('');
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<form>
			<table style="border: 1px solid #CBD8AC;">
				<tr
					style="font-weight: bold; background-color: #CBD8AC; text-align: center; height: 35px;">
					<td colspan="2" style="border: 1px solid #CBD8AC; font-size: 20px;">录入月用量</td>
				</tr>
				<tr style="height: 35px;">
					<td
						style="background-color: #CBD8AC; border: 1px solid #CBD8AC; width: 25%;">月份</td>
					<td style="width: 40%; border: 1px solid #CBD8AC;"><select
						id="year" name="year">
							<option value="2016" selected="selected">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
					</select><label>年</label><select id="month" name="month">
							<option value="01" selected="selected">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
					</select><label>月</label></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">房间号</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="houseNo" style="width: 50px;"><span
						style="color: red;">如：1#1-101</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">水量</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="water" style="width: 50px;"><span style="color: red;">（吨/月）</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">电量</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="electric" style="width: 50px;"><span
						style="color: red;">（度/月）</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">燃气</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="gas" style="width: 50px;"><span style="color: red;">（m³/月）</span></td>
				</tr>
				<tr
					style="background-color: #CBD8AC; text-align: center; height: 35px;">
					<td colspan="2" style="border: 1px solid #CBD8AC;"><input
						type="button" id="submit" value="提交">&nbsp;&nbsp;<input
						type="reset" value="重置"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>