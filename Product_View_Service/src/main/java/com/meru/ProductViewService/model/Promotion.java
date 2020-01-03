package com.meru.ProductViewService.model;



public class Promotion {
	
	public Promotion() {}
	public Promotion(int productid,int percentage,int durationInDays) {
		this.productid=productid;
		this.percentage=percentage;
		this.duration=durationInDays;
	}
	
	
	private int productid;
	private int percentage;
	private int duration;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
