package com.githinit.hibernate.service;

import com.githinit.hibernate.entity.Student;
import com.githinit.hibernate.repository.StudentRepository;
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
