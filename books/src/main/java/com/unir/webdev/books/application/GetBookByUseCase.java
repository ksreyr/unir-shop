package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.SearchInterface;
import com.unir.webdev.books.infrastructure.repositories.BookRepositoryElaImp;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
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

    public List<Book> getBookBy(String name, String author) {
        return searchInterface.getBooksBy(author, "", "", false );
    }
}
