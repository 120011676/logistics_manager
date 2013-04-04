<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择托运人</title>
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
</style>
<script type="text/javascript">
	function st(shipper, shipperUnit, shipperPhone, shipperAddress) {
		window.parent.sd(shipper, shipperUnit, shipperPhone, shipperAddress);
	}
</script>
</head>
<body>
	<form id="myForm" action="${path}/consignment/alert/shipper.htm"
		method="post">
		<table class="queryTable">
			<tr>
				<td class="textR">托运人：</td>
				<td><input name="shipper" type="text" value="${shipper }"></td>
				<td><input type="image"
					src="${path }/images/shared/top_search_btn.gif"></td>
			</tr>
		</table>
	</form>
	<br>
	<table class="dataTable">
		<tr>
			<th>序号</th>
			<th>托运人</th>
			<th>托运单位</th>
			<th>电话</th>
			<th>地址</th>
			<th>选中</th>
		</tr>
		<c:forEach items="${page.results}" var="c" varStatus="in">
			<tr>
				<td>${in.index + 1 }</td>
				<td>${c.shipper }</td>
				<td>${c.shipperUnit }</td>
				<td>${c.shipperPhone }</td>
				<td>${c.shipperAddress }</td>
				<td><a
					onclick="st('${c.shipper }','${c.shipperUnit }','${c.shipperPhone }','${c.shipperAddress }')"
					href="#">确认</a></td>
			</tr>
		</c:forEach>
	</table>
	<pageTag:pageTag pageEntity="${page }" formId="myForm" />
</body>
</html>