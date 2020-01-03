package com.meru.PriceService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.meru.PriceService.events.PromotionEvent;
import com.meru.PriceService.model.Price;


@Component
//@EnableJms
public class EventListener {
	private Gson gson; 
	@Autowired
	private PriceService  priceService;
	
	@JmsListener(destination ="promotion.update")
	public void promotionListener(String message){
        System.out.println("promtionListener Message received {} "+ message);
        
        
        int productid;
		float newPrice;
		try {
			gson=new Gson();
			System.out.println(" convert to object ");
			PromotionEvent promotionEvent =gson.fromJson(message, PromotionEvent.class);
			System.out.println(" converted to object ");
			productid = promotionEvent.getProductid();
			int discountpercentage=promotionEvent.getDiscountpercentage();
			Price price=  priceService.getPrice(productid);
			float pricevalue=price.getPrice();
			newPrice = 0F;
			if(discountpercentage!=0) {
			newPrice=pricevalue-((pricevalue*discountpercentage)/100);
			//price.setPrice(newPrice);
			
			}
			 priceService.changePrice(productid, newPrice);
		     System.out.println("Price updated !");
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			System.out.println("JsonSyntaxException !");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception !");
			e.printStackTrace();
		}
        
       
      
	}
	
	
}
