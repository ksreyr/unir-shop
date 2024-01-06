package com.unir.webdev.products.infrastructur.persistence.mappers;

import com.unir.webdev.products.domain.Product;
import com.unir.webdev.products.domain.valueObjects.Category;
import com.unir.webdev.products.domain.valueObjects.Description;
import com.unir.webdev.products.domain.valueObjects.Image;
import com.unir.webdev.products.domain.valueObjects.Price;
import com.unir.webdev.products.domain.valueObjects.ProductName;
import com.unir.webdev.products.domain.valueObjects.SellerName;
import com.unir.webdev.products.domain.valueObjects.SmallDescription;
import com.unir.webdev.products.infrastructur.persistence.entity.ProductEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.CategoryEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.DescriptionEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ImageEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.PriceEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ProductNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SellerNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SmallDescriptionEntity;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class ProductMapper {
    @Contract ("_ -> new")
    public static @NotNull Product fromDbToDomain(@NotNull ProductEntity productEntity) {
        return new Product(productEntity.getProductId(),
                new ProductName(productEntity.getProductNameEntity().productName()),
                new Price(productEntity.getPriceEntity().price()),
                new Image(productEntity.getImageEntity().url()),
                new SmallDescription(productEntity.getSmallDescriptionEntity().smallDescription()),
                new Description(productEntity.getDescriptionEntity().description()),
                new SellerName(productEntity.getSellerNameEntity().sellerName()),
                new Category(productEntity.getCategoryEntity().category()));
    }

    @Contract ("_ -> new")
    public static @NotNull ProductEntity fromDomainToDb(@NotNull Product product) {
        return new ProductEntity
                (product.productId(),
                        new ProductNameEntity(product.productName().productName()),
                        new PriceEntity(product.price().price()),
                        new SmallDescriptionEntity(product.smallDescription().smallDescription()),
                        new DescriptionEntity(product.description().description()),
                        new SellerNameEntity(product.sellerName().sellerName()),
                        new CategoryEntity(product.category().category()),
                        new ImageEntity(product.image().url()));
    }
}
