package com.meru.ProductViewService.model;

import java.io.Serializable;
import java.util.Properties;

public class Product {

	public Product() {}
	public Product(Integer productid,String productName,float price,short isInStock) {
		this.productid=productid;
		this.productname=productName;
		this.price=price;
		this.isinstock=isInStock;
	}
	private Integer productid;
	private String productname;
	private float price;
	
	private short isinstock;
	
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public short getIsinstock() {
		return isinstock;
	}
	public void setIsinstock(short isinstock) {
		this.isinstock = isinstock;
	}
	
}
