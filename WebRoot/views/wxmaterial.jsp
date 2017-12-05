<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<link rel="stylesheet" type="text/css" href="<%=path%>/dist/css/LArea.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxfooter.css"/>
<style type="text/css">
	.area_roll>div{
		height: 11rem;
	}
</style>
</head>

<body>
<div class="wx_wrap">
	<div class="my_mater">
	
		<form action="${pageContext.request.contextPath}/addUser" method="post" id="wxfpphone">
			<c:if test="${empty user.telephone}">
			<div class="rows first_rows">
				<div class="rows_phone">
					<b>手机号</b>
				    <p>未绑定</p>
			    	<i></i>
		        </div>
		        
		        <a href="<%=path%>/materphone.jsp" class="txts"></a>
			</div>
			</c:if>
		<c:if test="${!empty user.telephone}">
			<div class="rows first_rows">
				<div class="rows_phone">
					<b>手机号</b>
				    <p>已绑定</p>
			    	<i></i>
		        </div>
		        
			</div>
			</c:if>
			<input type="text" hidden="hidden" name="ID" value="${user.ID}">
			
			<div class="rows">
				<div class="rows_name">
			    	<b>姓名</b>
			    	<p>
			    		<input type="text" placeholder="" name="realName" class="mytext" value="${user.realName}"/>
			    	</p>
			    	<i></i>
			    </div>
			    <!--<a href="matertexts/matertexts.html" class="txts"></a>-->
			</div>
		    
		    <div class="rows">
		    	<div class="rows_sex">
			    	<b>性别</b>
			    	<c:if test="${!empty user.sex}">
			    	<p>${user.sex}</p>
			    	</c:if>
			    	<c:if test="${empty user.sex}">
			    	<p>请选择</p>
			    	</c:if>
			    	<i></i>
			    </div>
			    <select name="sex" class="selects">
			    	<option value="" disabled="disabled">请选择</option>
			    	<option value="男" ${user.sex == "男" ? 'selected = "selected"' : '' }>男</option>
			    	<option value="女" ${user.sex == "女" ? 'selected = "selected"' : '' }>女</option>
			    </select>
		    </div>
		    
		     <div class="rows">
		    	<div class="rows_map">
			    	<b>所在地</b>
			    	<p>
			    		
			    		<input id="demo2" type="text" name="demo1" readonly placeholder="选择城市" />
			    		
			    	</p>
			    	<i></i>
			    </div>
			    <input id="value2" type="hidden" name="demo2" value=""/>
			    
		    </div>
		    
		    <div class="rows">
		    	<div class="rows_school">
			    	<b>学校</b>
			    	<p>
			    		<input type="text" name="school" id="" class="mytext" value="${user.school}" placeholder="" />
			    	</p>
			    	<i></i>
			    </div>
		    </div>
		    
		       <div class="rows">
		    	<div class="rows_year">
			    	<b>年级</b>
			    	<c:if test="${!empty user.grade}">
			    	<p>${user.grade}</p>
			    	</c:if>
			    	<c:if test="${empty user.grade}">
			    	<p>请选择</p>
			    	</c:if>
			    	<i></i>
			    </div>
			    <select name="grade" class="selects" id="">
			    	<option value="" disabled="disabled">请选择</option>
			    	<option value="一年级" ${user.grade == "一年级" ? 'selected = "selected"' : '' }>一年级</option>
			    	<option value="二年级" ${user.grade == "二年级" ? 'selected = "selected"' : '' }>二年级</option>
			    	<option value="三年级" ${user.grade == "三年级" ? 'selected = "selected"' : '' }>三年级</option>
			    	<option value="四年级" ${user.grade == "四年级" ? 'selected = "selected"' : '' }>四年级</option>
			    	<option value="五年级" ${user.grade == "五年级" ? 'selected = "selected"' : '' }>五年级</option>
			    	<option value="六年级" ${user.grade == "六年级" ? 'selected = "selected"' : '' }>六年级</option>
			    </select>
		    </div>
		    
		    <div class="rows last_rows">
		    	<div class="rows_class">
			    	<b>班级</b>
			    	<p>
			    		<input type="text" name="wxclass" id="" class="mytext" value="${user.wxclass}" placeholder="" />
			    	</p>
			    	<i></i>
			    </div>
			    
		    </div>
			<input type="submit" value="完善资料" id="mater_btn" class="mater_btn"/>
		</form>
	</div>
	
	 <footer class="footer">
    	<div class="foot_nav">
    		<a href="<%=path%>/wxser?id=191" class="footlist" da-id="${menupoint }" value="1">
    			<i class="nav_icon"><b></b></i>
    			<span>课程首页</span>
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
<script type="text/javascript" src="<%=path%>/dist/js/LAreaData1.js"></script>
<script type="text/javascript" src="<%=path%>/dist/js/LAreaData2.js"></script>
<script type="text/javascript" src="<%=path%>/dist/js/LArea.js"></script>
<script type="text/javascript" src="<%=path%>/js/wxmaterial.js"></script>
<script type="text/javascript">
	$('.footlist').each(function(){
	
	if($(this).attr('da-id') == $(this).attr('value')){
		$(this).addClass('foot_active');
	} 
});
   
    var area2 = new LArea();
    area2.init({
        'trigger': '#demo2',
        'valueTo': '#value2',
        'keys': {
            id: 'value',
            name: 'text'
        },
        'type': 2,
        'data': [provs_data, citys_data, dists_data]
    });

</script>