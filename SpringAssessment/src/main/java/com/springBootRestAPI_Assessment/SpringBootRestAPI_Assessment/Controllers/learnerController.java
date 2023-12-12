package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Controllers;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Courses;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Learners;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Services.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learner")
public class learnerController {
    @Autowired
    LearnerService learnerService;

    //read
    @GetMapping("/getAll")
    public List<Learners> getAllLearners(){
        return learnerService.getAllLearners();
    }

    @GetMapping("/{id}")
    public Learners getLearnerById(@PathVariable int id){
        return learnerService.getLearnerById(id);
    }

    //create
    @PostMapping("/add")
    public Learners createLearner(@RequestBody Learners learner){
        return learnerService.createLearner(learner);
    }

    //delete
    @GetMapping("/del/{id}")
    public void deleteLearner(@PathVariable int id){
        learnerService.deleteLearner(id);
    }

    @PutMapping("/update/{id}")
    public Learners updateCourse(@PathVariable int id, @RequestBody Learners learner) throws Exception {
        return learnerService.updateLearner(id,learner);
    }

    //totalLearners
    @GetMapping("/total")
    public long totalLearners(){
        return learnerService.numOfLearners();
    }

    //Exist or Not
    @GetMapping("/exist/{id}")
    public boolean checkExist(@PathVariable int id){
        return learnerService.learnerExist(id);
    }
}
