package com.ch.service.impl;

import com.ch.dao.StudentDao;
import com.ch.domain.Student;
import com.ch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao dao;

    @Override
    public int addStudent(Student student) {
        return dao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {
        return dao.selectStudents();
    }
}
