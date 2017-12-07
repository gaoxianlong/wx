package com.jcxa.safe.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcxa.safe.dao.SeriesDao;
import com.jcxa.safe.entity.Series;
import com.jcxa.safe.entity.Seriesmp;
import com.jcxa.safe.entity.Type;

@Service
public class SeriesService {

	@Autowired
	private SeriesDao seriesDao;
	
	
	//MP3
		//total
		public List<Seriesmp> getSeriesermptotal(){
			return seriesDao.getSeriesermptotal();
		}
		public List<Seriesmp> getSeriesermpyi(Integer id){
			return seriesDao.getSeriesermpyi(id);
		}
		public List<Seriesmp> getSeriesermper(Integer id){
			return seriesDao.getSeriesermper(id);
		}
		public String seltypename(Integer id){
			return seriesDao.seltypename(id);
		}
		public List<Type> wxgetMulvsanmp(Integer id){
			return seriesDao.wxgetMulvsanmp(id);
		}
	//MP3
	
		public List<Series> getSerieser(Integer id) {
			return seriesDao.getSerieser(id);
		}
		
		public List<Series> getSerieserxq(Integer id) {
			return seriesDao.getSerieserxq(id);
		}
		
		public List<Series> gethobby(String syn){
			return seriesDao.gethobby(syn);
		}
		
		public List<Series> getfree(String free){
			return seriesDao.getfree(free);
		}
		public List<Series> selectfpseries(List ls){
			return seriesDao.selectfpseries(ls);
		}
		public List<Type> wxgetMulvsan(Integer id){
			return seriesDao.wxgetMulvsan(id);
		}
		public List<Series> getSeriessan(Integer id) {
			return seriesDao.getSeriessan(id);
		}
		public String rightname(Integer id){
			return seriesDao.rightname(id);
		}
}
