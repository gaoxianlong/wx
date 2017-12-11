// path
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPaht=curWwwPath.substring(0,pos);
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
var path=localhostPaht+projectName;
//初始化
var timer;
var num = 1;
var isPlaying = true; //音频播放状态 true播放中 
var $width = 0;
var slider = 10;
var curmargin = 0.34;//进度条圆点本身的margin-left
var player = $("#audio")[0]; /*jquery对象转换成js对象*/
var container = document.querySelector('.singerimg');
var $image = container.querySelector('img');
var playingBtn = document.getElementById('playing_btn');
//初始化
fntimer();
//暂停效果
//暂停效果
playingBtn.addEventListener('click',function bindEvent(){
    if (num == 1){ /*如果已经播放*/
   	    player.pause();/*暂停*/
        clearInterval(timer);
        this.style.background = 'url('+path+'/img/audio/playing_btn.png) no-repeat center';
        this.style.backgroundSize = '2.04rem 2.04rem';
        this.style.webkitBackgroundSize = '2.04rem 2.04rem';
        num++;
	    pause();
        return num;
    }else {
        player.play(); /*播放*/
        fntimer();
        this.style.background = 'url('+path+'/img/audio/play_stop.png) no-repeat center';
        this.style.backgroundSize = '2.04rem 2.04rem';
        this.style.webkitBackgroundSize = '2.04rem 2.04rem';
        num=1;
        play();
        return num;
    }
});
//上一个音频
$('#prev_btn').on('click',function(){
	var top=$('#top').val();
	var next=$('#next').val();
	var serid=$('#serid').val();
	
//	$.ajax({
//		url : "mpplayjson",
//		type : "POST",
//		
//		data : {
//			"seriesID" : serid,	
//			"id"       : top
//		},
//		success : function(msgs) {
//			alert(msgs.url);
//			$('#audio').attr('src','http://oss.shoutike.com/stkmp3/20171206/'+msgs.url+'');
//			$('#circle').attr('src','http://localhost:8080/STK/cover/'+msgs.bg+'');
//			$('.bg').css('background','url("http://localhost:8080/STK/cover/'+msgs.bg+'") no-repeat center');
//			$('.bg').css('background-size','cover');
//			$('.bg').css('-webkit-background-size','cover');
//		},
//		error : function(res) {
//			//alert(res.responseText);
//			alert("0000000");
//		}
//	});
	
	

	
	
	
	
	//lyric("s,s,s,s,s");
	window.location.href=''+path+'/mpplay?seriesID='+serid+'&id='+top;
});
//下一个音频
$('#next_btn').on('click',function(){
	var top=$('#top').val();
	var next=$('#next').val();
	var serid=$('#serid').val();
	
	window.location.href=''+path+'/mpplay?seriesID='+serid+'&id='+next;
});

//进度条移动
fnslider();
function fnslider(){
	$('#cur-btn').on('touchstart',function(e){
		
		var disx = 0;
	    var movedisx = 0;
	    var nowtime = 0;
	    var nowleft = $width;
		clearInterval(timer);
		//点击圆点时 当前的left值
		disx = e.originalEvent.targetTouches[0].pageX*2/50;
		$('.wx_wrap').on('touchmove',function(e){
			
			//鼠标或者手指移动的距离
			movedisx = e.originalEvent.targetTouches[0].pageX*2/50;
	        $width  = movedisx - disx + nowleft;
			if($width < 0)$width = 0;
			if($width > slider)$width = slider;
			$('#process-cur').css('width',$width+'rem');
	        $('#cur-btn').css('left',$width+'rem');
	        //根据移动的距离计算出需要播放的当前时间
	        nowtime = $width/slider*player.duration;
	        sToM(nowtime,$('#currentTime'));
		});
		$('.wx_wrap').on('touchend',function(e){
			
			//鼠标手指抬起时 设置改变当前播放时间
			var $currentTime = $width/slider*player.duration;
			player.currentTime = $currentTime;
			if('fastSeek' in player){
			    player.fastSeek($currentTime);//改变audio.currentTime的值
			}else if(player.seekable.start(0)<= $currentTime <=player.seekable.end(0)){
				//获得第一个以秒计的音频可寻址范围（部分）：
				player.currentTime = $currentTime;
			}else{
				//如果以上都不满足 就设置播放时间为缓冲到最大位置的时间
				//player.buffered表示音频已缓冲部分的
				player.currentTime = player.buffered.end(player.buffered.length-1);
			}
			fntimer();
			$('.wx_wrap').off('touchmove');
			$('.wx_wrap').off('touchend');
		});
	});
}




//每隔一秒获取当前播放时间 放到页面
function fntimer(){
	timer = setInterval(function(){
		//当前时间转成分秒
		sToM(player.currentTime,$('#currentTime'));
		sToM(player.duration,$('#total-time'));
		//进度条
		$width = audio.currentTime/audio.duration*slider;
		$('#process-cur').css('width',$width+'rem');
		$('#cur-btn').css('left',$width+'rem');
		if(audio.currentTime == audio.duration){
			clearInterval(timer);
//			$(this).css('background-position-y','-13.98rem');
			//alert('播放结束跳转下一页');
			
			 var top=$('#top').val();
			 var next=$('#next').val();
			 var serid=$('#serid').val();
			
			 var curWwwPath=window.document.location.href;
			 var pathName=window.document.location.pathname;
			 var pos=curWwwPath.indexOf(pathName);
			 var localhostPaht=curWwwPath.substring(0,pos);
			 var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
			 var path=localhostPaht+projectName;
			 window.location.href=''+path+'/mpplay?seriesID='+serid+'&id='+next;
		}
	},1000);
}


//展示字幕函数封装
function lyric(lyric){
	$('.audio_lrc ul').html('');
	var lrc = lyric.split(',');
    for (var i = 0; i < lrc.length; i++) {
        $('<li>').html(lrc[i]==''?'&nbsp':lrc[i]).appendTo($('.audio_lrc ul'));
    }
}

//切换字幕
$('.music_menu').on('click',function(){
	if($(this).attr('data-onoff')=='false'){
		$(this).attr('data-onoff','true');
		$('.audio_singer').hide();
		$('.lrc_mask').show();
		$(this).css('background','url('+path+'/img/audio/lrcicon01.png) no-repeat center');
		$(this).css('background-size','1.12rem 0.72rem');
		$(this).css('-webkit-background-size','1.12rem 0.72rem');
	}else{
		$(this).attr('data-onoff','false');	
		$('.lrc_mask').hide();
		$('.audio_singer').show();
		$(this).css('background','url('+path+'/img/audio/lrcicon.png) no-repeat center');
		$(this).css('-webkit-background-size','1.12rem 0.72rem');
	}
});


//选集
$('.loop').on('click',function(){
	$('.footer').hide();
//	$('.mask_list').slideDown();
	$('.mask_list').show();
	$('.sel_title').hide();
	
});
//选集菜单关闭
$('.lists_close').on('click',function(){
	$('.footer').show();
//	$('.mask_list').slideUp();
	$('.mask_list').hide();
	$('.sel_title').show();
});

//分钟转化成秒
function minToSec (StrTime) {
    var arr=StrTime.split(':');
    var sec=parseFloat((parseFloat(arr[0])*60+parseFloat(arr[1])).toFixed(2));
    return sec;
}
//将秒换算成分钟 换算后放入相应标签里函数
function sToM (sec,name) {
	var m=Math.floor(sec/60);
	var s=Math.floor(sec%60);	
	name.html(toZero (m)+':'+toZero (s));
}
//补零函数
function toZero(n){
    return n<10? '0'+n:''+n;
}

//暂停图片动画
function pause() {
    var iTransform = getComputedStyle($image).transform;
    var cTransform = getComputedStyle(container).transform;
    container.style.transform = cTransform === 'none'? iTransform: iTransform.concat(' ', cTransform);
    $image.classList.remove('anmiting');
    //$image.classList.add('anmitnomal');
    //console.log($image.classList);
}
//开始播放时 动画图片旋转
function play() {
	//$image.classList.remove('anmitnomal');
    $image.classList.add('anmiting');
}