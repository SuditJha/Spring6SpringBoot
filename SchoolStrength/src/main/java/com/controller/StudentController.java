package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bean.Student;
import com.dao.SchoolDAO;

@RestController
public class StudentController {

    @Autowired
    private SchoolDAO schoolDAO;

    @PostMapping("/registerStudentToSchool/{schoolId}")
    public ResponseEntity<List<Student>> registerStudentToSchool(
            @PathVariable String schoolId,
            @RequestBody List<Student> students) {
        return ResponseEntity.ok(schoolDAO.registerStudentToSchool(schoolId, students));
    }
}
