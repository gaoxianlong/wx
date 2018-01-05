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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxaudio/audioing.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
<div class="wx_wrap">
	<div class="bg"></div>
	<div class="bgblack"></div>
	<header class="header">
		<div class="prev_btn">
			<a href="wxmp"></a>
		</div>
	</header>
	<section class="section">
		<div class="audio_center">
			<div class="audio_singer">
				<div class="singerimg" >
					<img src="https://www.shoutike.com/STK/cover/${bg }"" id="circle" class="anmiting"/>
				</div>
			</div>
			<div class="lrc_mask">
				<div class="audio_lrc scroll">
					<ul>
						<li></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	
	<div class="sel_title">
		<h5>${Title }</h5>
		<h6>${itemvo.title}</h6>
	</div>
	
	<div class="footer">
		<div class="foot_con">
	        <div class="process">
	            <span id="currentTime">00:00</span>
	            <div id="process-bar">
	                <div id="process-all"></div>
	                <div id="process-cur">
	                    <em id="cur-btn"></em>
	                </div>
	                <div id="process-ready"></div>
	            </div>
	            <span id="total-time">00:00</span>
	        </div>
	        <div class="loop"></div>
	        <div class="prev_btn" id="prev_btn"></div>
	        <div class="playing_btn" id="playing_btn"></div>
	        <div class="next_btn" id="next_btn"></div>
	        <div class="music_menu" data-onoff="false"></div>
	    </div>
		<div class="audiohide">
	    	<audio autoplay="autoplay" id="audio" src="http://oss.shoutike.com/${itemvo.videoURL}">
	    		
	    	</audio>
	    </div>
	</div>

</div>
<div class="mask_list">

<input type="hidden" id="top" value="${topid }"/>
<input type="hidden" id="next" value="${nextid }"/>
<input type="hidden" id="serid" value="${nowserid }"/>
<input type="hidden" id="lys" value="${itemvo.des}"/>
	<div class="mask_cose">
		<h6>课程列表<span>（${size }集）</span></h6>
		<div class="list_con">
			<ul class="scroll">
			  <c:forEach items="${lsvideo }" var="ls">
    			<li  class="navs">
    				<a href="mpplay?seriesID=${ls.SID }&id=${ls.ID }" data-id="${playing }" value="${ls.ID }">
						<div class="lis ellipsis">${ls.title }</div>
						<i></i>
					</a>
    			</li>
			 </c:forEach>
			</ul>
		</div>
		<div class="lists_close">关闭</div>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<!--  <script type="text/javascript" src="<%=path%>/jscript/move.js"></script>-->
<script type="text/javascript" src="<%=path%>/js/audio.js"></script>
<!-- <script type="text/javascript" src="<%=path%>/js/stopscroll.js"></script> -->
<script>
//初始化加载背景图和唱片图片
var backbg = 'https://www.shoutike.com/STK/cover/${bg}';
$('.bg').css('background','url("'+backbg+'") no-repeat center');
$('.bg').css('background-size','cover');
$('.bg').css('-webkit-background-size','cover');
//初始化加载字幕
var ly=$('#lys').val();
lyric(ly);

function lyric(lyric){
	$('.audio_lrc ul').html('');
	var lrc = lyric.split('，');
	console.log(lrc,lrc.length);
    for (var i = 0; i < lrc.length; i++) {
        $('<li>').html(lrc[i]==''?'&nbsp':lrc[i]).appendTo($('.audio_lrc ul'));
    }
}


$('.navs').each(function(){
	
		if($(this).children('a').attr('data-id') == $(this).children('a').attr('value')){
			$(this).addClass('audio_active');
		} 
	});
	
</script>

<script>  
//微信分享朋友圈  
$(function(){  
  /***用户点击分享到微信圈后加载接口接口*******/  
     var url=window.location.href.split('#')[0];  
	 var add="&prolocutor=";
     urll=url+add+'${prolocutorplay }';
     url = url.replace(/&/g, '%26');  
  
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
        	  // mp3  play
        	  player.play();
        	  
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
                  desc: '${Title}',  
                  link: urll,  
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
            	  title: '手提课-活到老学到老,${Title}',  
                  desc: '',  
                  link: urll,  
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