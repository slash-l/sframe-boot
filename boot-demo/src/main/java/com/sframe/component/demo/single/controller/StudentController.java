package com.sframe.component.demo.single.controller;

import javax.annotation.Resource;

import com.sframe.component.demo.single.bean.Student;
import com.sframe.component.demo.single.invo.StudentInvo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.sframe.component.demo.single.service.StudentService;

import java.util.List;

/**
 * @author mumu
 * @vervion v1.0
 * @description Student Controller
 * @date 16/8/29 2016, 下午11:20
 */
@RestController
@RequestMapping(value="/demo/single")
public class StudentController {

	Logger logger = LoggerFactory.getLogger(StudentController.class.getName());
	
	@Resource
    private StudentService studentService;

    @GetMapping(value = "/student")
    public Student getStudentInfo() {
		Student student = studentService.getStudentInfo();
        if(student!=null){
        	logger.info("student name: " + student.getStudentName());
            logger.info("student age: " + student.getStudentAge());
        }
        return student;
    }

    @GetMapping(value = "/student/studentList")
    public List getStudentList(StudentInvo studentInvo){


        return null;
    }
}
