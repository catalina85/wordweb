package com.learn.word.dao.impl;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.learn.word.dao.TradeDAO;
import com.learn.word.domain.Trade;
import com.learn.word.domain.TradeTotal;

public class TradeDAOImpl extends BaseDAO<Trade>implements TradeDAO {

	@Override
	public void insert(Trade trade) {
		String sql = "INSERT INTO trade (USERNAME,TRADETIME,TRADEAMOUNT)"
				+ "values(?,?,?)";
		update(sql, trade.getUsername(),trade.getTradeTime(),trade.getTradeAmount());
	}


	@Override
	public List<Trade> getTradesWithUserName(String username) {
		String sql = "SELECT TRADEID \"tradeId\",USERNAME \"username\",TRADETIME \"tradeTime\",TRADEAMOUNT \"tradeAmount\"  FROM trade where USERNAME = ?";
		
		return queryForList(sql, username);
	}



}
