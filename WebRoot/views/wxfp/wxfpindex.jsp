<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>手提课-活到老学到老</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxkc_public.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stkxx.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxfp/wxfpindex.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/menu_public.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxfooter.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
<div class="wx_wrap">
	<div class="wx_topnav">
		<div class="person">
		</div>
		<div class="member">
			<c:if test="${empty user.helpCode}">
			 <a href="selectCode">免费学习验证码</a>
			</c:if>
			<c:if test="${!empty user.helpCode}">
			 <a href="views/wxfp/wxyzmok.jsp">免费学习验证码</a>
			</c:if>
		</div>
	</div>
	<div class="banner_wrap">
		<div class="wx_banner">
			<div class="banner_box">
				<div class="banner_con">
			        <div class="banner_list">
			        	<a href="javascript:;">
			        		<img src="<%=path%>/img/fp/fpbanner.png" />
			        	</a>
			        </div>
			    </div>
			</div>
		</div>
		<div class="banner_mask"></div>
	</div>
	<!-- fpindex -->
	<div class="wx_nav">
		<div class="nav_menu">
			<div class="nav_list" data-onoff="false">
			 <c:if test="${school eq 1}">
				<span>小学课程</span>
			 </c:if>
			  <c:if test="${school eq 0}">
				<span>学前课程</span>
			 </c:if>
				<i></i>
			</div>
			<div class="nav_list" data-onoff="false">
				 <c:if test="${point eq 191}">
				<span>一年级</span>
			 </c:if>
			 
			 <c:if test="${point eq 196}">
				<span>二年级</span>
			 </c:if>
			 
			 <c:if test="${point eq 202}">
				<span>三年级</span>
			 </c:if>
			 
			 <c:if test="${point eq 205}">
				<span>四年级</span>
			 </c:if>
			 
			 <c:if test="${point eq 216}">
				<span>五年级</span>
			 </c:if>
			 
			 <c:if test="${point eq 219}">
				<span>六年级</span>
			 </c:if>
				<i></i>
			</div>
			<div class="nav_list" data-onoff="false">
				<span>科目</span>
				<i></i>
			</div>
		</div>
		<div class="nav_wrap">
			<div class="menu_con">
				<ul class="items clearfix">
					<li da-id="${school }" value="1" class="tit"><a href="<%=path%>/wxfpser?id=191">小学课程</a></li>
					<li da-id="${school }" value="0" class="tit"><a href="<%=path%>/wxfpserxueqian?id=188">学前课程</a></li>
				</ul>
			</div>
			<div class="menu_con menu_year">
				<ul class="items clearfix">
					<li class="navs"><a href="wxfpser?id=191" data-id="${point }" value="191">一年级</a></li>
					<li class="navs"><a href="wxfpser?id=196" data-id="${point }" value="196">二年级</a></li>
					<li class="navs"><a href="wxfpser?id=202" data-id="${point }" value="202">三年级</a></li>
					<li class="navs"><a href="wxfpser?id=205" data-id="${point }" value="205">四年级</a></li>
					<li class="navs"><a href="wxfpser?id=216" data-id="${point }" value="216">五年级</a></li>
					<li class="navs"><a href="wxfpser?id=219" data-id="${point }" value="219">六年级</a></li>
				</ul>
			</div>
			<div class="menu_con">
				<ul class="items clearfix">
				<c:forEach items="${tysan }" var="bs">
				<li class="navss"><a href="wxfpright?id=${point }&sanid=${bs.ID }" data-id="${pointsan }" value="${bs.ID }">${bs.typeName }</a></li>
				</c:forEach>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=307&sorid=1&pointding=1" data-id="${pointsan }" value="307">学习方法</a></li>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=308&sorid=1&pointding=2" data-id="${pointsan }" value="308">家庭教育</a></li>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=297&sorid=1&pointding=3" data-id="${pointsan }" value="297">绘画</a></li>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=298&sorid=1&pointding=4" data-id="${pointsan }" value="298">记忆法</a></li>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=309&sorid=1&pointding=5" data-id="${pointsan }" value="309">国学</a></li>
				<li class="navss"><a href="wxfprighthobby?id=${point }&erid=304&sorid=1&pointding=6" data-id="${pointsan }" value="304">古诗词</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- fpindex -->
	<div class="wx_kc clearfix">
	<c:forEach items="${series }" var="ser">
		<div class="kc_item">
			<a href="<%=path%>/fpplay?seriesID=${ser.ID }">
				<div class="kc_img">
					<img class="lazy" data-original="http://www.shoutike.com/cover/${ser.picURL }" src="<%=path%>/img/xiaoshou.png"/>
				</div>
				<div class="kc_xq">
					<h5 class="ellipsis">${ser.title }</h5>
					<div class="kc_pic">
						<p>
							<span>
								<img src="<%=path%>/img/icon/playicon.jpg" alt="" />
							</span>
							<em>${ser.clickRate }</em>
						</p>
						<strong>免费</strong>
					</div>
				</div>
			</a>
		</div>
		
		</c:forEach>
		
		
		
		
		<c:forEach items="${seriespublic }" var="ser">
		<div class="kc_item">
			<a href="<%=path%>/fpplay?seriesID=${ser.ID }">
				<div class="kc_img">
					<img class="lazy" data-original="http://www.shoutike.com/cover/${ser.picURL }" src="<%=path%>/img/xiaoshou.png"/>
				</div>
				<div class="kc_xq">
					<h5 class="ellipsis">${ser.title }</h5>
					<div class="kc_pic">
						<p>
							<span>
								<img src="<%=path%>/img/icon/playicon.jpg" alt="" />
							</span>
							<em>${ser.clickRate }</em>
						</p>
						<strong>免费</strong>
					</div>
				</div>
			</a>
		</div>
		
		</c:forEach>
	</div>
		
    <!--  -->
    
   <footer class="footer">
    	<div class="foot_nav">
    		<a href="<%=path%>/wxser?id=191" class="footlist" da-id="${menupoint }" value="1">
    			<i class="nav_icon"><b></b></i>
    			<span>课程首页</span>
    		</a>
    		<a class="footlist" href="<%=path%>/wxmp" da-id="${menupoint }" value="5">
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
<script type="text/javascript" src="<%=path%>/jscript/jquery.lazyload.min.js"></script>
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

$('.tit').each(function(){
	
		if($(this).attr('da-id') == $(this).attr('value')){
			$(this).addClass('menu_active');
		} 
	});
$('.footlist').each(function(){
	
	if($(this).attr('da-id') == $(this).attr('value')){
		$(this).addClass('foot_active');
	} 
});
</script>


<script type="text/javascript">
//threshold 为 200  令图片在距离屏幕 200 像素时提前加载.
//$("img.lazy").lazyload({
//  threshold : 200
//});
//特效 添加淡入淡出效果
$("img.lazy").lazyload({
    effect : "fadeIn"
});

//加载隐藏图片 默认情况下 初始不加载隐藏图片
$("img.lazy").lazyload({ 
    skip_invisible : false
});

//图片在容器内 水平滚动时加载
//$("img.lazy").lazyload({
//  container: $("#container")
//});
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
                  desc: '课程“短小精练，生动有趣”。满足“课前预习，课后复习”。', 
                  link: 'http://www.shoutike.com/wx/wxfpser?id=191&prolocutor=${prolocutorindex }',  
                  imgUrl: 'http://www.shoutike.com/wx/img/share.jpg',  
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
                 desc: '课程“短小精练 ，生动有趣”。满足“课前预习，课后复习”。', 
                  link: 'http://www.shoutike.com/wx/wxfpser?id=191&prolocutor=${prolocutorindex }',  
                  imgUrl: 'http://www.shoutike.com/wx/img/share.jpg',  
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
