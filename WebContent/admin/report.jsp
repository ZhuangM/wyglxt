<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计报表</title>
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/report.js"></script>
</head>
<body style="background-color: #F3F6FA;">
	<div style="background-color: #CBD8AC; height: 30px;">
		<label>&nbsp;选择年份</label> <select id="year" name="year">
			<option value="2016" selected="selected">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
			<option value="2020">2020</option>
		</select><label>年</label>&nbsp;&nbsp; <input type="button" value="查看报表"
			id="report">
	</div>
	<hr>
	<table style="width: 100%; height: 100%; text-align: center;">
		<tr style="background-color: #CBD8AC; height: 28px;">
			<td>月份</td>
			<td>一月</td>
			<td>二月</td>
			<td>三月</td>
			<td>四月</td>
			<td>五月</td>
			<td>六月</td>
			<td>七月</td>
			<td>八月</td>
			<td>九月</td>
			<td>十月</td>
			<td>十一月</td>
			<td>十二月</td>
			<td>总计</td>
		</tr>
		<tr style="height: 25px;">
			<td>用水量（吨）</td>
			<td id="11"></td>
			<td id="21"></td>
			<td id="31"></td>
			<td id="41"></td>
			<td id="51"></td>
			<td id="61"></td>
			<td id="71"></td>
			<td id="81"></td>
			<td id="91"></td>
			<td id="101"></td>
			<td id="111"></td>
			<td id="121"></td>
			<td id="131"></td>
		</tr>
		<tr style="height: 25px;">
			<td>用电量（度）</td>
			<td id="12"></td>
			<td id="22"></td>
			<td id="32"></td>
			<td id="42"></td>
			<td id="52"></td>
			<td id="62"></td>
			<td id="72"></td>
			<td id="82"></td>
			<td id="92"></td>
			<td id="102"></td>
			<td id="112"></td>
			<td id="122"></td>
			<td id="132"></td>
		</tr>
		<tr style="height: 25px;">
			<td>燃气量（m³）</td>
			<td id="13"></td>
			<td id="23"></td>
			<td id="33"></td>
			<td id="43"></td>
			<td id="53"></td>
			<td id="63"></td>
			<td id="73"></td>
			<td id="83"></td>
			<td id="93"></td>
			<td id="103"></td>
			<td id="113"></td>
			<td id="123"></td>
			<td id="133"></td>
		</tr>
	</table>
</body>
</html>