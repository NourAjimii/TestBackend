package com.example.testtech.services;


import com.example.testtech.models.Course;
import com.example.testtech.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testtech.models.Title;
import com.example.testtech.repositories.TitleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TitleRepository titleRepository;

    public List<Course> retrieveAll() {
        return this.courseRepository.findAll();
    }
    
    public Course add(Course e) {
        return this.courseRepository.save(e);
    }

    public Course update(int id,Course e) {
        Course course = courseRepository.findById(id).orElse(null);
        System.out.println("the id of the course to update is "+course.getIdCourse());
        if(course == null){
            return null;
        }else{
            course.setPrice(e.getPrice());
            course.setImage(e.getImage());
            courseRepository.save(course);
        }
        return course;

    }

    public Course retrieve(int id) {
        return this.courseRepository.findById(id).orElse(null);
    }

    public void remove(int id){
        Course course = courseRepository.findById(id).orElse(null);
        this.courseRepository.delete(course);
    }

    public Course addTitleToCourse(int idCourse, int idTitle){
        Course course = courseRepository.findById(idCourse).orElse(null);
        Title title = titleRepository.findById(idTitle).orElse(null);

        if (course == null || title == null){
            return null;
        }else{
            if (course.getTiles()==null){
                course.setTiles(new ArrayList<>());
                course.getTiles().add(title);
            }else {
                course.getTiles().add(title);
            }
        }
        return this.courseRepository.save(course);
    }


}
