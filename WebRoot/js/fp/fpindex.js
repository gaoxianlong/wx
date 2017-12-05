var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var path=localhostPaht+projectName;
//点击年级时 效果
$('.nav_year').on('touchstart',function(){
	if($('.nav_class').attr('data-onoff')=='true'){
		$('.nav_class').attr('data-onoff','false');
		$('.nav_right').slideUp();
		$(this).attr('data-onoff','true');
	    $('.nav_left').slideDown();
	    $('.nav_left').show();
	    navdown($('.nav_class'));
	    navup($(this));
	    
	}else{
		if($(this).attr('data-onoff')=='false'){
			$(this).attr('data-onoff','true');
		    $('.nav_left').slideDown();
		    $('.nav_left').show();
            navup($(this));
		}else{
			$(this).attr('data-onoff','false');
		    $('.nav_left').slideUp();
			navdown($(this));
		}
	}
});
//点击品类时效果
$('.nav_class').on('touchstart',function(){
	if($('.nav_year').attr('data-onoff')=='true'){
		$('.nav_year').attr('data-onoff','false');
	    $('.nav_left').slideUp();
	    $(this).attr('data-onoff','true');
	    $('.nav_right').slideDown();
	    $('.nav_right').show();
        navdown($('.nav_year'));
        navup($(this));
	}else{
		if($(this).attr('data-onoff')=='false'){
			$(this).attr('data-onoff','true');
		    $('.nav_right').slideDown();
		    $('.nav_right').show();
            navup($(this));
		}else{
			$(this).attr('data-onoff','false');
		    $('.nav_right').slideUp();
		    navdown($(this));
		}
	}
	
});
//点击导航添加焦点
navList($('.nav_left ul li'));
navList($('.nav_right ul li'));
function navList(obj){
	obj.each(function(){
		$(this).on('touchstart',function(){
			obj.removeClass('menu_active');
			$(this).addClass('menu_active');
		});
	});
}



//特效
function navup(obj){
	obj.find('i').css('background-image','url('+path+'/img/fp/up.png)');
	obj.find('span').css('color','#DF5555');
	obj.find('i').css('transform','rotate(180deg)');
	obj.find('i').css('-webkit-transform','rotate(180deg)');
	obj.find('i').css('-ms-transform','rotate(180deg)');
	obj.find('i').css('-o-transform','rotate(180deg)');
	obj.find('i').css('-moz-transform','rotate(180deg)');
}
function navdown(obj){
	obj.find('i').css('background-image','url('+path+'/img/fp/down.png)');
	obj.find('span').css('color','#090909');
    obj.find('i').css('transform','rotate(0deg)');
	obj.find('i').css('-webkit-transform','rotate(0deg)');
	obj.find('i').css('-ms-transform','rotate(0deg)');
	obj.find('i').css('-o-transform','rotate(0deg)');
	obj.find('i').css('-moz-transform','rotate(deg)');
}

$('.footlist').each(function(){
	
	if($(this).attr('da-id') == $(this).attr('value')){
		$(this).addClass('foot_active');
	} 
});

$('.navs').each(function(){
	
		if($(this).children('a').attr('data-id') == $(this).children('a').attr('value')){
			$(this).addClass('menu_active');
		} 
	});
$('.navss').each(function(){
	
	if($(this).children('a').attr('data-id') == $(this).children('a').attr('value')){
		$(this).addClass('menu_active');
	} 
});