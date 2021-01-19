package com.ch.dao;

import com.ch.domain.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectAllStudents();
}
