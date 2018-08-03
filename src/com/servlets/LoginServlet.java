package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Dao.UserDao;

import com.beans.User;

import sun.misc.BASE64Encoder;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		System.out.println("接收数据");
		String id=request.getParameter("id");//获得用户名
		String password=request.getParameter("password");//获得密码
		UserDao dao=new UserDao();
		//BookDao bdao=new BookDao();
		User user=null;
		 MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        BASE64Encoder base64en = new BASE64Encoder();
	        //加密后的字符串
	        password=base64en.encode(md5.digest(password.getBytes("utf-8")));
		user=dao.getUser(id, password);
		HttpSession session=request.getSession();
		
		if(user.getID()!=null){
			System.out.println("用户已查到");
			System.out.println(user);
			session.setAttribute("userid",user.getID());//把查到的用户放进session中，便于登录检查		
			response.sendRedirect("loginsuccess.jsp");
		}
		else
		{
			
			PrintWriter out=response.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("window.alert('用户名或密码不正确！');");
 			out.print("</script>");
 			out.print("<script>window.location.href='login.jsp';</script> ");//<a href="javascript:history.go(-1)">
 			out.flush();
 			out.close();
 			
 			
		}
       
	}

}
