<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增货物托运受理单</title>
<style type="text/css">
.btn {
	border: 0px;
	border-bottom: 1px solid #bbb;
}

.dataTable {
	width: 100%;
	border-collapse: collapse;
}

.dataTable td {
	border: 1px solid #bbb;
	padding-left: 5px;
	height: 25px;
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
					<div class="data">
						<div align="center">
							<font size="5" style="font-weight: bold;">成都道成物流有限公司</font>&nbsp;<font
								size="2" style="font-weight: bold;">货物托运受理单</font>
						</div>
						<div style="margin-top: 10px;">
							<span style="margin-left: 30px;"><input name=""
								type="text" class="btn" style="width: 30px;">&nbsp;年&nbsp;<input
								name="" type="text" class="btn" style="width: 15px;">&nbsp;月&nbsp;<input
								name="" type="text" class="btn" style="width: 15px;">&nbsp;日</span>
							<span style="margin-left: 50px;">发站：<input name=""
								type="text" class="btn" style="width: 100px;"></span> <span
								style="margin-left: 50px;">到站：<input name="" type="text"
								class="btn" style="width: 100px;"></span> <span
								style="margin-left: 50px;">运输方式：<input name=""
								type="text" class="btn" style="width: 100px;"></span> <span
								style="margin-left: 50px;">服务方式：<input name=""
								type="text" class="btn" style="width: 100px;"></span> <span
								style="margin-left: 50px;">付款方式：<input name=""
								type="text" class="btn" style="width: 100px;"></span>
						</div>
						<table height="300px;" class="dataTable" style="margin-top: 5px;">
							<tr>
								<td rowspan="4" align="center" valign="middle"><span>发</span><br>
									<br> <span>货</span><br> <br> <span>人</span></td>
								<td><span>托运人：</span><input name="" type="text" class="btn"
									style="width: 100px;"></td>
								<td rowspan="4" align="center" valign="middle"><span>收</span><br>
									<br> <span>货</span><br> <br> <span>人</span></td>
								<td>收货人：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
							</tr>
							<tr>
								<td>托运单位：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
								<td>收货单位：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
							</tr>
							<tr>
								<td>地址：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
								<td>地址：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
							</tr>
							<tr>
								<td>电话：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
								<td>电话：<input name="" type="text" class="btn"
									style="width: 100px;"></td>
							</tr>
						</table>
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