package com.beans;

public class User {
      @Override
	public String toString() {
		return "User [ID=" + ID + ", Password=" + Password + ", Sex=" + Sex + ", Phone=" + Phone + ", Home=" + Home
				+ ", Email=" + Email + ", Header=" + Header + "]";
	}
	private String ID;
      private String Password;
      private String Sex;
      private String Phone;
      private String Home;
      private String Email;
      private String Header;
      public User(){
    	  
      }
      public User(String ID,String Password, String Sex,String Phone,String Home,String Email,String Header){
    	  this.ID=ID;
    	  this.Password=Password;
    	  this.Sex=Sex;
    	  this.Phone=Phone;
    	  this.Home=Home;
    	  this.Email=Email; 
    	  this.Header=Header;
      }
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getHome() {
		return Home;
	}
	public void setHome(String home) {
		Home = home;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}
      
}
