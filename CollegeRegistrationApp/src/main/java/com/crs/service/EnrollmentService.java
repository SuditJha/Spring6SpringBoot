package com.crs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crs.entity.Course;
import com.crs.entity.Enrollment;
import com.crs.entity.EnrollmentId;
import com.crs.entity.Student;
import com.crs.exception.InvalidEntityException;
import com.crs.repository.CourseRepository;
import com.crs.repository.EnrollmentRepository;
import com.crs.repository.StudentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Enrollment addEnrollment(Enrollment enrollment, int studentId, int courseId) throws InvalidEntityException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new InvalidEntityException("Invalid student ID: " + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new InvalidEntityException("Invalid course ID: " + courseId));

        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);
        enrollment.setId(enrollmentId);
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    public Enrollment updateStudentGrade(EnrollmentId enrollmentId, double grade) throws InvalidEntityException {
        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new InvalidEntityException("Invalid enrollment ID: " + enrollmentId));
        enrollment.setGrade(grade);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> viewEnrollmentByDate(LocalDate enrollmentDate) {
        return enrollmentRepository.findByEnrollmentDate(enrollmentDate);
    }

    public List<Enrollment> viewEnrollmentsByInstructor(String instructorName) {
        return enrollmentRepository.findByInstructor(instructorName);
    }
}
