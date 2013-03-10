<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增货物托运受理单</title>
<script type="text/javascript"
	src="${path }/js/My97DatePicker/WdatePicker.js"></script>
<link type="text/css" rel="sheetsytle"
	href="${path }/js/My97DatePicker/skin/WdatePicker.css">
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
<script type="text/javascript">
	function DX(n) {
		if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
			return "数据非法";
		var unit = "千百拾亿千百拾万千百拾元角分", str = "";
		n += "00";
		var p = n.indexOf('.');
		if (p >= 0)
			n = n.substring(0, p) + n.substr(p + 1, 2);
		unit = unit.substr(unit.length - n.length);
		for ( var i = 0; i < n.length; i++)
			str += '零壹贰叁肆伍陆柒捌玖'.charAt(n.charAt(i)) + unit.charAt(i);
		return str.replace(/零(千|百|拾|角)/g, "零").replace(/(零)+/g, "零").replace(
				/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(
				/^元零?|零分/g, "").replace(/元$/g, "元整");
	}

	$(function() {
		$("#sc").html(DX($("#total").html()));
	});

	function isNull(obj) {
		if (obj.value == "") {
			obj.setAttribute("class", "btnRed");
		} else {
			obj.setAttribute("class", "btn");
		}
	}

	function getByName(name) {
		var o = $("input[name='" + name + "']");
		var v = o.val();
		if (v == "") {
			o.attr("class", "btnRed");
		} else {
			o.attr("class", "btn");
		}
		return v;
	}

	function mySubmit() {
		var msg = "";
		if (getByName("signShipper").length <= 0) {
			msg += "【托运人（签字）姓名】不能为空！<br>";
		}
		if (getByName("signCarrier").length <= 0) {
			msg += "【承运人（签字）姓名】不能为空！<br>";
		}
		if (getByName("signConsignee").length <= 0) {
			msg += "【收货人（签字）姓名】不能为空！<br>";
		}
		if (getByName("signDatetime").length <= 0) {
			msg += "【收获日期】不能为空！<br>";
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
		<h1>查看货物托运受理单</h1>
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
					<input name="id" type="hidden" value="${consignment.id }">
					<div class="data">
						<div align="center">
							<font size="5" style="font-weight: bold;">成都道成物流有限公司</font>&nbsp;<font
								size="2" style="font-weight: bold;">货物托运受理单</font>
						</div>
						<div style="margin-top: 10px;">
							<table width="100%" style="margin-left: 30px;">
								<tr>
									<td>日期：<fmt:formatDate value="${consignment.datetime }"
											pattern="yyyy-MM-dd" /></td>
									<td>发站：${consignment.startCity }</td>
									<td>到站：${consignment.arrivalCity }</td>
									<td>运输方式：${consignment.modeOfTransportation }</td>
									<td>服务方式：${consignment.serviceMode }</td>
									<td>付款方式：${consignment.payment }</td>
								</tr>
							</table>
						</div>
						<table class="dataTable"
							style="margin-top: 5px; text-align: left;">
							<tr>
								<td rowspan="4" align="center" valign="middle" width="30px"><span>发</span><br>
									<br> <span>货</span><br> <br> <span>人</span></td>
								<td><span>托&nbsp;&nbsp;运&nbsp;&nbsp;人：</span>${consignment.shipper
									}</td>
								<td rowspan="4" align="center" valign="middle" width="30px"><span>收</span><br>
									<br> <span>货</span><br> <br> <span>人</span></td>
								<td>收&nbsp;&nbsp;货&nbsp;&nbsp;人：${consignment.consignee }</td>
							</tr>
							<tr>
								<td>托运单位：${consignment.shipperUnit }</td>
								<td>收货单位：${consignment.consigneeUnit }</td>
							</tr>
							<tr>
								<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：${consignment.shipperAddress
									}</td>
								<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：${consignment.consigneeAddress
									}</td>
							</tr>
							<tr>
								<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：${consignment.shipperPhone
									}</td>
								<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：${consignment.consigneePhone
									}</td>
							</tr>
						</table>
						<table class="dataTable">
							<tr class="dataTableAddTd">
								<td>品名</td>
								<td>包装</td>
								<td>件数</td>
								<td>重量（kg）</td>
								<td>体积（m³）</td>
								<td>声明价值（元）</td>
								<td colspan="3" align="left" width="50px">计费方式： <c:if
										test="${consignment.chargingWays == '1'}">重量和</c:if> <c:if
										test="${consignment.chargingWays == '2'}">体积和</c:if>
								</td>
								<td align="left" width="200px">单价：<fmt:formatNumber
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
								<td>运费</td>
								<td><fmt:formatNumber
										value="${consignment.transportPrice }" pattern="0.00" /></td>
								<td>装卸费</td>
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
								<td>取货费</td>
								<td><fmt:formatNumber
										value="${consignment.takeCargoPrice }" pattern="0.00" /></td>
								<td>其他费</td>
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
								<td>送货费</td>
								<td><fmt:formatNumber
										value="${consignment.carryCargoPrice }" pattern="0.00" /></td>
								<td>代收费</td>
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
								<td>保险费</td>
								<td><fmt:formatNumber
										value="${consignment.insurancePrice }" pattern="0.00" /></td>
								<td>代收款<br> 手续费
								</td>
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
								<td>包装费</td>
								<td><fmt:formatNumber value="${consignment.packPrice }"
										pattern="0.00" /></td>
								<td>返&nbsp;&nbsp;&nbsp;&nbsp;单<br> 手续费
								</td>
								<td class="textLeft"><fmt:formatNumber
										value="${consignment.returnPrice }" pattern="0.00" /></td>
							</tr>
							<tr>
								<td colspan="6" align="left">费用总计：<span id="sc"></span></td>
								<td colspan="4" align="left">￥<span id="total"><fmt:formatNumber
											value="${total }" pattern="0.00" /></span>元
								</td>
							</tr>
						</table>
						<form id="myForm" action="${path }/take/updateTake.htm"
							method="post">
							<input name="id" type="hidden" value="${consignment.id }">
							<table class="dataTable">
								<tr class="dataTableAddTd">
									<td rowspan="4"><span>约</span><br> <br> <span>定</span><br>
										<br> <span>条</span><br> <br> <span>款</span></td>
									<td rowspan="4" align="left" width="900px"
										style="padding-top: 5px; padding-bottom: 5px;"><p>
											<font style="font-weight: bold;">重要提示：</font>请托运人仔细阅读以下条款，签字则视为同意以下条款！
										</p>
										<p style="text-indent: 2em;">一、托运人提供的包裹应当符合运输安全的要求，严禁托运或夹带易燃、易爆、有毒放射腐蚀等危险品，不得夹带现金、增值税发票、汇票、空白支票等有价证劵，严禁托运国家禁止运输的其他物品。</p>
										<p style="text-indent: 2em;">二、运输责任自承运人接收货物后开始至收货人接收货物后结束，收货人接收货物时，应当场验收，发现问题，应该及时声明和同承运人检查损失。</p>
										<p style="text-indent: 2em;">三、办理保险的货物，在运输途中发生损失，按实际损失赔偿，但最高不超过声明价格，未办理保险货物，在运输途中发生损失、丢失，按五元每公斤赔付，赔付金额最高不超过十元每公斤。</p>
										<p style="text-indent: 2em;">四、收货人为单位的，凭单位证明和领导人身份证领取货物；收货人为个人的，凭收货人身份证，代领时凭身份证复印件，领货人省份证领取货物。</p>
										<p style="text-indent: 2em;">五、免责条款：</p>
										<p style="text-indent: 4em;">1、本公司对托运人所托运物品的收益、利润、实际用途或在市场上任何直接或间接损失、特殊商业价值损失，承运人不承担任何责任。</p>
										<p style="text-indent: 4em;">2、对因托运人原因，包括但不限于对所有物品做了不正确的说明，或者没有充分、恰当的包裹、捆绑，或没有提供或记载收货人以后小地址及联系方式，或有意无意使托运物品包含恩了本公司拒绝承运的物品而产生的后果，承运人概不负责。</p>
										<p style="text-indent: 4em;">3、对因托运货物的自然属性，内在质量瑕疵或缺陷，合理损耗而造成的损失，承运人概不负责。</p>
										<p style="text-indent: 4em;">4、对因地震、台风、洪水、战争、动乱等人力不可抗拒的因素或政府例行检查导致的货物延误、损坏、短缺、丢失等，承运人概不负责。</p>
										<p style="text-indent: 4em;">5、外包装完好而内件短缺或损坏，承运人概不负责。</p>
										<p>
											<font style="font-weight: bold;">客服电话： 028-65668758
												13438206949 13982160265</font>
										</p></td>
									<td align="left">托运人（签字）姓名：<input name="signShipper"
										onchange="isNull(this)" type="text" class="btn"
										style="width: 70px;" maxlength="4" value="${consignment.signShipper }"></td>
								</tr>
								<tr>
									<td align="left">承运人（签字）姓名：<input name="signCarrier"
										onchange="isNull(this)" type="text" class="btn"
										style="width: 70px;" maxlength="4" value="${consignment.signCarrier }"></td>
								</tr>
								<tr>
									<td align="left">收货人（签字）姓名：<input name="signConsignee"
										onchange="isNull(this)" type="text" class="btn"
										style="width: 70px;" maxlength="4" value="${consignment.signConsignee }"></td>
								</tr>
								<tr>
									<td align="left">收&nbsp;获&nbsp;日&nbsp;期：<input
										name="signDatetime" onchange="isNull(this)" type="text"
										onclick="WdatePicker()" class="btn" readonly="readonly"
										style="width: 70px;" value='<fmt:formatDate value="${consignment.signDatetime }" pattern="yyyy-MM-dd"/>'></td>
								</tr>
							</table>
							<center>
								<div style="margin-top: 15px;">
									<input class="form-submit" onclick="mySubmit()"
										style="margin-left: 45%;" type="button" value="">
								</div>
							</center>
						</form>
					</div>
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