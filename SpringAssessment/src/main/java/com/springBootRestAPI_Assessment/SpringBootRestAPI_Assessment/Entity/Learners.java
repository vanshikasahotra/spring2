package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="learners")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Learners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String learner_first_name;

    public String getLearner_first_name() {
        return learner_first_name;
    }

    public String getLearner_last_name() {
        return learner_last_name;
    }

    public void setLearner_first_name(String learner_first_name) {
        this.learner_first_name = learner_first_name;
    }

    public void setLearner_last_name(String learner_last_name) {
        this.learner_last_name = learner_last_name;
    }

    public void setLearner_email(String learner_email) {
        this.learner_email = learner_email;
    }

    public void setLearner_password(String learner_password) {
        this.learner_password = learner_password;
    }

//    public void setCourse_id(int course_id) {
//        this.course_id = course_id;
//    }

    public String getLearner_email() {
        return learner_email;
    }

    public String getLearner_password() {
        return learner_password;
    }

//    public int getCourse_id() {
//        return course_id;
//    }

    private String learner_last_name;
    private String learner_email ;
    private String learner_password;
//    private int course_id;
}
