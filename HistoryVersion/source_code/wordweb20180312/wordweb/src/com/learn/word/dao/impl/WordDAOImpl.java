package com.learn.word.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.learn.word.dao.WordDAO;
import com.learn.word.domain.MBaseItem;
import com.learn.word.domain.Word;
import com.learn.word.web.CriteriaWord;
import com.learn.word.web.ListWord;
import com.learn.word.web.Page;
import com.learn.word.web.ReviewWord;

public class WordDAOImpl extends BaseDAO<Word> implements WordDAO {

	@Override
	public Word getWord(int gId) {
		String sql = "select  G_ID \"gId\",l_id \"lId\",NAME \"name\","
				+ "PRON \"pron\",P \"p\",M \"m\",MDATE \"mDate\","
				+ "L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\",MTIME \"mTime\"  "
				+ "from testword2 where g_id = ? ";

		return query(sql, gId);
	}

	@Override
	public Page<Word> getPage(CriteriaWord cw) {
		Page<Word> page = new Page<>(cw.getPageNo());
		page.setTotalItemNumber(getTotalWordNumber(cw));
		cw.setPageNo(page.getPageNo());
		page.setList(getPageList(cw, 10));
		return page;
	}

	@Override
	public int getTotalWordNumber(CriteriaWord cw) {
		String sql = "select count(name) from testword2 where lower(name) like ? or lower(name) like ? or lower(name) like ? or meaning like ? or meaning like ? or meaning like ?";

		Object ob = getSingelValue(sql, cw.getNameFeatureOne(), cw.getNameFeatureTwo(), cw.getNameFeatureThree(),
				cw.getMeaningFeatureOne(), cw.getMeaningFeatureTwo(), cw.getMeaningFeatureThree());
		int totalWordNumber = Integer.parseInt(ob.toString());
		return totalWordNumber;
	}

	@Override
	public List<Word> getPageList(CriteriaWord cw, int pageSize) {
		String sql = "select * from (select rownum \"rowNum\", temp.*from (select  G_ID \"gId\",l_id \"lId\",NAME \"name\",PRON \"pron\",P \"p\",M \"m\",MDATE \"mDate\",L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\",MTIME \"mTime\"  from testword2 where lower(name) like ? or lower(name) like ? or lower(name) like ? or meaning like ? or meaning like ? or meaning like ? order by name) temp)where \"rowNum\" between ? and ?";
		return queryForList(sql, cw.getNameFeatureOne(), cw.getNameFeatureTwo(), cw.getNameFeatureThree(),
				cw.getMeaningFeatureOne(), cw.getMeaningFeatureTwo(), cw.getMeaningFeatureThree(),
				((cw.getPageNo() - 1) * pageSize + 1), pageSize * cw.getPageNo());
	}

	@Override
	public void batchUpdateRecord(Collection<MBaseItem> items) {
		String sql = "UPDATE testword2 SET p = ?, m = ?, mTime = ?, mDate = ?" + "where g_id = ?";
		Object[][] params = null;
		params = new Object[items.size()][5];
		List<MBaseItem> mbis = new ArrayList<>(items);

		int mTime = 0;
		Timestamp mDate = new Timestamp(new java.util.Date().getTime());
		for (int i = 0; i < items.size(); i++) {
			if (mbis.get(i).getWord().getmTime() == null) {
				mTime = 1;
			} else {
				mTime = mbis.get(i).getWord().getmTime() + 1;
			}
			params[i][0] = mbis.get(i).getWord().getP();
			params[i][1] = mbis.get(i).getWord().getM();
			params[i][2] = mTime;
			params[i][3] = mDate;
			params[i][4] = mbis.get(i).getWord().getgId();
		}
		batch(sql, params);
	}

	@Override
	public Page<Word> getReviePage(ReviewWord rw) {
		// TODO Auto-generated method stub
		Page<Word> page = new Page<>(rw.getPageNo());
		page.setTotalItemNumber(getTotalRevieWordNumber(rw));
		rw.setPageNo(page.getPageNo());
		page.setList(getReviePageList(rw, 10));
		return page;
	}

	@Override
	public int getTotalRevieWordNumber(ReviewWord rw) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(name) FROM testword2 where " + "MDATE between ? and ?";
		Object ob = getSingelValue(sql, rw.getmDate(), rw.getmDateEnd());
		int totalRevieWordNumber = Integer.parseInt(ob.toString());
		return totalRevieWordNumber;
	}

	@Override
	public List<Word> getReviePageList(ReviewWord rw, int pageSize) {
		String sql = "select * from (select rownum \"rowNum\", temp.* from (select  G_ID \"gId\",l_id \"lId\",NAME \"name\",PRON \"pron\",P \"p\",M \"m\",MDATE \"mDate\",L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\",MTIME \"mTime\"  from testword2 where MDATE between ? and ? order by MDATE ) temp)where \"rowNum\" between ? and ?";
		return queryForList(sql, rw.getmDate(), rw.getmDateEnd(), ((rw.getPageNo() - 1) * pageSize + 1),
				pageSize * rw.getPageNo());
	}

	@Override
	public Page<Word> getListWordPage(ListWord lw) {
		// TODO Auto-generated method stub
		Page<Word> page = new Page<>(lw.getPageNo());
		page.setTotalItemNumber(getTotalListWordNumber(lw));
		lw.setPageNo(page.getPageNo());
		page.setList(getListWordPageList(lw, 10));
		return page;
	}

	@Override
	public int getTotalListWordNumber(ListWord lw) {
		// TODO Auto-generated method stub
		String sql = "SELECT count(name) FROM testword2 where " + "l_na between ? and ?";
		Object ob = getSingelValue(sql, lw.getListName(), lw.getListNameEnd());
		int totalListWordNumber = Integer.parseInt(ob.toString());
		return totalListWordNumber;
	}

	@Override
	public List<Word> getListWordPageList(ListWord lw, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from (select rownum \"rowNum\", temp.* from (select  G_ID \"gId\",l_id \"lId\",NAME \"name\",PRON \"pron\",P \"p\",M \"m\",MDATE \"mDate\",L_NA \"lNa\",MEANING \"meaning\",BOOK_NAME \"bookName\",MTIME \"mTime\"  from testword2 where L_NA  between ? and ? order by g_id) temp)where \"rowNum\" between ? and ?";
		return queryForList(sql, lw.getListName(), lw.getListNameEnd(), ((lw.getPageNo() - 1) * pageSize + 1),
				pageSize * lw.getPageNo());
	}

}
