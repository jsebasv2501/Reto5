package com.example.reto5.reto5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.reto5.reto5.model.Clientes;
import com.example.reto5.reto5.service.ClientesService;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.POST})
public class ClientesController {
    
    @Autowired
    private ClientesService clientesService;

    @GetMapping("/all")
    public List<Clientes> getClientes(){
        return clientesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> getCliente(@PathVariable("id") int id){
        return clientesService.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes saveClietes(@RequestBody Clientes c){
        return clientesService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes c){
        return clientesService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clientesService.deleteCliente(id);
    }
}
