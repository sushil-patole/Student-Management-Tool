package com.studentmanagementtool.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.studentmanagementtool.model.Student;
import com.studentmanagementtool.repository.StudentRepository;
import com.studentmanagementtool.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
   
	// Save student data
	@Override
	public Student saveStudentDtls(Student student) {
		return studentRepo.save(student);
	}
     
	//It will get all student data
	@Override
	public List<Student> getAllStudentDtls() {
		return studentRepo.findAll();
	}

	//This method update the student details based on id if id not found then it will throw the exception
	@Override
	public Student updateStudentDtls(Student student, Integer id) {
		Student updatedstudent= studentRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Student Id is not found"));
		updatedstudent.setFirstName(student.getFirstName());
		updatedstudent.setAddress(student.getAddress());
		updatedstudent.setDob(student.getDob());
		updatedstudent.setEmail(student.getEmail());
		updatedstudent.setGender(student.getGender());
		updatedstudent.setGrade(student.getGrade());
		updatedstudent.setLastName(student.getLastName());
		updatedstudent.setPhoneno(student.getPhoneno());
		updatedstudent.setPhotoUrl(student.getPhotoUrl());
		return studentRepo.save(updatedstudent);	
		
	}

	@Override
	public String deactivateStudent(Integer id) {
		studentRepo.deleteById(id);
		return "Student Deactivated";
	}
     //This method will fetch student details by giving id if not then it will throw the exception
	@Override
	public Student getStudentDtlsById(Integer id) {
		Optional<Student> studentById = studentRepo.findById(id);
		if(studentById.isEmpty())
		{
			throw new IllegalArgumentException("Student Id is not found");
		}
		return studentById.get();
	}

	
}
