package com.learn.word.domain;

import java.sql.Date;

public class Trade {
	
	private int tradeId;
	private String username;
	private Date tradeTime;
	private int tradeAmount;
	
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public int getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(int tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public Trade() {
		super();
	}
	public Trade(int tradeId, String username, Date tradeTime, int tradeAmount) {
		super();
		this.tradeId = tradeId;
		this.username = username;
		this.tradeTime = tradeTime;
		this.tradeAmount = tradeAmount;
	}
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", username=" + username + ", tradeTime=" + tradeTime + ", tradeAmount="
				+ tradeAmount + "]";
	}
	
	
	
}
