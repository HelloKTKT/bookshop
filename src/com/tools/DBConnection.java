package com.tools;
import java.sql.*;
public class DBConnection {	
private Connection con;			//�������ݿ����������
private PreparedStatement pstm;	
private String user="root";		//�������ݿ��û���
private String password="";		//�������ݿ�����
private String driverName="com.mysql.jdbc.Driver";	//���ݿ�����
private String url="jdbc:mysql://localhost:3306/shoppingcart";		
//�������ݿ��URL,�������Ϊ�˷�ֹ�������� ��������룬?useUnicode=true&characterEncoding=UTF-8
//���캯��
public DBConnection(){
	
}
/**�������ݿ�����*/
public Connection getCon(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		System.out.println("�������ݿ�����ʧ�ܣ�");
		e.printStackTrace();
	}
	try {
		con=DriverManager.getConnection(url,user,password);		//��ȡ���ݿ�����
	} catch (SQLException e) {
		System.out.println("�������ݿ�����ʧ�ܣ�");
		con=null;
		e.printStackTrace();
	}
	return con;					//�������ݿ����Ӷ���
}	
/**
 *@���ܣ������ݿ��������ɾ���ġ������
 *@������sqlΪSQL��䣻paramsΪObject���飬����洢����Ϊsql��ʾ��SQL�����"?"ռλ����ֵ������ 
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
					System.out.println("doPstm()��������");
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
			System.out.println("�ر�pstm����ʧ�ܣ�");
			e.printStackTrace();
		}
		try{
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			System.out.println("�ر�con����ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
