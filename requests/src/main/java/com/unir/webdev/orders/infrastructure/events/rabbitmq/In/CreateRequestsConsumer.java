package com.unir.webdev.orders.infrastructure.events.rabbitmq.In;

import com.unir.webdev.orders.application.RegisterNewRequestUseCase;
import io.micrometer.observation.annotation.Observed;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    @Observed (
            name = "create.request",
            contextualName = "Request",
            lowCardinalityKeyValues = {"booksType", "booksType2"}
    )
    public void handleMessage(@NotNull List<UUID> message) {
        Option.of(message).map(registerNewRequestUseCase :: createNewOder);
        log.info("gettin event notification");
    }
}