<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		proc();
	});

	function proc() {
		var submit = $("#submit");
		submit.bind("click", function() {
			var title = $("#title").val();
			var content = $("#content").val();
			if (title.length <= 0 || content.length <= 0) {
				alert("公告不能为空");
				return;
			}
			$.ajax({
				type : "post",
				url : "announce_create",
				data : {
					"announce.title" : title,
					"announce.content" : content
				},
				dataType : "json",
				success : function(resp) {
					// alert(resp);
					var obj = eval("(" + resp + ")");
					if (obj.respCode == '00') {
						alert("发布成功");
						clear();
					} else {
						alert("发布失败");
					}
				},
				error : function() {
					alert("服务器异常");
				}
			});
		});
	}

	function clear() {
		$("#title").val('');
		$("#content").val('');
	}
</script>
</head>
<body style="background-color: #F3F6FA;">
	<center>
		<form>
			<div>
				<span style="font-weight: bold; font-size: 20px;">标题：</span> <input
					type="text" id="title" style="width: 400px;">
			</div>
			<br>
			<div>
				<textarea rows="10" cols="70" id="content"></textarea>
			</div>
			<hr>
			<div>
				<input type="button" value="发布公告" id="submit"> <input
					type="reset" value="重置公告">
			</div>
		</form>
	</center>
</body>
</html>