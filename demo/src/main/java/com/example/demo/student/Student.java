package com.example.demo.student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "Student_ID", length = 10, nullable = false)
    private String studentId;

    @Column(name = "Student_Name", length = 10, nullable = false)
    private String studentName;

    @Column(name = "Student_RollNo", nullable = false)
    private Integer studentRollNo;

    // Constructors
    public Student() {
    }

    public Student(String studentId, String studentName, Integer studentRollNo) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentRollNo = studentRollNo;
    }

    public Student(String studentName, Integer studentRollNo) {
        this.studentName = studentName;
        this.studentRollNo = studentRollNo;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Integer studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentRollNo=" + studentRollNo +
                '}';
    }
}
