package com.unir.webdev.books.infrastructure.searchfilter.inerface;

import com.unir.webdev.books.infrastructure.searchfilter.entity.BookEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.UUID;


public interface ElastikInterface extends ElasticsearchRepository<BookEntity, UUID> {}
