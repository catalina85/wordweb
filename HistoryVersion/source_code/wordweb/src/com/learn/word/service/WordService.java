package com.learn.word.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.learn.word.dao.TradeDAO;
import com.learn.word.dao.WordDAO;
import com.learn.word.dao.impl.TradeDAOImpl;
import com.learn.word.dao.impl.WordDAOImpl;
import com.learn.word.domain.MBase;
import com.learn.word.domain.MBaseItem;
import com.learn.word.domain.Trade;
import com.learn.word.domain.Word;
import com.learn.word.web.CriteriaWord;
import com.learn.word.web.ListWord;
import com.learn.word.web.Page;
import com.learn.word.web.ReviewWord;

public class WordService {
	
private WordDAO wordDAO = new WordDAOImpl();
private TradeDAO tradeDAO = new TradeDAOImpl();
	

	
	public Page<Word> getPage(CriteriaWord criteriaWord){
		return wordDAO.getPage(criteriaWord);
	}
	
	public Word getWord(int gId){
		return wordDAO.getWord(gId);
	}
	
	public boolean addToMBas(int gId,MBase mb){
		Word word = wordDAO.getWord(gId);
		if(word != null){
			mb.addWord(word);
			return true;
		}
		
		return false;
	}
	
	public void removeItemFromMBase(MBase mb,int gId){
		mb.removeItem(gId);
	}

	public void trade(MBase mBase, String username, String password) {
		wordDAO.batchUpdateRecord(mBase.getItems());
		
//		Trade trade = new Trade();
//		trade.setUsername(username);
//		trade.setTradeTime(new Date(new java.util.Date().getTime()));
//		trade.setTradeAmount(mBase.getWordNumber());
//		tradeDAO.insert(trade);
		mBase.clear();
	}

	public Page<Word> getReviewPage(ReviewWord reviewWord) {
		return wordDAO.getReviePage(reviewWord);
	}

	public Page<Word> getListWord(ListWord listWord) {
		return wordDAO.getListWordPage(listWord);
	}
	
}
