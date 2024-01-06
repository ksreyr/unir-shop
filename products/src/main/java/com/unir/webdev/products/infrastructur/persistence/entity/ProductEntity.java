package com.unir.webdev.products.infrastructur.persistence.entity;

import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.CategoryEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.DescriptionEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ImageEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.PriceEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ProductNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SellerNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SmallDescriptionEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID productId;

    @Embedded
    ProductNameEntity productNameEntity;

    @Embedded
    PriceEntity priceEntity;

    @Embedded
    SmallDescriptionEntity smallDescriptionEntity;

    @Embedded
    DescriptionEntity descriptionEntity;

    @Embedded
    SellerNameEntity sellerNameEntity;

    @Embedded
    CategoryEntity categoryEntity;

    @Embedded
    ImageEntity imageEntity;
}
