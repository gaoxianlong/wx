<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <!--  
    ${ui.total_fee }
    ${ui.return_code }
    ${ui.return_msg }
    -->
    <center>
    
    <div style="font-size:80px;">
    <c:forEach items="${lsvideo }" var="ls">
    <div>
    <a href="mpplay?seriesID=${ls.SID }&id=${ls.ID }">
     ${ls.title }
     </a>
     </div>
    </c:forEach>
    
    
    <div style="margin-top:20px;">
    
    next: ${nextid }
   <br/>
   
    top: ${topid }
    <br/>
  url:  ${itemvo.videoURL }
   <br/>
  title: ${Title }
   
   <br/>
  playing:${playing }
  
   
    </div>
    </div>
    </center>
  </body>
</html>
