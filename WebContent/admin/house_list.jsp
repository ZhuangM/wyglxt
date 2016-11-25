<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>all houses</title>

<link rel="stylesheet" type="text/css" href="css/common.css">

</head>
<body style="background-color: #F3F6FA;">
	<%
		int i = 1;
		int currentPageNum = (Integer) request.getAttribute("currentPageNum");
		int lastPageNum = currentPageNum - 1;
		int nextPageNum = currentPageNum + 1;
	%>
	<table
		style="text-align: center; width: 100%; height: 100%; border: 1px solid black;">
		<tr style="background-color: #CBD8AC; border-bottom: 1px solid black;">
			<td width="5%">ID</td>
			<td width="10%">房号</td>
			<td width="15%">描述</td>
			<td width="5%">楼号</td>
			<td width="5%">单元号</td>
			<td width="10%">建筑年代</td>
			<td width="10%">户型</td>
			<td width="5%">面积</td>
			<td width="10%">户主姓名</td>
			<td width="10%">户主电话</td>
			<td width="15%">操作</td>
		</tr>

		<s:iterator value="#request.houses" var="house">
			<tr>
				<td><%=i++%></td>
				<td><s:property value="#house.houseNo" /></td>
				<td><s:property value="#house.description" /></td>
				<td><s:property value="#house.floorId" /></td>
				<td><s:property value="#house.cellId" /></td>
				<td><s:property value="#house.buildDate" /></td>
				<td><s:property value="#house.shape" /></td>
				<td><s:property value="#house.area" /><label>㎡</label></td>
				<td><s:property value="#house.ownerName" /></td>
				<td><s:property value="#house.ownerTel" /></td>
				<td><a
					href="house_load?currentPageNum=<%=currentPageNum%>&house.id=<s:property value="#house.id"/>">修改</a>|<a
					href="house_delete?currentPageNum=<%=currentPageNum%>&house.id=<s:property value="#house.id"/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>

	<table
		style="text-align: center; width: 100%; height: 100%; background-color: silver; border-bottom: 1px solid black; border-left: 1px solid black; border-right: 1px solid black;">
		<tr style="background-color: #CBD8AC; border-top: 1px solid black;">
			<td><a href="house_list?currentPageNum=1"><input
					type="button" value="首页" style="width: 100%;"></a></td>
			<td><a href="house_list?currentPageNum=<%=lastPageNum%>"><input
					type="button" value="上一页" style="width: 100%;"></a></td>
			<td><span><%=currentPageNum%>/10页</span></td>
			<td><a href="house_list?currentPageNum=<%=nextPageNum%>"><input
					type="button" value="下一页" style="width: 100%;"></a></td>
			<td><a href="house_list?currentPageNum=10"><input
					type="button" value="尾页" style="width: 100%;"></a></td>
		</tr>
	</table>
</body>
</html>