package com.tools;
import java.sql.*;
public class DBConnection {	
private Connection con;			//定义数据库连接类对象
private PreparedStatement pstm;	
private String user="root";		//连接数据库用户名
private String password="";		//连接数据库密码
private String driverName="com.mysql.jdbc.Driver";	//数据库驱动
private String url="jdbc:mysql://localhost:3306/shoppingcart";		
//连接数据库的URL,后面的是为了防止插入数据 库出现乱码，?useUnicode=true&characterEncoding=UTF-8
//构造函数
public DBConnection(){
	
}
/**创建数据库连接*/
public Connection getCon(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		System.out.println("加载数据库驱动失败！");
		e.printStackTrace();
	}
	try {
		con=DriverManager.getConnection(url,user,password);		//获取数据库连接
	} catch (SQLException e) {
		System.out.println("创建数据库连接失败！");
		con=null;
		e.printStackTrace();
	}
	return con;					//返回数据库连接对象
}	
/**
 *@功能：对数据库进行增、删、改、查操作
 *@参数：sql为SQL语句；params为Object数组，里面存储的是为sql表示的SQL语句中"?"占位符赋值的数据 
 */
	public void doPstm(String sql,Object[] params){
		if(sql!=null&&!sql.equals("")){
			if(params==null)
				params=new Object[0];			
			getCon();
			if(con!=null){
				try{		
					System.out.println(sql);
					pstm=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					for(int i=0;i<params.length;i++){
						pstm.setObject(i+1,params[i]);
					}
					pstm.execute();
				}catch(SQLException e){
					System.out.println("doPstm()方法出错！");
					e.printStackTrace();
				}				
			}			
		}
	}	
	public ResultSet getRs() throws SQLException{
		return pstm.getResultSet();		
	}
	public int getCount() throws SQLException{
		return pstm.getUpdateCount();		
	}
	public void closed(){
		try{
			if(pstm!=null)
				pstm.close();			
		}catch(SQLException e){
			System.out.println("关闭pstm对象失败！");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("关闭con对象失败！");
			e.printStackTrace();
		}
	}
}
