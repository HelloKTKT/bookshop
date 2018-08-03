package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.beans.User;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class CheckCodeService
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CheckCodeService" })
public class CheckCodeService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckCodeService() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String password= request.getParameter("pw");
		Map<String, String[]> map=request.getParameterMap();
		String newpassword= request.getParameter("pw1");
		String newpassword2= request.getParameter("pw2");
		String test= request.getParameter("test");
	
		HttpSession httpSession=request.getSession();
		String id=(String) httpSession.getAttribute("userid");
		if(newpassword.equals(newpassword2)){
			 MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        BASE64Encoder base64en = new BASE64Encoder();
		        newpassword=base64en.encode(md5.digest(newpassword.getBytes("utf-8")));
		        password=base64en.encode(md5.digest(password.getBytes("utf-8")));
		        System.out.println(password);
			UserDao userdao=new UserDao();
			User user=new User();
			user=userdao.getUser(id, password);
			if(user.getID()!=null||user.getPassword()!=null){
				user.setPassword(newpassword);
				boolean b=userdao.updatecode(id, user.getPassword());
				System.out.println(b);
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("window.alert('修改密码成功');");
	 			out.print("</script>");
	 			out.print("<script>window.history.back(-1);</script> ");//<a href="javascript:history.go(-1)">
	 			out.flush();
	 			out.close();
			}
			else{
				PrintWriter out=response.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("window.alert('用户名或密码不正确！');");
	 			out.print("</script>");
	 			out.print("<script>window.history.back(-1);</script> ");//<a href="javascript:history.go(-1)">
	 			out.flush();
	 			out.close();
			}
			
			
			
			
			
		}
		
		
	}

}
