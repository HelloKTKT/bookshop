package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.OrderDao;

/**
 * Servlet implementation class CompleteOrderService
 */
@WebServlet("/CompleteOrderService")
public class CompleteOrderService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		   response.setCharacterEncoding("UTF-8");
		String oid=request.getParameter("oid");
		OrderDao orderdao=new OrderDao();
		boolean b=orderdao.updateorder(oid);
		if(b){
	
		request.getRequestDispatcher("MyServlet").forward(request, response); 
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
