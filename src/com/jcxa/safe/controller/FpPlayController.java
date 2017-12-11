package com.jcxa.safe.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcxa.safe.entity.Playrecord;
import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesvideo;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.OrderService;
import com.jcxa.safe.service.PlayService;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.VipService;
import com.jcxa.safe.service.ZanService;
import com.utils.DateUtils;




@Controller
public class FpPlayController {

	protected Logger log = Logger.getLogger(FpPlayController.class);
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
	
	@RequestMapping(value = "/fpplay")
	public String fpplay(Map<String, Object> map, HttpSession session,
			@RequestParam(value = "seriesID") Integer seriesID,
			@RequestParam(value = "id", required = false) Integer id
			) {
		
		//取出用户信息
		Users user = (Users) session.getAttribute("user");
		WxUser wxuser = (WxUser) session.getAttribute("wxuser");		
		playService.ClickRate(seriesID);
		
		int vid=0;
		int sid=0;
		// 视频集合
		List<Seriesvideo> lsvideo = null;
		lsvideo = orderService.getvideo(seriesID);
		
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
							log.info("111111111111111111111111111111111");
						}

						log.info("000000000000000000000000000000000000");
					} else {
						log.info("已经添加该课程的播放记录了已经添加该课程的播放记录了已经添加该课程的播放记录了已经添加该课程的播放记录了已经添加该课程的播放记录了已经添加该课程的播放记录了");
					}
				}		
				//视频点赞
				boolean flag = zanService.selectVideoService(user.getID(), vid);
				map.put("flag", flag);
				Integer voZan = zanService.selectZanVService(vid);
				System.out.println("视频点赞+++++++++" + voZan);
				map.put("voZan", voZan);	
				//得到每一个具体视频的信息
				Seriesvideo itemvo = orderService.playvideo(vid);
				//查询课程封面的信息
				Series sers=playService.getplaySeries(seriesID);
				String Title=sers.getTitle();
				//封面的Title
				map.put("Title", Title);
				//免费视频
				map.put("lsvideo", lsvideo);
				map.put("playing", vid);
				//视频的详细信息
				map.put("itemvo", itemvo);
				
				return "views/wxfp/fpplay.jsp";

	}
	
}
