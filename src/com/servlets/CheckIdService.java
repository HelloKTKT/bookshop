package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;

/**
 * Servlet implementation class CheckIdService
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CheckIdService" })
public class CheckIdService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("u");
		String tip=null;
		 UserDao dao=new UserDao();
			if(!dao.isContainUser(id)){//是否存在用户    
				tip="OK";
			}
			else{
				tip="Not";
			}
		PrintWriter out=response.getWriter();
		out.println(tip);
		out.close();
		out.flush();
		
		
	}

}
