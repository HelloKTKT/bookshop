package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;

public class ClearCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           
		   HttpSession session=request.getSession();
		   String userid=(String)session.getAttribute("userid");
		   
		   CartDao cd=new CartDao();
		    boolean b=cd.ClearCartBook(userid);
	        if(b){
	        	response.sendRedirect("http://localhost:8080/BookStore/CartServlet");
	        }
	        else{
	        	response.sendRedirect("http://localhost:8080/BookStore/CartServlet?m=2");
	        }
	}

}
