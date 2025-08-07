package com.repository;

import com.bean.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SchoolRepository extends JpaRepository<School, String> {

    @Query("SELECT s FROM School s WHERE s.city = ?1 AND SIZE(s.studentList) = " +
           "(SELECT MAX(SIZE(s2.studentList)) FROM School s2 WHERE s2.city = ?1)")
    List<School> findSchoolWithMaxStudentsByCity(String city);
}
