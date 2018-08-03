package com.beans;

import java.util.List;

public class Order {
	private String oid;
	private String id;
	private double total;
	private String receiver;
	private String address;
	private String post;
	private String mobile;
	private String message;
	private String state;
    private List<Cart_Books> cart_books;
    
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Cart_Books> getCart_books() {
		return cart_books;
	}
	public void setCart_books(List<Cart_Books> cart_books) {
		this.cart_books = cart_books;
	}
	public Order(String oid,String id, double total, String receiver, String address, String post, String mobile,
			String message) {
		super();
		this.oid = oid;
		this.id = id;
		this.total = total;
		this.receiver = receiver;
		this.address = address;
		this.post = post;
		this.mobile = mobile;
		this.message = message;
	}
	public Order() {
	
	}
	public Order(String oid, String id, double total, String receiver, String address, String post, String mobile,
			String message, String state, List<Cart_Books> cart_books) {
		super();
		this.oid = oid;
		this.id = id;
		this.total = total;
		this.receiver = receiver;
		this.address = address;
		this.post = post;
		this.mobile = mobile;
		this.message = message;
		this.state = state;
		this.cart_books = cart_books;
	}
	
	
	
	

}
