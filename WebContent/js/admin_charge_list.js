var currentPageNum = 1;

$(document).ready(function() {
	preProcess();
	commonProcess(1);
});

function preProcess() {
	var findBtn = $("#find");
	var firstBtn = $("#first");
	var preBtn = $("#pre");
	var nextBtn = $("#next");
	var lastBtn = $("#last");
	findBtn.bind("click", function() {
		commonProcess(1);
	});
	firstBtn.bind("click", function() {
		currentPageNum = 1;
		commonProcess(currentPageNum);
	});
	preBtn.bind("click", function() {
		currentPageNum--;
		if(currentPageNum < 1) {
			currentPageNum = 1;
		}
		commonProcess(currentPageNum);
	});
	nextBtn.bind("click", function() {
		currentPageNum++;
		if(currentPageNum > 10) {
			currentPageNum = 10;
		}
		commonProcess(currentPageNum);
	});
	lastBtn.bind("click", function() {
		currentPageNum = 10;
		commonProcess(currentPageNum);
	});
}

function commonProcess(pageNum) {
	clear();
	$("#currentPageNum").html(pageNum);
	var year = $("#year").val();
	var month = $("#month").val();
	var date = year + '-' + month + '-01';
	var houseNo = $("#houseNo").val();
	
	$.ajax({
		type : "post",
		url : "charge_queryByDate",
		data : {
			"date" : date,
			"currentPageNum" : pageNum,
			"houseNo" : houseNo
		},
		dataType : "json",
		success : function(resp) {
			var obj = eval("(" + resp + ")");
			if (obj.respCode == '00') {
				// window.location.href = "owner_list?currentPageNum=" +
				// pageNum;
				var length = obj.charges.length;
				for (var i = 0; i < length; i++) {
					var temp = i + 1;
					$("#" + temp + "1").html(i + 1);
					$("#" + temp + "2").html((obj.charges)[i].houseNo);
					$("#" + temp + "3").html(year + '-' + month);
					$("#" + temp + "4").html('¥ ' + (obj.charges)[i].waterCharge);
					$("#" + temp + "5").html('¥ ' + (obj.charges)[i].electricCharge);
					$("#" + temp + "6").html('¥ ' + (obj.charges)[i].gasCharge);
					$("#" + temp + "7").html('¥ ' + (obj.charges)[i].wuye);
					var total = (obj.charges)[i].waterCharge + (obj.charges)[i].electricCharge + (obj.charges)[i].gasCharge + (obj.charges)[i].wuye;
					$("#" + temp + "8").html('¥ ' + total);
					if ((obj.charges)[i].status == 0) {
						$("#" + temp + "9").html("否");
					} else {
						$("#" + temp + "9").html("是");
					}
					$("#" + temp + "0").html((obj.charges)[i].paymentName);
				}
			} else {
				clear();
			}
		},
		error : function() {
			alert("server exception, try again please.");
			clear();
		}
	});
}

function clear() {
	for (var i = 0; i < 17; i++) {
		var temp = i + 1;
		$("#" + temp + "1").html("");
		$("#" + temp + "2").html("");
		$("#" + temp + "3").html("");
		$("#" + temp + "4").html("");
		$("#" + temp + "5").html("");
		$("#" + temp + "6").html("");
		$("#" + temp + "7").html("");
		$("#" + temp + "8").html("");
		$("#" + temp + "9").html("");
		$("#" + temp + "0").html("");
	}
}