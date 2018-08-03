package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.BookDao;
import com.Dao.CartDao;
import com.beans.Book;

public class CheckLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("gb2312");
        HttpSession session=request.getSession(); 
		//String user=(String) session.getAttribute("user");//从session中获取用户
        
        System.out.println("加入购物车");
		String bookid=request.getParameter("bookid");
		BookDao bookdao=new BookDao();
		Book b=bookdao.getBookById(Integer.parseInt(bookid));//通过传过来的bookid返回书的对象
		
        System.out.println("以获取用户");
		if( session.getAttribute("userid")==null){//如果用户未登录
			System.out.println("用户未空");
			request.setAttribute("msg", "<script language='javascript'>window.alert('用户未登录！');</script>");
 			request.getRequestDispatcher("Book1.jsp").forward(request, response);
		}
		else{
			//加入购物车的操作			
			CartDao cartdao=new CartDao();
			String userid=(String)session.getAttribute("userid");
			//System.out.println(b.getName());
			//System.out.println((String)session.getAttribute("userid"));	
			boolean cc=cartdao.isContainBook(userid, bookid);
			if(cc){//如果此书已添加
				request.setAttribute("msg", "<script language='javascript'>window.alert('此书已加入购物车，请勿重复添加！');</script>");
				request.getRequestDispatcher("Book1.jsp").forward(request, response);
			}else{//如果此书没添加
				
				boolean bb=cartdao.InsertBook((String)session.getAttribute("userid"), b);
				if(bb){//如果插入书籍成功
					/*PrintWriter out=response.getWriter();
	     			out.print("<script language='javascript'>window.alert('成功加入购物车！');</script>");    			
	     			out.flush();
	     			out.close();*/
					request.setAttribute("msg", "<script language='javascript'>window.alert('成功加入购物车！');</script>");
					request.getRequestDispatcher("Book1.jsp").forward(request, response);
				}
				else{	
					request.setAttribute("msg", "<script language='javascript'>window.alert('加入购物车失败！');</script>");
					request.getRequestDispatcher("Book1.jsp").forward(request, response);
				}
				
			}			
		}
	}

}
