package com.sy.comm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sy.action.SYAction;
import com.sy.action.SYForwardAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class SYFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SYFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doReq(request, response);
	}

	private void doReq(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String path= request.getServletPath();
		SYAction act = null;
				
		if(path.equals("/list.do")) {
			act = new SYListAction();
		}else if(path.equals("/login.do")) {
			//act = new LoginAction();
		}else if(path.equals("/loginresult.do")) {
			//act = new LoginResultAction();
		}
		
		SYForwardAction f = act.execute(request, response);
		if(f.isForward()) {
			RequestDispatcher disp = request.getRequestDispatcher(f.getPath());
			disp.forward(request, response);
		}else {
			response.sendRedirect(f.getPath());
		}
		
	}
}
