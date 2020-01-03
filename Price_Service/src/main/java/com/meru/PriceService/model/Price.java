package com.meru.PriceService.model;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

@Entity
public class Price implements Serializable,IdentifierGenerator,Configurable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8381339782996577069L;
	@Id
	@GenericGenerator(name = "prod_id", strategy = "com.meru.PriceService.model.Price")
	@GeneratedValue(generator = "prod_id")  
	@Column(name="productid")
	private Integer productid;
	private float price;
	
	public Price() {}
	
	public Price(Integer productid, float price) {
		System.out.println(" _Price___ ");
		this.productid = productid;
		this.price = price;
	}
	
    
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
	
	public String toString() {
		return Float.toString(this.price);
	}
	

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		//System.out.println(((Price)object).getPrice());//.getPrice()
		//System.out.println(" Id :::: "+getProductid()+">> "+this.productid); 
		return ((Price)object).getProductid();
	}

	@Override
	public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
		// TODO Auto-generated method stub
		
	}
	
}



