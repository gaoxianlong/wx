<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>/content/swiper.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/spokesman/wxaboutspokesman.css"/>
</head>
<body>
<div class="swiper-container wx_wrap">
	<ol class="swiper-wrapper wrapper">
		<li class="swiper-slide con">
			<div class="okimg">
				<p><img src="<%=path%>/img/wxabout/daiyanren01.png" alt="" /></p>
			</div>
			<div class="oknav">
				<div class="oklist">
					<img src="<%=path%>/img/wxabout/wxabout01.png"/>
				</div>
			</div>
			<div class="oktabscon">
				<h6>成为代言人</h6>
				<div class="oktabs">
					<p>关注进入手提课K12公众号，绑定手机号点击成为代言人。</p>
				</div>
			</div>
			
		</li>
		<li class="swiper-slide con">
			<div class="okimg">
				<p><img src="<%=path%>/img/wxabout/daiyanren02.png" alt="" /></p>
			</div>
			<div class="oknav">
				<div class="oklist">
					<img src="<%=path%>/img/wxabout/wxabout02.png"/>
				</div>
			</div>
			<div class="oktabscon">
				<h6>分享给好友</h6>
				<div class="oktabs">
					<p>浏览微信端网页，分享链接给好友或朋友圈，好友通过点击链接成为学员。</p>
				</div>
			</div>
			
		</li>
		<li class="swiper-slide con">
			<div class="okimg">
				<p><img src="<%=path%>/img/wxabout/daiyanren03.png" alt="" /></p>
			</div>
			<div class="oknav">
				<div class="oklist">
					<img src="<%=path%>/img/wxabout/wxabout03.png"/>
				</div>
			</div>
			<div class="oktabscon">
				<h6>获得收益</h6>
				<div class="oktabs">
					<p>学员在网站的任何消费，你都可以获得收益，收益可用于提现。</p>
					<div class="dyrxq">
						<a href="<%=path%>/views/spokesman/wxmydaiyrxq.jsp">代言人详情</a>
						<a href="<%=path%>/money">返回主页</a>
					</div>
				</div>
			</div>
			
		</li>
		
	</ol>
	<div class="swiper-pagination listjd"></div>
	
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/jscript/swiper.jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript">
$(document).ready(function () {

	var mySwiper = new Swiper('.swiper-container',{
//		direction: 'vertical', //滑动的方向 veertical是竖着滑动 默认是横着
//      hashnav:false,
		loop: true,
	    pagination : '.swiper-pagination',  //分页器 焦点
	    paginationClickable: true,
//	    autoplay : 2000,                      //自动播放的时间间隔 
//		autoplayDisableOnInteraction : false,  //自动播放 手指触摸滑动后继续自动播放  true是手指触摸滑动后 停止自动播放
		effect:"flip"                          //3d切换
	});
	
});

</script>
