package com.ch.service;

import com.ch.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    List<Student> queryStudents();
}
