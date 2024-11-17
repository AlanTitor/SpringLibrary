package com.AlanTitor.SpringLibrary;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Value;


//Основной класс. Объект бизнес логики
@Entity
@Value
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name_of_book;
    String author_of_book;
    String year_of_publish;
    Double cost;


    @Override
    public String toString() {
        return "Book " + this.name_of_book + " author " + this.author_of_book + " year " + this.year_of_publish + " cost " + this.cost;
    }

}

