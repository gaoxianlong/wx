package com.jcxa.safe.controller.mp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jcxa.safe.entity.Prolocutor;
import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesmp;
import com.jcxa.safe.entity.Users;
import com.jcxa.safe.entity.WxUser;
import com.jcxa.safe.service.ProlocutorService;
import com.jcxa.safe.service.SeriesService;
import com.jcxa.safe.entity.Type;

@Controller
public class MpController {
	protected Logger log = Logger.getLogger(MpController.class);

	@Autowired
	private SeriesService seriesService;
	@Autowired
	private ProlocutorService prolocutorService;

	// 查询二级菜单视频
	@RequestMapping(value = "/wxmp")
	public String wxindexser(
			Map<String, Object> map,
			@RequestParam(value = "id") int id,
			HttpSession session,
			@RequestParam(value = "prolocutor", required = false, defaultValue = "a") String prolocutor) {
		List<Type> type = null;
		List<Type> tyer = null;
		List<Seriesmp> seriesmp = null;
		type = seriesService.wxgetMulvsan(0);
		tyer = seriesService.wxgetMulvsan(id);
		// 取出用户信息
		Users user = (Users) session.getAttribute("user");
		WxUser wxuser = (WxUser) session.getAttribute("wxuser");
		String prolocutorindex = "a";
		if (user != null) {
			// 当用户不为null时 通过用户的id查询参数
			prolocutorindex = prolocutorService.selspro(user.getID());

		}
		if (!prolocutor.equals("a")) {
			System.out.println("我得参数不为a");
			// 当前自己的状态
			String openid = wxuser.getOpenid();
			// int proid=prolocutorService.selproid(prolocutor);
			int WXopenid = 0;
			System.out.println(openid + "77777777777");
			try {
				// 根据传的参数去查user 信息
				WXopenid = prolocutorService.selproopenidd(prolocutor);
				System.out.println("对方的id=" + WXopenid);
			} catch (Exception e) {
				// TODO: handle exception
			}

			String Openidchuan = "a";
			// 传过来的状态
			if (WXopenid != 0) {
				// 查询微信表信息
				Openidchuan = prolocutorService.wxuseropenidd(WXopenid);
			}
			if (openid != Openidchuan) {
				// 自己是否已经成为了下级
				System.out.println("是不是自己本身");
				if (prolocutorService.onlydaiyan(openid)) {
					// 判断自己是否已经主动成为了代理人
					// String spro=prolocutorService.selspro(nowid);
					System.out.println("判断自己是否已经主动成为了代理人");
					int zhuid = prolocutorService.openidzhu(openid);
					System.out.println("看看微信表的id" + zhuid);
					String spro = "a";
					try {
						// 根据微信id查参数
						spro = prolocutorService.wxprolocutor(zhuid);
						System.out.println("根据微信id查参数" + spro);
						if (spro == null) {
							spro = "a";
						}
					} catch (Exception e) {
						// TODO: handle exception
						spro = "a";
					}
					if ("a".equals(spro)) {
						java.sql.Date nowSql = new java.sql.Date(
								System.currentTimeMillis());
						System.out.println(spro + "保存时");
						Prolocutor ps = new Prolocutor();
						ps.setProlocutor(prolocutor);
						ps.setOpenid(openid);
						ps.setCreateTime(nowSql);
						prolocutorService.adddaiyan(ps);
						System.out.println("我已保存");
					}
				}

			}

		}

		seriesmp = seriesService.getSeriesermpyi(id);

		// 一级菜单name
		String nameone = seriesService.seltypename(id);
		map.put("nameone", nameone);

		// 一级菜单
		Integer point = id;
		map.put("point", point);

		Integer pointb = 0;

		map.put("type", type);
		map.put("tyer", tyer);
		map.put("seriesmp", seriesmp);
		map.put("prolocutorindex", prolocutorindex);

		// 底部导航
		map.put("menupoint", 5);

		return "/index.jsp";
	}

	// 查询二级菜单视频
	@RequestMapping(value = "/wxmpright")
	public String wxmpright(
			Map<String, Object> map,
			@RequestParam(value = "id") int id,
			@RequestParam(value = "erid") Integer erid,
			@RequestParam(value = "sorid") Integer sorid,
			@RequestParam(value = "pointding") Integer pointding,
			HttpSession session,
			@RequestParam(value = "prolocutor", required = false, defaultValue = "a") String prolocutor) {
		List<Type> type = null;
		List<Type> tyer = null;
		List<Seriesmp> seriesmp = null;
		type = seriesService.wxgetMulvsan(0);
		tyer = seriesService.wxgetMulvsan(id);
		// 取出用户信息
		Users user = (Users) session.getAttribute("user");
		WxUser wxuser = (WxUser) session.getAttribute("wxuser");
		String prolocutorindex = "a";

		if (user != null) {
			// 当用户不为null时 通过用户的id查询参数
			prolocutorindex = prolocutorService.selspro(user.getID());

		}
		if (!prolocutor.equals("a")) {
			System.out.println("我得参数不为a");
			// 当前自己的状态
			String openid = wxuser.getOpenid();
			// int proid=prolocutorService.selproid(prolocutor);
			int WXopenid = 0;
			System.out.println(openid + "77777777777");
			try {
				// 根据传的参数去查user 信息
				WXopenid = prolocutorService.selproopenidd(prolocutor);
				System.out.println("对方的id=" + WXopenid);
			} catch (Exception e) {
				// TODO: handle exception
			}

			String Openidchuan = "a";
			// 传过来的状态
			if (WXopenid != 0) {
				// 查询微信表信息
				Openidchuan = prolocutorService.wxuseropenidd(WXopenid);
			}
			if (openid != Openidchuan) {
				// 自己是否已经成为了下级
				System.out.println("是不是自己本身");
				if (prolocutorService.onlydaiyan(openid)) {
					// 判断自己是否已经主动成为了代理人
					// String spro=prolocutorService.selspro(nowid);
					System.out.println("判断自己是否已经主动成为了代理人");
					int zhuid = prolocutorService.openidzhu(openid);
					System.out.println("看看微信表的id" + zhuid);
					String spro = "a";
					try {
						// 根据微信id查参数
						spro = prolocutorService.wxprolocutor(zhuid);
						System.out.println("根据微信id查参数" + spro);
						if (spro == null) {
							spro = "a";
						}
					} catch (Exception e) {
						// TODO: handle exception
						spro = "a";
					}

					if ("a".equals(spro)) {
						java.sql.Date nowSql = new java.sql.Date(
								System.currentTimeMillis());
						System.out.println(spro + "保存时");
						Prolocutor ps = new Prolocutor();
						ps.setProlocutor(prolocutor);
						ps.setOpenid(openid);
						ps.setCreateTime(nowSql);
						prolocutorService.adddaiyan(ps);
						System.out.println("我已保存");
					}

				}

			}

		}

		// 音频封面
		seriesmp = seriesService.getSeriesermper(erid);

		// 一级菜单name
		String nameone = seriesService.seltypename(id);
		map.put("nameone", nameone);
		// 二级菜单name
		String nametwo = seriesService.seltypename(erid);
		map.put("nametwo", nameone);

		// 一级菜单
		Integer point = id;
		map.put("point", point);
		// 二级菜单
		Integer pointer = erid;
		map.put("pointer", pointer);
		// 一二级菜单
		map.put("type", type);
		map.put("tyer", tyer);

		map.put("seriesmp", seriesmp);

		map.put("prolocutorindex", prolocutorindex);

		return "/index.jsp";

	}

}
