package com.meru.PriceService.events;

import java.time.Instant;

public class PriceEvent {

	private String eventid;
	private int productid;
	private float price;
	private Instant eventtime;
	
	public PriceEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PriceEvent(String eventid, int productid, float price, Instant eventtime) {
		super();
		this.eventid = eventid;
		this.productid = productid;
		this.price = price;
		this.eventtime = eventtime;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Instant getEventtime() {
		return eventtime;
	}

	public void setEventtime(Instant eventtime) {
		this.eventtime = eventtime;
	}

	
	
	
}
