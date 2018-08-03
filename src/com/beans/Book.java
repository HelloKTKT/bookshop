package com.beans;

public class Book {
	public static final int PAGE_SIZE=6;
    private int bookId;
    private String name;
    private String author;
    private String publisher;
    private String price;
    private String intro;
    private String pic;
    public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Book(){
    	
    }
   public Book(int bookId, String name,String author,String publisher,String price, String intro){
    	this.bookId=bookId;
    	this.name=name;
    	this.author=author;
    	this.publisher=publisher;
    	this.price=price; 
    	this.intro = intro;
    }
   	public int getBookId() {
   		return bookId;
   	}
   	public void setBookId(int bookId) {
   		this.bookId = bookId;
   	}
   	public String getName() {
   		return name;
   	}	
   	public void setName(String name) {
   		this.name = name;
   	}
   	public String getAuthor() {
   		return author;
   	}
   	public void setAuthor(String author) {
   		this.author = author;
   	}
   	public String getPublisher() {
   		return publisher;
   	}
   	public void setPublisher(String publisher) {
   		this.publisher = publisher;
   	}
   	public String getPrice() {
   		return price;
   	}
   	public void setPrice(String price) {
   		this.price = price;
   	}  
}
