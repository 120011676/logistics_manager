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

function topHref(url) {
	window.top.location = url;
}

function rightHref(url) {
	top.right.location.href = url;
}

var contextPath = "";

var _prompt = contextPath + "/js/framework/images/Prompt.png";
var _boy = contextPath + "/js/framework/images/boy.png";
var _card = contextPath + "/js/framework/images/card.png";
var _error = contextPath + "/js/framework/images/error.png";
var _ever = contextPath + "/js/framework/images/ever.png";
var _gril = contextPath + "/js/framework/images/gril.png";
var _right = contextPath + "/js/framework/images/right.png";
var _search = contextPath + "/js/framework/images/search.png";
var _search2 = contextPath + "/js/framework/images/search2.png";
var _loading = contextPath + "/js/framework/images/loading.gif";

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
							+ '<hr /></Th>'
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
							+ '<input class="btn" value=" '
							+ button_message
							+ ' " onclick="MClose()" class="btn" type="button" /></Th></tr></table></div>',
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