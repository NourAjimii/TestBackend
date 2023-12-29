package com.example.testtech.services;


import com.example.testtech.models.Course;
import com.example.testtech.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public List<Course> retrieveAll() {
        return this.courseRepository.findAll();
    }
    
    public Course add(Course e) {
        return this.courseRepository.save(e);
    }

    public Course update(int id,Course e) {
        Course course = courseRepository.findById(id).orElse(null);
        if(course!=null){
            course.setPrice(e.getPrice());
            course.setImage(e.getImage());
        }
        return this.courseRepository.save(e);
    }

    public Course retrieve(int id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    public void remove(int id){
        Course course = courseRepository.findById(id).orElse(null);
        this.courseRepository.delete(course);
    }



}
