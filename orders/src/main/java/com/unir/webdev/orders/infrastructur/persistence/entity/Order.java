package com.unir.webdev.orders.infrastructur.persistence.entity;

import com.unir.webdev.orders.infrastructur.persistence.entity.valueObjects.DateInfo;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Order {
    @Id
    UUID id;
    @Embedded
    DateInfo dateInfo;
    @ElementCollection
    @Column(name = "product_id")
    List<UUID> productsID;
}
