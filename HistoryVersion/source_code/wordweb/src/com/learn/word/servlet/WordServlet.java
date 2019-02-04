package com.learn.word.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.word.domain.MBase;
import com.learn.word.domain.User;
import com.learn.word.domain.Word;
import com.learn.word.service.UserService;
import com.learn.word.service.WordService;
import com.learn.word.web.CriteriaWord;
import com.learn.word.web.ListWord;
import com.learn.word.web.Page;
import com.learn.word.web.ReviewWord;
import com.learn.word.web.WordWebUtils;

public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	private WordService wordService = new WordService();
	UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void getListWords(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		String listName = request.getParameter("listName");
		String listNameEnd = request.getParameter("listNameEnd");
		String backpath = request.getParameter("method");
		if (!backpath.equals(new String("getListWords"))) {
			backpath = new String("getListWords");
		}

		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {
		}

		ListWord listWord = new ListWord(listName, listNameEnd, pageNo);
		Page<Word> page = wordService.getListWord(listWord);

		request.setAttribute("listwordpage", page);
		request.setAttribute("backpath", backpath);

		request.getRequestDispatcher("/WEB-INF/pages/listwords.jsp").forward(request, response);

	}

	protected void getReviewWords(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, Exception {

		String pageNoStr = request.getParameter("pageNo");
		String mDateStr = request.getParameter("mDate");
		String mDateEndStr = request.getParameter("mDateEnd");
		String backpath = request.getParameter("method");
		if (!backpath.equals(new String("getReviewWords"))) {
			backpath = new String("getReviewWords");
		}

		int pageNo = 1;
		Timestamp mDate = null;
		Timestamp mDateEnd = null;

		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {
		}

		try {
			if (mDateStr.equals(new String(""))) {
				request.getRequestDispatcher("/WEB-INF/pages/reviewwords.jsp").forward(request, response);

			}
			java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			mDateStr = mDateStr + " 00:00:00";
			mDateEndStr = mDateEndStr + " 23:59:59";
			mDate = new Timestamp(sdf.parse(mDateStr).getTime());
			mDateEnd = new Timestamp(sdf.parse(mDateEndStr).getTime());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/pages/errortime.jsp").forward(request, response);
		}

		ReviewWord reviewWord = new ReviewWord(mDate, mDateEnd, pageNo);
		Page<Word> page = wordService.getReviewPage(reviewWord);

		request.setAttribute("reviewwordpage", page);
		request.setAttribute("backpath", backpath);

		request.getRequestDispatcher("/WEB-INF/pages/reviewwords.jsp").forward(request, response);

	}

	protected void trade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUser(username, password);

		if (user == null) {

			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
		} else {
			wordService.trade(WordWebUtils.getMBase(request), username, password);

			response.sendRedirect(request.getContextPath() + "/success.jsp");
		}
	}

	protected void remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String gIdStr = request.getParameter("gId");
		int gId = -1;

		try {
			gId = Integer.parseInt(gIdStr);
		} catch (Exception e) {
		}

		MBase mb = WordWebUtils.getMBase(request);
		wordService.removeItemFromMBase(mb, gId);

		if (mb.isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/pages/emptybase.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/WEB-INF/pages/base.jsp").forward(request, response);

	}

	protected void forwardPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		request.getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp").forward(request, response);
	}

	protected void addToMBase(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String gIdStr = request.getParameter("gId");
		String re = request.getParameter("time");
		String ln = request.getParameter("time");
		int id = -1;
		boolean flag = false;

		try {
			id = Integer.parseInt(gIdStr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (id > 0) {
			MBase mb = WordWebUtils.getMBase(request);

			flag = wordService.addToMBas(id, mb);
		}

		if (flag) {
			if (re != null && re.equals(new String("re"))) {
				getReviewWords(request, response);
				return;
			}
			if (ln != null && re.equals(new String("ln"))) {
				getListWords(request, response);
				return;
			}
			getWords(request, response);
			return;
		}

		response.sendRedirect(request.getContextPath() + "/error-1.jsp");
	}

	protected void getWord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String gIdStr = request.getParameter("gId");
		int id = -1;

		Word word = null;

		try {
			id = Integer.parseInt(gIdStr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (id > 0)
			word = wordService.getWord(id);

		if (word == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}

		request.setAttribute("word", word);
		request.getRequestDispatcher("/WEB-INF/pages/word.jsp").forward(request, response);
	}

	protected void getWords(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageNoStr = request.getParameter("pageNo");
		String nameFeatureOneStr = request.getParameter("nameFeatureOne").trim().toLowerCase();
		String nameFeatureTwoStr = request.getParameter("nameFeatureTwo").trim().toLowerCase();
		String nameFeatureThreeStr = request.getParameter("nameFeatureThree").trim().toLowerCase();
		String meaningFeatureOneStr = request.getParameter("meaningFeatureOne");
		String meaningFeatureTwoStr = request.getParameter("meaningFeatureTwo");
		String meaningFeatureThreeStr = request.getParameter("meaningFeatureThree");
		String backpath = request.getParameter("method");
		if (!backpath.equals(new String("getWords"))) {
			backpath = new String("getWords");
		}
		int pageNo = 1;

		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {
		}

		CriteriaWord criteriaWord = new CriteriaWord(nameFeatureOneStr, nameFeatureTwoStr, nameFeatureThreeStr,
				meaningFeatureOneStr, meaningFeatureTwoStr, meaningFeatureThreeStr, pageNo);
		Page<Word> page = wordService.getPage(criteriaWord);

		request.setAttribute("wordpage", page);
		request.setAttribute("backpath", backpath);

		request.getRequestDispatcher("/WEB-INF/pages/words.jsp").forward(request, response);

	}

}
