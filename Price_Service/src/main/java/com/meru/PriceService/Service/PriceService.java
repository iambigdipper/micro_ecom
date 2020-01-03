package com.meru.PriceService.Service;

import java.time.Instant;
import java.util.Date;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.meru.PriceService.Repository.PriceRepository;
import com.meru.PriceService.events.PriceEvent;
import com.meru.PriceService.model.Price;
import com.meru.PriceService.model.Product;

@Service
@RefreshScope
public class PriceService {
	private final static String SUCCESS="success"; 
	private final static String FAILURE="fail"; 
	
	@Autowired
	private PriceRepository priceRepository;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue queue; 
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${product.service.query}")
	private String PRODUCT_SERVICE_QUERY;                                           //="http://product-service/productdetails/";
	@Value("${product.service.update}")   
	private String PRODUCT_SERVICE_UPDATE;                                         //="http://product-service/updateproduct";
	
	public String changePrice(Integer productid,float priceValue) {
		if(priceRepository.existsById(productid)) {
			Price price=priceRepository.findById(productid).get();
			price.setPrice(priceValue);
			System.out.println(" >>>>>>>>>>>>>>>> ");
			Price priceChanged=priceRepository.save(price);
			System.out.println(" <<<<<<<<<<<<<<<<< ");
			if(priceChanged.getPrice()==priceValue) {
				//EventPriceChanged(priceChanged);
				priceStatusChanged(priceChanged);
				return SUCCESS;
			}
		}
		return FAILURE;
	}
	
	
	
    public String addPrice(Price price) {
    	   
    	    Price pricetoAdd=new Price(Integer.valueOf(price.getProductid()),price.getPrice());
    	    System.out.println(Integer.valueOf(price.getProductid()) +"--- "+price.getPrice());
    	    System.out.println("Add price :______________________________");
		    Price priceAdded =priceRepository.save(price);
			if(priceAdded.getProductid()==price.getProductid()) {
				System.out.println(" priceadded  ");
				return SUCCESS;
			}
		return FAILURE;
	}
    
    public Price getPrice(int productid) {
    	return priceRepository.findById(productid).get();
    }
    
    private void priceStatusChanged(Price priceChanged)
    {
    	
    	System.out.println(" ____________ priceStatusChanged ___ ");
    	final String uriQuery = PRODUCT_SERVICE_QUERY+priceChanged.getProductid();
        final String query=PRODUCT_SERVICE_UPDATE ;
    	
       
        Product product=restTemplate.getForObject(uriQuery, Product.class);
        product.setPrice(priceChanged.getPrice());
        Gson gson=new Gson();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);
        ResponseEntity<String> response =restTemplate.exchange(query, HttpMethod.PUT, entity, String.class);
        HttpStatus httpStatus =response.getStatusCode();
        System.out.println(httpStatus.getReasonPhrase());
    	//EventPriceChanged(priceChanged);
    }
    
	/*
	 * private void EventPriceChanged(Price priceChanged) {
	 * 
	 * //priceChanged.set Date date=new Date(); Instant instant= date.toInstant();
	 * PriceEvent priceEvent=new PriceEvent("PRC"+priceChanged.getProductid(),
	 * priceChanged.getProductid(), priceChanged.getPrice(), instant); Gson gson=new
	 * Gson(); gson.toJson(priceEvent); jmsTemplate.convertAndSend(queue, gson);
	 * System.out.println("Price Changed!");
	 * 
	 * }
	 */
    
    
   
   
    
	
}
