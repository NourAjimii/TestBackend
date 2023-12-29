package com.example.testtech.controllers;

import com.example.testtech.models.Course;
import com.example.testtech.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getAll")
    public List<Course> getAll(){
        return courseService.retrieveAll();
    }

    @PostMapping("/add")
    public Course add(@RequestBody Course e){
        return this.courseService.add(e);
    }


    @PutMapping("/update/{id}")
    public Course update(@PathVariable("id")int id,@RequestBody Course e){
        return this.courseService.update(id,e);
    }


    @GetMapping("/{id}")
    public Course retrieveById(@PathVariable("id") int id) {
        return this.courseService.retrieve(id);
    }


    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") int id) {
        this.courseService.remove(id);

    }

    @PutMapping("/addTitleToCourse/{idCourse}/{idTitle}")
    public Course addTitleToCourse(@PathVariable("idCourse")int idCourse,@PathVariable("idTitle")int idTitle ){
        return this.courseService.addTitleToCourse(idCourse,idTitle);
    }

}
