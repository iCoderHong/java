package com.ch.controller;

import com.ch.domain.Student;
import com.ch.exception.NameException;
import com.ch.exception.StudentException;
import com.ch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) throws StudentException {
        if (student.getName().equals("")) throw new NameException("提交的学生姓名为空");
        if (student.getAge() <= 0) throw new NameException("提交的学生年纪不合法");

        ModelAndView mv = new ModelAndView();
        int rows = service.addStudent(student);
        if (rows <= 0) {
            mv.addObject("msg", "注册失败");
            mv.setViewName("result"); // 请求转发
        } else {
            // 如果重定向传递参数 可以通过mv.addObject(key, value) 框架内部转化成/student/allStudents.do?key=value的形式
            // 重定向的jsp页面 可以通过<%= request.getParameter("key") %>
            // 重定向不能访问受保护目录下的文件
            mv.setViewName("redirect:/student/allStudents.do");// 重定向
        }
        return mv;
    }

    /*
    @RequestMapping(value = "/allStudents.do")
    public ModelAndView queryAllStudent() {
        ModelAndView mv = new ModelAndView();
        List<Student> students = service.queryStudents();
        mv.addObject("students", students);
        mv.setViewName("allStudents");
        return students;
    }
    */

    @RequestMapping(value = "/allStudents.do", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object queryAllStudent() {
        List<Student> students = service.queryStudents();
        return students;
    }
}
