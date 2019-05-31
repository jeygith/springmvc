package com.onetoone.hibernate.service;

import com.onetoone.hibernate.entity.Student;
import com.onetoone.hibernate.repository.StudentRepository;
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
