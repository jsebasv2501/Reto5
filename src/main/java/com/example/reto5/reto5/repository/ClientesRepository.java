package com.example.reto5.reto5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto5.reto5.model.Clientes;
import com.example.reto5.reto5.repository.crud.ClientesCrudRepository;

@Repository
public class ClientesRepository {
    
    @Autowired
    private ClientesCrudRepository clientesCrudRepository;

    public List<Clientes> getAll(){
        return (List<Clientes>)clientesCrudRepository.findAll();
    }

    public Optional<Clientes> getCliente(Integer id){
        return clientesCrudRepository.findById(id);
    }
    
    public Clientes save(Clientes c){
        return clientesCrudRepository.save(c);
    }

    public void borrar(Clientes c){
        clientesCrudRepository.delete(c);
    }
}
