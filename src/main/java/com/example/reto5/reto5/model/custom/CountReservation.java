package com.example.reto5.reto5.model.custom;

import com.example.reto5.reto5.model.Clientes;


public class CountReservation {
    
    private Long total;

    private Clientes client;

    public CountReservation(Long total, Clientes client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Clientes getClient() {
        return client;
    }

    public void setClient(Clientes client) {
        this.client = client;
    }



}
