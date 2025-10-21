package com.example.demo.Teacher;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @Column(name = "Teacher_ID", length = 10, nullable = false)
    private String teacherId;

    @Column(name = "Teacher_Name", length = 50, nullable = false)
    private String teacherName;

    @Column(name = "Teacher_Subject", length = 50, nullable = false)
    private String teacherSubject;

    // Constructors
    public Teacher() {
    }

    public Teacher(String teacherId, String teacherName, String teacherSubject) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
    }

    public Teacher(String teacherName, String teacherSubject) {
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
    }

    // Getters and Setters
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSubject='" + teacherSubject + '\'' +
                '}';
    }
}

