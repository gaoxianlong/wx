<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = request.getParameter("url");
String a = request.getParameter("a");
String names="关于我们";
String name=null;
if(a.equals("a"))

{
 name="关于我们";
}else if(a.equals("b")){
 name="产品宣传片";
}



%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/aboutplay.css"/>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script src="https://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
</head>
<body>
<script type="text/javascript">


</script>
<div class="wx_wrap">
	<div class="banner_video">
		<!--极酷阳光播放器/代码开始-->
        <div class="video2" id="CuPlayer">
            <script>

                var vID = "";
                var vWidth = "100%";            //播放器宽度设置
                var vHeight = "100%";               //播放器高度设置
                var vFile = "<%=path%>/jscript/v3/CuSunV3set.xml";
                var vPlayer = "<%=path%>/jscript/v3/player.swf?v=3.5";
                var vPic = "";//视频缩略图
                var vCssurl = "content/wxcss/mini.css";
                var vMp4url = "http://oss.shoutike.com/<%=url%>";
            </script>
            <script class="CuPlayerVideo" data-mce-role="CuPlayerVideo" type="text/javascript" src="<%=path%>/jscript/v3/CuSunX1.min.js"></script>
	    </div>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript">
	$('#CuPlayerVideo_video').height('100%');
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
                  desc: '<%=name%>',  
                  link: 'https://www.shoutike.com/wx/views/aboutplay.jsp?url=<%=url%>&a=<%=a%>',  
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
                  desc: '<%=name%>',  
                  link: 'https://www.shoutike.com/wx/views/aboutplay.jsp?url=<%=url%>&a=<%=a%>',  
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