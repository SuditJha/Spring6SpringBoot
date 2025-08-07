package com.crs.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;
import com.crs.exception.InvalidEntityException;
import com.crs.service.EnrollmentService;

@RestController
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/addEnrollment/{studentId}/{courseId}")
    public ResponseEntity<Enrollment> addEnrollment(@RequestBody Enrollment enrollment,
                                                    @PathVariable int studentId,
                                                    @PathVariable int courseId) throws InvalidEntityException {
        return ResponseEntity.ok(enrollmentService.addEnrollment(enrollment, studentId, courseId));
    }

    @PutMapping("/updateStudentGrade/{studentId}/{courseId}/{grade}")
    public ResponseEntity<Enrollment> updateStudentGrade(@PathVariable int studentId,
                                                         @PathVariable int courseId,
                                                         @PathVariable double grade) throws InvalidEntityException {
        EnrollmentId enrollmentId = new EnrollmentId();
        enrollmentId.setStudentId(studentId);
        enrollmentId.setCourseId(courseId);
        return ResponseEntity.ok(enrollmentService.updateStudentGrade(enrollmentId, grade));
    }

    @GetMapping("/viewEnrollmentByDate/{enrollmentDate}")
    public ResponseEntity<List<Enrollment>> viewEnrollmentByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate enrollmentDate) {
        return ResponseEntity.ok(enrollmentService.viewEnrollmentByDate(enrollmentDate));
    }

    @GetMapping("/viewEnrollmentsByInstructor/{instructor}")
    public ResponseEntity<List<Enrollment>> viewEnrollmentsByInstructor(@PathVariable String instructor) {
        return ResponseEntity.ok(enrollmentService.viewEnrollmentsByInstructor(instructor));
    }
}
