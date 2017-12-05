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
	String price = request.getParameter("moneys");
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="../css/wxpublic/wxpublic.css"/>
<style>
	h1{
		height: 4rem;
		padding-top: 2.5rem;
		text-align: center;
		font-size: 0.9rem;
	}
	h5{
		height: 3%;
		padding-top: 1%;
		padding-left: 0.6rem;
	}
	span{
		font-size: 0.6rem;
	}
	h6{
		text-align: center;
		height: 2rem;
		line-height: 2rem;
		margin-bottom: 0.5rem;
		font-size: 0.55rem;
		
	}
	.fkxq{
		height: 40%;
		padding: 5% 0;
		margin-bottom: 20%;
		border-top: 1px solid #ccc;
		border-bottom: 1px solid #ccc;
		margin-top: 5%;
	}
	.cxzf{
		width: 94%;
		height: 1.5rem;
		text-align: center;
		border-radius: 0.3rem;
		-webkit-border-radius: 0.3rem;
		margin-left: 3%;
		background: #ccc;
		line-height: 1.5rem;
		color: #fff;
		font-size: 0.6rem;
		background: #d21213;
	}
</style>

<script type="text/javascript">
  
  
  	function callpay(){
  
		 WeixinJSBridge.invoke('getBrandWCPayRequest',{
  		 "appId" : "<%=appId%>","timeStamp" : "<%=timeStamp%>", "nonceStr" : "<%=nonceStr%>", "package" : "<%=packageValue%>","signType" : "MD5", "paySign" : "<%=paySign%>" 
   			},function(res){
				WeixinJSBridge.log(res.err_msg);
 				
	            if(res.err_msg == "get_brand_wcpay_request:ok"){ 
	           // alert("用户成功支付!"); 
	            $.post("<%=path%>/getTephone","ID="+${user.ID},function(data){
	             
	            
	        	   if(data=="exist"){
	        		   window.location.href="<%=path%>/wxser?id=191";
	        	   }else{
	        		   window.location.href="wxmaterialpay.jsp";
	        	   }
	           }); 
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
<div class="wx_wrap" style="100%">
	<h1>交易进行中.....</h1>
	<div class="fkxq">
		
		<h5><span>商品名称：</span><span>手提课会员</span></h5>
		<h5><span>交易金额：</span><span><%=price %></span></h5>
		
	</div>
	<h6>交易完成后自动返回</h6>
	<div class="cxzf" onclick="callpay()">立即支付</div>
</div>
</body>
</html>
<script type="text/javascript" src="../jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="../js/wxpublic.js"></script>
