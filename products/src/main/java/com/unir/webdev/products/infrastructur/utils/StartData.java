package com.unir.webdev.products.infrastructur.utils;

import com.unir.webdev.products.infrastructur.persistence.ProductRepositoryJPA;
import com.unir.webdev.products.infrastructur.persistence.entity.ProductEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.CategoryEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.DescriptionEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ImageEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.PriceEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.ProductNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SellerNameEntity;
import com.unir.webdev.products.infrastructur.persistence.entity.valueObjects.SmallDescriptionEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Service
public class StartData {
    ProductRepositoryJPA productRepositoryJPA;

    @EventListener (ApplicationReadyEvent.class)
    public void persistDataAfterStart() {
        productRepositoryJPA.saveAll(
                List.of(
                new ProductEntity(
                        UUID.randomUUID(),
                        new ProductNameEntity("Zapatillas Deportivas"),
                        new PriceEntity(79.99F),
                        new SmallDescriptionEntity("Zapatillas ligeras para correr"),
                        new DescriptionEntity("Zapatillas de alto rendimiento para " +
                                              "correr, con soporte de arco y " +
                                              "amortiguación. Ideales para " +
                                              "entrenamientos y competiciones."),
                        new SellerNameEntity("Deportes Max"),
                        new CategoryEntity("Ropa y Accesorios Deportivos"),
                        new ImageEntity("http://thecatapi.com/api/images/get?format=src" +
                                        "&type=gif")),
                new ProductEntity(
                        UUID.randomUUID(),
                        new ProductNameEntity("Smartphone X200"),
                        new PriceEntity(499.00F),
                        new SmallDescriptionEntity("Smartphone de última generación"),
                        new DescriptionEntity("Smartphone con pantalla de 6.5 pulgadas," +
                                              " cámara triple, 128GB de almacenamiento " +
                                              "y procesador de alta velocidad."),
                        new SellerNameEntity("Tecnologías Avanzadas"),
                        new CategoryEntity("Electrónica y Tecnología"),
                        new ImageEntity("http://thecatapi.com/api/images/get?format=src" +
                                        "&type=gif")),
                new ProductEntity(
                        UUID.randomUUID(),
                        new ProductNameEntity("Cafetera Eléctrica"),
                        new PriceEntity(120.00F),
                        new SmallDescriptionEntity("Cafetera automática para espresso"),
                        new DescriptionEntity("Cafetera eléctrica con sistema de " +
                                              "cápsulas, prepara espressos, lattes y " +
                                              "cappuccinos con solo tocar un botón."),
                        new SellerNameEntity("Hogar & Cocina"),
                        new CategoryEntity("Electrodomésticos"),
                        new ImageEntity("http://thecatapi.com/api/images/get?format=src" +
                                        "&type=gif"))
        ));

    }
}
