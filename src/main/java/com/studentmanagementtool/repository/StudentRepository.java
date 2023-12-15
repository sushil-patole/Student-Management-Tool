package com.studentmanagementtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementtool.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

}
