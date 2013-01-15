<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${path }css/screen.css" type="text/css"
	media="screen" title="default" />
<script src="${path }js/jquery/custom_jquery.js" type="text/javascript"></script>
<script src="${path }js/jquery/jquery.pngFix.pack.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).pngFix();
	});
</script>
</head>
<body id="login-bg">
	<div id="login-holder">
		<div id="logo-login">
			<a href="index.html"><img src="images/shared/logo.png"
				width="156" height="40" alt="" /></a>
		</div>
		<div class="clear"></div>
		<div id="loginbox">
			<div id="login-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Username</th>
						<td><input type="text" class="login-inp" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><input type="password" value="************"
							onfocus="this.value=''" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td valign="top"><input type="checkbox" class="checkbox-size"
							id="login-check" /><label for="login-check">Remember me</label></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
			<a href="" class="forgot-pwd">Forgot Password?</a>
		</div>
		<div id="forgotbox">
			<div id="forgotbox-text">Please send us your email and we'll
				reset your password.</div>
			<div id="forgot-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Email address:</th>
						<td><input type="text" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
			<a href="" class="back-login">Back to login</a>
		</div>
	</div>
</body>
</html>