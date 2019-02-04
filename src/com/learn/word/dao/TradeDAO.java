package com.learn.word.dao;

import java.sql.Date;
import java.util.List;

import com.learn.word.domain.Trade;
import com.learn.word.domain.TradeTotal;

public interface TradeDAO {
	
	public abstract void insert(Trade trade);
	

	public abstract List<Trade> getTradesWithUserName(String username);
}
