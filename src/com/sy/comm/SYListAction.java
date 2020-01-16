package com.sy.comm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sy.action.SYAction;
import com.sy.action.SYForwardAction;

public class SYListAction implements SYAction
{

	@Override
	public SYForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		SYForwardAction f = new SYForwardAction();
		
		if(id == null) {
			//null 이면 send redirect . 로그인으루..
			
			//response.sendRedirect("login.do");
			//forward 만들어서! 
			f.setForward(false);
			f.setPath("login.do");
			
		}else {
			//자료받아서 넘기기
			List<String> arr = new ArrayList<>();
			arr.add("choi");
			arr.add("eom");
			request.setAttribute("list", arr);
			
			f.setForward(true);
			f.setPath("main.jsp?page=list.jsp");
		}

		return f;
	}

}
