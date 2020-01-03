package com.meru.PriceService.events;

import java.io.Serializable;
import java.time.Instant;

public class PromotionEvent implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4990135614613556898L;
	private String eventid;
	private int productid;
	private int discountpercentage;
	//private Instant eventtime;
	
	public PromotionEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PromotionEvent(String eventid, int productid, int discountpercentage, Instant eventtime) {
		super();
		this.eventid = eventid;
		this.productid = productid;
		this.discountpercentage = discountpercentage;
		//this.eventtime = eventtime;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getDiscountpercentage() {
		return discountpercentage;
	}
	public void setDiscountpercentage(int discountpercentage) {
		this.discountpercentage = discountpercentage;
	}
	/*
	 * public Instant getEventtime() { return eventtime; } public void
	 * setEventtime(Instant eventtime) { this.eventtime = eventtime; }
	 */
	
	
}
