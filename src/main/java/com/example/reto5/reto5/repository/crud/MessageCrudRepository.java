package com.example.reto5.reto5.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.reto5.reto5.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
