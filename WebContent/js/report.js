$(document).ready(function() {
	preProc();
	commonProcess();
});

function preProc() {
	var btn = $("#report");
	btn.bind("click", function() {
		commonProcess();
	});
}

function commonProcess() {
	var year = $("#year").val();

	$.ajax({
		type : "post",
		url : "waterElecGas_report",
		data : {
			"date" : year,
		},
		dataType : "json",
		success : function(resp) {
//			alert(resp);
			var obj = eval("(" + resp + ")");
			if (obj.respCode == '00' && obj.dtos != null) {
				var waterTotal = 0;
				var elecTotal = 0;
				var gasTotal = 0;
				for (var i = 0; i < 12; i++) {
					var water = obj.dtos[i].water;
					var elec = obj.dtos[i].elec;
					var gas = obj.dtos[i].gas;
					waterTotal += water;
					elecTotal += elec;
					gasTotal += gas;
					var temp = i + 1;
					$("#" + temp + "1").html(water);
					$("#" + temp + "2").html(elec);
					$("#" + temp + "3").html(gas);
				}
				$("#131").html(waterTotal);
				$("#132").html(elecTotal);
				$("#133").html(gasTotal);
			} else {
				alert("不存在记录");
				for (var i = 0; i < 12; i++) {
					var temp = i + 1;
					$("#" + temp + "1").html("0");
					$("#" + temp + "2").html("0");
					$("#" + temp + "3").html("0");
				}
				$("#131").html("0");
				$("#132").html("0");
				$("#133").html("0");
			}
		},
		error : function() {
			alert("服务器异常");
		}
	});
}