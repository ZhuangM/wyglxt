<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账单查询</title>
<link rel="stylesheet" type="text/css" href="css/admin_jiaofei.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		preProc();
	});

	function preProc() {
		var look = $("#look");
		look.bind("click", function() {
			var houseNo = $("#houseNo").html();
			var year = $("#year").val();
			var month = $("#month").val();
			var date = year + '-' + month + '-01';
			$.ajax({
				type : "post",
				url : "charge_queryBill",
				data : {
					"date" : date,
					"houseNo" : houseNo
				},
				dataType : "json",
				success : function(resp) {
					// alert(resp);
					var obj = eval("(" + resp + ")");
					if (obj.respCode == '00') {
						$("#_date").html(year + '-' + month);
						$("#wuye").html(obj.charge.wuye + "元");
						$("#water").html(obj.weg.water + "吨");
						$("#elec").html(obj.weg.electric + "度");
						$("#gas").html(obj.weg.gas + "m³");
						$("#waterPrice").html(obj.charge.waterCharge + "元");
						$("#elecPrice").html(obj.charge.electricCharge + "元");
						$("#gasPrice").html(obj.charge.gasCharge + "元");
						var total = obj.charge.waterCharge
								+ obj.charge.electricCharge
								+ obj.charge.gasCharge;
						$("#total").html(total + "元");
						var status = obj.charge.status;
						if (status == '1') {
							$("#status").html('是');
							$("#paymentName").html(obj.charge.paymentName);
						} else {
							$("#status").html('否');
							$("#paymentName").html('');
						}
					} else {
						alert("未出账单");
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
<body>
	<center>
		<s:set var="account" value="#session.account"></s:set>
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
			</select><label>月</label>&nbsp;&nbsp;<label>房间号：</label><span id="houseNo"><s:property
					value="#account.username" /></span><span style="color: red"></span>&nbsp;&nbsp;<input
				type="button" value="查看费用详单" id="look">
		</div>
		<hr>
		<table>
			<tr style="text-align: center;">
				<td colspan="6" class="td_color"><span id="shoufeidan">收费单</span></td>
			</tr>
			<tr>
				<td class="td_color">房号</td>
				<td class="td_none" id="_houseNo"><s:property
						value="#account.username" /></td>
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
				<td class="td_none"><span id="paymentName"></span></td>
			</tr>
		</table>
	</center>
</body>
</html>