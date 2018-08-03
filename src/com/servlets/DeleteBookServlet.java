package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;

public class DeleteBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   HttpSession session=request.getSession();
		   String userid=(String)session.getAttribute("userid");
           String bookid=request.getParameter("bookid");
           
           CartDao cartdao=new CartDao();
           boolean b=cartdao.DeleteBook(userid, Integer.parseInt(bookid));//É¾³ýÊé¼®
           if(b){
        	   System.out.println("É¾³ý³É¹¦");  	
        	   response.sendRedirect("http://localhost:8080/BookStore/CartServlet?m=1");
           }
           else{
        	   
        	   response.sendRedirect("http://localhost:8080/BookStore/CartServlet?m=0");
           }		
	}

}
