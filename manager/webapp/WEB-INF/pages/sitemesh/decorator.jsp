<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/utils/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>物流后台管理系统-<sitemesh:write property='title' /></title>
<script type="text/javascript"
	src="${path }/js/jquery/jquery-1.8.3.min.js"></script>
<link rel="stylesheet" href="${path }/css/screen.css" type="text/css"
	media="screen" title="default" />
<sitemesh:write property='head' />
</head>
<body>
	<div id="page-top-outer">
		<div id="page-top">
			<div id="logo">
				<a href="/"><img src="${path }/images/shared/logo.png"
					width="156" height="40" alt="" /></a>
			</div>
		</div>
	</div>
	<div class="nav-outer-repeat">
		<div class="nav-outer">
			<div id="nav-right">
				<div class="nav-divider">&nbsp;</div>
				<div class="showhide-account">
					<img src="${path }/images/shared/nav/nav_myaccount.gif" width="93"
						height="14" alt="" />
				</div>
				<div class="nav-divider">&nbsp;</div>
				<a href="${path }/noSecurity/logout.htm" id="logout"><img
					src="${path }/images/shared/nav/nav_logout.gif" width="64"
					height="14" alt="" /></a>
				<div class="clear">&nbsp;</div>
			</div>
			<div class="nav">
				<div class="table">

					<ul
						class="<c:choose>
						<c:when test="${current == 'consignment' }">current</c:when>
						<c:otherwise>select</c:otherwise>
					</c:choose>">
						<li><a href="#nogo"><b>货物托运管理</b></a>

							<div
								class="select_sub<c:if test="${show == 'consignment_show' }"> show</c:if>">
								<ul class="sub">
									<li
										<c:if test="${subShow == 'consignment_show_acceptance' }"> class="sub_show"</c:if>><a
										href="${path }/consignment/list.htm">受理单管理</a></li>
								</ul>
							</div></li>
					</ul>
					<div class="nav-divider">&nbsp;</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div id="content-outer">
		<sitemesh:write property='body' />
		<div class="clear">&nbsp;</div>
	</div>
	<div class="clear">&nbsp;</div>
	<div id="footer">
		<div id="footer-left">版权信息</div>
		<div class="clear">&nbsp;</div>
	</div>
</body>
</html>