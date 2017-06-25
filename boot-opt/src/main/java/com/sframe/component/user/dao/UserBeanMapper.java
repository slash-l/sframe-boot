package com.sframe.component.user.dao;

import com.sframe.component.user.bean.UserBean;
import com.sframe.component.user.bean.UserBeanExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserBeanMapper {
    @SelectProvider(type=UserBeanSqlProvider.class, method="countByExample")
    long countByExample(UserBeanExample example);

    @DeleteProvider(type=UserBeanSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserBeanExample example);

    @Delete({
        "delete from t_user",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into t_user (user_id, login_name, ",
        "age, email, mobile)",
        "values (#{userId,jdbcType=CHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{email,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR})"
    })
    int insert(UserBean record);

    @InsertProvider(type=UserBeanSqlProvider.class, method="insertSelective")
    int insertSelective(UserBean record);

    @SelectProvider(type=UserBeanSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    List<UserBean> selectByExample(UserBeanExample example);

    @Select({
        "select",
        "user_id, login_name, age, email, mobile",
        "from t_user",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR)
    })
    UserBean selectByPrimaryKey(String userId);

    @UpdateProvider(type=UserBeanSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    @UpdateProvider(type=UserBeanSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserBean record, @Param("example") UserBeanExample example);

    @UpdateProvider(type=UserBeanSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserBean record);

    @Update({
        "update t_user",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "email = #{email,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(UserBean record);
}