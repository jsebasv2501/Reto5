package com.example.reto5.reto5.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.reto5.reto5.model.Machine;
import com.example.reto5.reto5.repository.crud.MachineCrudRepository;

@Repository
public class MachineRepository {
    
    @Autowired
    private MachineCrudRepository machineCrudRepository;

    public List<Machine> getAll(){
        return (List<Machine>)machineCrudRepository.findAll();
    }

    public Optional<Machine> getMachine(Integer id){
        return machineCrudRepository.findById(id);
    }

    public Machine save(Machine m){
        return machineCrudRepository.save(m);
    }

    public void borrar(Machine m){
        machineCrudRepository.delete(m);
    }
}
