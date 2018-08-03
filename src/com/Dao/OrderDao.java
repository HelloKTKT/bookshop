package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.beans.CartBook;
import com.beans.Cart_Books;
import com.beans.Order;
import com.tools.DBConnection;

public class OrderDao {
	DBConnection DB=new DBConnection();
    Connection conn=null;
	
	
	
	 public boolean InsertOrder(String userid,Order order){  
    	 conn = DB.getCon();			//��ȡ���ݿ�����      	
    	 //System.out.println(userid);
      if(conn!=null){
    	  try { 
 
      		String sql="insert into orders(oid,ID,total,receiver,address,post,mobile,message,state)  values(?,?,?,?,?,?,?,?,?)";
      		System.out.println(sql);
  			PreparedStatement pstm=conn.prepareStatement(sql); 			
  			//pstm.setInt(1, b.getBookId());
  			//System.out.println(b.getName());
  			pstm.setString(1, order.getOid());	
			pstm.setString(2, userid);			
  			pstm.setDouble(3, order.getTotal());
  			pstm.setString(4, order.getReceiver());
  			pstm.setString(5, order.getAddress());
  			pstm.setString(6, order.getPost());
  			pstm.setString(7, order.getMobile());
  			pstm.setString(8, order.getMessage());
  			pstm.setString(9, "������");
        	System.out.println("���û��");
  			pstm.executeUpdate();
  			return true;			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}     	
      }
   	  return false;    	
     }
	 public List<Order> getOrders(String userid){
    	 conn = DB.getCon();	//��ȡ���ݿ�����  
    	 List<Order> list=new ArrayList<Order>();
    	 System.out.println("�Ѿ����뺯��");
    	 if(conn!= null){    		
    		 try {   			
    			System.out.println(userid);
    			String sql="select * from orders where ID='"+userid+"'";
    			System.out.println(sql);
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					Order order=new Order();
					Cart_BooksDao cbs=new Cart_BooksDao();
					
					order.setOid((rs.getString(1)));
					order.setId((rs.getString(2)));
					order.setTotal(rs.getDouble(3));
					order.setReceiver((rs.getString(4)));
					order.setAddress((rs.getString(5)));
					order.setPost((rs.getString(6)));
					order.setMobile((rs.getString(7)));
					order.setMessage((rs.getString(8)));
					order.setState((rs.getString(9)));
					order.setCart_books(cbs.getCart_Books(order.getOid()));
					list.add(order);
				}				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 return list;
     }
	 
	 public List<Order> getOrders2(String userid,String state){
    	 conn = DB.getCon();	//��ȡ���ݿ�����  
    	 List<Order> list=new ArrayList<Order>();
    	 System.out.println("�Ѿ����뺯��");
    	 if(conn!= null){    		
    		 try {   			
    			System.out.println(userid);
    			String sql="select * from orders where ID='"+userid+"' and state='"+state+"'";
    			System.out.println(sql);
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					Order order=new Order();
					Cart_BooksDao cbs=new Cart_BooksDao();
					
					order.setOid((rs.getString(1)));
					order.setId((rs.getString(2)));
					order.setTotal(rs.getDouble(3));
					order.setReceiver((rs.getString(4)));
					order.setAddress((rs.getString(5)));
					order.setPost((rs.getString(6)));
					order.setMobile((rs.getString(7)));
					order.setMessage((rs.getString(8)));
					order.setState((rs.getString(9)));
					order.setCart_books(cbs.getCart_Books(order.getOid()));
					list.add(order);
				}				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 return list;
     }
	 
	 public  boolean updateorder(String oid){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){
    		try{
    			 String sql="update orders set state='�����' where  oid='"+oid+"'";
        		 PreparedStatement pstm = conn.prepareStatement(sql);
        		 pstm.executeUpdate(); 	
        		 return true;
        		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    		   
    	 }
    return false;
     }
	 
}
