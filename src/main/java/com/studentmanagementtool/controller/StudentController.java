package com.studentmanagementtool.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementtool.model.Student;
import com.studentmanagementtool.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	//Using service class methods
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/")
    public ResponseEntity<Student> saveStudent(@Valid@RequestBody Student student){
 
    	return new ResponseEntity<>(studentService.saveStudentDtls(student),HttpStatus.CREATED);
    	
    }
     @PutMapping("/{id}")
      public ResponseEntity<Student> updateStudentDtls(@PathVariable Integer id,@Valid@RequestBody Student student)
      {
		return new ResponseEntity<>(studentService.updateStudentDtls(student, id),HttpStatus.ACCEPTED);
    	  
      }
        @GetMapping("/")
        public ResponseEntity<List<Student>> getAllStudents()
        {
        	return new ResponseEntity<>(studentService.getAllStudentDtls(), HttpStatus.OK);
        	
        }
         @DeleteMapping("/{id}")
        public ResponseEntity<String> deactivateStudent(@PathVariable Integer id){
        	
        	String msg = studentService.deactivateStudent(id);
        	
			return new ResponseEntity<>(msg,HttpStatus.OK);
        	
        }
          @GetMapping("/{id}")
         public ResponseEntity<Student> getStudentDtlsById(@PathVariable Integer id)
         {
        	 
			return new ResponseEntity<>(studentService.getStudentDtlsById(id),HttpStatus.FOUND);
        	 
         }
}
