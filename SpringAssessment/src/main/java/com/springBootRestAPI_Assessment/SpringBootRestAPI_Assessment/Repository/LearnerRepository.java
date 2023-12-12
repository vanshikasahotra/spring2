package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Repository;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learners,Integer> {
}
