package com.example.reto5.reto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto5.reto5.model.Score;
import com.example.reto5.reto5.repository.ScoreRepository;

@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getIdScore(id);
    }

    public Score save(Score s){
        if(s.getIdScore() == null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> sAux = scoreRepository.getIdScore(s.getIdScore());
            if(sAux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }

    public Score update(Score s){
        if(s.getIdScore() != null){
            Optional<Score> sAux = scoreRepository.getIdScore(s.getIdScore());
            if(!sAux.isEmpty()){
                if(s.getMessageText() != null){
                    sAux.get().setMessageText(s.getMessageText());
                }
                if(s.getStars() != null){
                    sAux.get().setStars(s.getStars());
                }

                if(s.getReservation() !=null){
                    sAux.get().setReservation(s.getReservation());
                }
                scoreRepository.save(sAux.get());
                return sAux.get();
            }else{
                return s;
            }
        }else{
            return s;
        }
    }

    public boolean deleteScore(int id){
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.borrar(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
