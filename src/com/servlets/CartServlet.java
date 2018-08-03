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
            String userId=(String) session.getAttribute("userid");//��¼�ɹ����û���Id����session��
            System.out.println(userId);
            
            String m=request.getParameter("m");//ɾ���鼮��ʱ���жϱ��
            if(m!=null){
            	 if(m.equals("1")){
               	  request.setAttribute("msg", "<script language='javascript'>window.alert('�ɹ�ɾ����');</script>");
               }
               else if(m.equals("0")){
               	request.setAttribute("msg", "<script language='javascript'>window.alert('ɾ��ʧ�ܣ�');</script>");
               }
               else if(m.equals("2")){
            	   request.setAttribute("msg", "<script language='javascript'>window.alert('��չ��ﳵʧ�ܣ�');</script>");
               }
            }
                     
            CartDao ccdao=new CartDao();
            List<CartBook> list=ccdao.getAllCartBooks((String)session.getAttribute("userid"));
            request.setAttribute("booklist", list);//���ѹ�����鵥�Ž�request��
            request.getRequestDispatcher("Carts.jsp").forward(request, response);           
	}
	
}
