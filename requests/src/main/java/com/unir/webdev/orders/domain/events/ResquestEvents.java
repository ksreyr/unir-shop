package com.unir.webdev.orders.domain.events;

import io.vavr.control.Either;

import java.util.List;
import java.util.UUID;

public interface ResquestEvents {
    Either<String, Boolean> sendEventChangeAvailability(List<UUID> uuidList);
}
