package com.sframe.component.demo.single.service;

import com.sframe.component.demo.single.bean.Student;
import com.sframe.component.demo.single.invo.StudentInvo;
import java.util.List;

/**
 * @author mumu
 * @vervion v1.0
 * @description Student Service 接口
 * @date 16/8/29 2016, 下午11:40
 */
public interface StudentService {

	/**
	 *
	 * @description	查询 student 单个对象
	 * @param
	 * @return Student
	 * @throws
	 */
	public Student getStudentInfo();

	/**
	 * @description	根据条件获取 student 列表数据
	 * @return	List
	 */
	public List getStudentList(StudentInvo studentInvo);
}
