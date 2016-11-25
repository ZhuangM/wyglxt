<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>all demos</title>

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
			<td width="10%">ID</td>
			<td width="15%">编码</td>
			<td width="15%">名称</td>
			<td width="10%">责任人</td>
			<td width="10%">原值</td>
			<td width="10%">启用日期</td>
			<td width="10%">年限</td>
			<td width="20%">操作</td>
		</tr>

		<s:iterator value="#request.demos" var="demo">
			<tr>
				<td><%=i++%></td>
				<td><s:property value="#demo.bianma" /></td>
				<td><s:property value="#demo.mingcheng" /></td>
				<td><s:property value="#demo.zerenren" /></td>
				<td><s:property value="#demo.yuanzhi" /></td>
				<td><s:property value="#demo.qiyong" /></td>
				<td><s:property value="#demo.nianxian" /></td>
				<td><a
					href="demo_load?currentPageNum=<%=currentPageNum%>&demo.id=<s:property value="#demo.id"/>">修改</a>|<a
					href="demo_delete?currentPageNum=<%=currentPageNum%>&demo.id=<s:property value="#demo.id"/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>

	<table
		style="text-align: center; width: 100%; height: 100%; background-color: silver; border-bottom: 1px solid black; border-left: 1px solid black; border-right: 1px solid black;">
		<tr style="background-color: #CBD8AC; border-top: 1px solid black;">
			<td><a href="demo_list?currentPageNum=1"><input
					type="button" value="首页" style="width: 100%;"></a></td>
			<td><a href="demo_list?currentPageNum=<%=lastPageNum%>"><input
					type="button" value="上一页" style="width: 100%;"></a></td>
			<td><span><%=currentPageNum%>/10页</span></td>
			<td><a href="demo_list?currentPageNum=<%=nextPageNum%>"><input
					type="button" value="下一页" style="width: 100%;"></a></td>
			<td><a href="demo_list?currentPageNum=10"><input
					type="button" value="尾页" style="width: 100%;"></a></td>
		</tr>
	</table>
</body>
</html>