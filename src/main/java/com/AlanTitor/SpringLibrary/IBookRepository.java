package com.AlanTitor.SpringLibrary;

import org.springframework.data.repository.CrudRepository;
//Для CRUD операций
public interface IBookRepository extends CrudRepository<BookEntity, Long> {

}