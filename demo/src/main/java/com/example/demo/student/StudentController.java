package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET student by roll number
    @GetMapping("/rollno/{rollNo}")
    public ResponseEntity<Student> getStudentByRollNo(@PathVariable Integer rollNo) {
        Optional<Student> student = studentService.getStudentByRollNo(rollNo);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET students by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
        List<Student> students = studentService.getStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // SEARCH students by name pattern
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudentsByName(@RequestParam String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // POST create new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student newStudent = studentService.addStudent(student);
            return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PUT update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            studentService.deleteStudent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // GET student count by name
    @GetMapping("/count/{name}")
    public ResponseEntity<Long> getStudentCountByName(@PathVariable String name) {
        Long count = studentService.getStudentCountByName(name);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // CHECK if student exists by roll number
    @GetMapping("/exists/rollno/{rollNo}")
    public ResponseEntity<Boolean> studentExistsByRollNo(@PathVariable Integer rollNo) {
        boolean exists = studentService.studentExistsByRollNo(rollNo);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }
}