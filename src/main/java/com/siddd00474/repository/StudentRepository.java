package com.siddd00474.repository;

import com.siddd00474.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAllByStatus(int status);
    Student findByEmail(String email);
}
