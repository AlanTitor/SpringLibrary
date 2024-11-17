package com.AlanTitor.SpringLibrary;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Обработка HTTP запросов
@RestController()
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private final IBookService IBookService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws BookUnavailableException {
        return IBookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return IBookService.findAllBooks();
    }

    @PostMapping
        public void addBook(@RequestBody BookRequest request) {
        Book book = convertToBook(request);
        IBookService.addBook(book);
    }

    private Book convertToBook(BookRequest request) {
        return new Book(request.getId(), request.getName_of_book(), request.getAuthor_of_book(), request.getYear_of_publish(), request.getCost());
    }

}
