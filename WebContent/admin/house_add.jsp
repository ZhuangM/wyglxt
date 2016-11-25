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
		$("#houseNo").css("width", "50%");
		$(".remark").html("如：1#1-101");
		$(".remark").css("color", "red");
		submit();
	});

	function submit() {
		var button = $("#btn");
		button.bind("click", function() {
			if (check()) {
				$.ajax({
					type : "post",
					url : "house_add",
					data : {
						"house.area" : $("#area").val(),
						"house.description" : $("#description").val(),
						"house.houseNo" : $("#houseNo").val(),
						"house.floorId" : $("#floorId").val(),
						"house.cellId" : $("#cellId").val(),
						"house.shape" : $("#shape").val(),
						"house.buildDate" : $("#buildDate").val()
					},
					datatype : "json",
					success : function(resp) {
						//alert(data);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							alert("添加成功.");
							$("#area").val("");
							$("#description").val("");
							$("#houseNo").val("");
							$(".title").html("新增房产信息");
						} else if (obj.respCode == '01') {
							alert("房号已存在.");
							$(".title").html("房号已存在");
						} else {
							alert("添加失败.");
							$(".title").html("添加失败");
						}
					},
					error : function() {
						alert("服务器异常,请稍后再试.");
					}
				});
			}
		});
	}

	function check() {
		var area = $("#area").val();
		var description = $("#description").val();
		var houseNo = $("#houseNo").val();

		if (area.length > 0 && houseNo.length > 0 && description.length > 0) {
			return confirm("确定添加房产信息？");
		} else {
			alert("输入不能为空.");
			return false;
		}
	}
</script>
</head>
<body>
	<center>
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">新增房产信息</span></td>
				</tr>
				<tr>
					<td id="td_color">房号</td>
					<td id="td_none"><input type="text" id="houseNo"
						name="house.houseNo"><span class="remark"></span></td>
					<td id="td_color">面积</td>
					<td id="td_none"><input id="area" type="text"
						name="house.area"> <label>㎡</label></td>
				</tr>
				<tr>
					<td id="td_color">楼号</td>
					<td id="td_none"><select name="house.floorId" id="floorId"><option
								value="1栋" selected="selected">1栋</option>
							<option value="2栋">2栋</option>
							<option value="3栋">3栋</option>
							<option value="4栋">4栋</option>
							<option value="5栋">5栋</option>
							<option value="6栋">6栋</option>
							<option value="7栋">7栋</option>
							<option value="8栋">8栋</option>
							<option value="9栋">9栋</option>
							<option value="10栋">10栋</option>
					</select></td>
					<td id="td_color">户主姓名</td>
					<td id="td_none"><span style="color: red;">**此处不准添加**</span></td>
				</tr>
				<tr>
					<td id="td_color">单元号</td>
					<td id="td_none"><select name="house.cellId" id="cellId"><option
								value="1单元">1单元</option>
							<option value="2单元">2单元</option>
							<option value="3单元">3单元</option>
							<option value="4单元">4单元</option>
							<option value="5单元">5单元</option>
							<option value="6单元">6单元</option>
					</select></td>
					<td id="td_color">户主电话</td>
					<td id="td_none"><span style="color: red;">**此处不准添加**</span></td>
				</tr>
				<tr>
					<td id="td_color">户型</td>
					<td id="td_none"><select id="shape" name="house.shape"><option
								value="一室一厅一卫">一室一厅一卫</option>
							<option value="二室一厅一卫" selected="selected">二室一厅一卫</option>
							<option value="三室一厅一卫">三室一厅一卫</option>
							<option value="三室一厅二卫">三室一厅二卫</option>
					</select></td>
					<td id="td_color">建筑年代</td>
					<td id="td_none"><select id="buildDate" name="house.buildDate"><option
								value="2000年">2000年</option>
							<option value="2001年">2001年</option>
							<option value="2002年" selected="selected">2002年</option>
							<option value="2003年">2003年</option>
							<option value="2004年">2004年</option>
							<option value="2005年">2005年</option>
							<option value="2006年">2006年</option>
							<option value="2007年">2007年</option>
							<option value="2008年">2008年</option>
							<option value="2009年">2009年</option>
							<option value="2010年">2010年</option>
							<option value="2011年">2011年</option>
							<option value="2012年">2012年</option>
							<option value="2013年">2013年</option>
							<option value="2014年">2014年</option>
							<option value="2015年">2015年</option></select></td>
				</tr>
				<tr>
					<td id="td_color">描述</td>
					<td colspan="3" id="td_none"><textarea cols="60" rows="2"
							id="description" name="house.description"></textarea>
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