package com.unir.webdev.books.application;

import com.unir.webdev.books.domain.Book;
import com.unir.webdev.books.domain.repository.SearchInterface;
import com.unir.webdev.books.domain.response.Result;
import io.vavr.control.Either;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults (level = AccessLevel.PRIVATE, makeFinal = true)
public class GetAllBooksUseCase {
    SearchInterface searchInterface;
    public GetAllBooksUseCase(@Qualifier ("ElaImp") SearchInterface searchInterface)
    {
        this.searchInterface = searchInterface;
    }

    public @NotNull Either<String, List<Book>> getAllProducts() {
        return Either.right(searchInterface.getAllBooks());
    }
}
