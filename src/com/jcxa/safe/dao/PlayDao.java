package com.jcxa.safe.dao;

import com.jcxa.safe.entity.Series;


/**播放记录*/
public interface PlayDao {
	/**查询播放记录*/
	//mp3
	
	public void ClickRatemp(Integer id);
	
	//mp3
	public Series getplaySeries(Integer seriesID);
	public void ClickRate(Integer id);
}
