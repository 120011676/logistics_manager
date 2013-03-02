<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>受理单管理</title>
</head>
<body>
	<div id="page-heading">
		<h1>受理单管理</h1>
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
						<a href="${path }/consignment/toUpdate.htm"><b>新增</b></a>
					</div>
					<br>
					<form id="myForm" action="${path }/consignment/list.htm"
						method="post">
						<table border="0" width="100%" cellpadding="0" cellspacing="0"
							id="product-table">
							<tr style="color: white;">
								<th class="table-header-repeat line-left"><a href="#">序号</a></th>
								<th class="table-header-repeat line-left"><a href="#">订单时间</a></th>
								<th class="table-header-repeat line-left"><a href="#">发货人</a></th>
								<th class="table-header-repeat line-left"><a href="#">发货人电话</a></th>
								<th class="table-header-repeat line-left"><a href="#">收货人</a></th>
								<th class="table-header-repeat line-left"><a href="#">收货人电话</a></th>
								<th class="table-header-options line-left"><a href="#">创建人</a></th>
								<th class="table-header-options line-left"><a href="#">创建时间</a></th>
								<th class="table-header-options line-left"><a href="#">操作</a></th>
							</tr>
							<c:forEach items="${page.results }" var="c" varStatus="in">
								<tr>
									<td>${in.index + 1 }</td>
									<td><fmt:formatDate value="${c.datetime }"
											pattern="yyyy-MM-dd" /></td>
									<td>${c.shipper }</td>
									<td>${c.shipperPhone }</td>
									<td>${c.consignee }</td>
									<td>${c.consigneePhone }</td>
									<td>${c.createUser.name }</td>
									<td><fmt:formatDate value="${c.createDatetime }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><a class="icon-1 info-tooltip"
										href="${path }/consignment/toUpdate.htm?id=${c.id}"></a> <c:if
											test="${c.enable == true }">
											<a class="icon-2 info-tooltip"
												href="${path }/consignment/delete.htm?id=${c.id}"></a>
										</c:if> <c:if test="${c.enable == false }">
											<a class="icon-5 info-tooltip"
												href="${path }/consignment/recovery.htm?id=${c.id}"></a>
										</c:if> <a class="icon-3 info-tooltip" href=""></a></td>
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