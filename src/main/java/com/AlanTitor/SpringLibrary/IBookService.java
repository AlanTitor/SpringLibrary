package com.AlanTitor.SpringLibrary;

import java.util.List;

//Интерфейс, определяющий контракт для работы с книгами.
public interface IBookService {
    Book getBookById(Long id) throws BookUnavailableException;
    List<Book> findAllBooks();
    void addBook(Book book);
}
