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
   //编写按用户名密码查询用户方法
     public User getUser(String userID,String Password){
     	User user = new User();				//创建JavaBean对象
     	conn = DB.getCon();			//获取数据库连接
     	try {
     		String sql = "select * from users where ID = ? and Password = ?";	//定义查询预处理语句
     		PreparedStatement statement = conn.prepareStatement(sql);		//实例化PreparedStatement对象
     		statement.setString(1, userID);			//设置预处理语句参数
     		statement.setString(2, Password);
     		ResultSet rest = statement.executeQuery();	//执行预处理语句
     		while(rest.next()){
     			user.setID(rest.getString(1));				//应用查询结果设置对象属性   			
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
						//返回查询结果
     }	
     //根据用户id返回用户对象
     public User getUser(String userid){
    	 User user = new User();				//创建JavaBean对象
      	 conn = DB.getCon();			//获取数据库连接
        try {
        	 String sql="select * from users where ID='"+userid+"'";
			  PreparedStatement pstm = conn.prepareStatement(sql);
			  ResultSet rest = pstm.executeQuery();	//执行预处理语句
	     		while(rest.next()){
	     			user.setID(rest.getString(1));				//应用查询结果设置对象属性   			
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
			 conn = DB.getCon();			//获取数据库连接
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
    	 conn = DB.getCon();			//获取数据库连接      	
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
     
     public  boolean updatedata(String userid,User user){
    	 conn = DB.getCon();			//获取数据库连接  
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
    	 conn = DB.getCon();			//获取数据库连接  
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
