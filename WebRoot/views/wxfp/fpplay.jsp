<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.jcxa.safe.entity.Users"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxplay.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>



</head>
<body>
<div class="wx_wrap">
	<div class="video_wrap">
		<!--极酷阳光播放器/代码开始-->
        <div class="video2" id="CuPlayer">
          <script>
			                    var vID = "";			                    var vWidth = "100%";            //播放器宽度设置
			                    var vHeight = "100%";               //播放器高度设置
			                    var vFile = "<%=path%>/jscript/v3/CuSunV3set.xml";
			                    var vPlayer = "<%=path%>/jscript/v3/player.swf?v=3.5";
			                    var vPic = "";//视频缩略图
			                    var vCssurl = "<%=path%>/content/wxcss/mini.css";
			                    var vMp4url = "http://oss.shoutike.com/${itemvo.videoURL}"; 
//                              var vMp4url = "C:\Users\Administrator\Desktop\demo\TWST.mp4";
			                </script>
			                <script class="CuPlayerVideo" data-mce-role="CuPlayerVideo" type="text/javascript" src="<%=path%>/jscript/v3/CuSunX1.min.js"></script>
	    </div>
	</div>
	<!--点赞分享-->
	<div class="play_dz">
		<h1>${Title}</h1>
		<div class="play_fx">
			<div class="kc_dz">
			<c:if test="${empty user.ID}">
					<input type="text" hidden="hidden" value="${wxuser.id}" name="uid" id="uid"/>
				</c:if>
				<c:if test="${!empty user.ID}">
					<input type="text" hidden="hidden" value="${user.ID}" name="uid" id="uid" />
				</c:if>
			<input type="text" hidden="hidden" value="${playing}" name="vid" id="vid"/>
				<span class="dz_btn" data-btn="${flag}"></span>
				<span class="dz_num">${voZan}</span>
			</div>
			<div class="kc_bf">
				<span class="bf_icon"></span>
				<span class="bf_num">987</span>
			</div>
			
			<div class="kc_btn">
			    
			</div>
		</div>
	</div>
	<!--播放列表-->
	<div class="play_list">
		<ul class="list">
			
			<c:forEach items="${lsvideo }" var="vo" varStatus="flag">
			<li data-id="${playing }" value="${vo.ID }">
				<a href="fpplay?seriesID=${vo.SID }&id=${vo.ID }">
					<h6>${vo.title }</h6>
					
				</a>
			</li>
			</c:forEach>
		
			
		</ul>
	</div>
   
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxplay.js"></script>
<!--视频播放-->
<script type="text/javascript">
$('#CuPlayerVideo_video').height('8.52rem');
ChangeCurr();

function getNext(pars) {
    var url = $("#nextUrl").val();
    if (url == undefined || url == "") {
        return false;
    }
    window.location = url;
}

function ChangeCurr() {
	
    var video_index = $("#curr").val();
//  $(".list li").addClass('playering');
    $(".list li").eq(video_index).addClass('playering');
    LeftScr(video_index);
}

function LeftScr(m) {
    var scrtop;
    if (m > 1) {
        scrtop = 76 * (m - 1);
    } else {
        scrtop = 0;
    }
    $(".list").animate({
        scrollTop: scrtop
    }, 130);
}
function share(t) {
    var url = "/Share/Share?i=nct1LqfUAA7c0DiYNZ1sZw..&t=" + t;
    window.open(url);
}
    
</script>




