package com.example.reto5.reto5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto5.reto5.model.Message;
import com.example.reto5.reto5.repository.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>)messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(Integer id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message m){
        return messageCrudRepository.save(m);
    }

    public void borrar(Message m){
        messageCrudRepository.delete(m);
    }
}
