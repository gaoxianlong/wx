//视频点赞
var uid=$("#uid").val();
var vid=$("#vid").val();

var addzan={
		url:"addzan.action?uid="+uid+"&vid="+vid,
        type: "POST",  
        dataType: 'json',    	
};
var deletezan={
		url:"deleteZanvo.action?uid="+uid+"&vid="+vid,
        type: "POST",  
        dataType: 'json',
};
$('.dz_btn').each(function(){
	if($(this).attr('data-btn') == 'true'){
		$(this).css('background-position','0 -0.88rem');
		}else{
		$(this).css('background-position','-0.84rem -0.88rem');
		}
});
//点赞
$('.dz_btn').on('touchstart',function(){
	if($(this).attr('data-btn') == 'false'){
	 $.ajax(addzan); 
		var num = parseInt($(this).next().html());
		$(this).attr('data-btn','true');
		$(this).css('background-position','0 -0.88rem');
		$(this).next().html(num+1);
		
	}else{
		 $.ajax(deletezan); 
		var num = parseInt($(this).next().html());
		$(this).attr('data-btn','false');
		$(this).css('background-position','-0.84rem -0.88rem');
		$(this).next().html(num-1);
	}
});

//点击收起播放列表
$('.kc_btn').attr('data-onoff','true');
$('.kc_btn').on('touchstart',function(){
	if($(this).attr('data-onoff') == 'true'){
		$(this).attr('data-onoff','false');
		$(this).css('background-position','-4.04rem 0');
		$('.play_list').slideUp();
	}else{
		$(this).attr('data-onoff','true');
		$(this).css('background-position','-3.2rem 0');
		$('.play_list').slideDown();
	}
	
});
