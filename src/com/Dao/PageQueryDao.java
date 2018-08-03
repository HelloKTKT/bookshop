package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.tools.DBConnection;

public class PageQueryDao {
	    //分页查询所有书目信息
        public List<Book> getPageList(int page){
        	List<Book> list=new ArrayList<Book>();
        	DBConnection DB=new DBConnection();
        	Connection conn=DB.getCon();
        	String sql="select * from books order by BookID asc limit ?,?";//limit关键字
        	try {
        		
				PreparedStatement pstm=conn.prepareStatement(sql);
				pstm.setInt(1, (page-1)*Book.PAGE_SIZE); //设置查询记录的开始位置
				pstm.setInt(2, Book.PAGE_SIZE);          //设置查询数据所返回的记录数
				ResultSet rs=pstm.executeQuery();
				 while(rs.next()){
					  Book book=new Book();
					  book.setBookId(rs.getInt(1));
					  book.setName(rs.getString(2));
					  book.setAuthor(rs.getString(3));
					  book.setPublisher(rs.getString(4));
					  book.setPrice(rs.getString(5));
					  book.setPic(rs.getString(7));
					  list.add(book);
				  }
				 rs.close();
				 pstm.close();
				 conn.close();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return list;
        }
        
        //查询总记录数
        public int FindCounts(){
        	int count=0;
        	DBConnection DB=new DBConnection();
        	Connection conn=DB.getCon();
        	String sql="select count(*) from books";
        	try {
        		
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				if(rs.next()){//rs里就一个值
					count=rs.getInt(1); 				
				}
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return count;
        	
        }
	
}
