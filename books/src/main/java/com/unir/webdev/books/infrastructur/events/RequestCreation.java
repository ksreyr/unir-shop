package com.unir.webdev.books.infrastructur.events;

import java.util.List;
import java.util.UUID;

public record RequestCreation(List<UUID> booksIDList) {}
