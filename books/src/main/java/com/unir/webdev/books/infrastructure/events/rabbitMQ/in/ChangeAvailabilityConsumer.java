package com.unir.webdev.books.infrastructure.events.rabbitMQ.in;

import com.unir.webdev.books.application.ChangeAvailabilityUseCase;
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
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ChangeAvailabilityConsumer {
    ChangeAvailabilityUseCase changeAvailabilityUseCase;

    @RabbitListener (queues = "${rabbitmq.in.books.queue}")
    public void handleMessage(@NotNull List<UUID> message) {
        Option.of(message)
              .map(io.vavr.collection.List :: ofAll)
              .map(changeAvailabilityUseCase :: changeAvailability);
        log.info("gettin event notification "+message.get(0).toString());
    }

}
