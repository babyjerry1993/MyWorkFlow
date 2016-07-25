<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Activiti测试系统登录页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script>
<link href="<%=request.getContextPath()%>/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="login" style="margin-top: 200px;">
		<div class="header">
			<h1>
				登录<sup>V2016</sup>
			</h1>
		</div>
		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">
			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<form action="<%=request.getContextPath()%>/login.do" name="loginform" accept-charset="utf-8"
							id="login_form" class="loginForm" method="post">
							<div id="loginError" align="center" class="warning alert alert-warning" role="alert">
								<span class="glyphicon glyphicon-warning-sign"></span>
								用户名密码不正确，请重新输入!
							</div>
								<div class="uinArea" id="uinArea">
									<label class="input-tips" for="u">帐号：</label>
									<div class="inputOuter" id="uArea">
										<input type="text" style="color: #AAA" name="username" class="inputstyle"placeholder="Username" /> 
										<span class="glyphicon glyphicon-user"></span>
									</div>
								</div>
								<div class="pwdArea" id="pwdArea">
									<label class="input-tips" for="p">密码：</label>
									<div class="inputOuter" id="pArea">
										<input type="password" style="color: #AAA" name="userpassword" class="inputstyle" placeholder="Password" /> 
										<span class="glyphicon glyphicon-lock"></span>
									</div>
								</div>
								<div style="padding-left: 50px; margin-top: 20px;">
									<input type="submit" value="登 录" style="width: 150px;"class="button_blue" />
								</div>
						</form>
					</div>
				</div>
			</div>
			<!--登录end-->
		</div>
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>
<script type="text/javascript">
	var flag = "${errMsg}";
	$(document).ready(function() {
		if (flag != '') {
			$("#loginError").fadeIn(3000);
		} else {
			$("#loginError").hide();
		}
	});
</script>
</html>