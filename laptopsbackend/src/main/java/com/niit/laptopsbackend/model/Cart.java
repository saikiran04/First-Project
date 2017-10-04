package com.niit.laptopsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="userid",insertable=false,updatable=false)
	private User cartuser;
	private int userid;
	
	@ManyToOne
	@JoinColumn(name="prodid",insertable=false,updatable=false)
	private Product cartproduct;
	private int prodid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public User getCartuser() {
		return cartuser;
	}
	public void setCartuser(User cartuser) {
		this.cartuser = cartuser;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Product getCartproduct() {
		return cartproduct;
	}
	public void setCartproduct(Product cartproduct) {
		this.cartproduct = cartproduct;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	

}
