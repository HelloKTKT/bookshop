package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.beans.User;

/**
 * Servlet implementation class updateMyinformationService
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/updateMyinformationService" })
public class UpdateMyinformationService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String id=request.getParameter("id");//获得用户名
		String sex=request.getParameter("sex");
		String phone=request.getParameter("phone");
		String home=request.getParameter("home");
		String email=request.getParameter("email");
		
		User user=new User();
		user.setSex(sex);
		user.setPhone(phone);
		user.setHome(home);
		user.setEmail(email);
		UserDao userdao=new UserDao();
		
		boolean b=userdao.updatedata(id, user);
		if(b){
	    response.sendRedirect("updatesuccess.jsp");
		}
	
		
		
	
	}

}
