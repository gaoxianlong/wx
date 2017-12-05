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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/spokesman/wxspokephone.css"/>
</head>
<body>
<div class="wx_wrap">
	
	
	<div class="spokebtn">
		<a href="<%=path%>/become" style="opacity: 1;">成为代言人</a>
	</div>
</div>
</body>
</html>
<!--<script type="text/javascript" src="<%=path%>/jscript/jquery-2.0.3.js"></script>-->
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
