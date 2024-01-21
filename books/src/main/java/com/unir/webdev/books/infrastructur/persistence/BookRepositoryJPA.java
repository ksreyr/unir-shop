package com.unir.webdev.books.infrastructur.persistence;

import com.unir.webdev.books.infrastructur.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookRepositoryJPA extends JpaRepository<BookEntity, UUID>, JpaSpecificationExecutor<BookEntity> {

}
