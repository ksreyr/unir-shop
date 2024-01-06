package com.unir.webdev.products.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unir.webdev.products.domain.valueObjects.Category;
import com.unir.webdev.products.domain.valueObjects.Description;
import com.unir.webdev.products.domain.valueObjects.Image;
import com.unir.webdev.products.domain.valueObjects.Price;
import com.unir.webdev.products.domain.valueObjects.ProductName;
import com.unir.webdev.products.domain.valueObjects.SellerName;
import com.unir.webdev.products.domain.valueObjects.SmallDescription;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @JsonProperty
    UUID productId;
    @JsonProperty
    ProductName productName;
    @JsonProperty
    Price price;
    @JsonProperty
    Image image;
    @JsonProperty
    SmallDescription smallDescription;
    @JsonProperty
    Description description;
    @JsonProperty
    SellerName sellerName;
    @JsonProperty
    Category category;
}
