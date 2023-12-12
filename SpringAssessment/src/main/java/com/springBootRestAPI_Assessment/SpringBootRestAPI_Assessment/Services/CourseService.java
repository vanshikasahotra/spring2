package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Services;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Courses;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Learners;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    //create course
    public Courses createCourse(Courses course){
        return courseRepository.save(course);
    }
    //read course
    //get all courses
    public List<Courses> getAllCourses(){
        return courseRepository.findAll();
    }

    //get course by id
    public Courses getCourseById(int id){
        return courseRepository.findById(id).get();
    }

    //delete course by id
    public void deleteCourse(int id){
        Optional<Courses> tempCourse=courseRepository.findById(id);
        if(tempCourse.isEmpty()){
            throw new RuntimeException("No such course exist");
        }
        courseRepository.deleteById(id);
    }

    //Total no. of entities
    public long numOfCourses(){
        return courseRepository.count();
    }
    //update course
    public Courses updateCourse(int id,Courses courseEntry) throws Exception {
        Courses tempCourse = courseRepository.findById(id).orElseThrow(() -> new Exception("Course with ID " + id + " not found"));

        if (courseEntry.getCourse_name() != null && !courseEntry.getCourse_name().isEmpty()) {
            tempCourse.setCourse_name(courseEntry.getCourse_name());
        }

        // Check if course_description is not null and not empty
        if (courseEntry.getCourse_description() != null && !courseEntry.getCourse_description().isEmpty()) {
            tempCourse.setCourse_description(courseEntry.getCourse_description());
        }
        courseRepository.save(tempCourse);
        return tempCourse;
    }

    public boolean courseExist(int id){
        Optional<Courses> tempCourse=courseRepository.findById(id);
        return tempCourse.isPresent();
    }
}
