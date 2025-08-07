package com.crs.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crs.entity.Course;

//Provide necessary annotation
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c JOIN c.enrollments e GROUP BY c ORDER BY COUNT(e) DESC")
    List<Course> findMostEnrolledCourse(PageRequest pageRequest);
}

