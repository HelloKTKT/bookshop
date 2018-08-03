package com.beans;

import java.util.List;

public class Cart_Books {
	private int cid;
	private String id;
	private String oid;
	private int bookid;
	private String name;
	private int number;
	private double allprice;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	public Cart_Books(String id, String oid, int bookid,String name, int number, double allprice) {
		super();
		this.id = id;
		this.oid = oid;
		this.bookid = bookid;
		this.name=name;
		this.number = number;
		this.allprice = allprice;
	}
	public Cart_Books() {
		
	}
}
