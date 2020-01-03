package com.meru.ProductViewService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.meru.ProductViewService.model.Product;
import com.meru.ProductViewService.model.ProductList;
import com.meru.ProductViewService.model.ProductView;
import com.meru.ProductViewService.model.ProductViewList;
import com.meru.ProductViewService.model.Promotion;

@Service
public class ProductViewService {

	static final String PRODUCT_URI_QUERY = "http://product-service/productdetails/";
	static final String PROMOTION_QUERY ="http://promotion-service/promotionffered/";
	@Autowired
    private RestTemplate restTemplate;
    
	public ProductView getProductView(int productid){
		
		String productquery=PRODUCT_URI_QUERY+productid;
		Product product=restTemplate.getForObject(productquery, Product.class);
		
		String promotionQuery=PROMOTION_QUERY+productid;
		Promotion promotion =restTemplate.getForObject(promotionQuery, Promotion.class);
		
		ProductView productView=new ProductView();
		productView.setProduct(product);
		
		if(promotion!=null){
		productView.setDiscount(promotion.getPercentage());
		productView.setDiscountduration(promotion.getDuration());
		}else {
			productView.setDiscount(0);
			productView.setDiscountduration(0);
		}
		return productView;
		
	}
	
	
	public ProductViewList getProductsView(){
		
		ProductList productList =restTemplate.getForObject(PRODUCT_URI_QUERY,ProductList.class);
		List<ProductView> products=new ArrayList<ProductView>();
		for(Product product:productList.getProducts()) {
			products.add(new ProductView(product,0,0));
		}
		ProductViewList productViewList=new ProductViewList();
		productViewList.setPrductViews(products);
		
		return productViewList;
		
	}
	
}
