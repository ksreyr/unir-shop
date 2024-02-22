package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.SearchInterface;
import com.unir.webdev.books.infrastructure.repositories.DTO.BooksResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults (makeFinal = true, level = AccessLevel.PRIVATE)
public class GetBookByUseCase {
    SearchInterface searchInterface;

    public GetBookByUseCase(@Qualifier ("ElaImp") SearchInterface searchInterface)
    {
        this.searchInterface = searchInterface;
    }

    public BooksResponse getBookBy(String searchCriteria, String anoPu, String idioma, Boolean v) {
        return searchInterface.buildResponse(searchCriteria, anoPu, v);
    }
}
