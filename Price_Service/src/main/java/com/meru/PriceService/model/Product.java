package com.meru.PriceService.model;

import java.io.Serializable;
import java.util.Properties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;


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
