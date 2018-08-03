package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.beans.User;
import com.tools.DBConnection;

import sun.misc.BASE64Encoder;

public class RegServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		   response.setCharacterEncoding("UTF-8");
		   response.setContentType("text/html");
		   
           String id= request.getParameter("ID");
           String password=request.getParameter("Password");
           String sex= request.getParameter("Sex");
           String phone=request.getParameter("Phone");
           String home=request.getParameter("Home");
           String email=request.getParameter("Email");
           String header=request.getParameter("Header");
           
           DBConnection DB=new DBConnection();
           Connection conn=null;
           conn=DB.getCon();
     if(conn!=null){    
        UserDao dao=new UserDao();
		if(!dao.isContainUser(id)){//�Ƿ�����û�    
			 MessageDigest md5 = null;
			try {
				md5 = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        BASE64Encoder base64en = new BASE64Encoder();
		        //���ܺ���ַ���
		      password=base64en.encode(md5.digest(password.getBytes("utf-8")));
			User user=new User(id,password,sex,phone,home,email,"123");
			dao.InsertUser(user);
		 	/*String sql="insert into users values(?,?,?,?,?,?,?)";
			PreparedStatement pstm=conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, password);
			pstm.setString(3, sex);
			pstm.setString(4, phone);
			pstm.setString(5, home);
			pstm.setString(6, email);
			pstm.setString(7, header);
			pstm.executeUpdate();
			System.out.println("ע��ɹ���");*/
			//ͬʱ�½�һ�Ź�������ÿ���û�ע��ɹ����Ὠһ�ű�
			//String sql1="create table "+id+"(ID int(20),Name varchar(20),Price varchar(20),Num int(20),Total int(20),primary key(ID))";
			//PreparedStatement pstm1=conn.prepareStatement(sql1);
			//pstm1.executeUpdate();
			HttpSession session=request.getSession();
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>window.alert('ע��ɹ���');</script>"); 
		    session.setAttribute("userid",user.getID());//�Ѳ鵽���û��Ž�session�У����ڵ�¼���		
		    response.sendRedirect("loginsuccess.jsp");
			
		}
		else{
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>window.alert('ע��ʧ�ܣ�');</script>");    			
			out.flush();
			out.close();
			System.out.println("�û��Ѵ��ڣ�");
			response.sendRedirect("register.jsp");
		}
           
	}
	}
}
