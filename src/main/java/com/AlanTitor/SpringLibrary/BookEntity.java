package com.AlanTitor.SpringLibrary;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Соответствует таблице в БД (Объект книги в БД)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_of_book;
    private String author_of_book;
    private String year_of_publish;
    private Double cost;
}
