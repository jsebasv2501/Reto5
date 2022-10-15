package com.example.reto5.reto5.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto5.reto5.model.Machine;
import com.example.reto5.reto5.repository.MachineRepository;

@Service
public class MachineService {
    
    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll(){
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id){
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine m){
        if(m.getId() == null){
            return machineRepository.save(m);
        }else{
            Optional<Machine> mAux = machineRepository.getMachine(m.getId());
            if(mAux.isEmpty()){
                return machineRepository.save(m);
            }else{
                return m;
            }
        }
    }

    public Machine update(Machine m){
        if(m.getId() != null){
            Optional<Machine> mAux = machineRepository.getMachine(m.getId());
            if(!mAux.isEmpty()){
                if(m.getName() != null){
                    mAux.get().setName(m.getName());
                }
                if(m.getBrand() != null){
                    mAux.get().setBrand(m.getBrand());
                }

                if(m.getDescription() !=null){
                    mAux.get().setDescription(m.getDescription());
                }

                if(m.getName() != null){
                    mAux.get().setName(m.getName());
                }

                if(m.getYear() != null){
                    mAux.get().setYear(m.getYear());
                }

                if(m.getCategory() != null){
                    mAux.get().setCategory(m.getCategory());
                }

                if(m.getMessages() != null){
                    mAux.get().setMessages(m.getMessages());
                }

                if(m.getReservations() != null){
                    mAux.get().setReservations(m.getReservations());
                }

                machineRepository.save(mAux.get());
                return mAux.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }

    public boolean deleteMachine(int id){
        Boolean aBoolean = getMachine(id).map(machine -> {
            machineRepository.borrar(machine);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
