package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			// Insert sample data
//			studentRepository.save(new Student("STU001", "Emmanuel", 1001));
//			studentRepository.save(new Student("STU002", "John", 1002));
//			studentRepository.save(new Student("STU003", "Sarah", 1003));
//			studentRepository.save(new Student("STU004", "Michael", 1004));
			//studentRepository.save(new Student("STU006", "hehehe", 1006));
		};
	}
}