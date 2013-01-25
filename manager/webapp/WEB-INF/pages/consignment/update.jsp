<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
	<div id="page-heading">
		<h1>新增货物托运受理单</h1>
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
					<form action="${path }/consignment/update.htm" method="post">
						<div class="data">
							<div align="center">
								<font size="5" style="font-weight: bold;">成都道成物流有限公司</font>&nbsp;<font
									size="2" style="font-weight: bold;">货物托运受理单</font>
							</div>
							<div style="margin-top: 10px;">
								<span style="margin-left: 30px;">日期：<input
									name="datetime" onclick="WdatePicker()" type="text" class="btn"
									style="width: 70px;"></span> <span style="margin-left: 50px;">发站：<input
									name="startCity" type="text" class="btn" style="width: 100px;"></span>
								<span style="margin-left: 50px;">到站：<input name="arrivalCity"
									type="text" class="btn" style="width: 100px;"></span> <span
									style="margin-left: 50px;">运输方式：<input name="modeOfTransportation"
									type="text" class="btn" style="width: 100px;"></span> <span
									style="margin-left: 50px;">服务方式：<input name="serviceMode"
									type="text" class="btn" style="width: 100px;"></span> <span
									style="margin-left: 50px;">付款方式：<input name="payment"
									type="text" class="btn" style="width: 100px;"></span>
							</div>
							<table class="dataTable" style="margin-top: 5px;">
								<tr>
									<td rowspan="4" align="center" valign="middle" width="30px"><span>发</span><br>
										<br> <span>货</span><br> <br> <span>人</span></td>
									<td><span>托&nbsp;&nbsp;运&nbsp;&nbsp;人：</span><input
										name="consignor.personalName" type="text" class="btn" style="width: 480px;"></td>
									<td rowspan="4" align="center" valign="middle" width="30px"><span>收</span><br>
										<br> <span>货</span><br> <br> <span>人</span></td>
									<td>收&nbsp;&nbsp;货&nbsp;&nbsp;人：<input name="consignee.personalName" type="text"
										class="btn" style="width: 480px;"></td>
								</tr>
								<tr>
									<td>托运单位：<input name="consignor.companyName" type="text" class="btn"
										style="width: 480px;"></td>
									<td>收货单位：<input name="consignee.companyName" type="text" class="btn"
										style="width: 480px;"></td>
								</tr>
								<tr>
									<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<input
										name="consignor.address" type="text" class="btn" style="width: 480px;"></td>
									<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：<input
										name="consignee.address" type="text" class="btn" style="width: 480px;"></td>
								</tr>
								<tr>
									<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input
										name="consignor.phone" type="text" class="btn" style="width: 480px;"></td>
									<td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：<input
										name="consignee.phone" type="text" class="btn" style="width: 480px;"></td>
								</tr>
							</table>
							<table class="dataTable">
								<tr class="dataTableAddTd">
									<td>品名</td>
									<td>包装</td>
									<td>件数</td>
									<td>重量（KG）</td>
									<td>体积（m³）</td>
									<td>声明价值（元）</td>
									<td colspan="3" align="left" width="50px">计费方式：<input
										name="chargingWays" type="text" class="btn" style="width: 100px;"></td>
									<td align="left" width="200px">单价：<input name="unitPrice"
										type="text" class="btn" style="width: 100px;"></td>
								</tr>
								<tr>
									<td><input name="cargos[0].commodityName" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[0].pack" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[0].numberOfPackages" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[0].weight" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[0].volume" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[0].statementValue" type="text" class="btn"
										style="width: 100px;"></td>
									<td>运费</td>
									<td><input name="transportPrice" type="text" class="btn"
										style="width: 100px;"></td>
									<td>装卸费</td>
									<td><input name="loadUnloadPrice" type="text" class="btn"
										style="width: 100px;"></td>
								</tr>
								<tr>
									<td><input name="cargos[1].commodityName" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[1].pack" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[1].numberOfPackages" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[1].weight" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[1].volume" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[1].statementValue" type="text" class="btn"
										style="width: 100px;"></td>
									<td>取货费</td>
									<td><input name="takeCargoPrice" type="text" class="btn"
										style="width: 100px;"></td>
									<td>其他费</td>
									<td><input name="otherPrice" type="text" class="btn"
										style="width: 100px;"></td>
								</tr>
								<tr>
									<td><input name="cargos[2].commodityName" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[2].pack" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[2].numberOfPackages" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[2].weight" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[2].volume" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[2].statementValue" type="text" class="btn"
										style="width: 100px;"></td>
									<td>送货费</td>
									<td><input name="carryCargoPrice" type="text" class="btn"
										style="width: 100px;"></td>
									<td>代收费</td>
									<td><input name="collectionMoney" type="text" class="btn"
										style="width: 100px;"></td>
								</tr>
								<tr>
									<td><input name="cargos[3].commodityName" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[3].pack" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[3].numberOfPackages" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[3].weight" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[3].volume" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[3].statementValue" type="text" class="btn"
										style="width: 100px;"></td>
									<td>保险费</td>
									<td><input name="insurancePrice" type="text" class="btn"
										style="width: 100px;"></td>
									<td>代收款<br> 手续费
									</td>
									<td><input name="collectionMoneyCharge" type="text" class="btn"
										style="width: 100px;"></td>
								</tr>
								<tr>
									<td><input name="cargos[4].commodityName" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[4].pack" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[4].numberOfPackages" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[4].weight" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[4].volume" type="text" class="btn"
										style="width: 100px;"></td>
									<td><input name="cargos[4].statementValue" type="text" class="btn"
										style="width: 100px;"></td>
									<td>包装费</td>
									<td><input name="packPrice" type="text" class="btn"
										style="width: 100px;"></td>
									<td>返&nbsp;&nbsp;&nbsp;&nbsp;单<br> 手续费
									</td>
									<td><input name="returnPrice" type="text" class="btn"
										style="width: 100px;"></td>
								</tr>
								<tr>
									<td colspan="6" align="left">费用总计：</td>
									<td colspan="4" align="left">￥元</td>
								</tr>
							</table>
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
									<td align="left">托运人签字：</td>
								</tr>
								<tr>
									<td align="left">承运人签字：</td>
								</tr>
								<tr>
									<td align="left">收货人签字：</td>
								</tr>
								<tr>
									<td align="left">收&nbsp;获&nbsp;日&nbsp;期：</td>
								</tr>
							</table>
							<center>
								<div style="margin-top: 15px;">
									<input class="form-submit" style="margin-left: 45%;"
										type="submit" value="">
								</div>
							</center>
						</div>
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