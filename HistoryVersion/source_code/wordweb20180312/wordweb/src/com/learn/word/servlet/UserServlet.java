package com.learn.word.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.word.domain.Trade;
import com.learn.word.domain.TradeTotal;
import com.learn.word.domain.User;
import com.learn.word.service.TradeService;
import com.learn.word.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService = new UserService();
	TradeService tradeService = new TradeService();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request,response);
		
		} catch  (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void getTrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.getUser(username, password);
		
		if(user == null){
			request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}
		//List<Trade> trades = tradeService.getTrade(username);
		
		List<TradeTotal> tradeTotal = tradeService.getTradeTotal(username);
		Integer Amount = tradeService.getTotalAmount();
		Integer totalDays = tradeService.getTotalDays();
		request.setAttribute("username", username);
		request.setAttribute("trades", tradeTotal);
		request.setAttribute("Amount", Amount);
		request.setAttribute("totalDays", totalDays);
		
		request.getRequestDispatcher("/WEB-INF/pages/traderecord.jsp").forward(request, response);

				
	}

}
