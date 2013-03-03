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
<script src="${path }/js/fancyapps-fancyBox/jquery.fancybox.js"
	type="text/javascript"></script>
<link media="screen"
	href="${path }/js/fancyapps-fancyBox/jquery.fancybox.css"
	type="text/css" rel="stylesheet"></link>
<link
	href="${path }/js/fancyapps-fancyBox/helpers/jquery.fancybox-buttons.css"
	type="text/css" rel="stylesheet"></link>
<script
	src="${path }/js/fancyapps-fancyBox/helpers/jquery.fancybox-buttons.js"
	type="text/javascript"></script>
<link
	href="${path }/js/fancyapps-fancyBox/helpers/jquery.fancybox-thumbs.css"
	type="text/css" rel="stylesheet"></link>
<script
	src="${path }/js/fancyapps-fancyBox/helpers/jquery.fancybox-thumbs.js"
	type="text/javascript"></script>
<script
	src="${path }/js/fancyapps-fancyBox/helpers/jquery.fancybox-media.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${path }/js/snow-framework/snow.framework.js"></script>
<link type="text/css" rel="stylesheet"
	href="${path }/js/snow-framework/css/framework.css">
<link type="text/css" rel="stylesheet"
	href="${path }/js/snow-framework/css/pageTag.css">
<link type="text/css" rel="stylesheet" href="${path }/css/main.css">
<script type="text/javascript">
	function myUser() {
		var obj = $("#myUserMenu");
		if (obj.is(":visible")) {
			$("#myUserMenu").hide();
		} else {
			$("#myUserMenu").show();
		}
	}
</script>
<sitemesh:write property='head' />
</head>
<body>
	<input id="contextPath" type="hidden" value="${path }">
	<div id="page-top-outer">
		<div id="page-top">
			<div id="logo">
				<a href="${path }/"><img src="${path }/images/shared/logo.png"
					width="156" height="40" alt="" /></a>
			</div>
		</div>
	</div>
	<div class="nav-outer-repeat">
		<div class="nav-outer">
			<div id="nav-right">
				<div class="nav-divider">&nbsp;</div>
				<div class="showhide-account">
					<img title="我的信息"
						src="${path }/images/shared/nav/nav_myaccount.gif" width="93"
						height="14" alt="" onclick="myUser()" />
				</div>
				<div class="nav-divider">&nbsp;</div>
				<a title="退出" href="${path }/noSecurity/logout.htm" id="logout"><img
					src="${path }/images/shared/nav/nav_logout.gif" width="64"
					height="14" alt="" /></a>
				<div class="clear">&nbsp;</div>
				<div id="myUserMenu" class="account-content" style="display: none;">
					<div class="account-drop-inner">
						<a id="acc-settings"
							href="${path }/my/toUpdate.htm?id=${LOGIN_USER.id}">我的信息</a>
						<div class="clear"></div>
						<div class="acc-line">&nbsp;</div>
						<a id="acc-settings"
							href="${path }/my/toPassword.htm?id=${LOGIN_USER.id}">密码修改</a>
						<div class="clear"></div>
						<div class="acc-line">&nbsp;</div>
					</div>
				</div>
			</div>
			<div class="nav">
				<div class="table">
					<c:if test="${LOGIN_USER.position == true }">
						<ul
							class="<c:choose>
						<c:when test="${menu == 'user' }">current</c:when>
						<c:otherwise>select</c:otherwise>
					</c:choose>">
							<li><a href="${path }/user/list.htm"><b>用户管理</b></a></li>
						</ul>
					</c:if>
					<ul
						class="<c:choose>
						<c:when test="${menu == 'consignment' }">current</c:when>
						<c:otherwise>select</c:otherwise>
					</c:choose>">
						<li><a href="${path }/consignment/list.htm"><b>货物托运管理</b></a>
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
		<div id="content">
			<sitemesh:write property='body' />
		</div>
		<div class="clear">&nbsp;</div>
	</div>
	<div class="clear">&nbsp;</div>
	<div id="footer" style="margin-top: 0px;">
		<div id="footer-left">版权信息</div>
		<div class="clear">&nbsp;</div>
	</div>
</body>
</html>