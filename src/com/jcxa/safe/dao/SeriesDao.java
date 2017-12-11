package com.jcxa.safe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesmp;
import com.jcxa.safe.entity.Type;





public interface SeriesDao {
		//MP3
			//total
	    public List<Seriesmp> getSeriesermptotal();
		public List<Seriesmp> getSeriesermpyi(Integer id);
		public List<Seriesmp> getSeriesermper(Integer id);
		public String seltypename(Integer id);
		public List<Type> wxgetMulvsanmp(Integer id);
		//MP3
	
	    //根据传入的二级id值取出对应的课程封面
		public List<Series> getSerieser(Integer id);
		public List<Series> getSerieserxq(Integer id);
		public List<Series> gethobby(String syn);
		public List<Series> getfree(String free);
		public List<Series> selectfpseries(@Param("ls")List ls);
		public List<Type> wxgetMulvsan(Integer id);
		//根据传入的三级id值取出对应的课程封面
		public List<Series> getSeriessan(Integer id);
		public String rightname(Integer id);
		
		
}
