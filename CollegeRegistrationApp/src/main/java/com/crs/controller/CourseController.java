package com.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crs.entity.Course;
import com.crs.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/viewMostEnrolledCourse")
    public ResponseEntity<Course> viewMostEnrolledCourse() {
        return ResponseEntity.ok(courseService.viewMostEnrolledCourse());
    }
}
