package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bean.School;
import com.dao.SchoolDAO;

@RestController
public class SchoolController {

    @Autowired
    private SchoolDAO schoolDAO;

    @PostMapping("/addSchool")
    public ResponseEntity<School> addSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolDAO.addSchool(school));
    }

    @GetMapping("/schoolWithMaximumStudents/{city}")
    public ResponseEntity<List<School>> schoolWithMaximumStudents(@PathVariable String city) {
        return ResponseEntity.ok(schoolDAO.schoolWithMaximumStudents(city));
    }
}
