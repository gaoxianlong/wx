package com.jcxa.safe.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcxa.safe.entity.Order;
import com.jcxa.safe.entity.Playrecord;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesvideo;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.entity.Wxorder;
import com.jcxa.safe.service.LoginService;
import com.jcxa.safe.service.OrderService;
import com.jcxa.safe.service.PlayService;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.VipService;
import com.jcxa.safe.service.ZanService;
import com.utils.DateUtils;




@Controller
public class PlayController {

	protected Logger log = Logger.getLogger(PlayController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private PlayService playService;
	@Autowired
	private VipService vipService;
	@Autowired
	private ZanService zanService;
	@Autowired
	private ProlocutorService prolocutorService;
	@Autowired
	private LoginService loginService;
	@RequestMapping(value = "/play")
	public String play(Map<String, Object> map, HttpSession session,
			@RequestParam(value = "seriesID") Integer seriesID,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor) {
		
		
			playService.ClickRate(seriesID);
			int vid=0;
			String show=null;
			List<Seriesvideo> lsvideo = null;// 免费视频集合
			List<Seriesvideo> videopay = null;// 付费视频集合
			int sid=0;
			String eqq=null;
			//取出用户信息
			Users user = (Users) session.getAttribute("user");
			WxUser wxuser = (WxUser) session.getAttribute("wxuser");
			
			String prolocutorplay="a";
			if(user!=null){
				prolocutorplay=prolocutorService.selspro(user.getID());
			}
			
			
			if(!prolocutor.equals("a")){
				
				//当前自己的状态
				String openid=wxuser.getOpenid();
				//int proid=prolocutorService.selproid(prolocutor);
				int WXopenid=0;
				try {
					WXopenid=prolocutorService.selproopenidd(prolocutor);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String Openidchuan="a";
				//传过来的状态
				if(WXopenid!=0){
					 Openidchuan=prolocutorService.wxuseropenidd(WXopenid);
				}
					if(openid != Openidchuan){		
						//自己是否已经成为了下级
					  if(prolocutorService.onlydaiyan(openid)){
						  //判断自己是否已经主动成为了代理人
						//String spro=prolocutorService.selspro(nowid);
						  int zhuid=prolocutorService.openidzhu(openid);
						  
						  String spro="a";
						  try {
							  spro=prolocutorService.wxprolocutor(zhuid);
						} catch (Exception e) {
							// TODO: handle exception
							spro="a";
						}
						 
							if(spro.equals("a")){
							java.sql.Date nowSql = new java.sql.Date(System.currentTimeMillis());
							Prolocutor ps=new Prolocutor();
							ps.setProlocutor(prolocutor);
							ps.setOpenid(openid);
							ps.setCreateTime(nowSql);
							prolocutorService.adddaiyan(ps);
							
							}
				
						}
			
					}
	
				}
		
		
		
		
		
		//查询课程封面的信息
		Series sers=playService.getplaySeries(seriesID);
		
		log.info(sers.toString());
		//是否是同步课程
		String syn=sers.getSyn();
		//取出课程封面的Title
		String Title=sers.getTitle();
		//课程的价格
		int price=sers.getRealPrice();
		String pric=String.valueOf(price);
		
		if(syn.equals("sy")){
			//同步课程
			
			if(vipService.judvip(user.getID())){
				
				//是VIP
				
				//获取VIP的到期时间
				Wxorder wx=vipService.getwxorder(user.getID());
				Date now = new Date(); 
				Date over=wx.getOvertime();
				
				Long dat=now.getTime();
				Long ove=over.getTime();
				System.out.println(dat+"ccccc9999999999999999999999999999999999999999999999999999999999999999999999");
				System.out.println(ove+"ddddd8888888888888888888888888888888888888888888888888888888888888888888888");
				if(dat<ove){
					
					//是VIP,VIP未到期
					lsvideo = orderService.getvideo(seriesID);	
					show="sho";
				}else{
					//是VIP,VIP到期
					
					
					//验证是否购买该课程
					boolean ord = orderService.getorderserid(user.getID(), seriesID);
					   Date nowplay = new Date(); 
			    	   Long datplay=nowplay.getTime();
			    	   
			    	   Long oveplay = (long) 1;
			    	   if(vipService.getoornotnull(user.getID(), seriesID)){
			    		   
			    		Order or=vipService.getOrders(user.getID(), seriesID);
			   			Date overplay=or.getOvertime();
			   			oveplay=overplay.getTime();
			    	   }  
					
					if (ord&&datplay<oveplay) {
						lsvideo = orderService.getvideo(seriesID);
						show="sho";
					} else {
						lsvideo = orderService.videofree(seriesID);
						videopay = orderService.videopay(seriesID);
						show="nosho";
					}
						
				}	
				
			}else{
				
				//不是VIP
				
				//验证是否购买该课程
				boolean ord = orderService.getorderserid(user.getID(), seriesID);
				
				 Date nowplay = new Date(); 
		    	   Long datplay=nowplay.getTime();
		    	   
		    	   Long oveplay = (long) 1;
		    	   if(vipService.getoornotnull(user.getID(), seriesID)){
		    		   
		    		Order or=vipService.getOrders(user.getID(), seriesID);
		   			Date overplay=or.getOvertime();
		   			oveplay=overplay.getTime();
		    	   }
				if (ord&&datplay<oveplay) {
					lsvideo = orderService.getvideo(seriesID);
					show="sho";
				} else {

					lsvideo = orderService.videofree(seriesID);
					videopay = orderService.videopay(seriesID);
					show="nosho";
				}	
				
			}
			
			
		}
		
		else if(syn.equals("hobby")){
			//兴趣课程
			
			if(vipService.judvip(user.getID())){
				
				//是VIP
				
				//获取VIP的信息
				Wxorder wx=vipService.getwxorder(user.getID());
				//获取VIP的类别
				String vipsort=wx.getVipsort();
				//获取VIP的到期时间
				Date now = new Date(); 
				Date over=wx.getOvertime();
				Long dat=now.getTime();
				Long ove=over.getTime();
				
				if(dat<ove){
					
					//是VIP,VIP未到期
					
						//是VIP,VIP未到期,VIP级别高
						lsvideo = orderService.getvideo(seriesID);
						show="sho";
				}else{
					//是VIP,VIP到期
					
					//验证是否购买该课程
					boolean ord = orderService.getorderserid(user.getID(), seriesID);
					   Date nowplay = new Date(); 
			    	   Long datplay=nowplay.getTime();
			    	   
			    	   Long oveplay = (long) 1;
			    	   if(vipService.getoornotnull(user.getID(), seriesID)){
			    		   
			    		Order or=vipService.getOrders(user.getID(), seriesID);
			   			Date overplay=or.getOvertime();
			   			oveplay=overplay.getTime();
			    	   }
					if (ord&&datplay<oveplay) {
						lsvideo = orderService.getvideo(seriesID);
						show="sho";
					} else {

						lsvideo = orderService.videofree(seriesID);
						videopay = orderService.videopay(seriesID);
						show="nosho";
					}	
				}
			}else{
				
				//不是VIP
				
				//验证是否购买该课程
				boolean ord = orderService.getorderserid(user.getID(), seriesID);
				   Date nowplay = new Date(); 
		    	   Long datplay=nowplay.getTime();
		    	   
		    	   Long oveplay = (long) 1;
		    	   if(vipService.getoornotnull(user.getID(), seriesID)){
		    		   
		    		Order or=vipService.getOrders(user.getID(), seriesID);
		   			Date overplay=or.getOvertime();
		   			oveplay=overplay.getTime();
		    	   }
				if (ord&&datplay<oveplay) {
					lsvideo = orderService.getvideo(seriesID);
					show="sho";
				} else {

					lsvideo = orderService.videofree(seriesID);
					videopay = orderService.videopay(seriesID);
					show="nosho";
				}
				
			}	
		}
		//
		else if(syn.equals("vphigh")){
			//兴趣课程
			
			if(vipService.judvip(user.getID())){
				
				//是VIP
				
				//获取VIP的信息
				Wxorder wx=vipService.getwxorder(user.getID());
				//获取VIP的类别
				String vipsort=wx.getVipsort();
				//获取VIP的到期时间
				Date now = new Date(); 
				Date over=wx.getOvertime();
				Long dat=now.getTime();
				Long ove=over.getTime();
				System.out.println(dat+"ffff888888888888888888888888888888888888888888888888888888888888888888");
				System.out.println(ove+"ffff777777777777777777777777777777777777777777777777777777777777777777");
				if(dat<ove){
					//是VIP,VIP未到期
					if(vipsort.equals("1")){
						//是VIP,VIP未到期,VIP级别高
						System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000");
						lsvideo = orderService.getvideo(seriesID);
						show="sho";
					}else{
						//是VIP,VIP未到期,VIP级别低
						
						//验证是否购买该课程
						boolean ord = orderService.getorderserid(user.getID(), seriesID);
						 Date nowplay = new Date(); 
				    	   Long datplay=nowplay.getTime();
				    	   
				    	   Long oveplay = (long) 1;
				    	   if(vipService.getoornotnull(user.getID(), seriesID)){
				    		   
				    		Order or=vipService.getOrders(user.getID(), seriesID);
				   			Date overplay=or.getOvertime();
				   			oveplay=overplay.getTime();
				    	   }
						if (ord&&datplay<oveplay) {
							System.out.println("111111111111111111111111111111111111111111111111111111111111111111111");
							lsvideo = orderService.getvideo(seriesID);
							show="sho";
						} else {
							System.out.println("2222222222222222222222222222222222222222222222222222222222222222222222");
							lsvideo = orderService.videofree(seriesID);
							videopay = orderService.videopay(seriesID);
							show="nosho";
						}
					}
						
				}else{
					//是VIP,VIP到期
					
					//验证是否购买该课程
					boolean ord = orderService.getorderserid(user.getID(), seriesID);
					 Date nowplay = new Date(); 
			    	   Long datplay=nowplay.getTime();
			    	   
			    	   Long oveplay = (long) 1;
			    	   if(vipService.getoornotnull(user.getID(), seriesID)){
			    		   
			    		Order or=vipService.getOrders(user.getID(), seriesID);
			   			Date overplay=or.getOvertime();
			   			oveplay=overplay.getTime();
			    	   }
					if (ord&&datplay<oveplay) {
						System.out.println("333333333333333333333333333333333333333333333333333333333333333333333333333333");
						lsvideo = orderService.getvideo(seriesID);
						show="sho";
					} else {
						System.out.println("44444444444444444444444444444444444444444444444444444444444444444444444444444444");
						lsvideo = orderService.videofree(seriesID);
						videopay = orderService.videopay(seriesID);
						show="nosho";
					}
				}
				
			}else{
				
				//不是VIP
				
				System.out.println("5555555555555555555555555555555555555555555555555555555555555555");
				//验证是否购买该课程
				boolean ord = orderService.getorderserid(user.getID(), seriesID);
				
				   Date nowplay = new Date(); 
		    	   Long datplay=nowplay.getTime();
		    	   
		    	   Long oveplay = (long) 1;
		    	   if(vipService.getoornotnull(user.getID(), seriesID)){
		    		   
		    		Order or=vipService.getOrders(user.getID(), seriesID);
		   			Date overplay=or.getOvertime();
		   			oveplay=overplay.getTime();
		    	   }
				if (ord&&datplay<oveplay) {
					lsvideo = orderService.getvideo(seriesID);
					show="sho";
				} else {

					lsvideo = orderService.videofree(seriesID);
					videopay = orderService.videopay(seriesID);
					show="nosho";
				}
				
			}	
		}
		
		//
		else{
			//不同步课程
			
			//验证是否购买该课程
			boolean ord = orderService.getorderserid(user.getID(), seriesID);
			    Date nowplay = new Date(); 
	    	    Long datplay=nowplay.getTime();
	    	   
	    	    Long oveplay = (long) 1;
	    	    if(vipService.getoornotnull(user.getID(), seriesID)){
	    		   
	    		Order or=vipService.getOrders(user.getID(), seriesID);
	   			Date overplay=or.getOvertime();
	   			oveplay=overplay.getTime();
	    	   }
			if (ord&&datplay<oveplay) {
				lsvideo = orderService.getvideo(seriesID);
				show="sho";
			} else {

				lsvideo = orderService.videofree(seriesID);
				videopay = orderService.videopay(seriesID);
				show="nosho";
			}
			
		}
		
		
		int ids = 0;
		if(id ==null){
			
			//得到封面默认的第一个视频ID
			for (int i = 0; i < lsvideo.size(); i++) {
				ids = lsvideo.get(0).getID();
			}
			
		}
		
		//给具体视频的ID赋值
		if(id==null){
			vid=ids;
		}else{
			vid=id;
		}
		
		// 添加播放记录
		if (vid != 0) {
			if (orderService.getrecord(user.getID(), vid)) {
				try {
					
					Playrecord record=new Playrecord();
					record.setUid(user.getID());
					record.setVid(vid);
					record.setAddtimes(DateUtils.getFormatDateYMDHMS());
					orderService.addrecord(record);
				} catch (Exception e) {
					
				}

					
			} else {
					
			}
		}
		//得到每一个具体视频的信息
		Seriesvideo itemvo = orderService.playvideo(vid);
		//得到下一个具体视频的信息
		
		int maxsort = 0;
		if(id != null){
			 maxsort = lsvideo.get(lsvideo.size() - 1).getSort();
		}
		
			int nextsort = 0;
			int nextid = 0;
			
			if(id != null){
				
				if (itemvo.getSort() < maxsort) {
					nextsort = itemvo.getSort() + 1;
				} else {
					nextsort = maxsort;
				}
				Seriesvideo nextitemvo = orderService.selnext(seriesID, nextsort);
				//得到下一个具体视频的ID
				 nextid = nextitemvo.getID();	
			}

		//视频点赞
		
		boolean flag = this.zanService.selectVideoService(user.getID(), vid);
		Integer voZan = this.zanService.selectZanVService(vid);
		System.out.println("视频点赞+++++++++" + voZan);
		map.put("voZan", voZan);
		map.put("flag", Boolean.valueOf(flag));
		
		//封面的Title
		map.put("Title", Title);
		//免费视频
		map.put("lsvideo", lsvideo);
		//付费视频
		map.put("videopay", videopay);
		//视频的详细信息
		map.put("itemvo", itemvo);
		//下一个视频的ID
		map.put("nextid", nextid);
		//当前播放视频的ID
		map.put("playing", vid);
		//当前视频的价格
		map.put("pric", pric);
		//是否显示支付提示
		map.put("show", show);
		//当前视频的seriesid
		map.put("nowserid", seriesID);
		
		map.put("zhuanqu", "cost");
		
		map.put("prolocutorplay", prolocutorplay);
		return "views/wxplay.jsp";

	}
	
}
