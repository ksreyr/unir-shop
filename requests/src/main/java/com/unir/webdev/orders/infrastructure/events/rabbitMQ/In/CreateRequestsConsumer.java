package com.unir.webdev.orders.infrastructure.events.rabbitMQ.In;

import com.unir.webdev.orders.application.RegisterNewRequestUseCase;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
@Slf4j
public class CreateRequestsConsumer {
    final RegisterNewRequestUseCase registerNewRequestUseCase;

    @RabbitListener (queues = "${rabbitmq.in.requests.queue}")
    public void handleMessage(@NotNull List<UUID> message) {
        Option.of(message).map(registerNewRequestUseCase :: createNewOder);
        log.info("gettin event notification");
    }
}