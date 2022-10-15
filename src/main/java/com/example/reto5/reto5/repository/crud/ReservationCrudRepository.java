package com.example.reto5.reto5.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.reto5.reto5.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);

    @Query("select r.client, COUNT(r.client) from Reservation AS r group by r.client order by COUNT(r.client) desc")
    public List<Object[]> CountTotalReservationByClient();

    
}
