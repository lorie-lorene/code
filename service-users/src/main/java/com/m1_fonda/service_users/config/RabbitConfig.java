package com.m1_fonda.service_users.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;

// import java.util.Queue;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitConfig {

    // configuration d'un convertisseur de message pour gerer la serialisation et la deserialisation
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    // configuration de RabbitTemplate pour utiliser ce convertisseur
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    // cree une liste d'attentes ou il vas publier ses informations 
    public TopicExchange userExchange(){
        return new TopicExchange("userExchange");
    }

    @Bean 
    public Queue userQueue(){
        return new Queue("userQueue");
    }
    
     // declaration de la file d'attente du producteur copy si elle n'a pas encore ete creer
    @Bean 
    public Queue userQueue1(){
        return new Queue("userCopy",true,false,false);
    }

    @Bean 
    public Binding binding(TopicExchange userExchange,Queue userQueue){
        return BindingBuilder.bind(userQueue).to(userExchange).with("user.create");
    }
}
