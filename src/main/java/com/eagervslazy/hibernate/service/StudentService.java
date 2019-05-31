package com.eagervslazy.hibernate.service;

import com.eagervslazy.hibernate.entity.Student;
import com.eagervslazy.hibernate.repository.StudentRepository;
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
