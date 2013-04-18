<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.btn {
	border: 0px;
	border-bottom: 1px solid #bbb;
}

.btnRed {
	border: 0px;
	border-bottom: 1px solid red;
}

.dataTable {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}

.dataTable td {
	border: 1px solid #bbb;
	padding-left: 5px;
	height: 25px;
}

.dataTableAddTd td {
	border-top: 0px;
}

.dataTable p {
	padding-top: 1px;
	font-size: 8px;
}

body {
	line-height: normal;
}

.textLeft {
	text-align: left;
}
</style>
<script type="text/javascript"
	src="${path }/js/jquery/jquery.PrintArea.js"></script>
<script>
	$(document).ready(function() {
		$("#p").click(function() {
			$("div#print").printArea({ mode : "popup", popClose : false });
		});
	});
</script>
</head>
<body>
	<div align="center">
		<div align="center">
			<font size="5" style="font-weight: bold;">成都道成物流有限公司</font>&nbsp;<font
				size="2" style="font-weight: bold;">货物托运受理单</font>
		</div>
		<div id="print" style="width: 300px;">
			<div style="margin-top: 10px;">
				<table width="100%" style="margin-left: 30px;">
					<tr>
						<td><fmt:formatDate value="${consignment.datetime }"
								pattern="yyyy-MM-dd" /></td>
						<td>${consignment.startCity }</td>
						<td>${consignment.arrivalCity }</td>
						<td>${consignment.modeOfTransportation }</td>
						<td>${consignment.serviceMode }</td>
						<td>${consignment.payment }</td>
					</tr>
				</table>
			</div>
			<table class="dataTable" style="margin-top: 5px; text-align: left;">
				<tr>
					<td rowspan="4" align="center" valign="middle" width="50px"></td>
					<td width="400px">${consignment.shipper }</td>
					<td rowspan="4" align="center" valign="middle" width="50px"></td>
					<td>${consignment.consignee }</td>
				</tr>
				<tr>
					<td>${consignment.shipperUnit }</td>
					<td>${consignment.consigneeUnit }</td>
				</tr>
				<tr>
					<td>${consignment.shipperAddress }</td>
					<td>${consignment.consigneeAddress }</td>
				</tr>
				<tr>
					<td>${consignment.shipperPhone }</td>
					<td>${consignment.consigneePhone }</td>
				</tr>
			</table>
			<table class="dataTable">
				<tr class="dataTableAddTd">
					<td width="100px"></td>
					<td width="100px"></td>
					<td width="100px"></td>
					<td width="100px"></td>
					<td width="100px"></td>
					<td width="100px"></td>
					<td colspan="3" align="left" width="100px">
						${consignment.chargingWays }</td>
					<td align="left" width="200px"><fmt:formatNumber
							value="${consignment.unitPrice }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td>${consignment.commodityNameOne }</td>
					<td>${consignment.commodityPackageOne }</td>
					<td>${consignment.commodityPackageNumberOne }</td>
					<td><fmt:formatNumber
							value="${consignment.commodityWeightOne }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityVolumeOne }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityWorthOne }" pattern="0.00" /></td>
					<td></td>
					<td><fmt:formatNumber value="${consignment.transportPrice }"
							pattern="0.00" /></td>
					<td></td>
					<td class="textLeft"><fmt:formatNumber
							value="${consignment.loadUnloadPrice }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td>${consignment.commodityNameTwo }</td>
					<td>${consignment.commodityPackageTwo }</td>
					<td>${consignment.commodityPackageNumberTwo }</td>
					<td><fmt:formatNumber
							value="${consignment.commodityWeightTwo }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityVolumeTwo }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityWorthTwo }" pattern="0.00" /></td>
					<td></td>
					<td><fmt:formatNumber value="${consignment.takeCargoPrice }"
							pattern="0.00" /></td>
					<td></td>
					<td class="textLeft"><fmt:formatNumber
							value="${consignment.otherPrice }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td>${consignment.commodityNameThree }</td>
					<td>${consignment.commodityPackageThree }</td>
					<td>${consignment.commodityPackageNumberThree }</td>
					<td><fmt:formatNumber
							value="${consignment.commodityWeightThree }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityVolumeThree }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityWorthThree }" pattern="0.00" /></td>
					<td></td>
					<td><fmt:formatNumber value="${consignment.carryCargoPrice }"
							pattern="0.00" /></td>
					<td></td>
					<td class="textLeft"><fmt:formatNumber
							value="${consignment.collectionMoney }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td>${consignment.commodityNameFour }</td>
					<td>${consignment.commodityPackageFour }</td>
					<td>${consignment.commodityPackageNumberFour }</td>
					<td><fmt:formatNumber
							value="${consignment.commodityWeightFour }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityVolumeFour }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityWorthFour }" pattern="0.00" /></td>
					<td></td>
					<td><fmt:formatNumber value="${consignment.insurancePrice }"
							pattern="0.00" /></td>
					<td></td>
					<td class="textLeft"><fmt:formatNumber
							value="${consignment.collectionMoneyCharge }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td>${consignment.commodityNameFive }</td>
					<td>${consignment.commodityPackageFive }</td>
					<td>${consignment.commodityPackageNumberFive }</td>
					<td><fmt:formatNumber
							value="${consignment.commodityWeightFive }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityVolumeFive }" pattern="0.00" /></td>
					<td><fmt:formatNumber
							value="${consignment.commodityWorthFive }" pattern="0.00" /></td>
					<td></td>
					<td><fmt:formatNumber value="${consignment.packPrice }"
							pattern="0.00" /></td>
					<td></td>
					<td class="textLeft"><fmt:formatNumber
							value="${consignment.returnPrice }" pattern="0.00" /></td>
				</tr>
				<tr>
					<td colspan="6" align="left"><span id="sc">${capital }</span></td>
					<td colspan="4" align="left"><span id="total">${total }</span></td>
				</tr>
			</table>
		</div>
		<br>
		<div align="center">
			<a id="p" href="#">打印</a>
		</div>
	</div>
</body>
</html>