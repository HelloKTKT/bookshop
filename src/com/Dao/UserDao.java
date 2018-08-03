package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.Book;
import com.beans.User;
import com.tools.DBConnection;

public class UserDao {
     DBConnection DB=new DBConnection();
     Connection conn=null;
   //��д���û��������ѯ�û�����
     public User getUser(String userID,String Password){
     	User user = new User();				//����JavaBean����
     	conn = DB.getCon();			//��ȡ���ݿ�����
     	try {
     		String sql = "select * from users where ID = ? and Password = ?";	//�����ѯԤ�������
     		PreparedStatement statement = conn.prepareStatement(sql);		//ʵ����PreparedStatement����
     		statement.setString(1, userID);			//����Ԥ����������
     		statement.setString(2, Password);
     		ResultSet rest = statement.executeQuery();	//ִ��Ԥ�������
     		while(rest.next()){
     			user.setID(rest.getString(1));				//Ӧ�ò�ѯ������ö�������   			
     			user.setPassword(rest.getString(2));
     			user.setSex(rest.getString(3));
     			user.setPhone(rest.getString(4));
     			user.setHome(rest.getString(5));
     			user.setEmail(rest.getString(6));
     			user.setHeader(rest.getString(7));
     				
     		}
     	} catch (SQLException e) {			
     		e.printStackTrace();
     	}	
     	return user;
						//���ز�ѯ���
     }	
     //�����û�id�����û�����
     public User getUser(String userid){
    	 User user = new User();				//����JavaBean����
      	 conn = DB.getCon();			//��ȡ���ݿ�����
        try {
        	 String sql="select * from users where ID='"+userid+"'";
			  PreparedStatement pstm = conn.prepareStatement(sql);
			  ResultSet rest = pstm.executeQuery();	//ִ��Ԥ�������
	     		while(rest.next()){
	     			user.setID(rest.getString(1));				//Ӧ�ò�ѯ������ö�������   			
	     			user.setPassword(rest.getString(2));
	     			user.setSex(rest.getString(3));
	     			user.setPhone(rest.getString(4));
	     			user.setHome(rest.getString(5));
	     			user.setEmail(rest.getString(6));
	     			user.setHeader(rest.getString(7));
	     		
	     		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return user;
     }
     public boolean isContainUser(String id){
    	
		try {
			 conn = DB.getCon();			//��ȡ���ݿ�����
	    	 String sql="select * from users where ID=?";
	    	 PreparedStatement pstm;
			 pstm = conn.prepareStatement(sql);
			 pstm.setString(1, id);
			 ResultSet rs=pstm.executeQuery();
			 if(rs.next()){
				 return true;
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;   	 
     }
     public boolean InsertUser(User user){  
    	 conn = DB.getCon();			//��ȡ���ݿ�����      	
    	 //System.out.println(userid);
      if(conn!=null){
    	  try { 
    		 
      		String sql="insert into users values(?,?,?,?,?,?)";
      		System.out.println(sql);
  			PreparedStatement pstm=conn.prepareStatement(sql); 			
  			pstm.setString(1, user.getID());
  			//System.out.println(b.getName());
			pstm.setString(2, user.getPassword());			
  			pstm.setString(3, user.getSex());
  			pstm.setString(4, user.getPhone());
  			pstm.setString(5, user.getHome());
  			pstm.setString(6, user.getEmail());
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
     
     public  boolean updatedata(String userid,User user){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){
    		try{
    			 String sql="update users set sex='"+user.getSex()+"',phone='"+user.getPhone()+"',home='"+user.getHome()+"',email='"+user.getEmail()+"' where  ID='"+userid+"'";
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
     
     public  boolean updatecode(String userid,String pw){
    	 conn = DB.getCon();			//��ȡ���ݿ�����  
    	 if(conn!=null){
    		try{
    			 String sql="update users set Password='"+pw+"' where  ID='"+userid+"'";
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
