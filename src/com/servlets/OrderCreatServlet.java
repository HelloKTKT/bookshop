package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;
import com.Dao.Cart_BooksDao;
import com.Dao.OrderDao;
import com.beans.CartBook;
import com.beans.Cart_Books;
import com.beans.Order;

/**
 * Servlet implementation class OrderCreatServlet
 */
@WebServlet("/OrderCreatServlet")
public class OrderCreatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
         HttpSession session=request.getSession();
         String userid=(String)session.getAttribute("userid");
         System.out.println(request.getParameter("total"));
         double total=Double.parseDouble(request.getParameter("total"));
         String receiver=request.getParameter("receiver");
         String address=request.getParameter("address");
         String post=request.getParameter("post");
         String mobile=request.getParameter("mobile");
         String message=request.getParameter("message");
         SimpleDateFormat simpleDateFormat;
         simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
         Date date = new Date();
         StringBuilder str=new StringBuilder();
         str.append(simpleDateFormat.format(date));
         str.append(userid);
         System.out.println(str.toString());
         Order order=new Order(str.toString(),userid, total, receiver, address, post, mobile, message);
         OrderDao orderdao=new OrderDao();
         orderdao.InsertOrder(userid, order);
         CartDao cd=new CartDao(); 
         Cart_BooksDao cbs=new Cart_BooksDao();
         List<CartBook> list=cd.getAllCartBooks(userid);
       for(CartBook cb:list){
    	   Cart_Books cb1=new Cart_Books(userid, str.toString(), cb.getBookid(),cb.getName(), cb.getNum(), cb.getAllprice());
    	   cbs.InsertCartBooks(userid, cb1);
    	   cd.ClearCartBook(userid);

    	   //request.getRequestDispatcher("orderupsuccess.jsp").forward(request, response);
    	   response.sendRedirect("orderupsuccess.jsp");
   
    	   
    	   
       }
         
         
	}

}
