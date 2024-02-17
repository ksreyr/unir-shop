package com.unir.webdev.books.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitConfig {


    @Value ("${rabbitmq.out.requests.exchange}")
    String exchange;

    @Value("${rabbitmq.out.requests.routingkey}")
    private String routingkey;

    @Bean
    Queue queue2(@Value ("${rabbitmq.in.books.queue}")String queueName) {
        log.info("--:::::::::::::: CREATION QUEUE ONE:::::::::::::::::::::-");
        return new Queue(queueName, false);
    }

    @Bean
    Queue queue(@Value ("${rabbitmq.out.requests.queue}")String queueName) {
        log.info("--:::::::::::::: CREATION QUEUE TWO:::::::::::::::::::::-");
        return new Queue(queueName, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
