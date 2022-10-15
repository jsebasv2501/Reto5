package com.example.reto5.reto5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto5.reto5.model.Category;
import com.example.reto5.reto5.repository.CategoryRepository;



@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId() == null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> cAux = categoryRepository.getCategory(c.getId());
            if(cAux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Category update(Category c){
        if(c.getId() != null){
            Optional<Category> cAux = categoryRepository.getCategory(c.getId());
            if(!cAux.isEmpty()){
                if(c.getName() != null){
                    cAux.get().setName(c.getName());
                }    
                if(c.getDescription() != null){
                    cAux.get().setDescription(c.getDescription());
                }

                if(c.getMachines() !=null){
                    cAux.get().setMachines(c.getMachines());
                }
                categoryRepository.save(cAux.get());
                return cAux.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean deleteCategory(int id){
        Boolean aBoolean = getCategory(id).map(category ->{
            categoryRepository.borrar(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
