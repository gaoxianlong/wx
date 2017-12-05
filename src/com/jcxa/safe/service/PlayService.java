package com.jcxa.safe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcxa.safe.dao.PlayDao;
import com.jcxa.safe.entity.Series;


@Service
public class PlayService {
	@Autowired
	private PlayDao playDao;
	//mp3
	
	public void ClickRatemp(Integer id){
		playDao.ClickRatemp(id);
	}
	//mp3
	
	
	public Series getplaySeries(Integer seriesID){
		return playDao.getplaySeries(seriesID);
	}
	
	public void ClickRate(Integer id){
		playDao.ClickRate(id);
	}
}

