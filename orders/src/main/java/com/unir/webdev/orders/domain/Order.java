package com.unir.webdev.orders.domain;

import com.unir.webdev.orders.domain.valueObjects.DateInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    UUID id;
    DateInfo dateInfo;
    List<UUID> productsID;
    public static Order of(List<UUID> productsID) {
        return new Order(UUID.randomUUID(), DateInfo.of(), productsID);
    }

    ;
}
