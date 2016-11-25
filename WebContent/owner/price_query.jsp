<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		preProc();
	});

	function preProc() {
		var look = $("#look");
		look.bind("click", function() {
			var year = $("#year").val();
			var month = $("#month").val();
			var date = year + '-' + month + '-01';
			$.ajax({
				type : "post",
				url : "price_query",
				data : {
					"date" : date
				},
				dataType : "json",
				success : function(resp) {
					//alert(resp);
					var obj = eval("(" + resp + ")");
					if (obj.respCode == '00') {
						$("#waterPrice").html(obj.price.waterPrice);
						$("#electricPrice").html(obj.price.electricPrice);
						$("#gasPrice").html(obj.price.gasPrice);
						$("#wuyePrice").html(obj.price.wuyePrice);
					} else {
						alert("查询失败");
						$("#waterPrice").html("");
						$("#electricPrice").html("");
						$("#gasPrice").html("");
						$("#wuyePrice").html("");
					}
				},
				error : function() {
					alert("服务器异常");
				}
			});
		});
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<div style="background-color: #CBD8AC; height: 30px;">
			<label>&nbsp;选择年月份</label> <select id="year" name="year">
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
			</select><label>月</label>&nbsp;&nbsp;<input type="button" value="查询" id="look">
		</div>
		<hr>
		<table style="border: 1px solid #CBD8AC; width: 30%;">
			<tr
				style="font-weight: bold; background-color: #CBD8AC; text-align: center; height: 35px;">
				<td colspan="2" style="border: 1px solid #CBD8AC; font-size: 20px;">收费标准</td>
			</tr>
			<tr style="height: 35px;">
				<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">水费</td>
				<td style="border: 1px solid #CBD8AC;"><span id="waterPrice"></span><span
					style="color: red;">（元/吨）</span></td>
			</tr>
			<tr style="height: 35px;">
				<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">电费</td>
				<td style="border: 1px solid #CBD8AC;"><span id="electricPrice"></span><span
					style="color: red;">（元/度）</span></td>
			</tr>
			<tr style="height: 35px;">
				<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">燃气费</td>
				<td style="border: 1px solid #CBD8AC;"><span id="gasPrice"></span><span
					style="color: red;">（元/m³）</span></td>
			</tr>
			<tr style="height: 35px;">
				<td style="background-color: #CBD8AC; border: 1px solid #CBD8AC;">物业费</td>
				<td style="border: 1px solid #CBD8AC;"><span id="wuyePrice"></span><span
					style="color: red;">（元/㎡.月）</span></td>
			</tr>
		</table>
	</center>
</body>
</html>