package com.beans;

public class CartBook {
    private int cid;
    private String id;
    private int bookid;
    private int num;
	private String name;
    private double price;
    private double allprice;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


   
    public CartBook(){
    	
    }

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	public CartBook(int cid, String id, int bookid, int num, String name, double price) {
		
		this.cid = cid;
		this.id = id;
		this.bookid = bookid;
		this.num = num;
		this.name=name;
		this.price=price;
	}
}