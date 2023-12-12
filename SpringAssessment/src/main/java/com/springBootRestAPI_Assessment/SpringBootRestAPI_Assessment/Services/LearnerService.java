package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Services;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Learners;
import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepository learnerRepository;

    //Create learner
    public Learners createLearner(Learners learner){
        return learnerRepository.save(learner);
    }

    //Read learner
    //get all users
    public List<Learners> getAllLearners(){
        return learnerRepository.findAll();
    }

    //get learner by id
    public Learners getLearnerById(int id){
        return learnerRepository.findById(id).get();
    }

    //delete learner
    public void deleteLearner(int id){
        Optional<Learners> tempLearner=learnerRepository.findById(id);
        if(tempLearner.isEmpty()){
            throw new RuntimeException("Learner doesn't exist");
        }
        learnerRepository.deleteById(id);
    }

    //update learner
    public Learners updateLearner(int id, Learners learnerEntry) throws Exception {
        Learners tempLearner=learnerRepository.findById(id)
        .orElseThrow(()-> new Exception("Learner does not exist"));

        if(learnerEntry.getLearner_first_name()!=null && !learnerEntry.getLearner_first_name().isEmpty()){tempLearner.setLearner_first_name(learnerEntry.getLearner_first_name());}
        if(learnerEntry.getLearner_last_name()!=null && !learnerEntry.getLearner_last_name().isEmpty())tempLearner.setLearner_last_name(learnerEntry.getLearner_last_name());
        learnerRepository.save(tempLearner);

        return tempLearner;
    }

    //Total no. of entities
    public long numOfLearners(){
        return learnerRepository.count();
    }

    //Weather given Id exist
    public boolean learnerExist(int id){
        Optional<Learners> tempLearner=learnerRepository.findById(id);
        return tempLearner.isPresent();
    }
}
