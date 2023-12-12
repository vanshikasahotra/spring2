package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Controllers;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Courses;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class courseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/getAll")
    public List<Courses> getAllCourse(){
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Courses getCourseById(@PathVariable int id){
        return courseService.getCourseById(id);
    }

    @PostMapping("/add")
    public Courses createCourse(@RequestBody Courses course){
        return courseService.createCourse(course);
    }

    @GetMapping("/del/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }
    @PutMapping("/update/{id}")
    public Courses updateCourse(@PathVariable int id,@RequestBody Courses course) throws Exception {
        return courseService.updateCourse(id,course);
    }

    @GetMapping("/total")
    public long totalCourses(){
        return courseService.numOfCourses();
    }

    @GetMapping("/exist/{id}")
    public boolean checkExist(@PathVariable int id){
        return courseService.courseExist(id);
    }
}
