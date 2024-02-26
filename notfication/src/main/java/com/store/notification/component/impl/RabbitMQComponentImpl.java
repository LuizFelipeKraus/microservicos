package com.store.notification.component.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.store.notification.component.RabbitMQComponent;
import com.store.notification.service.impl.EmailServiceImpl;

@Component
public class RabbitMQComponentImpl  implements RabbitMQComponent {
    @Value("${rabbitmq.queue.name}")
    private String queue;

    @RabbitListener(queues = "order_notification")
    public void handleMessage(String message){
        String obj = EmailServiceImpl.convertToObject(message);

        String content = EmailServiceImpl.constructContent();

        EmailServiceImpl.sendEmail(content, obj);
    }
}