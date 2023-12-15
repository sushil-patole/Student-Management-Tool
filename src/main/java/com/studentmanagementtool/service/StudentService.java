package com.studentmanagementtool.service;

import java.util.List;

import com.studentmanagementtool.model.Student;

public interface StudentService  {
      public Student saveStudentDtls(Student student);
      public List<Student> getAllStudentDtls();
      public Student updateStudentDtls(Student student,Integer id);
      public String deactivateStudent(Integer id);
      public Student getStudentDtlsById(Integer id);
    	  
      
}
