<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择收货人</title>
<link href="${path }/js/snow-framework/css/pageTag.css" type="text/css"
	rel="stylesheet" media="screen" />
<style type="text/css">
.dataTable {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}

.dataTable th {
	height: 30px;
	border: 1px solid #bbb;
	background-color: #ccc;
}

.dataTable td {
	height: 30px;
	border: 1px solid #bbb;
	font-size: 12px;
}

.queryTable {
	width: 100%;
	border-collapse: collapse;
}

.queryTable td {
	height: 30px;
	border: 1px solid #bbb;
	font-size: 12px;
	padding-left: 5px;
}

.textR {
	text-align: right;
}

input {
	border: 1px solid #ccc;
	height: 20px;
}

a {
	text-decoration: none;
	color: green;
}
</style>
<script type="text/javascript">
	function ct(consignee, consigneeUnit, consigneePhone, consigneeAddress) {
		window.parent.c(consignee, consigneeUnit, consigneePhone,
				consigneeAddress);
	}
</script>
</head>
<body>
	<form id="myForm" action="${path}/consignment/alert/consignee.htm"
		method="post">
		<table class="queryTable">
			<tr>
				<td class="textR">收货人：</td>
				<td><input name="consignee" type="text" value="${consignee }"></td>
				<td><input type="image"
					src="${path }/images/shared/top_search_btn.gif"></td>
			</tr>
		</table>
	</form>
	<br>
	<table class="dataTable">
		<tr>
			<th>序号</th>
			<th>收货人</th>
			<th>收货单位</th>
			<th>电话</th>
			<th>地址</th>
			<th>选中</th>
		</tr>
		<c:forEach items="${page.results}" var="c" varStatus="in">
			<tr>
				<td>${in.index + 1 }</td>
				<td>${c.consignee }</td>
				<td>${c.consigneeUnit }</td>
				<td>${c.consigneePhone }</td>
				<td>${c.consigneeAddress }</td>
				<td><a
					onclick="ct('${c.consignee }','${c.consigneeUnit }','${c.consigneePhone }','${c.consigneeAddress }')"
					href="#">确认</a></td>
			</tr>
		</c:forEach>
	</table>
	<pageTag:pageTag pageEntity="${page }" formId="myForm" />
</body>
</html>