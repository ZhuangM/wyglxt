function check() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;

	if (username.length == 0) {
		window.alert("账号不能为空.");
		return false;
	}
	if (password.length == 0) {
		window.alert("密码不能为空.");
		return false;
	}
	
	return true;
}
