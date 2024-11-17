package com.AlanTitor.SpringLibrary;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Реализация бизнес логики для рабоыт с книгами
@Service
@RequiredArgsConstructor
public class DefaultIBookService implements IBookService {

    @Autowired
    private IBookRepository bookRepos;

    @Override
    public Book getBookById(Long id) throws BookUnavailableException {
        BookEntity bookEntity = bookRepos
                .findById(id)
                .orElseThrow(()-> new BookUnavailableException("Book not found: id = " + id));
        return convertToBook(bookEntity);
    }

    @Override
    public List<Book> findAllBooks() {
        Iterable<BookEntity> iterable = bookRepos.findAll();
        ArrayList<Book> books = new ArrayList<>();

        for(BookEntity bookEntity : iterable){
            books.add(convertToBook(bookEntity));
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = convertToBookEntity(book);
        bookRepos.save(bookEntity);
    }

    //коверторы из одного типа в другой
    private Book convertToBook(BookEntity bookEntity) {
        return new Book(bookEntity.getId(), bookEntity.getName_of_book(), bookEntity.getAuthor_of_book(), bookEntity.getYear_of_publish(), bookEntity.getCost());
    }
    private BookEntity convertToBookEntity(Book book) {
        return new BookEntity(null, book.getName_of_book(), book.getAuthor_of_book(), book.getYear_of_publish(), book.getCost());
    }
}
