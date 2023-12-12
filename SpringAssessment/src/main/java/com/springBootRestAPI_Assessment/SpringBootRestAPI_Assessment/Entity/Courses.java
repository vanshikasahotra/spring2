package com.springBootRestAPI_Assessment.SpringBootRestAPI_Assessment.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="courses")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String course_name;
    private String course_description;

}
