package com.meru.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meru.promotion.model.Promotion;
import com.meru.promotion.service.PromotionService;

@RestController
@RefreshScope
public class PromotionController {
    

	
	@Autowired
	private PromotionService promotionService;
	@Value("${service.success.status}")
	private String SUCCESS; 
	@Value("${service.failure.status}")
	private String FAILURE; 
	
	@RequestMapping(method =RequestMethod.POST,value="/promotionffered/{productid}/{offer}/{duration}")
	public String ServiceOffered(@PathVariable int productid,@PathVariable int offer,@PathVariable int duration) {
		String returnCode=FAILURE;
		Promotion promotion=new Promotion(productid, offer, duration);
		String status=promotionService.addOffer(promotion);
		if(status.equalsIgnoreCase(SUCCESS)) {
			returnCode=SUCCESS;
		}
		return returnCode;
	}
	
	@RequestMapping(method =RequestMethod.GET,value="/promotionffered/{productid}")
	public Promotion PromotionOffered(@PathVariable int productid) {
		Promotion promotion=promotionService.findPromotion(productid);
		return promotion;
	}
	
}
