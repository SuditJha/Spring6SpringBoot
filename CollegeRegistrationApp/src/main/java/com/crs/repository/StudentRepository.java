package com.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crs.entity.Student;

//Provide necessary annotation
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

