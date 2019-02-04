package com.learn.word.dao.impl;

import java.util.List;

import com.learn.word.dao.TradeTotalDAO;
import com.learn.word.domain.TradeTotal;

public class TradeTotalDAOImpl extends BaseDAO<TradeTotal>implements TradeTotalDAO {

//	@Override
//	public List<TradeTotal> getTradeTotalWithUserName(String username) {
//		String sql = "select TRADETIME \"tradeTime\",sum(tradeamount) \"tradeTotalAmount\" from trade where username = ? group by TRADETIME order by TRADETIME";
//		return queryForList(sql, username);
//	}
	
	@Override
	public List<TradeTotal> getTradeTotalWithUserName(String username) {
		//String sql = "select MDATE \"tradeTime\",count(NAME) \"tradeTotalAmount\" from testword2 where mdate <= sysdate group by MDATE order by MDATE";
		String sql = "select to_date(to_char(mdate,'yyyy-mm-dd'),'yyyy-mm-dd') \"tradeTime\",count(NAME) \"tradeTotalAmount\" from testword2 where to_date(to_char(mdate,'yyyy-mm-dd'),'yyyy-mm-dd')<= to_date(to_char(sysdate,'yyyy-mm-dd'),'yyyy-mm-dd') group by to_date(to_char(mdate,'yyyy-mm-dd'),'yyyy-mm-dd') order by to_date(to_char(mdate,'yyyy-mm-dd'),'yyyy-mm-dd')";
		return queryForList(sql);
	}

	@Override
	public Integer getTotalAmount() {
		// TODO Auto-generated method stub
		String sql = "select count(NAME)  from testword2 where mdate is not null";
		
		Object ob = getSingelValue(sql);
		int total = Integer.parseInt(ob.toString());
		return total; 
				
	}

	@Override
	public Integer getTotalDays() {
		// TODO Auto-generated method stub
		String sql = "select count(distinct to_char(mdate,'yyyy-mm-dd')) from testword2";
		
		Object ob = getSingelValue(sql);
		int totalDays = Integer.parseInt(ob.toString());
		return totalDays; 
	}

}
