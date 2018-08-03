package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.PageQueryDao;
import com.beans.Book;

public class PageQueryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          int currpage=1;
          if(request.getParameter("page")!=null){
        	  currpage=Integer.parseInt(request.getParameter("page"));
          }
        
         PageQueryDao pagedao=new PageQueryDao();
         List<Book> list=pagedao.getPageList(currpage);//��ѯ��ǰҳ��¼
         request.setAttribute("list", list); 
         int pages;   //�����ѯ��ҳ��
         int count=pagedao.FindCounts();
         if(count%Book.PAGE_SIZE==0){
        	 pages=count/Book.PAGE_SIZE;
         }
         else{
        	 pages=count/Book.PAGE_SIZE+1;
         }
         
         StringBuffer sb=new StringBuffer();
         //������ҳ��
         for(int i=1;i<=pages;i++){
        	 if(i==currpage){
        		 sb.append("��" + i + "��");
        	 }
        	 else{
        		 sb.append("<a href='PageQueryServlet?page="+i+"'>"+i+"</a>");
        	 }
        	 sb.append(" ");
         }
         request.setAttribute("bar", sb.toString());
         request.getRequestDispatcher("books.jsp").forward(request, response);	//����ת��	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
