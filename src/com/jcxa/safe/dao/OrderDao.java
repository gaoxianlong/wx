package com.jcxa.safe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcxa.safe.entity.Order;
import com.jcxa.safe.entity.Playrecord;
import com.jcxa.safe.entity.Seriesvideo;


public interface OrderDao {
//mp3
	
	//判断用户是否添加该课程的播放记录
	public Playrecord getrecordmp(@Param("uid")Integer uid,@Param("vid")Integer vid);
	//添加播放记录	
	public void addrecordmp(Playrecord playrecord);
	//得到具体视频的信息
	public Seriesvideo playvideomp(Integer id);
	//得到下一个具体视频的信息
	public Seriesvideo selnextmp(@Param("seriesID")Integer seriesID,@Param("sort")Integer sort);
	public List<Seriesvideo> getvideomp(Integer seriesID);
	
//mp3
	//判断用户是否购买该课程
	public Order getorderserid(@Param("userID")Integer userID,@Param("seriesID")Integer seriesID);
	//得到具体视频的信息
	public Seriesvideo playvideo(Integer id);
	//得到下一个具体视频的信息
	public Seriesvideo selnext(@Param("seriesID")Integer seriesID,@Param("sort")Integer sort);
	/*
	 * 查询课程封面对应的视频
	 */
	public List<Seriesvideo> getvideo(Integer seriesID);
	public List<Seriesvideo> videofree(Integer seriesID);
	public List<Seriesvideo> videopay(Integer seriesID);
	public int selmaxsort(Integer seriesID);
	//判断用户是否添加该课程的播放记录
	public Playrecord getrecord(@Param("uid")Integer uid,@Param("vid")Integer vid);
	//添加播放记录	
	public void addrecord(Playrecord playrecord);
	
}
