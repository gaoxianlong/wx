<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxfp/wxyzmok.css" />
</head>
<body>
<div class="wx_wrap">
	<div class="okimg">
		<h6><i></i><p>恭喜您绑定成功！</p></h6>
		<div><img src="<%=path%>/img/icon/yzmxs.png" alt="" /></div>
	</div>
	<div class="return_fp">
		<c:if test="${empty urlcode}">
		<a href="<%=path%>/wxfpser?id=191">返回课程首页</a>
			</c:if>
			<c:if test="${fn:containsIgnoreCase(urlcode, 'fpplay')}">
		<a href="<%=path%>${urlcode}">返回课程页面</a>
			</c:if>
			<!--  <a href="<%=path%>/wxfpser?id=191">返回课程首页</a>-->
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
