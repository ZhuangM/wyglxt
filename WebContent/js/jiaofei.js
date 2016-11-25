$(document).ready(function() {
	preProc();
});

function preProc() {
	var look = $("#look");
	look.bind("click", function() {
		var year = $("#year").val();
		var month = $("#month").val();
		var date = year + '-' + month + '-01';
		var houseNo = $("#houseNo").val();
		if (houseNo.length <= 0) {
			alert("房间号为空");
			return;
		}
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
					$("#_houseNo").html(houseNo);
					$("#_date").html(year + '-' + month);
					$("#wuye").html(obj.charge.wuye + "元");
					$("#water").html(obj.weg.water + "吨");
					$("#elec").html(obj.weg.electric + "度");
					$("#gas").html(obj.weg.gas + "m³");
					$("#waterPrice").html(obj.charge.waterCharge + "元");
					$("#elecPrice").html(obj.charge.electricCharge + "元");
					$("#gasPrice").html(obj.charge.gasCharge + "元");
					var total = obj.charge.waterCharge
							+ obj.charge.electricCharge + obj.charge.gasCharge;
					$("#total").html(total + "元");
					var status = obj.charge.status;
					if (status == '1') {
						$("#status").html('是');
						$("#paymentName").val(obj.charge.paymentName);
					} else {
						$("#status").html('否');
						$("#paymentName").val('');
					}
					proc(date, houseNo);
				} else {
					alert("账单未出");
				}
			},
			error : function() {
				alert("服务器异常");
			}
		});
	});
}

function proc(date, houseNo) {
	var jiaofei = $("#jiaofei");
	jiaofei.bind("click", function() {
		var paymentName = $("#paymentName").val();
		$.ajax({
			type : "post",
			url : "charge_jiaofei",
			data : {
				"charge.paymentName" : paymentName,
				"date" : date,
				"houseNo" : houseNo
			},
			dataType : "json",
			success : function(resp) {
				// alert(resp);
				var obj = eval("(" + resp + ")");
				if (obj.respCode == '00') {
					alert("缴费成功");
				} else {
					alert("缴费失败");
				}
			},
			error : function() {
				alert("服务器异常");
			}
		});
	});
}