package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.beans.User;

/**
 * Servlet implementation class MyInformationServer
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MyInformationServer" })
public class MyInformationServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userdao=new UserDao();
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("userid");
		User user=userdao.getUser(id);
		request.setAttribute("userdata", user);
		
		request.getRequestDispatcher("userinformation.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
