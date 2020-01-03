package com.meru.PriceService.Controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.meru.PriceService.Service.PriceService;
import com.meru.PriceService.model.Price;

@RestController
@RefreshScope
public class PriceController {

	@Autowired
	private PriceService priceService;
	@Value("{service.success.status}")
	private  String SUCCESS; 
	@Value("{service.failure.status}")
	private String FAILURE;
	
	@RequestMapping(method =RequestMethod.PUT,value="/changeprice")
	public String chanegPrice(@RequestBody Price price) {
		boolean isPriceChanged=false;
	    String status=priceService.changePrice(price.getProductid(), price.getPrice());	
		if(status.equalsIgnoreCase(SUCCESS)) {
			return SUCCESS;
		}
		return FAILURE;
	}
	

	@RequestMapping(method =RequestMethod.POST, value="/addprice")//, produces = MediaType.APPLICATION_JSON)
	
	public String addPrice(@RequestBody Price price) {
		boolean isPriceChanged=false;
		//System.out.println("Prod id "+price.getProductid());
	    String status=priceService.addPrice(price);	
		if(status.equalsIgnoreCase(SUCCESS))if(status.equalsIgnoreCase(SUCCESS)) {
			return SUCCESS;
		}
		return FAILURE;
	}
	
	
	@RequestMapping(method =RequestMethod.GET,value="/getprice/{prodcutid}")
	public Price getPrice(@PathVariable int prodcutid ) {
	    return priceService.getPrice(prodcutid);	
	}
	
	
	
	
}
