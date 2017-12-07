package com.jcxa.safe.dao;

import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesmp;


/**播放记录*/
public interface PlayDao {
	/**查询播放记录*/
	//mp3
	
	public void ClickRatemp(Integer id);
	public Seriesmp getplaySeriesmp(Integer seriesID);
	//mp3
	public Series getplaySeries(Integer seriesID);
	public void ClickRate(Integer id);
}
