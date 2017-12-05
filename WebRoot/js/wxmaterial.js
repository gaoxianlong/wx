//输入时 i标签的图标隐藏
$('.mytext').focus(function(){
	$(this).parent().next().hide();
	$(this).css('outline','none');
	$(this).parents('.rows').removeClass('error');
	$('.mytext').blur(function(){
		$(this).parent().next().show();
		texts($(this));
	});
});

//监控select下拉框选中
$('.selects').each(function(){
	$(this)[0].selectedIndex = -1;
	$(this).change(function(){
		var $value = $(this).val();
		$(this).prev().children('p').html($value);
		$(this).parents('.rows').removeClass('error');
	});
});

//点击完善资料即可观看视频按钮
$('#mater_payform').submit(function(e){
	if(phones()||!texts($('#value2'))||!texts($('#pay_school'))||!selects($('#pay_year'))||!texts($('#pay_class'))){
		e.preventDefault();
		alert('请完善资料');
		phones();
		texts($('#value2'));
		texts($('#pay_school'));
		selects($('#pay_year'));
		texts($('#pay_class'));
	}
});
function phones(){
	if($('.rows_phone p').html() == '未绑定'){
		$('.rows_phone p').parents('.rows').addClass('erro');
		return false;
	}else{
		return true;
	}
}
//select 选框判断是否有值
function selects(obj){
	if(obj.val() == null){
		obj.parents('.rows').addClass('error');
		return false;
	}else{
		obj.parents('.rows').removeClass('error');
		return true;
	}
}

function texts(obj){
	if(obj.val() == ''){
		obj.parents('.rows').addClass('error');
		return false;
	}else{
		obj.parents('.rows').removeClass('error');
		return true;
	}
}

	$('#wxfpphone').submit(function(e){
		alert("修改成功！");
	});
