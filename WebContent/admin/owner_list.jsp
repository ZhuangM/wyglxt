<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.wyglxt.entity.Owner"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>all owner</title>

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
			<td width="8%">ID</td>
			<td width="12%">姓名</td>
			<td width="15%">房号</td>
			<td width="18%">联系方式</td>
			<td width="10%">家庭人口</td>
			<td width="17%">入住时间</td>
			<td width="20%">操作</td>
		</tr>

		<s:iterator var="owner" value="#request.owners">
			<tr>
				<td><%=i++%></td>
				<td><s:property value="#owner.name" /></td>
				<td><s:property value="#owner.houseNo" /></td>
				<td><s:property value="#owner.tel" /></td>
				<td><s:property value="#owner.population" /></td>
				<td><s:date format="yyyy-MM-dd" name="#owner.enterDate" /></td>
				<td><a
					href="owner_load?currentPageNum=<%=currentPageNum%>&owner.id=<s:property value="#owner.id"/>">修改</a>|<a
					href="owner_delete?currentPageNum=<%=currentPageNum%>&owner.id=<s:property value="#owner.id"/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>

	<table
		style="text-align: center; width: 100%; height: 100%; background-color: silver; border-bottom: 1px solid black; border-left: 1px solid black; border-right: 1px solid black;">
		<tr style="background-color: #CBD8AC; border-top: 1px solid black;">
			<td><a href="owner_list?currentPageNum=1"><input
					type="button" value="首页" style="width: 100%;"></a></td>
			<td><a href="owner_list?currentPageNum=<%=lastPageNum%>"><input
					type="button" value="上一页" style="width: 100%;"></a></td>
			<td><span><%=currentPageNum%>/10页</span></td>
			<td><a href="owner_list?currentPageNum=<%=nextPageNum%>"><input
					type="button" value="下一页" style="width: 100%;"></a></td>
			<td><a href="owner_list?currentPageNum=10"><input
					type="button" value="尾页" style="width: 100%;"></a></td>
		</tr>
	</table>
</body>
</html>