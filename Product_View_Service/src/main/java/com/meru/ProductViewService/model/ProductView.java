package com.meru.ProductViewService.model;

public class ProductView {

	/*
	 * private String productname; private int productid; private float
	 * productPrice; private boolean isInStock;
	 * 
	 */
	
	private Product product;
	private int discount;
	private int discountduration;
	
	
	public ProductView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductView(Product product, int discount, int discountduration) {
		super();
		this.product = product;
		this.discount = discount;
		this.discountduration = discountduration;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getDiscountduration() {
		return discountduration;
	}
	public void setDiscountduration(int discountduration) {
		this.discountduration = discountduration;
	}
	
}
