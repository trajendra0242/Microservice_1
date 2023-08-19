package com.example.studentserviceapp.repo;

import com.example.studentserviceapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo  extends JpaRepository<Student, Integer> {
}
