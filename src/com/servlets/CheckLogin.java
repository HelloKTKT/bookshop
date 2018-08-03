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
		//String user=(String) session.getAttribute("user");//��session�л�ȡ�û�
        
        System.out.println("���빺�ﳵ");
		String bookid=request.getParameter("bookid");
		BookDao bookdao=new BookDao();
		Book b=bookdao.getBookById(Integer.parseInt(bookid));//ͨ����������bookid������Ķ���
		
        System.out.println("�Ի�ȡ�û�");
		if( session.getAttribute("userid")==null){//����û�δ��¼
			System.out.println("�û�δ��");
			request.setAttribute("msg", "<script language='javascript'>window.alert('�û�δ��¼��');</script>");
 			request.getRequestDispatcher("Book1.jsp").forward(request, response);
		}
		else{
			//���빺�ﳵ�Ĳ���			
			CartDao cartdao=new CartDao();
			String userid=(String)session.getAttribute("userid");
			//System.out.println(b.getName());
			//System.out.println((String)session.getAttribute("userid"));	
			boolean cc=cartdao.isContainBook(userid, bookid);
			if(cc){//������������
				request.setAttribute("msg", "<script language='javascript'>window.alert('�����Ѽ��빺�ﳵ�������ظ���ӣ�');</script>");
				request.getRequestDispatcher("Book1.jsp").forward(request, response);
			}else{//�������û���
				
				boolean bb=cartdao.InsertBook((String)session.getAttribute("userid"), b);
				if(bb){//��������鼮�ɹ�
					/*PrintWriter out=response.getWriter();
	     			out.print("<script language='javascript'>window.alert('�ɹ����빺�ﳵ��');</script>");    			
	     			out.flush();
	     			out.close();*/
					request.setAttribute("msg", "<script language='javascript'>window.alert('�ɹ����빺�ﳵ��');</script>");
					request.getRequestDispatcher("Book1.jsp").forward(request, response);
				}
				else{	
					request.setAttribute("msg", "<script language='javascript'>window.alert('���빺�ﳵʧ�ܣ�');</script>");
					request.getRequestDispatcher("Book1.jsp").forward(request, response);
				}
				
			}			
		}
	}

}
