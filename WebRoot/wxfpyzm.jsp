<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxfp/wxfpyzm.css"/>

</head>
<body>
<div class="wx_wrap">
	<form action="addHelpCode" method="post" id="yzm-sub">
		<div class="my_yzm">
			<div class="rows">
				<input type="text" class="yzmcode" id="wxyzm" autofocus="autofocus" placeholder="请输入免费学习验证码" name="HelpCode"/>
				<i></i>
			</div>
			<p>免费学习验证码是以STK开头的18位英文和数字组合，若想获取免费学习验证码，可在公众号下输入“免费学习验证码”</p >
		</div>
	    <input type="submit" value="确定" class="yzm_btn" />
	</form>
	<div id="error"></div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
<script type="text/javascript" src="<%=path%>/js/fp/fpyzm.js"></script>
<script type="text/javascript">
	
</script>

