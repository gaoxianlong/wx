package com.jcxa.safe.controller.mp;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcxa.safe.entity.Mpnext;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Seriesmp;
import com.jcxa.safe.entity.Seriesvideo;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.LoginService;
import com.jcxa.safe.service.OrderService;
import com.jcxa.safe.service.PlayService;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.VipService;
import com.jcxa.safe.service.ZanService;




@Controller
public class MpPlayController {

	protected Logger log = Logger.getLogger(MpPlayController.class);
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
	@RequestMapping(value = "/mpplay")
	public String mpplay(Map<String, Object> map, HttpSession session,
			@RequestParam(value = "seriesID") Integer seriesID,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value="prolocutor",required = false,defaultValue="a") String prolocutor) {
		
		
		playService.ClickRatemp(seriesID);
		int vid=0;
		String show=null;
		List<Seriesvideo> lsvideo = null;// 免费音频集合
		List<Seriesvideo> videopay = null;// 付费音频集合
		
			
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
		
		
		lsvideo = orderService.getvideomp(seriesID);
		int size=lsvideo.size();
		
		//查询音频封面的信息
		Seriesmp sers=playService.getplaySeriesmp(seriesID);
		
		//取出音频封面的Title
		String Title=sers.getTitle();
		//取出音频封面的图片
		String bg=sers.getPicURL();
		//音频的价格
		int price=sers.getRealPrice();
		String pric=String.valueOf(price);
		
	
		int ids = 0;
		if(id ==null){
			
			//得到封面默认的第一个音频ID
			for (int i = 0; i < lsvideo.size(); i++) {
				ids = lsvideo.get(0).getID();
			}
			
		}
		
		//给具体音频的ID赋值
		if(id==null){
			vid=ids;
		}else{
			vid=id;
		}
		
		
		// 添加播放记录
//		if (vid != 0) {
//			if (orderService.getrecordmp(user.getID(), vid)) {
//				try {
//					
//					Playrecord record=new Playrecord();
//					record.setUid(user.getID());
//					record.setVid(vid);
//					record.setAddtimes(DateUtils.getFormatDateYMDHMS());
//					orderService.addrecordmp(record);
//				} catch (Exception e) {
//					
//				}
//
//				
//			} else {
//				
//			}
//		}
		//得到每一个具体音频的信息
		Seriesvideo itemvo = orderService.playvideomp(vid);
		//得到下一个具体音频的信息
		
		int maxsort = 0;
		if(vid != 0){
			
			
			 maxsort = lsvideo.get(lsvideo.size() - 1).getSort();
		}
		
		int topsort=1;
		int nextsort = 0;
		
		int topid=0;
		int nextid = 0;
		
		if(vid != 0){

			if (itemvo.getSort() < maxsort) {
				nextsort = itemvo.getSort() + 1;
			} else {
				nextsort = 1;
			}
			
			if(itemvo.getSort()>1){
				topsort=itemvo.getSort() - 1;
			}else{
				topsort=maxsort;
			}
		Seriesvideo nextitemvo = orderService.selnextmp(seriesID, nextsort);
		Seriesvideo topitemvo = orderService.selnextmp(seriesID, topsort);
		
	   //得到下一个具体音频的ID
	    nextid = nextitemvo.getID();
	    topid = topitemvo.getID();
	
		}

//视频点赞

//boolean flag = this.zanService.selectVideoService(user.getID(), vid);
//Integer voZan = this.zanService.selectZanVService(vid);
//System.out.println("视频点赞+++++++++" + voZan);
//map.put("voZan", voZan);
//map.put("flag", Boolean.valueOf(flag));
		
		
		
		//封面的图片
		map.put("bg", bg);
		//封面的Title
		map.put("Title", Title);
		//免费音频
		map.put("lsvideo", lsvideo);
	
		//音频的详细信息
		map.put("itemvo", itemvo);
		//下一个音频的ID
		map.put("nextid", nextid);
		//上一个音频的ID
		map.put("topid", topid);
		//当前播放音频的ID
		map.put("playing", vid);
		
		//当前音频的seriesid
		map.put("nowserid", seriesID);
		
		map.put("size",size);
		
		map.put("prolocutorplay", prolocutorplay);
		return "/views/wxaudio/audioing.jsp";


	}
	
	
	// json
	@RequestMapping(value = "/mpplayjson")
	@ResponseBody
	public Mpnext mpplayjson(Map<String, Object> map, HttpSession session,
			@RequestParam(value = "seriesID") Integer seriesID,
			@RequestParam(value = "id", required = false) Integer id
			) {
				playService.ClickRatemp(seriesID);
		
				int vid=0;
				String show=null;
				List<Seriesvideo> lsvideo = null;// 免费音频集合
				List<Seriesvideo> videopay = null;// 付费音频集合
				
				lsvideo = orderService.getvideomp(seriesID);
				//取出用户信息
				Users user = (Users) session.getAttribute("user");
				WxUser wxuser = (WxUser) session.getAttribute("wxuser");
				//查询音频封面的信息
				Seriesmp sers=playService.getplaySeriesmp(seriesID);
				//取出音频封面的Title
				String Title=sers.getTitle();
				//取出音频封面的图片
				String bg=sers.getPicURL();
				//音频的价格
				int price=sers.getRealPrice();
				String pric=String.valueOf(price);
				
				int ids = 0;
				if(id ==null){
					//得到封面默认的第一个音频ID
					for (int i = 0; i < lsvideo.size(); i++) {
						ids = lsvideo.get(0).getID();
					}	
				}
					//给具体音频的ID赋值
					if(id==null){
						vid=ids;
					}else{
						vid=id;
					}
				//得到每一个具体音频的信息
				Seriesvideo itemvo = orderService.playvideomp(vid);
				//得到下一个具体音频的信息
				int maxsort = 0;
				if(vid != 0){
					 maxsort = lsvideo.get(lsvideo.size() - 1).getSort();
				}
					int topsort=1;
					int nextsort = 0;
					int topid=0;
					int nextid = 0;
				
				if(vid != 0){
					if (itemvo.getSort() < maxsort) {
						nextsort = itemvo.getSort() + 1;
					} else {
						nextsort = 1;
					}
					
					if(itemvo.getSort()>1){
						topsort=itemvo.getSort() - 1;
					}else{
						topsort=maxsort;
					}
						Seriesvideo nextitemvo = orderService.selnextmp(seriesID, nextsort);
						Seriesvideo topitemvo = orderService.selnextmp(seriesID, topsort);
						//得到下一个具体音频的ID
						nextid = nextitemvo.getID();
						topid = topitemvo.getID();
				}
				String url=itemvo.getVideoURL();
				Mpnext mpnext =new Mpnext();
				mpnext.setBg(bg);
				mpnext.setTitle(Title);
				mpnext.setUrl(url);
				mpnext.setNext(nextid);
				mpnext.setTop(topid);
				mpnext.setId(vid);
				mpnext.setSerid(seriesID);
				
				return mpnext;


	}
	
}
