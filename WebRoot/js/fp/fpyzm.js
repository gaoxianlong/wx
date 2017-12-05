
//未注册优惠码 点击课程的弹窗效果
$('#wxyzm').blur(function(){
	yhm($(this));
		
	youhuima();
});
$('#wxyzm').focus(function(){
	$(".error2").hide();
});

//点击提交扶贫优惠码
$('#yzm-sub').submit(function(e){
	var Pval = $("#wxyzm").val();
	yhm($('#wxyzm'));
	 
	
	if(!youhuima()){
		
		alert('绑定失败');
		e.preventDefault();
	}
	
});

//优惠码验证
function yhm(obj){
	var Pval = obj.val();
	
	reg1 = /^STK\d{15}$/;
 
	if (Pval == ''){
	      $('#error').addClass("error2");
	      $(".error2").html("*请填写优惠码");
	      $(".error2").show();
	//    $("#preferential").val("");
	}else if (Pval.length != 18||!(reg1.test(Pval))) {
	      $('#error').addClass("error2");
	      $(".error2").html("*优惠码为以STK开头后面是数字的18个字符");
	      $(".error2").show();
	//    $("#preferential").val("");
	}else {
	  	
		$.post("selectHelpCode","HelpCode="+Pval,function(date){
			
			if(date.length<5){
				$('#error').addClass("error2");
		        $(".error2").html("*优惠码正确");
		        $(".error2").css('color','green');
		        $(".error2").show();
		      	
			}else{
				$('#error').addClass("error2");
		        $(".error2").html("*您输入的优惠码输入错误");
		        $(".error2").show();
	//	        $("#preferential").val("");
		       
			}
		});
	   
	}

}
function youhuima(){
	
	
	if($(".error2").html().length>6){
		return false;	
	}else{
		return true;
	}
}
