function getTopWindow() {
	if (parent) {
		var tempParent = parent;
		while (true) {
			if (tempParent.parent) {
				if (tempParent.parent == tempParent) {
					break;
				}
				tempParent = tempParent.parent;
			} else {
				break;
			}
		}
		return tempParent;
	} else {
		return window;
	}
}

function pageTurning(formId,nowPage,selectId){
	$("#" + formId).append('<input type="hidden" id="_nowPage" name="nowPage" value="" /><input type="hidden" id="_maxNum" name="onePageRows" value="" />');
	thisNowPage = nowPage;
	thisMaxNum = $("#" + selectId).val();
	$("#_nowPage").val(nowPage);
	$("#_maxNum").val($("#" + selectId).val());
	$("#" + formId).submit();
}

function topHref(url) {
	window.top.location = url;
}

function openHref(url){
	window.open(url);
}

function rightHref(url) {
	top.right.location.href = url;
}

var contextPath = "";

var _prompt = contextPath + "/js/snow-framework/images/Prompt.png";
var _boy = contextPath + "/js/snow-framework/images/boy.png";
var _card = contextPath + "/js/snow-framework/images/card.png";
var _error = contextPath + "/js/snow-framework/images/error.png";
var _ever = contextPath + "/js/snow-framework/images/ever.png";
var _gril = contextPath + "/js/snow-framework/images/gril.png";
var _right = contextPath + "/js/snow-framework/images/right.png";
var _search = contextPath + "/js/snow-framework/images/search.png";
var _search2 = contextPath + "/js/snow-framework/images/search2.png";
var _loading = contextPath + "/js/snow-framework/images/loading.gif";

function getContextPath() {
	return $("#contextPath").val();
}

showDIV = function(width, height, title, title_image, image_url, message,
		button_message) {
	$
			.fancybox(
					'<div style="width:'
							+ width
							+ ';height:'
							+ height
							+ ';overflow:auto;background-color:#fff;padding: 10px 10px 10px 10px;">'
							+ '<table width="100%" height="100%">'
							+ '<tr valign="middle" height="20px">'
							+ '<Th class="titleCss" align="left" colspan="2">'
							+ '<img width="20px" height="20px" src="'
							+ getContextPath()
							+ title_image
							+ '">&nbsp;&nbsp;'
							+ title
							+ '<div style="height:10px;"></div><hr /></Th>'
							+ '</tr>'
							+ '<tr valign="middle">'
							+ '<td width="80px" align="right">'
							+ '<img width="50px" height="50px" src="'
							+ getContextPath()
							+ image_url
							+ '">'
							+ '</td><Td class="messageCss" align="left">&nbsp;&nbsp;&nbsp;&nbsp;'
							+ message
							+ '</Td></tr><tr valign="middle" height="20px"><Th align="center" colspan="2">'
							+ '<input class="snow_framework_btn" value="'
							+ button_message
							+ '" onclick="MClose()" type="button" /></Th></tr></table></div>',
					{
						closeBtn : false
					});
}

var MBox = function() {
	this.height = "auto";
	this.width = "300px";
	this.title = "提示";
	this.title_image = _prompt;
	this.image_url = _ever;
	this.message = "";
	this.button_message = "确定";
	this.show = function() {
		showDIV(this.width, this.height, this.title, this.title_image,
				this.image_url, this.message, this.button_message);
	}
};

var MClose = function() {
	$.fancybox.close();
}

var DClose = function() {
	parent.MClose();
}

window.alert = function(message) {
	var mBox = new MBox();
	mBox.message = message;
	mBox.show();
}

showDIVE = function(width, height, title, title_image, image_url, message,
		button_yes, button_no, fun, esc) {
	$
			.fancybox(
					'<div style="width:'
							+ width
							+ ';height:'
							+ height
							+ ';overflow:auto;">'
							+ '<table width="100%" height="100%">'
							+ '<tr valign="middle" height="20px">'
							+ '<Th align="left" colspan="2">'
							+ '<img width="20px" height="20px" src="'
							+ getContextPath()
							+ title_image
							+ '">&nbsp;&nbsp;'
							+ title
							+ '<hr /></Th>'
							+ '</tr>'
							+ '<tr valign="middle">'
							+ '<td width="80px" align="right">'
							+ '<img width="50px" height="50px" src="'
							+ getContextPath()
							+ image_url
							+ '">'
							+ '</td><Td align="center">'
							+ message
							+ '</Td></tr><tr valign="middle" height="20px"><Th align="center" colspan="2">'
							+ '<input class="snow_framework_btn" value=" '
							+ button_yes
							+ ' " onclick="'
							+ fun
							+ '" type="button" />&nbsp;'
							+ '<input class="snow_framework_btn" value=" '
							+ button_no
							+ ' " onclick="'
							+ esc
							+ '" type="button" /></Th></tr></table></div>',
					{
						closeBtn : false
					});
}

var CBox = function() {
	this.height = "auto";
	this.width = "300px";
	this.title = "提示";
	this.title_image = _prompt;
	this.image_url = _ever;
	this.message = "";
	this.button_yes = "确定";
	this.button_no = "取消";
	this.fun = "";
	this.esc = "MClose()";
	this.show = function() {
		showDIVE(this.width, this.height, this.title, this.title_image,
				this.image_url, this.message, this.button_yes, this.button_no,
				this.fun, this.esc);
	}
}

function alertBox(message, fun, esc) {
	var cBox = new CBox();
	cBox.message = message;
	cBox.fun = fun;
	if (esc != null) {
		cBox.esc = esc;
	}
	cBox.show();
}