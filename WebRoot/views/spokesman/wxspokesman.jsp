<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.jcxa.safe.entity.Users"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/spokesman/wxspokesman.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxfooter.css"/>

</head>
<body>
<div class="wx_wrap">
	<!-- 修改 201815-->
	<div class="myspoke">
		<div class="myimg">
			<div class="imgicon">
					<c:if test="${empty user.headUrl}">
						<p> <img src="${wxuser.headUrl}"/> </p>
					</c:if>
					<c:if test="${!empty user.headUrl}">
						<c:if test="${fn:containsIgnoreCase(user.headUrl, 'http')}">
							<p> <img src="${user.headUrl}"/> </p >
						</c:if>
						<c:if test="${fn:containsIgnoreCase(user.headUrl, 'userhadle')}">
							<p><img src="https://www.shoutike.com/${user.headUrl}"/> </p >
						</c:if>
					</c:if>
				
				
			   		<h3 class="ellipsis">${name }</h3>
			    	<c:if test="${prolocutor ne 'a'}">
			    	<a href="javascript:;"> 已成为代言人</a>
			    	</c:if>
			 		<c:if test="${prolocutor eq 'a'}">
			    		<a href="<%=path%>/views/spokesman/wxspokephone.jsp">立即成为代言人</a>
			   		</c:if>
			</div>
			<div class="txok">
				<p>可提现收益（元）</p >
				<h5 class="cash">￥${alow}</h5>
			</div>
			<div class="txover">
				<div class="txleft">
					<p>暂不可提现收益</p>
					<p>￥${noo}</p>
				</div>
				<div class="txright">
					<p>已提现收益</p>
					<p>￥${money}</p>
				</div>
			</div>
		</div>
	    
	    <div class="mysyxq">
			<div class="nowtx" id="mytx">立即提现</div>
			<div class="mydd" id="txorder"><a href="<%=path%>/proordercourse">订单明细</a></div>
		</div>
		
	</div>
	
	<!-- 修改 201815-->
	<div class="spokelist">
		<ul>
			<li>
				<a href="txindex">
					<b>查看学员名单</b>
				    <i></i>
				</a>
			</li>
			<li>
				<a href="<%=path%>/views/spokesman/wxtxgz.jsp">
					<b>提现规则</b>
				    <i></i>
				</a>
			</li>
			<li>
				<a href="<%=path%>/views/spokesman/wxaboutspokesman.jsp">
					<b>关于代言人</b>
				    <i></i>
				</a>
			</li>
		</ul>
	</div>
	
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
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript">

$('.footlist').each(function(){
	
	if($(this).attr('da-id') == $(this).attr('value')){
		$(this).addClass('foot_active');
	} 
});



var jssec = 3;

var myDate = new Date();
var $date = myDate.getDate();

$('#mytx').on('click',function(){
	if("false" == $(this).attr("data-onoff")){
		return false;
	}

	if($date>=20&&$date<=25){
	
		var money=$('.cash').html().split("￥")[1];
		window.location.href='<%=path%>/views/spokesman/wxtxok.jsp?money='+money;
	
	}else{
		alert('每月20-25日为出账日期，请在规定的日期内提现');
	}
	changes();
});



function changes() {
	//如果过了3秒后 按钮的disabled为 true  即可再点 否则 为false 不能再点
	jssec--;
	if (jssec > -1) {
		timer = setTimeout('changes()', 1000);//调用自身实现
		$('#mytx').attr("data-onoff", 'false');
	}
	else {
		$('#mytx').attr("data-onoff", 'true');
		clearTimeout(timer);
		jssec = 3;
	}
}

</script>