package com.book.rabbitmqconfig.publisher;

//import com.book.dto.Order;
//import com.book.dto.OrderStatus;
//import com.book.rabbitmqconfig.MessagingConfig;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.UUID;

//@RestController
//@RequestMapping("/order")
//public class OrderPublisher {
//
//    @Autowired
//    private RabbitTemplate template;
//
//    @RequestMapping("/{library}")
//    public String bookOrder(@RequestBody Order order, @PathVariable String library) {
//        order.setOrderId(UUID.randomUUID().toString());
//        //book service
//        //payment service
//        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order Places Successfully in Library :: " + library);
//        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
//        return "Success !!";
//    }
//}
