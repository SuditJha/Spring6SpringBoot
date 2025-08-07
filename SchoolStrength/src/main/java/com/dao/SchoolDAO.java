package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.School;
import com.bean.Student;
import com.repository.SchoolRepository;
import com.repository.StudentRepository;

@Service
public class SchoolDAO {

    @Autowired
    private SchoolRepository schoolRepo;

    @Autowired
    private StudentRepository studentRepo;

    public School addSchool(School school) {
        return schoolRepo.save(school);
    }

    public List<Student> registerStudentToSchool(String schoolId, List<Student> students) {
        School school = schoolRepo.findById(schoolId).orElse(null);
        if (school != null) {
            for (Student student : students) {
                student.setSchool(school);
                school.getStudentList().add(student);
            }
            schoolRepo.save(school); // saves both school and students
            return students;
        }
        return null;
    }

    public List<School> schoolWithMaximumStudents(String city) {
        return schoolRepo.findSchoolWithMaxStudentsByCity(city);
    }
}
