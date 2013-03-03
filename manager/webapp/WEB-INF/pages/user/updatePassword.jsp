<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理-重置密码</title>
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

	function checkPassword(obj) {
		if (obj.value.length >= 6) {
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

	function checkNull(obj) {
		if ($.trim(obj.value) != "") {
			classBtn(obj);
			return true;
		} else {
			classBtnRed(obj);
			return false;
		}
	}

	function otherCheck() {
		if ($("#newPassword").val() != $("#newPassword1").val()) {
			classBtnRed(get("newPassword"));
			classBtnRed(get("newPassword1"));
		} else {
			classBtn(get("newPassword"));
			classBtn(get("newPassword1"));
		}
	}
	
	function res() {
		$(":text").val("");
		$(":password").val("");
	}

	function mySubmit() {
		var msg = "";
		if ($("#newPassword").val().length < 6) {
			classBtnRed(get("newPassword"));
			msg += "新密码长度不能小于6位!<br>";
		}
		if ($("#newPassword").val() != $("#newPassword1").val()) {
			classBtnRed(get("newPassword"));
			classBtnRed(get("newPassword1"));
			msg += "两次密码不一致!<br>";
		}
		if (msg.length > 0) {
			alert("<div style=\"color:red;margin-left: 10px;\">" + msg
					+ "<br></div>");
		} else {
			$("#myForm").submit();
		}
	}
</script>
</head>
<body>
	<div id="page-heading">
		<h1>重置密码</h1>
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
					<c:if test="${messages != null }">
						<div id="message-red">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tbody>
									<tr>
										<td class="red-left">错误：${messages }</td>
									</tr>
								</tbody>
							</table>
						</div>
					</c:if>
					<form id="myForm" action="${path }/user/updatePassword.htm"
						method="post">
						<input name="id" type="hidden" value="${user.id}">
						<table class="formTable">
							<tr>
								<td width="50%" class="title">帐号:</td>
								<td>${user.username }</td>
							</tr>
							<tr>
								<td class="title">姓名:</td>
								<td>${user.name }</td>
							</tr>
							<tr>
								<td class="title">类型:</td>
								<td><c:if test="${user.position == false }">普通用户</c:if> <c:if
										test="${user.position == true }">管理员</c:if></td>
							</tr>
							<tr>
								<td class="title">创建时间:</td>
								<td><fmt:formatDate value="${user.createDatetime }"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<td class="title">新密码:</td>
								<td><input onchange="otherCheck()" id="newPassword"
									name="password" type="password" class="inp-form"
									maxlength="20"></td>
							</tr>
							<tr>
								<td class="title">确认新密码:</td>
								<td><input onchange="otherCheck()" id="newPassword1"
									type="password" class="inp-form" maxlength="20"></td>
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