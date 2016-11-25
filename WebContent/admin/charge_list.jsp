<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="css/admin_charge_list.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/admin_charge_list.js"></script>
</head>
<body style="background-color: #F3F6FA;">
	<div class="top">
		<span>选择年月：</span> <select id="year" name="year">
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
		</select><label>月</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>楼号：</span><input
			type="text" id="houseNo" style="width: 50px;"><span
			class="example">如：1#1-101</span>&nbsp;&nbsp;<input type="button"
			id="find" value="查看">
	</div>
	<hr>
	<table class="table_center">
		<tr
			style="background-color: #CBD8AC; border-bottom: 1px solid black; height: 25px;">
			<td>ID</td>
			<td>房号</td>
			<td>月份</td>
			<td>水费</td>
			<td>电费</td>
			<td>燃气费</td>
			<td>物业费</td>
			<td>总计</td>
			<td>是否已缴费</td>
			<td>收费人</td>
		</tr>
		<tr height="25px">
			<td id="11"></td>
			<td id="12"></td>
			<td id="13"></td>
			<td id="14"></td>
			<td id="15"></td>
			<td id="16"></td>
			<td id="17"></td>
			<td id="18"></td>
			<td id="19"></td>
			<td id="10"></td>
		</tr>
		<tr height="25px">
			<td id="21"></td>
			<td id="22"></td>
			<td id="23"></td>
			<td id="24"></td>
			<td id="25"></td>
			<td id="26"></td>
			<td id="27"></td>
			<td id="28"></td>
			<td id="29"></td>
			<td id="20"></td>
		</tr>
		<tr height="25px">
			<td id="31"></td>
			<td id="32"></td>
			<td id="33"></td>
			<td id="34"></td>
			<td id="35"></td>
			<td id="36"></td>
			<td id="37"></td>
			<td id="38"></td>
			<td id="39"></td>
			<td id="30"></td>
		</tr>
		<tr height="25px">
			<td id="41"></td>
			<td id="42"></td>
			<td id="43"></td>
			<td id="44"></td>
			<td id="45"></td>
			<td id="46"></td>
			<td id="47"></td>
			<td id="48"></td>
			<td id="49"></td>
			<td id="40"></td>
		</tr>
		<tr height="25px">
			<td id="51"></td>
			<td id="52"></td>
			<td id="53"></td>
			<td id="54"></td>
			<td id="55"></td>
			<td id="56"></td>
			<td id="57"></td>
			<td id="58"></td>
			<td id="59"></td>
			<td id="50"></td>
		</tr>
		<tr height="25px">
			<td id="61"></td>
			<td id="62"></td>
			<td id="63"></td>
			<td id="64"></td>
			<td id="65"></td>
			<td id="66"></td>
			<td id="67"></td>
			<td id="68"></td>
			<td id="69"></td>
			<td id="60"></td>
		</tr>
		<tr height="25px">
			<td id="71"></td>
			<td id="72"></td>
			<td id="73"></td>
			<td id="74"></td>
			<td id="75"></td>
			<td id="76"></td>
			<td id="77"></td>
			<td id="78"></td>
			<td id="79"></td>
			<td id="70"></td>
		</tr>
		<tr height="25px">
			<td id="81"></td>
			<td id="82"></td>
			<td id="83"></td>
			<td id="84"></td>
			<td id="85"></td>
			<td id="86"></td>
			<td id="87"></td>
			<td id="88"></td>
			<td id="89"></td>
			<td id="80"></td>
		</tr>
		<tr height="25px">
			<td id="91"></td>
			<td id="92"></td>
			<td id="93"></td>
			<td id="94"></td>
			<td id="95"></td>
			<td id="96"></td>
			<td id="97"></td>
			<td id="98"></td>
			<td id="99"></td>
			<td id="90"></td>
		</tr>
		<tr height="25px">
			<td id="101"></td>
			<td id="102"></td>
			<td id="103"></td>
			<td id="104"></td>
			<td id="105"></td>
			<td id="106"></td>
			<td id="107"></td>
			<td id="108"></td>
			<td id="109"></td>
			<td id="100"></td>
		</tr>
		<tr height="25px">
			<td id="111"></td>
			<td id="112"></td>
			<td id="113"></td>
			<td id="114"></td>
			<td id="115"></td>
			<td id="116"></td>
			<td id="117"></td>
			<td id="118"></td>
			<td id="119"></td>
			<td id="110"></td>
		</tr>
		<tr height="25px">
			<td id="121"></td>
			<td id="122"></td>
			<td id="123"></td>
			<td id="124"></td>
			<td id="125"></td>
			<td id="126"></td>
			<td id="127"></td>
			<td id="128"></td>
			<td id="129"></td>
			<td id="120"></td>
		</tr>
		<tr height="25px">
			<td id="131"></td>
			<td id="132"></td>
			<td id="133"></td>
			<td id="134"></td>
			<td id="135"></td>
			<td id="136"></td>
			<td id="137"></td>
			<td id="138"></td>
			<td id="139"></td>
			<td id="130"></td>
		</tr>
		<tr height="25px">
			<td id="141"></td>
			<td id="142"></td>
			<td id="143"></td>
			<td id="144"></td>
			<td id="145"></td>
			<td id="146"></td>
			<td id="147"></td>
			<td id="148"></td>
			<td id="149"></td>
			<td id="140"></td>
		</tr>
		<tr height="25px">
			<td id="151"></td>
			<td id="152"></td>
			<td id="153"></td>
			<td id="154"></td>
			<td id="155"></td>
			<td id="156"></td>
			<td id="157"></td>
			<td id="158"></td>
			<td id="159"></td>
			<td id="150"></td>
		</tr>
		<tr height="25px">
			<td id="161"></td>
			<td id="162"></td>
			<td id="163"></td>
			<td id="164"></td>
			<td id="165"></td>
			<td id="166"></td>
			<td id="167"></td>
			<td id="168"></td>
			<td id="169"></td>
			<td id="160"></td>
		</tr>
		<tr height="25px">
			<td id="171"></td>
			<td id="172"></td>
			<td id="173"></td>
			<td id="174"></td>
			<td id="175"></td>
			<td id="176"></td>
			<td id="177"></td>
			<td id="178"></td>
			<td id="179"></td>
			<td id="170"></td>
		</tr>
	</table>
	<table class="table_down">
		<tr>
			<td><input type="button" id="first" value="首页"
				style="width: 100%;"></td>
			<td><input type="button" id="pre" value="上一页"
				style="width: 100%"></td>
			<td>第<span id="currentPageNum"></span>页
			</td>
			<td><input type="button" id="next" value="下一页"
				style="width: 100%"></td>
			<td><input type="button" id="last" value="末页"
				style="width: 100%"></td>
		</tr>
	</table>
</body>
</html>