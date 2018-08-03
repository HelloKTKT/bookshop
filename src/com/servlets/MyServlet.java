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
 * Servlet implementation class MyServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session=request.getSession();
		  String userid=(String) session.getAttribute("userid");
		  OrderDao orderdao=new OrderDao();
		  List<Order> list=orderdao.getOrders(userid);
		  request.setAttribute("list", list);
		  request.setAttribute("state", "È«²¿¶©µ¥");
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
