//package com.book.rabbitmqconfig;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MessagingConfig {
//
//    public static final String QUEUE = "book_queue";
//    public static final String EXCHANGE = "book_exchange";
//    public static final String ROUTING_KEY = "book_routingKey";
//
//    @Bean
//    public Queue queue() {
//        return new Queue("book_queue");
//    }
//
//    @Bean
//    public TopicExchange exchange() {
//        return new TopicExchange("book_exchange");
//    }
//
//    @Bean
//    public BindingBuilder.GenericArgumentsConfigurer binding(Queue queue, Exchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("book_routingKey");
//    }
//
//    @Bean
//    public MessageConverter converter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public AmqpTemplate template(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(converter());
//        return rabbitTemplate;
//    }
//}