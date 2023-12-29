package com.example.testtech.controllers;

import com.example.testtech.models.Title;
import com.example.testtech.services.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    @GetMapping("/getAll")
    public List<Title> getAll(){
        return titleService.retrieveAll();
    }

    @PostMapping("/add")
    public Title add(@RequestBody Title e){
        return this.titleService.add(e);
    }


    @PutMapping("/update/{id}")
    public Title update(@PathVariable("id")int id,@RequestBody Title e){
        return this.titleService.update(id,e);
    }


    @GetMapping("/{id}")
    public Title retrieveById(@PathVariable("id") int id) {
        return this.titleService.retrieve(id);
    }


    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") int id) {
        this.titleService.remove(id);

    }
}
