package com.example.reto5.reto5.service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto5.reto5.model.Reservation;
import com.example.reto5.reto5.model.custom.CountReservation;
import com.example.reto5.reto5.model.custom.StatusAmount;
import com.example.reto5.reto5.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> mAux = reservationRepository.getReservation(r.getIdReservation());
            if(mAux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservation update(Reservation r){
        if(r.getIdReservation() != null){
            Optional<Reservation> rAux = reservationRepository.getReservation(r.getIdReservation());
            if(!rAux.isEmpty()){
                if(r.getStartDate() != null){
                    rAux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate() != null){
                    rAux.get().setDevolutionDate(r.getDevolutionDate());
                }

                if(r.getStatus() !=null){
                    rAux.get().setStatus(r.getStatus());
                }

                if(r.getMachine() != null){
                    rAux.get().setMachine(r.getMachine());;
                }

                if(r.getClient() != null){
                    rAux.get().setClient(r.getClient());;
                }

                if(r.getScore() != null){
                    rAux.get().setScore(r.getScore());
                }
                reservationRepository.save(rAux.get());
                return rAux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReservation(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.borrar(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CountReservation> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public StatusAmount getStatusReport(){
        List<Reservation> completed = reservationRepository.getReservartionsByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservartionsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size()); 
    }

    public List<Reservation> getReservationPeriod(String d1, String d2){

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try{
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationsPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }

}
