<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>price create</title>
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		submit();
	});

	function submit() {
		var button = $("#submit");
		button.bind("click", function() {
			if (check()) {
				//alert("create start.");
				var waterPrice = $("#waterPrice").val();
				var electricPrice = $("#electricPrice").val();
				var gasPrice = $("#gasPrice").val();
				var wuyePrice = $("#wuyePrice").val();
				var year = $("#year").val();
				var month = $("#month").val();
				var date = year + '-' + month + '-01';

				$.ajax({
					type : "post",
					url : "price_create",
					data : {
						"price.waterPrice" : waterPrice,
						"price.electricPrice" : electricPrice,
						"price.gasPrice" : gasPrice,
						"price.wuyePrice" : wuyePrice,
						"date" : date
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							alert("成功");
							clear();
						} else if (obj.respCode == '02') {
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
		var waterPrice = $("#waterPrice").val();
		var electricPrice = $("#electricPrice").val();
		var gasPrice = $("#gasPrice").val();
		var wuyePrice = $("#wuyePrice").val();
		if (waterPrice.length <= 0 || electricPrice.length <= 0
				|| gasPrice <= 0 || wuyePrice <= 0) {
			alert("price is null.");
			return false;
		}
		return true;
	}

	function clear() {
		$("#waterPrice").val('');
		$("#electricPrice").val('');
		$("#gasPrice").val('');
		$("#wuyePrice").val('');
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<form>
			<table style="border: 1px solid #CBD8AC;">
				<tr
					style="font-weight: bold; background-color: #CBD8AC; text-align: center; height: 35px;">
					<td colspan="2" style="border: 1px solid #CBD8AC; font-size: 20px;">收费标准</td>
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
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">水费</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="waterPrice" style="width: 50px;"><span
						style="color: red;">（元/吨）</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">电费</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="electricPrice" style="width: 50px;"><span
						style="color: red;">（元/度）</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">燃气费</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="gasPrice" style="width: 50px;"><span
						style="color: red;">（元/m³）</span></td>
				</tr>
				<tr style="height: 35px;">
					<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">物业费</td>
					<td style="border: 1px solid #CBD8AC;"><input type="text"
						id="wuyePrice" style="width: 50px;"><span
						style="color: red;">（元/㎡.月）</span></td>
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