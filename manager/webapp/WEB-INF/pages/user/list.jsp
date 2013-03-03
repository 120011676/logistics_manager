<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
	<div id="page-heading">
		<h1>用户管理</h1>
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
					<div style="height: 35px; line-height: 35px;"
						class="product-table green-left">
						<a href="${path }/user/toUpdate.htm"><b>新增</b></a>
					</div>
					<br>
					<form id="myForm" action="${path }/consignment/list.htm"
						method="post">
						<table border="0" width="100%" cellpadding="0" cellspacing="0"
							id="product-table">
							<tr style="color: white;">
								<th class="table-header-options line-left">序号</th>
								<th class="table-header-options line-left">账号</th>
								<th class="table-header-options line-left">姓名</th>
								<th class="table-header-options line-left">类型</th>
								<th class="table-header-options line-left">创建时间</th>
								<th class="table-header-options line-left">启用</th>
								<th class="table-header-options line-left">操作</th>
							</tr>
							<c:forEach items="${page.results }" var="c" varStatus="in">
								<tr <c:if test="${in.index % 2 !=0 }">class="bgEEE"</c:if>>
									<td>${in.index + 1 }</td>
									<td>${c.username }</td>
									<td>${c.name }</td>
									<td><c:if test="${c.position == true }">管理员</c:if><c:if test="${c.position == false }">普通用户</c:if></td>
									<td><fmt:formatDate value="${c.createDatetime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><c:if test="${c.enable == true }">启用</c:if> <c:if
											test="${c.enable == false }">停用</c:if></td>
									<td><div style="margin-left: 10px;">
											<a class="icon-1 info-tooltip" title="修改"
												href="${path }/user/toUpdate.htm?id=${c.id}"></a>
											<c:if test="${c.enable == true }">
												<a class="icon-2 info-tooltip" title="停用"
													href="${path }/user/delete.htm?id=${c.id}"></a>
											</c:if>
											<c:if test="${c.enable == false }">
												<a class="icon-5 info-tooltip" title="启用"
													style="margin: 0 8px 0 0;"
													href="${path }/user/recovery.htm?id=${c.id}"></a>
											</c:if>
											<a class="icon-3 info-tooltip" title="查看"
												href="${path }/user/look.htm?id=${c.id}"></a>
										</div></td>
								</tr>
							</c:forEach>
						</table>
						<pageTag:pageTag pageEntity="${page }" formId="myForm" />
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