<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	
	String appId = request.getParameter("appid");
	String timeStamp = request.getParameter("timeStamp");
	String nonceStr = request.getParameter("nonceStr");
	String packageValue = request.getParameter("package");
	String paySign = request.getParameter("sign");
	String check = request.getParameter("checks");
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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxmember.css"/>
<script type="text/javascript">
  
  
  	function callpay(){
  
		 WeixinJSBridge.invoke('getBrandWCPayRequest',{
  		 "appId" : "<%=appId%>","timeStamp" : "<%=timeStamp%>", "nonceStr" : "<%=nonceStr%>", "package" : "<%=packageValue%>","signType" : "MD5", "paySign" : "<%=paySign%>" 
   			},function(res){
				WeixinJSBridge.log(res.err_msg);
 				
	            if(res.err_msg == "get_brand_wcpay_request:ok"){ 
	           // alert("用户成功支付!"); 
	              window.location.href="http://www.shoutike.com/wx/index.jsp"; 
	            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
	                alert("用户取消支付!");  
	           }else{  
	           alert(res.err_msg);
	               alert("支付失败!");  
	            }  
			})
		}	
  </script>
</head>
<body>
<div class="wx_wrap">
	<div class="banner_img">
		<div class="pic">
			<img src="<%=path%>/img/banner/member.png"/>
		</div>
	</div>
	<div class="person_vip">
		<h3>VIP特权</h3>
		<div class="vip_xq">
			<dl>
				<dt>
					<img src="<%=path%>/img/icon/copy01.png"/>
				</dt>
				<dd>课外知识</dd>
			</dl>
			<dl>
				<dt>
					<img src="<%=path%>/img/icon/copy02.png"/>
				</dt>
				<dd>英语数学同步精讲</dd>
			</dl>
			<dl>
				<dt>
					<img src="<%=path%>/img/icon/copy03.png"/>
				</dt>
				<dd>素质课程</dd>
			</dl>
		</div>
	</div>
	
	<div class="vip_time">
		<ul class="vip_list">
			<li class="vipitem" dataid="<%=check %>" value="1">
			<a href="javascript:;">
				<i class="vipcheck"></i>
				<span class="">1个月</span>
				<em>￥99</em>
			</a>
			</li>
			<li class="vipitem" dataid="<%=check %>" value="2">
				<a href="javascript:;">
				<i class="vipcheck"></i>
				<span class="">3个月</span>
				<em>￥199</em>
				</a>
			</li>
			<li class="vipitem last_vip" dataid="<%=check %>" value="3">
				<a href="javascript:;">
				<i class="vipcheck"></i>
				<span class="">6个月</span>
				<em>￥299</em>
				<p>赠送诗词课程和记忆力课程</p>
				</a>
			</li>
		</ul>
	</div>
	
	<div class="joinvip">
		<p class="vip_btn" data-onoff="true"><a href="javascript:;" style="display: block;color: #fff;">立即加入会员</a></p >
	</div>

</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxmember.js"></script>
<script type="text/javascript">
var jssec = 3;
	
	$('.vip_btn').on('touchstart',function(){
	   // var vippic = parseInt($('.vip_active').find('em').html());
	    if("false" == $(this).attr("data-onoff")){
		return false;
	}
	    var vippic = $('.vip_active').find('em').html().replace(/\D|^0/g,'');
	    //alert(vippic)
	    var num = $('.vip_active').attr('value');
	    //<%=path%>/MainServletfuzhi?vipso=vip&pric=99&check=1
	   //$(this).children().attr('href','<%=path%>/MainServletfuzhi?vipso=vip&pric='+vippic+'&check='+num);
	    //window.location.href='<%=path%>/MainServletfuzhi?vipso=vip&pric='+vippic+'&check='+num;
		window.location.href='<%=path%>/MainServletfuzhi?vipso=vip&pric='+vippic+'&check='+num;
		changes();
	});
	
	
	

function changes() {
	//如果过了3秒后 按钮的disabled为 true  即可再点 否则 为false 不能再点
    jssec--;
    if (jssec > -1) {
        timer = setTimeout('changes()', 1000);//调用自身实现
        $('.vip_btn').attr("data-onoff", 'false');
    }
    else {
        $('.vip_btn').attr("data-onoff", 'true');
        clearTimeout(timer);
        jssec = 3;
    }
}


	
</script>