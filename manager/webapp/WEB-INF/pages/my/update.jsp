<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.formTable {
	width: 100%;
}

.formTable td {
	height: 30px;
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
	}
	
	function mySubmit() {
		if (!checkNull(get("name_s"))) {
			alert("<font color=\"red\">姓名不能为空！</font>");
		} else {
			$("#myForm").submit();
		}
	}
</script>
</head>
<body>
	<div id="page-heading">
		<h1>我的信息</h1>
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
					<form id="myForm" action="${path }/my/update.htm" method="post">
						<input name="id" type="hidden" value="${user.id}">
						<table class="formTable">
							<tr>
								<td width="50%" class="title">帐号:</td>
								<td>${user.username }</td>
							</tr>
							<tr>
								<td class="title">姓名:</td>
								<td><input name="name" id="name_s" type="text"
									class="inp-form" onchange="checkNull(this)"
									value="${user.name }"></td>
							</tr>
							<tr>
								<td class="title">创建时间:</td>
								<td><fmt:formatDate value="${user.createDatetime }"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
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