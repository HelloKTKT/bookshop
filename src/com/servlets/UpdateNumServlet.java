package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;

public class UpdateNumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           request.setCharacterEncoding("UTF-8");
           HttpSession session=request.getSession();
           String userid=(String)session.getAttribute("userid");
           int bookid=Integer.parseInt((String)request.getParameter("bookidtext"));
           String hid=(String)request.getParameter("hid");
           int dnum=Integer.parseInt(hid);//hid的值是+1，-1
           
           CartDao cd=new CartDao();
           cd.ModifyNum(userid, bookid, dnum);
           System.out.println("进入修改数目servlet");
           response.sendRedirect("CartServlet");
	}

}
