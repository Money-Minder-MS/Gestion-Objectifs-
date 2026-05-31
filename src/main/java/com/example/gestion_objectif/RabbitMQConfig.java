package com.example.gestion_objectif;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;  // ← new import
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE       = "notification.exchange";
    public static final String KEY_REVENUE    = "notification.revenue.ajoute";
    public static final String KEY_DEPENSE    = "notification.depense.ajoutee";
    public static final String KEY_OBJECTIF   = "notification.objectif.atteint";
    public static final String KEY_RECLAMATION= "notification.reclamation.creee";
    public static final String KEY_POST       = "notification.post.cree";

    @Bean
    public TopicExchange notificationExchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {  // ← new return type
        return new JacksonJsonMessageConverter();            // ← new class
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}