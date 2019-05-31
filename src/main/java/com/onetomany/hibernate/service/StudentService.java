package com.onetomany.hibernate.service;

import com.onetomany.hibernate.repository.StudentRepository;
import com.onetomany.hibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String save(Student student) {

        System.out.println(student.toString());
        studentRepository.save(student);

        return "yes";
    }

}
