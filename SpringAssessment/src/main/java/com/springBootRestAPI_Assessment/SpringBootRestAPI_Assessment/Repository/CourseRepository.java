package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Repository;

import com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
