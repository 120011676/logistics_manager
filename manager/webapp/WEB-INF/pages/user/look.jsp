<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理-查看用户信息</title>
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
</head>
<body>
	<div id="page-heading">
		<h1>查看用户信息</h1>
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
							<td class="title">创建时间</td>
							<td><fmt:formatDate value="${user.createDatetime }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</table>
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