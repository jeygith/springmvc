package com.eagervslazy.hibernate.repository;

import com.eagervslazy.hibernate.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}

