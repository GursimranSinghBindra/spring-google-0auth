package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    // Find student by roll number
    Optional<Student> findByStudentRollNo(Integer studentRollNo);

    // Find students by name (exact match)
    List<Student> findByStudentName(String studentName);

    // Find students by name containing (case-sensitive)
    List<Student> findByStudentNameContaining(String name);

    // Find students by name containing (case-insensitive)
    List<Student> findByStudentNameContainingIgnoreCase(String name);

    // Find students with roll number greater than specified value
    List<Student> findByStudentRollNoGreaterThan(Integer rollNo);

    // Find students with roll number less than specified value
    List<Student> findByStudentRollNoLessThan(Integer rollNo);

    // Find students with roll number between two values
    List<Student> findByStudentRollNoBetween(Integer startRollNo, Integer endRollNo);

    // Custom query using @Query annotation
    @Query("SELECT s FROM Student s WHERE s.studentName LIKE %:name%")
    List<Student> findStudentsByNamePattern(@Param("name") String name);

    // Custom native SQL query
    @Query(value = "SELECT * FROM Student WHERE Student_RollNo > :rollNo", nativeQuery = true)
    List<Student> findStudentsWithRollNoGreaterThan(@Param("rollNo") Integer rollNo);

    // Count students by name
    Long countByStudentName(String studentName);

    // Check if student exists by roll number
    Boolean existsByStudentRollNo(Integer studentRollNo);

    // Delete student by roll number
    void deleteByStudentRollNo(Integer studentRollNo);
}