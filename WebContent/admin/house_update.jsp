<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update house</title>
<link rel="stylesheet" type="text/css" href="css/admin_house_update.css">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		submit();
	});

	function submit() {
		var button = $("#btn");
		var pageNum = $("#pageNum").val();
		button.bind("click", function() {
			if (check()) {
				$.ajax({
					type : "post",
					url : "house_update",
					data : {
						"house.id" : $("#id").val(),
						"house.area" : $("#area").val(),
						"house.description" : $("#description").val(),
						"house.shape" : $("#shape").val(),
						"house.buildDate" : $("#buildDate").val()
					},
					dataType : "json",
					success : function(resp) {
						//alert(resp);
						var obj = eval("(" + resp + ")");
						if (obj.respCode == '00') {
							// 跳转
							alert("修改成功");
							window.location.href = "house_list?currentPageNum="
									+ pageNum;
						} else if (obj.respCode == '01') {
							alert("不存在该条记录，无法进行修改.");
						} else {
							alert("修改失败.");
						}
					},
					error : function() {
						alert("服务器异常，请稍后重试.");
					}
				});
			}
		});
	}

	function check() {
		var area = $("#area").val();
		var description = $("#description").val();

		if (area.length > 0 && description.length > 0) {
			return confirm("确定修改房产信息？");
		} else {
			alert("输入不能为空.");
			return false;
		}
	}
</script>
</head>
<body>
	<center>
		<s:set var="house" value="#request.house" />
		<form>
			<table>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><span
						class="title">修改信息</span><input type="hidden" id="id"
						value=<s:property value="#house.id" />><input
						type="hidden" id="pageNum"
						value=<s:property value="#request.currentPageNum" />></td>
				</tr>
				<tr>
					<td id="td_color">房号</td>
					<td id="td_none"><s:property value="#house.houseNo" /><input
						type="hidden" id="houseNo"
						value=<s:property value="#house.houseNo"/>></td>
					<td id="td_color">面积</td>
					<td id="td_none"><input id="area" type="text"
						value=<s:property value="#house.area"/>> <label>㎡</label></td>
				</tr>
				<tr>
					<td id="td_color">楼号</td>
					<td id="td_none"><s:property value="#house.floorId" /><input
						type="hidden" id="floorId"
						value=<s:property value="#house.floorId"/>></td>
					<td id="td_color">户主姓名</td>
					<td id="td_none"><span><s:property
								value="#house.ownerName" /></span></td>
				</tr>
				<tr>
					<td id="td_color">单元号</td>
					<td id="td_none"><s:property value="#house.cellId" /><input
						type="hidden" id="cellId"
						value=<s:property value="#house.cellId"/>></td>
					<td id="td_color">户主电话</td>
					<td id="td_none"><span><s:property
								value="#house.ownerTel" /></span></td>
				</tr>
				<tr>
					<td id="td_color">户型</td>
					<td id="td_none"><select id="shape"><option
								value="一室一厅一卫">一室一厅一卫</option>
							<option value="二室一厅一卫" selected="selected">二室一厅一卫</option>
							<option value="三室一厅一卫">三室一厅一卫</option>
							<option value="三室一厅二卫">三室一厅二卫</option>
					</select></td>
					<td id="td_color">建筑年代</td>
					<td id="td_none"><select id="buildDate"><option
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
							id="description"><s:property
								value="#house.description" /></textarea>
				</tr>
				<tr>
					<td colspan="4" id="td_color" style="text-align: center;"><input
						type="button" id="btn" value="确认修改">&nbsp;&nbsp;<input
						type="reset" value="还原数据"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>