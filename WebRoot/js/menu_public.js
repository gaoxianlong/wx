var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var path=localhostPaht+projectName;

//点击年级时 效果
$('.nav_menu .nav_list').each(function(){
	$(this).on('touchstart',function(){
		var page = $(this).index();
		var arr = $(this).siblings();
		if($(this).attr('data-onoff')=='true'){
			$(this).attr('data-onoff','false');
			navdown($(this));
			$('.nav_wrap .menu_con').eq(page).slideUp();
			arr.attr('data-onoff','false');
			navdown(arr);
			$('.nav_wrap .menu_con').eq(page).siblings().slideUp();
			
		}else{
			$(this).attr('data-onoff','true');
			navup($(this));
			$('.nav_wrap .menu_con').eq(page).slideDown();
			arr.attr('data-onoff','false');
			navdown(arr);
			$('.nav_wrap .menu_con').eq(page).siblings().slideUp();
		}
	});
});
//点击导航添加焦点
$('.nav_wrap .menu_con').each(function(){
	navList($(this).find('li'));
});
function navList(obj){
	obj.each(function(){
		$(this).on('touchstart',function(){
			$(this).addClass('menu_active').siblings().removeClass('menu_active');
			
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
