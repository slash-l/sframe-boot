package com.sframe.component.demo.single.dao;

import com.sframe.component.demo.single.bean.Student;
import com.sframe.component.demo.single.bean.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int countByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int deleteByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String studentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    List<Student> selectByExample(StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    Student selectByPrimaryKey(String studentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo_student
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Student record);
}