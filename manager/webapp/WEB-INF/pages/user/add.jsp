<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理-新增用户</title>
<style type="text/css">
.formTable {
	width: 100%;
}

.formTable td {
	height: 40px;
	padding-left: 5px;
}

.title {
	text-align: right;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	function get(id) {
		return document.getElementById(id);
	}

	function checkNull(obj) {
		if ($.trim(obj.value) != "") {
			classBtn(obj);
			return true;
		} else {
			classBtnRed(obj);
			return false;
		}
	}

	function classBtn(obj) {
		obj.setAttribute("class", "inp-form");
	}

	function classBtnRed(obj) {
		obj.setAttribute("class", "inp-form-error");
	}

	function res() {
		$(":text").val("");
		$(":password").val("");
	}

	function otherCheck() {
		if ($("#password").val().length < 6
				|| $("#password").val() != $("#password1").val()) {
			classBtnRed(get("password"));
			classBtnRed(get("password1"));
		} else {
			classBtn(get("password"));
			classBtn(get("password1"));
		}
	}

	function mySubmit() {
		var msg = "";
		if (!checkNull(get("username"))) {
			msg += "账号不能为空！<br>";
		}
		if (!checkNull(get("name_s"))) {
			msg += "姓名不能为空！<br>";
		}
		if ($("#password").val().length < 6) {
			classBtnRed(get("password"));
			msg += "密码长度不能小于6位！<br>";
		}
		if ($("#password").val() != $("#password1").val()) {
			classBtnRed(get("password"));
			classBtnRed(get("password1"));
			msg += "两次密码不一致!<br>";
		}
		if (msg.length > 0) {
			alert("<font color=\"red\">" + msg + "</font>");
		} else {
			$.post("${path}/user/checkUsername.htm", {
				username : $("#username").val()
			}, function(data) {
				if ($.trim(data) == "true") {
					$("#myForm").submit();
				} else {
					alert("<font color=\"red\">账号已经存在！</font>");
				}
			});
		}
	}
</script>
</head>
<body>
	<div id="page-heading">
		<h1>新增用户</h1>
	</div>
	<table border="0" width="100%" cellpadding="0" cellspacing="0"
		id="content-table">
		<tr>
			<th rowspan="3" class="sized"><img
				src="${path }/images/shared/side_shadowleft.jpg" width="20"
				height="300" alt="" /></th>
			<th class="topleft"></th>
			<td id="tbl-border-top">&nbsp;</td>
			<th class="topright"></th>
			<th rowspan="3" class="sized"><img
				src="${path }/images/shared/side_shadowright.jpg" width="20"
				height="300" alt="" /></th>
		</tr>
		<tr>
			<td id="tbl-border-left"></td>
			<td valign="top">
				<div id="content-table-inner">
					<form id="myForm" action="${path }/user/update.htm" method="post">
						<input name="id" type="hidden" value="${user.id}">
						<table class="formTable">
							<tr>
								<td width="50%" class="title">帐号:</td>
								<td><input id="username" name="username"
									onchange="checkNull(this)" class="inp-form" type="text"
									value="${user.username }" maxlength="20"></td>
							</tr>
							<tr>
								<td class="title">姓名:</td>
								<td><input name="name" id="name_s" type="text"
									class="inp-form" onchange="checkNull(this)"
									value="${user.name }" maxlength="4"></td>
							</tr>
							<tr>
								<td class="title">类型:</td>
								<td><select name="position"
									style="width: 200px; height: 30px; border: 1px solid #bbb;">
										<option value="false">普通用户</option>
										<option value="true">管理员</option>
								</select></td>
							</tr>
							<tr>
								<td class="title">密码:</td>
								<td><input name="password" id="password" type="password"
									class="inp-form" onchange="otherCheck()" value=""
									maxlength="20"></td>
							</tr>
							<tr>
								<td class="title">确认密码:</td>
								<td><input id="password1" type="password" class="inp-form"
									onchange="otherCheck()" value="" maxlength="20"></td>
							</tr>
							<tr>
								<td></td>
								<td><input onclick="mySubmit()" type="button"
									class="form-submit" value=""> <input onclick="res()"
									type="button" class="form-reset" value=""></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
			<td id="tbl-border-right"></td>
		</tr>
		<tr>
			<th class="sized bottomleft"></th>
			<td id="tbl-border-bottom">&nbsp;</td>
			<th class="sized bottomright"></th>
		</tr>
	</table>
</body>
</html>