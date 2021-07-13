package com.rakuten.training.web;

import com.rakuten.training.Error.Errormessage;
import com.rakuten.training.model.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.service.StudentService;

@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	StudentService service;

	@PostMapping("/students/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		return new ResponseEntity<>(service.addStudentToDb(student),HttpStatus.OK);
	}
	
	@PostMapping("/students/updateStudent") 
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		return new ResponseEntity<>(service.updateStudentById( student),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/students/findById")
	public ResponseEntity<?> findStudentById(@RequestParam("id") String id) {
		Student student=service.getStudentById(id);
		if(student!=null)
			return new ResponseEntity<>(student,HttpStatus.OK);
		else 
			return new ResponseEntity<>(new Errormessage("Id does not exists",404),HttpStatus.BAD_REQUEST);
			
	}
	
	@GetMapping("/students/findAll")
	public Iterable<Student> findAll() {
		return service.getAllStudent();
	}
	
	@DeleteMapping("/students/deleteById")
	public ResponseEntity<?> deleteById(@RequestParam("id") String id) {
		boolean student=service.deleteStudentById(id);
		if(student!=false)
			return new ResponseEntity<>(new Errormessage("Student deleted with Id: "+id,200),HttpStatus.OK);
		else 
			return new ResponseEntity<>(new Errormessage("Id does not exists",404),HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
}
