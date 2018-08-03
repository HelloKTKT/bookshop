package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.OrderDao;
import com.beans.Order;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MyServlet2" })
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.setCharacterEncoding("utf-8");
		   response.setCharacterEncoding("UTF-8");
		  HttpSession session=request.getSession();
		  String userid=(String) session.getAttribute("userid");

		String state = new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		
		
		  System.out.println(state);
		  OrderDao orderdao=new OrderDao();
		  List<Order> list=orderdao.getOrders2(userid,state);
		  request.setAttribute("list", list);
		  request.setAttribute("state", state);
		  request.getRequestDispatcher("myorders.jsp").forward(request, response);
		  
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
