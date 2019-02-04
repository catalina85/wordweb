package com.learn.word.dao;

import java.util.Collection;
import java.util.List;

import com.learn.word.domain.MBaseItem;
import com.learn.word.domain.Word;
import com.learn.word.web.CriteriaWord;
import com.learn.word.web.ListWord;
import com.learn.word.web.Page;
import com.learn.word.web.ReviewWord;

public interface WordDAO {
	
	public abstract Word getWord(int gId);
	
	public abstract Page<Word> getPage(CriteriaWord cw);
	
	public abstract int getTotalWordNumber(CriteriaWord cw);
	
	public abstract List<Word> getPageList(CriteriaWord cw,int pageSize);
	
	public abstract Page<Word> getReviePage(ReviewWord rw);
	
	public abstract int getTotalRevieWordNumber(ReviewWord rw);
	
	public abstract List<Word> getReviePageList(ReviewWord rw,int pageSize);
	
	public abstract Page<Word> getListWordPage(ListWord lw);
	
	public abstract int getTotalListWordNumber(ListWord lw);
	
	public abstract List<Word> getListWordPageList(ListWord lw,int pageSize);
	

	public  abstract void batchUpdateRecord(Collection<MBaseItem> items);
	

}
