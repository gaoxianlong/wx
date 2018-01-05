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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/menu_public.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stkxx.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxfooter.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxaudio/audioindex.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
<div class="wx_wrap" style="padding-top:0;">
	
	<div class="banner_wrap">
		<div class="wx_banner">
			<div class="banner_box">
				<div class="banner_con">
			        <div class="banner_list">
			        	<a href="javascript:;">
			        		<img src="<%=path%>/img/audio/mp.jpg" />
			        	</a>
			        </div>
			    </div>
			</div>
		</div>
		<div class="banner_mask"></div>
	</div>
	<div class="wx_nav">
		<div class="nav_menu">
			<div class="nav_list" data-onoff="false">
				<c:if test="${empty nameone}">  
				<span>全部</span>
			</c:if>
			<c:if test="${not empty nameone}">  
				<span>${nameone }</span>
			</c:if>
				<i></i>
			</div>
			
			<div class="nav_list" data-onoff="false">
			<c:if test="${empty nametwo}">  
				<span>全部</span>
			</c:if>
			<c:if test="${not empty nametwo}">  
				<span>${nametwo }</span>
			</c:if>
				<i></i>
			</div>
		</div>
		<div class="nav_wrap">
			<div class="menu_con">
				<ul class="items clearfix">
					<c:forEach items="${type }" var="bs">
					<li class="navs"><a href="wxmp?id=${bs.ID }" data-id="${point }" value="${bs.ID }">${bs.typeName }</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="menu_con">
				<ul class="items clearfix">
					<c:forEach items="${tyer }" var="bs">
					<li class="navss"><a href="wxmpright?id=${point }&erid=${bs.ID }" data-id="${pointer }" value="${bs.ID }">${bs.typeName }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	<div class="audio_con">
	
	<c:forEach items="${seriesmp }" var="ser">
		<div class="items">
			<a href="mpplay?seriesID=${ser.ID }">
				<div class="audio_img">
					<img src="https://www.shoutike.com/cover/${ser.picURL }" alt="" />
				</div>
				<div class="audio_xq">
					<h5 class="ellipsis">${ser.title }</h5>
					<div class="audio_pon">
						<span>主讲人：${ser.writer }</span>
						<span>播放次数：${ser.clickRate }</span>
					</div>
				</div>
				<i class="audio_btn"></i>
			</a>
		</div>	
	</c:forEach>	
		
	</div>
	
	<footer class="footer">
    	<div class="foot_nav">
    		<a href="<%=path%>/wxser?id=191" class="footlist" da-id="${menupoint }" value="1">
    			<i class="nav_icon"><b></b></i>
    			<span>课程首页</span>
    		</a>
    		<a class="footlist" href="wxmp" da-id="${menupoint }" value="5">
    			<i class="nav_icon"><b></b></i>
    			<span>音频</span>
    		</a>
    		<a href="<%=path%>/wxfpser?id=191" class="footlist" da-id="${menupoint }" value="2">
    			<i class="nav_icon"><b></b></i>
    			<span>教育扶贫</span>
    		</a>
    		<a href="<%=path%>/money" class="footlist" da-id="${menupoint }" value="3">
    			<i class="nav_icon"><b></b></i>
    			<span>代言人</span>
    		</a>
    		<a href="<%=path%>/selectWxUser" class="footlist" da-id="${menupoint }" value="4">
    			<i class="nav_icon"><b></b></i>
    			<span>个人中心</span>
    		</a>
    		
    	</div>
    	
    </footer>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript" src="<%=path%>/js/menu_public.js"></script>
<script>
$('.navs').each(function(){
	
		if($(this).children('a').attr('data-id') == $(this).children('a').attr('value')){
			$(this).addClass('menu_active');
		} 
	});
$('.navss').each(function(){
	
	if($(this).children('a').attr('data-id') == $(this).children('a').attr('value')){
		$(this).addClass('menu_active');
	} 
});
$('.footlist').each(function(){
	
	if($(this).attr('da-id') == $(this).attr('value')){
		$(this).addClass('foot_active');
	} 
});
</script>

<script>  
//微信分享朋友圈  
$(function(){  
  /***用户点击分享到微信圈后加载接口接口*******/  
    var url=window.location.href.split('#')[0];  
     url = url.replace(/&/g, '%26');  
   
    console.log("url:"+url);  
    $.ajax({  
        url: "<%=path%>/shareServlet?url="+url,  
        type: "POST",  
        async:true,  
        cache: false,  
        dataType: "json",  
        success: function(data){  
            wx.config({  
              debug: false,  
              appId: data.appId,  
              timestamp:data.timeStamp,  
              nonceStr:data.nonceStr,  
              signature:data.signature,  
              jsApiList: [  
                  'checkJsApi',  
                  'onMenuShareTimeline',  
                  'hideOptionMenu',  
                  'onMenuShareAppMessage'  
              ]  
          });  
              
          wx.ready(function(){  
             //wx.hideOptionMenu();/***隐藏分享菜单****/   
             wx.checkJsApi({  
              jsApiList: [  
                'getLocation',  
                'onMenuShareTimeline',  
                'onMenuShareAppMessage'  
              ],  
              success: function (res) {  
                //alert(res.errMsg);  
              }  
            });  
               
            wx.onMenuShareAppMessage({  
                  title: '手提课-活到老学到老',  
                  desc: '课程“短小精练 ，生动有趣”。满足“课前预习，课后复习”。', 
                  link: 'https://www.shoutike.com/wx/wxmp?id=189&prolocutor=${prolocutorindex }',  
                  imgUrl: 'https://www.shoutike.com/wx/img/share.jpg',  
                  trigger: function (res) {  
                    //alert('用户点击发送给朋友');  
                  },  
                  success: function (res) {  
                	 
                   
                   
                  },  
                  cancel: function (res) {  
                    alert('已取消');  
                  },  
                  fail: function (res) {  
                    alert(res.errMsg);  
                  }  
               });  
              
              // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口  
              wx.onMenuShareTimeline({  
            	  title: '手提课-活到老学到老',  
                 desc: '课程“短小精练，生动有趣”。满足“课前预习，课后复习”。', 
                  link: 'https://www.shoutike.com/wx/wxmp?id=189&prolocutor=${prolocutorindex }',  
                  imgUrl: 'https://www.shoutike.com/wx/img/share.jpg',  
                  trigger: function (res) {  
                    //alert('用户点击分享到朋友圈');  
                  },  
                  success: function (res) {  
                	 
                   
                  },  
                  cancel: function (res) {  
                    //alert('已取消');  
                  },  
                  fail: function (res) {  
                    alert(res.errMsg);  
                  }  
            });  
               
            wx.error(function (res) {  
                   alert(res.errMsg);  
               });  
           });    
        },  
        error: function() {  
            alert('ajax request failed!!!!');  
            return;  
        }   
    });  
  });  
  
</script>  