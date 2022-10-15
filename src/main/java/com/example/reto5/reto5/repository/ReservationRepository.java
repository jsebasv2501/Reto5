package com.example.reto5.reto5.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto5.reto5.model.Clientes;
import com.example.reto5.reto5.model.Reservation;
import com.example.reto5.reto5.model.custom.CountReservation;
import com.example.reto5.reto5.repository.crud.ReservationCrudRepository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(Integer id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }

    public void borrar(Reservation m){
        reservationCrudRepository.delete(m);
    }

    public List<Reservation> getReservartionsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationsPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountReservation> getTopClients(){
        List<CountReservation> res = new ArrayList<>();

        List<Object[]> reporte = reservationCrudRepository.CountTotalReservationByClient();

        for(int i = 0; i < reporte.size(); i++){
            res.add(new CountReservation((Long) reporte.get(i)[1], (Clientes) reporte.get(i)[0]));
        }

        return res;
    }
}
