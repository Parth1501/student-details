package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.model.Student;


public interface StudentService {
	Student addStudentToDb(Student student);
	boolean deleteStudentById(String id);
	Student updateStudentById(Student student);
	<T> T getStudentById(String id);
	Iterable<Student> getAllStudent();
}
