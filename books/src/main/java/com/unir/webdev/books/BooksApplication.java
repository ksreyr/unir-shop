package com.unir.webdev.books;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.core.publisher.Hooks;

import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
public class BooksApplication {
    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }
    @Configuration
    public class MyConfiguration implements WebMvcConfigurer {
        @Bean
        ContainerCustomizer<SimpleMessageListenerContainer> containerCustomizer() {
            return container -> container.setObservationEnabled(true);
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }

}
