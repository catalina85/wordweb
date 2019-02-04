package com.learn.word.service;

import java.util.List;

import com.learn.word.dao.TradeDAO;
import com.learn.word.dao.TradeTotalDAO;
import com.learn.word.dao.impl.TradeDAOImpl;
import com.learn.word.dao.impl.TradeTotalDAOImpl;
import com.learn.word.domain.Trade;
import com.learn.word.domain.TradeTotal;

public class TradeService {
	private TradeDAO tradeDAO = new TradeDAOImpl();
	private TradeTotalDAO tradeTotalDAO =new TradeTotalDAOImpl();
	
	
	public List<Trade> getTrade(String username){
		return tradeDAO.getTradesWithUserName(username);
	}
	
	public List<TradeTotal> getTradeTotal(String username){
		return tradeTotalDAO.getTradeTotalWithUserName(username);
		
	}
	
	public Integer getTotalAmount(){
		return tradeTotalDAO.getTotalAmount();
		
	}
	
	public Integer getTotalDays(){
		return tradeTotalDAO.getTotalDays();
		
	}
}
