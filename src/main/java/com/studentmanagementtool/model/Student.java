package com.studentmanagementtool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name = "student_dtls")
public class Student 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @NotEmpty
	private String firstName;
    @NotEmpty
	private String lastName;
    @NotNull
	private String grade;
    @NotEmpty
	private String dob;
    @NotNull
	private String gender;
	@Email
	private String email;
	@NotNull	
	private String phoneno;
	@NotEmpty
	private String address;
	private String photoUrl;
	
}
