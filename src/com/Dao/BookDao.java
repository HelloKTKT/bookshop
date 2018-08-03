package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.tools.DBConnection;

public class BookDao {
	 DBConnection DB=new DBConnection();
     Connection conn=null;
     //返回所有图书列表
     public List<Book> getBookList(){
    	 List<Book> list=new ArrayList<Book>();
    	 try {
    		  conn=DB.getCon();
        	  String sql="select * from books";
			  PreparedStatement pstm=conn.prepareStatement(sql);
			  ResultSet rs=pstm.executeQuery();
			  while(rs.next()){
				  Book book=new Book();
				  book.setBookId(rs.getInt(1));
				  book.setName(rs.getString(2));
				  book.setAuthor(rs.getString(3));
				  book.setPublisher(rs.getString(4));
				  book.setPrice(rs.getString(5));
				  book.setIntro(rs.getString(6));
				  book.setPic(rs.getString(7));
				  list.add(book);
			  }
			  return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return null;
     }
     //根据图书ID返回这本书的信息
     public Book getBookById(int bookid){
    	 Book book=new Book();
    	 try {
   		      conn=DB.getCon();
   		   	  String sql="select * from books where BookID=?";
			  PreparedStatement pstm=conn.prepareStatement(sql);
			  pstm.setInt(1, bookid);
			  ResultSet rs=pstm.executeQuery();
			  while(rs.next())
			  {
				  book.setBookId(rs.getInt(1));
				  book.setName(rs.getString(2));
				  book.setAuthor(rs.getString(3));
				  book.setPublisher(rs.getString(4));
				  book.setPrice(rs.getString(5));
				  book.setIntro(rs.getString(6));
				  book.setPic(rs.getString(7));
			  }
			  return book;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
   	 return null;
     }
     
}
