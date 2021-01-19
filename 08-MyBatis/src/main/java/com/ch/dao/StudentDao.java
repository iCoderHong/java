package com.ch.dao;

import com.ch.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStudentById(Integer id);

    int insertStudent(String name, int age);

    int updateStuden(Student student);

    List<Student> selectAllStudents();

    int deleteStudentById(Integer id);

    List<Student> selectByNameOrAge(@Param("name") String name, @Param("age") Integer age);

    long countStudent();

    Map<Object, Object> selectMap(Integer id);

    // like示例
    List<Student> selectLike(@Param("name") String name);
}
