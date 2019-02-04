package com.learn.word.dao;

import java.util.List;

import com.learn.word.domain.TradeTotal;


public interface TradeTotalDAO {
	
	public abstract List<TradeTotal> getTradeTotalWithUserName(String username);
	
	public abstract Integer getTotalAmount();
	
	public abstract Integer getTotalDays();

}
