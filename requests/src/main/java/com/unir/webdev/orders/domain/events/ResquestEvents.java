package com.unir.webdev.orders.domain.events;

import java.util.List;
import java.util.UUID;

public interface ResquestEvents {
    void sendEventChangeAvailability(List<UUID> uuidList);
}
