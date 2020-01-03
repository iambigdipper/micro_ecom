package com.meru.PriceService.Service;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("price.update");//"promotion.update"
    }


}
