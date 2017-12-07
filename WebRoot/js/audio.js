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
var $width = 0;
var slider = 10;
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
        //$('.singerimg img').removeClass('anmiting');  
        //$(this).css('background-position-y','-11.9rem');
        this.style.backgroundPositionY = '-11.9rem';
        num++;
	    pause();
        return num;
    }else {
        player.play(); /*播放*/
        fntimer();
        //$('.singerimg img').addClass('anmiting');
        //$(this).css('background-position-y','-13.98rem');
        this.style.backgroundPositionY = '-13.98rem';
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




//每隔一秒获取当前播放时间 放到页面
function fntimer(){
	timer = setInterval(function(){
		//当前时间转成分秒
		sToM(player.currentTime,$('#currentTime'));
		sToM(player.duration,$('#total-time'));
		//进度条
		$width = audio.currentTime/audio.duration*slider+'rem';
		$('#process-cur').css('width',$width);
		$('#cur-btn').css('left',$width);
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
		$('.audio_lrc').show();
	}else{
		$(this).attr('data-onoff','false');	
		$('.audio_lrc').hide();
		$('.audio_singer').show();
	}
});
//选集
$('.loop').on('click',function(){
	$('.footer').hide();
//	$('.mask_list').slideDown();
	$('.mask_list').show();
	
});
//选集菜单关闭
$('.lists_close').on('click',function(){
	$('.footer').show();
//	$('.mask_list').slideUp();
	$('.mask_list').hide();
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