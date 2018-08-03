package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.beans.CartBook;
import com.tools.DBConnection;

public class CartDao {
	 DBConnection DB=new DBConnection();
     Connection conn=null;
     //������������鼮
    public List<CartBook> getAllCartBooks(String userid){
    	 conn = DB.getCon();	//��ȡ���ݿ�����  
    	 List<CartBook> list=new ArrayList<CartBook>();
    	 System.out.println("�Ѿ����뺯��");
    	 if(conn!= null){    		
    		 try {   			
    			System.out.println(userid);
    			String sql="select * from cart where ID='"+userid+"'";
    			System.out.println(sql);
				PreparedStatement pstm=conn.prepareStatement(sql);
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					CartBook cb=new CartBook();
					cb.setCid((rs.getInt(1)));
					cb.setId((rs.getString(2)));
					cb.setBookid((rs.getInt(3)));
					cb.setNum(rs.getInt(4));
					cb.setName((rs.getString(5)));
					cb.setPrice(rs.getDouble(6));
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
     //�����鼮
    public boolean InsertBook(String userid,Book b){  
    	 conn = DB.getCon();			//��ȡ���ݿ�����      	
    	 //System.out.println(userid);
      if(conn!=null){
    	  try { 
    		 
      		String sql="insert into cart(ID,BookID,number,Name,Price,allPrice)  values(?,?,?,?,?,?)";
      		System.out.println(sql);
  			PreparedStatement pstm=conn.prepareStatement(sql); 			
  			//pstm.setInt(1, b.getBookId());
  			//System.out.println(b.getName());
			pstm.setString(1, userid);			
  			pstm.setString(2, Integer.toString(b.getBookId()));
  			pstm.setInt(3, 1);
  			pstm.setString(4, b.getName());
  			pstm.setString(5, b.getPrice());
  			pstm.setString(6, b.getPrice());
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
     //ɾ�������鼮
    public boolean DeleteBook(String userid,int bookid){    	 
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){   		
    		try {
    			
    			String sql="delete from cart where BookID='"+bookid+"' and ID='"+userid+"'";
				PreparedStatement pstm=conn.prepareStatement(sql);
				pstm.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 return false;
     }
     //�޸�����
   public  boolean ModifyNum(String userid,int bookid,int num){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 int total=0;
    	 int oldnum=0;
    	 if(conn!=null){
    		try{
    			//���ԭ��������
    			 String sql3="select number from cart where BookID='"+bookid+"' and ID='"+userid+"'";
    			 PreparedStatement pstm3 = conn.prepareStatement(sql3);
    			 ResultSet rs=pstm3.executeQuery();
    			 if(rs.next()){
    				 oldnum=rs.getInt(1);
    			 }
    			 if(oldnum==1){
    				 if(num==-1){
    					 return true;
    				 }
    			 }
    			 //��������
    			 String sql="update cart set number='"+(num+oldnum)+"' where  BookID='"+bookid+"' and ID='"+userid+"'";
        		 PreparedStatement pstm = conn.prepareStatement(sql);
        		 pstm.executeUpdate();
        		  //�����ܼ�
        		 String sql1="select Price from cart where BookID='"+bookid+"' and ID='"+userid+"'";
        		 PreparedStatement pstm1 = conn.prepareStatement(sql1);
        		 ResultSet rs1=pstm1.executeQuery();
        		 if(rs1.next()){
        			 total=Integer.parseInt(rs1.getString("Price"))*(num+oldnum);
        		 }
        		 //�޸��ܼ�
        		 String sql2="update cart set allPrice='"+total+"' where BookID='"+bookid+"' and ID='"+userid+"'";
        		 PreparedStatement pstm2 = conn.prepareStatement(sql2);
        		 pstm2.executeUpdate(); 
        		 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		    		   
    	 }
    	 return false;
     }
   //�鼮�Ƿ����
     public boolean isContainBook(String userid,String bookid){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){   		 
    		 try {   			 
    			 String sql="select * from cart where ID='"+userid+"' and BookID='"+bookid+"'";
				 PreparedStatement pstm = conn.prepareStatement(sql);
				 ResultSet rs= pstm.executeQuery();
				 if(rs.next())//��������Ȿ��
					 return true;
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    	 }else{
    		 System.out.println("��������ʧ��");
    	 }    	 
    	 return false;
     }
     //��������ܼ۸�
     public int getTotalPrice(String userid){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){   	
    		
    		 try {
    			
    			 String sql="select sum(allprice)  from cart where ID='"+userid+"'";
				 PreparedStatement pstm = conn.prepareStatement(sql);
				 ResultSet rs= pstm.executeQuery();
				 if(rs.next()){
					 return rs.getInt(1);
				 }
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 return 0;
     }
     //��������鼮
     public boolean ClearCartBook(String userid){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){   		
    		try {
    			
    			String sql="delete from cart where ID='"+userid+"'";
				PreparedStatement pstm=conn.prepareStatement(sql);
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
