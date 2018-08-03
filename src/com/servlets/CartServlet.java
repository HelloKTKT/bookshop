package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;
import com.beans.CartBook;

public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            HttpSession session=request.getSession();
            String userId=(String) session.getAttribute("userid");//登录成功后用户的Id放在session中
            System.out.println(userId);
            
            String m=request.getParameter("m");//删除书籍的时候判断标记
            if(m!=null){
            	 if(m.equals("1")){
               	  request.setAttribute("msg", "<script language='javascript'>window.alert('成功删除！');</script>");
               }
               else if(m.equals("0")){
               	request.setAttribute("msg", "<script language='javascript'>window.alert('删除失败！');</script>");
               }
               else if(m.equals("2")){
            	   request.setAttribute("msg", "<script language='javascript'>window.alert('清空购物车失败！');</script>");
               }
            }
                     
            CartDao ccdao=new CartDao();
            List<CartBook> list=ccdao.getAllCartBooks((String)session.getAttribute("userid"));
            request.setAttribute("booklist", list);//把已购买的书单放进request中
            request.getRequestDispatcher("Carts.jsp").forward(request, response);           
	}
	
}
