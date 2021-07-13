package com.rakuten.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.dao.StudentRepository;
import com.rakuten.training.model.Student;

@SpringBootApplication
@RestController
public class StudentDetailsApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(StudentDetailsApplication.class, args);
//		StudentRepository repo=context.getBean(StudentRepository.class);
		
	}

}
