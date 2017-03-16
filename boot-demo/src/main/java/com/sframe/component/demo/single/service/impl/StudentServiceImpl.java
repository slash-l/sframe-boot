package com.sframe.component.demo.single.service.impl;

import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.sframe.component.demo.single.bean.Student;
import com.sframe.component.demo.single.dao.StudentMapper;
import com.sframe.component.demo.single.invo.StudentInvo;
import org.springframework.stereotype.Service;

import com.sframe.component.demo.single.service.StudentService;

import java.util.List;

/**
 * @author mumu
 * @vervion v1.0
 * @description Student Service 实现类
 * @date 16/8/29 2016, 下午11:40
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentMapper studentMapper;

	@Override
	public Student getStudentInfo(){
		return studentMapper.selectByPrimaryKey("1");
	}

	@Override
	public List getStudentList(StudentInvo studentInvo) {
		PageHelper.startPage(2,2);
		return null;
	}
}
