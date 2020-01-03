package com.meru.promotion.service;

import java.time.Instant;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.meru.promotion.events.PromotionEvent;
import com.meru.promotion.model.Promotion;
import com.meru.promotion.repository.PromotionRepository;

@Service
public class PromotionService {

	@Value("${service.success.status}")
	private String SUCCESS; 
	@Value("${service.failure.status}")
	private String FAILURE; 
	
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private Queue queue; 
	@Autowired
	private JmsTemplate jmsTemplate;
	
	public String addOffer(Promotion promotion) {
		Promotion promotionNew=promotionRepository.save(promotion);
		if(promotionNew!=null) {
			try {
				discountOffered(promotionNew);
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return FAILURE;
			}
			return SUCCESS;
		}
		else return FAILURE;
	}
	
	public Promotion findPromotion(int productid) {
		Promotion promotion =promotionRepository.findById(productid).get();
		return promotion;
	}
	
	
	public void discountOffered(Promotion promotion) throws JMSException {
	    Date date=new Date();
	    Instant instant = date.toInstant();
		System.out.println(" Stock Updated Event at "+instant);
		PromotionEvent promotionEvent=new PromotionEvent("PE"+promotion.getProductid(),promotion.getProductid(), promotion.getPercentage(),instant);
		Gson gson=new Gson();
		String  eventStr=gson.toJson(promotionEvent);
		System.out.println("Intiate Event to queue "+queue.getQueueName());
		jmsTemplate.convertAndSend(queue, eventStr);
	}
	
}
