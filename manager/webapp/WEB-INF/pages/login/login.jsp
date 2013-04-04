<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="${path }/css/screen.css" type="text/css"
	media="screen" title="default" />
<script src="${path }/js/jquery/custom_jquery.js" type="text/javascript"></script>
<script src="${path }/js/jquery/jquery.pngFix.pack.js"
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
			<a href="${path }/"><img src="${path }/images/shared/logo.png"
				width="156" height="40" alt="" /></a>
		</div>
		<div class="clear"></div>
		<div id="loginbox">
			<div id="login-inner">
				<form action="${path }/noSecurity/toLogin.htm" method="post">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>用户名：</th>
							<td><input name="username" type="text" class="login-inp" /></td>
						</tr>
						<tr>
							<th>密&nbsp;&nbsp;&nbsp;码：</th>
							<td><input name="password" type="password" class="login-inp" /></td>
						</tr>
						<tr>
							<th></th>
							<td valign="top"><input name="me" type="checkbox" checked="checked"
								class="checkbox-size" id="login-check" /><label
								for="login-check">记住我</label></td>
						</tr>
						<tr>
							<th></th>
							<td><input type="submit" class="submit-login" value="登录" /></td>
						</tr>
					</table>
				</form>
			</div>
			<div class="clear"></div>
			<a href="" class="forgot-pwd">Forgot Password?</a>
		</div>
	</div>
</body>
</html>