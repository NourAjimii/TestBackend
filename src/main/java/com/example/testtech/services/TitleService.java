package com.example.testtech.services;

import com.example.testtech.models.Title;
import com.example.testtech.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;
    public List<Title> retrieveAll() {
        return this.titleRepository.findAll();
    }

    public Title add(Title e) {
        return this.titleRepository.save(e);
    }

    public Title update(int id,Title e) {
        Title title = titleRepository.findById(id).orElse(null);
        if(title!=null){
            title.setNom(e.getNom());
        }
        return this.titleRepository.save(e);
    }

    public Title retrieve(int id) {
        return this.titleRepository.findById(id).orElse(null);
    }

    public void remove(int id){
        Title title = titleRepository.findById(id).orElse(null);
        this.titleRepository.delete(title);
    }
    
}
