<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>手提课</title>
<meta http-equiv="content-type" content="text/htm" charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxmaterial.css"/>
</head>
<body>
<div class="wx_wrap">
	<div class="my_mater">
		<form action="" method="post">
			<div class="rows first_rows">
				<div class="rows_phone">
					<b style="width: 80%;">代言人中心</b>
			    	<i></i>
		        </div>
		        <a href="<%=path%>/money" class="txts"></a>
			</div>
			
		    <div class="rows">
		    	<div class="rows_phone">
			    	<b style="width: 80%;">完善资料</b>
			    	<i></i>
			    </div>
			    <a href="<%=path%>/selectWxUser" class="txts"></a>
		    </div>
		</form>
	</div>
</div>
</body>
</html>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>
