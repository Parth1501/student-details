package com.rakuten.training.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dao.StudentRepository;
import com.rakuten.training.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repo;

	@Override
	public Student addStudentToDb(Student student) {
		int age=getAge(student.getDob());
		student.setAge(age);
		student=repo.save(student);
		return student;
	}

	@Override
	public boolean deleteStudentById(String id) {
		Student student=repo.findById(id).orElse(null);
		if(student!=null) {
			repo.delete(student);
			return true;
		}
		return false;
	}

	@Override
	public Student updateStudentById(Student student) {
		Student checkStudent=repo.findById(student.getId()).orElse(null);
		if(checkStudent!=null)
			checkStudent=repo.save(student);
		return checkStudent;
	}

	@Override
	public Student getStudentById(String id) {
		// TODO Auto-generated method stub
		Student student=repo.findById(id).orElse(null);
		if(student!=null) {
			int age=getAge(student.getDob());
			student.setAge(age);
			repo.save(student);
		}
		return student;
	}

	@Override
	public Iterable<Student> getAllStudent() {
		// TODO Auto-generated method stub
		repo.findAll();
		return null;
	}
	
	private int getAge(Date dob) {
		Date currentDate=new Date();
		int age=currentDate.getYear()-dob.getYear();
		return age;
		
	}
	

}
