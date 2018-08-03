package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.CartBook;
import com.beans.Cart_Books;
import com.beans.Order;
import com.tools.DBConnection;

public class Cart_BooksDao {
	DBConnection DB=new DBConnection();
    Connection conn=null;
    
    public boolean InsertCartBooks(String userid,Cart_Books cb){  
   	 conn = DB.getCon();			//获取数据库连接      	
   	 //System.out.println(userid);
     if(conn!=null){
   	  try { 

     		String sql="insert into cart_books(ID,oid,BookID,Name,number,allPrice)  values(?,?,?,?,?,?)";
     		System.out.println(sql);
 			PreparedStatement pstm=conn.prepareStatement(sql); 			
 			//pstm.setInt(1, b.getBookId());
 			//System.out.println(b.getName());
 			pstm.setString(1, userid);	
			pstm.setString(2, cb.getOid());			
 			pstm.setInt(3, cb.getBookid());
 			pstm.setString(4, cb.getName());
 			pstm.setDouble(5, cb.getNumber());
 			pstm.setDouble(6, cb.getAllprice());
 	
       	System.out.println("语句没错");
 			pstm.executeUpdate();
 			return true;			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}     	
     }
  	  return false;    	
    }
    
    public List<Cart_Books> getCart_Books(String oid){
   	 conn = DB.getCon();	//获取数据库连接  
   	 List<Cart_Books> list=new ArrayList<Cart_Books>();
   	 System.out.println("已经进入函数");
   	 if(conn!= null){    		
   		 try {   			
   			System.out.println(oid);
   			String sql="select * from cart_books where oid='"+oid+"'";
   			System.out.println(sql);
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					Cart_Books cb=new Cart_Books();
					cb.setBookid(rs.getInt(4));
					cb.setName(rs.getString(5));
					cb.setNumber(rs.getInt(6));
					cb.setAllprice(rs.getDouble(7));
					list.add(cb);
		
				}				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	 }
   	 return list;
    }


}
