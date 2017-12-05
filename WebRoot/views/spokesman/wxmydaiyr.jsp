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
<link rel="stylesheet" type="text/css" href="<%=path%>/css/spokesman/wxmydaiyr.css"/>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/content/bootstrap.min.css" />

</head>
<body>
<div class="wx_wrap">
	<header class="header">
		<h5>
			<span>学员名单</span>
			<span>共计：${info.getTotal() }人</span>
		</h5>
	</header>
	<section class="section">
		<ul>
		<c:forEach items="${userss }" var="bs">
		<c:forEach items="${bs}" var="wx">
			<li>
				<p>
					<b><img src="${wx.headUrl}" alt="" /></b>
					<span>${wx.nickName }</span>
				</p>
				<em>
				
			<fmt:formatDate value="${wx.registertime }"
										pattern="yyyy-MM-dd" />
				</em>
			</li>
			</c:forEach>
		</c:forEach>
		</ul>
	</section>
	
	
	<!--  -->
	<div class="pager">

					<nav aria-label="Page navigation">
						<ul class="pagination">
							<li><a href="txindex?page=1">首页</a></li>

							<c:if test="${info.hasPreviousPage }">
								<li><a href="txindex?page=${info.pageNum-1 }"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:if>



							<c:forEach items="${info.navigatepageNums }" var="page_Num">
								<c:if test="${page_Num == info.pageNum }">
									<li class="active"><a href="txindex?page=${page_Num }">${page_Num }</a></li>
								</c:if>

								<c:if test="${page_Num != info.pageNum }">
									<li><a href="txindex?page=${page_Num }">${page_Num }</a></li>
								</c:if>
							</c:forEach>

							<c:if test="${info.hasNextPage }">
								<li><a href="txindex?page=${info.pageNum+1 }"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:if>


							<li><a href="txindex?page=${info.pages }">末页</a></li>




						</ul>
					</nav>
				</div>
	
	
	
	
	<!--  -->
	

	
	
</div>	
</body>
</html>
<script type="text/javascript" src="<%=path%>/js/wxpublic.js"></script>