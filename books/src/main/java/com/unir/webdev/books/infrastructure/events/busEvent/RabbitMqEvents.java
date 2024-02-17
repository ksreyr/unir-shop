package com.unir.webdev.books.infrastructure.events.busEvent;

import com.unir.webdev.books.domain.events.BookEvents;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
@Primary
public class RabbitMqEvents implements BookEvents {
    final RabbitTemplate amqpTemplate;

    @Value ("${rabbitmq.exchange}")
    String exchange;

    @Value ("${rabbitmq.routingkey}")
    String routingkey;

    @Override
    public Either<String, Boolean> requestBooksCreation(java.util.List<UUID> booksID) {
        return Try.of(() -> {
                      amqpTemplate.convertAndSend(
                              exchange,
                              routingkey,
                              booksID);
                      return true;
                  })
                  .toEither("Error sending message");
    }
}
