package com.learn.word.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.learn.word.domain.MBase;

public class WordWebUtils {
	
	public static MBase getMBase(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		MBase mb = (MBase) session.getAttribute("MBase");
		
		if(mb == null){
			mb = new MBase();
			session.setAttribute("MBase", mb);
		}
		
		return mb;
	}
}
