<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>缴费</title>
<link rel="stylesheet" type="text/css" href="css/admin_jiaofei.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/jiaofei.js"></script>
</head>
<body>
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
			</select><label>月</label>&nbsp;&nbsp;<label>房间号</label><input type="text"
				id="houseNo" width="40px"><span style="color: red">如:1#1-101</span>&nbsp;&nbsp;<input
				type="button" value="查看费用详单" id="look">
		</div>
		<hr>
		<table>
			<tr style="text-align: center;">
				<td colspan="6" class="td_color"><span id="shoufeidan">收费单</span></td>
			</tr>
			<tr>
				<td class="td_color">房号</td>
				<td class="td_none" id="_houseNo"></td>
				<td class="td_color">年月份</td>
				<td class="td_none" id="_date"></td>
				<td class="td_color">物业费</td>
				<td class="td_none" id="wuye"></td>
			</tr>
			<tr>
				<td class="td_color">用水量</td>
				<td class="td_none" id="water"></td>
				<td class="td_color">用电量</td>
				<td class="td_none" id="elec"></td>
				<td class="td_color">用气量</td>
				<td class="td_none" id="gas"></td>
			</tr>
			<tr>
				<td class="td_color">水费</td>
				<td class="td_none" id="waterPrice"></td>
				<td class="td_color">电费</td>
				<td class="td_none" id="elecPrice"></td>
				<td class="td_color">燃气费</td>
				<td class="td_none" id="gasPrice"></td>
			</tr>
			<tr>
				<td class="td_color">费用统计</td>
				<td class="td_none" id="total"></td>
				<td class="td_color">是否已缴费</td>
				<td class="td_none" id="status"></td>
				<td class="td_color">收费人</td>
				<td class="td_none"><input type="text" id="paymentName"></td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="6" class="td_color"><input type="button"
					id="jiaofei" value="确认交费"></td>
			</tr>
		</table>
	</center>
</body>
</html>