package com.learn.word.domain;

import java.sql.Date;

public class TradeTotal {
	
	private Date tradeTime;
	private Integer tradeTotalAmount;
	


	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Integer getTradeTotalAmount() {
		return tradeTotalAmount;
	}

	public void setTradeTotalAmount(Integer tradeTotalAmount) {
		this.tradeTotalAmount = tradeTotalAmount;
	}

	public TradeTotal(Date tradeTime, Integer tradeTotalAmount) {
		super();
		this.tradeTime = tradeTime;
		this.tradeTotalAmount = tradeTotalAmount;
	}

	public TradeTotal() {
		super();
	}
	
	
	
}
