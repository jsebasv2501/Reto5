package com.example.reto5.reto5.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="message")
public class Message implements Serializable{
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="machineId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Machine machine;

    @ManyToOne
    @JoinColumn(name="clienteId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Clientes client;

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messagetext) {
        this.messageText = messagetext;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes clients) {
        this.client = clients;
    }


    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine2) {
        this.machine = machine2;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer id) {
        this.idMessage = id;
    }

}    
