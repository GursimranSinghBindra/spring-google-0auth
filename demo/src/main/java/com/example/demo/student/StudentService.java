package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(String studentId) {
        return studentRepository.findById(studentId);
    }

    // Get student by roll number
    public Optional<Student> getStudentByRollNo(Integer rollNo) {
        return studentRepository.findByStudentRollNo(rollNo);
    }

    // Get students by name
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByStudentName(name);
    }

    // Search students by name pattern
    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByStudentNameContainingIgnoreCase(name);
    }

    // Add new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update student
    public Student updateStudent(String studentId, Student studentDetails) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setStudentName(studentDetails.getStudentName());
            student.setStudentRollNo(studentDetails.getStudentRollNo());
            return studentRepository.save(student);
        }
        return null;
    }

    // Delete student
    public void deleteStudent(String studentId) {
        studentRepository.deleteById(studentId);
    }

    // Check if student exists by roll number
    public boolean studentExistsByRollNo(Integer rollNo) {
        return studentRepository.existsByStudentRollNo(rollNo);
    }

    // Get student count by name
    public Long getStudentCountByName(String name) {
        return studentRepository.countByStudentName(name);
    }
}