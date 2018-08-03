package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CartDao;
import com.beans.CartBook;

public class OrderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             request.setCharacterEncoding("UTF-8");
             response.setCharacterEncoding("UTF-8");
             
             String receiver=request.getParameter("receiver");
             String address=request.getParameter("address");
             String post=request.getParameter("post");
             String mobile=request.getParameter("mobile");
           String message=request.getParameter("message");
             
           
             
             
             Map<String,String> hashmap=new HashMap<String,String>();
             hashmap.put("receiver",receiver);
             hashmap.put("address", address);
             hashmap.put("post", post);            
             hashmap.put("mobile", mobile);

             hashmap.put("message", message);

             request.setAttribute("hashmap", hashmap);//封装订单信息
            
             
             HttpSession session=request.getSession();          
             CartDao ccdao=new CartDao();
             List<CartBook> list=ccdao.getAllCartBooks((String)session.getAttribute("userid"));
             request.setAttribute("booklist", list);//把已购买的书单放进session中
             request.getRequestDispatcher("confirmorder.jsp").forward(request, response);
             
	}

}
