<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxpublic/wxpublic.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/wxmaterial.css"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/dist/css/LArea.css"/>
<style type="text/css">
	.area_roll>div{
		height: 11rem;
	}
</style>
</head>
<body>
<input type="text" hidden="hidden" name="ID" value="${user.ID}">
<div class="wx_wrap">
	<div class="my_mater">
		<form action="${pageContext.request.contextPath}/addUser" method="post">
			<c:if test="${empty user.telephone}">
			<div class="rows first_rows error">
				<div class="rows_phone">
					<b><span>*</span>手机号<strong id="errorcall">未绑定手机号</strong></b>
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
		        <a href="<%=path%>/materphone.jsp" class="txts"></a>
			</div>
			</c:if>
			<div class="rows">
				<div class="rows_name">
			    	<b>姓名</b>
			    	<p>
			    		<input type="text" placeholder="" name="realName" class="mytext" />
			    	</p>
			    	<i></i>
			    </div>
			    <!--<a href="matertexts/matertexts.html" class="txts"></a>-->
			</div>
		    
		    <div class="rows">
		    	<div class="rows_sex">
			    	<b>性别</b>
			    	<p>请选择</p>
			    	<i></i>
			    </div>
			    <select name="sex" class="selects">
			    	<option value="" disabled="disabled">请选择</option>
			    	<option value="男">男</option>
			    	<option value="女">女</option>
			    </select>
		    </div>
		    
		    <div class="rows">
		    	<div class="rows_map">
			    	<b><span>*</span>所在地<strong>请输入所在地</strong></b>
			    	<p>
			    		<!--<input id="demo1" type="text" readonly="" placeholder="选择城市"  value="广东省,深圳市,南山区"/>-->
			    		<input id="demo2" type="text" name="demo1" readonly placeholder="选择城市" class="mytext" />
			    	</p>
			    	<i></i>
			    </div>
			    <!--<input id="value1" type="hidden" value="20,234,504"/>-->
			    <input id="value2" type="hidden" />
		    </div>
		    
		    <div class="rows">
		    	<div class="rows_school">
			    	<b><span>*</span>学校<strong>请输入学校</strong></b>
			    	<p>
			    		<input type="text" name="school" id="" class="mytext" value="" placeholder="" />
			    	</p>
			    	<i></i>
			    </div>
			    
		    </div>
		    
		    <div class="rows">
		    	<div class="rows_year">
			    	<b><span>*</span>年级<strong>请输入年级</strong></b>
			    	<p>请选择</p>
			    	<i></i>
			    </div>
			    <select name="grade" class="selects">
			    	<option value="" disabled="disabled">请选择</option>
			    	<option value="一年级">一年级</option>
			    	<option value="二年级">二年级</option>
			    	<option value="三年级">三年级</option>
			    	<option value="四年级">四年级</option>
			    	<option value="五年级">五年级</option>
			    	<option value="六年级">六年级</option>
			    </select>
		    </div>
		    
		    <div class="rows last_rows">
		    	<div class="rows_class">
			    	<b class="error"><span>*</span>班级<strong>请输入班级</strong></b>
			    	<p>
			    		<input type="text" name="wxclass" id="" class="mytext" value="" placeholder="" />
			    	</p>
			    	<i></i>
			    </div>
			    
		    </div>
			<input type="submit" value="完善资料，即可观看视频" id="mater_btn" class="mater_btn"/>
		</form>
	</div>
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
	//三级联动
	/*
	var area1 = new LArea();
    area1.init({
        'trigger': '#demo1', //触发选择控件的文本框，同时选择完毕后name属性输出到该位置
        'valueTo': '#value1', //选择完毕后id属性输出到该位置
        'keys': {
            id: 'id',
            name: 'name'
        }, //绑定数据源相关字段 id对应valueTo的value属性输出 name对应trigger的value属性输出
        'type': 1, //数据源类型
        'data': LAreaData //数据源
    });
    area1.value=[1,13,3];//控制初始位置，注意：该方法并不会影响到input的value
    */
    
   
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