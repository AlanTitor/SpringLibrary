package com.AlanTitor.SpringLibrary;

import lombok.Data;

//Представляет объект запроса для добавления книги.
@Data
public class BookRequest {
    private Long id;
    private String name_of_book;
    private String author_of_book;
    private String year_of_publish;
    private Double cost;
}
