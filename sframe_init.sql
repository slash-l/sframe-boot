/** 创建数据库 sframe_db */
CREATE DATABASE IF NOT EXISTS sframe_db DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;
/** 创建用户 sframe 赋予 sframe_db 所有操作权限 */
CREATE USER 'sframe'@'%' IDENTIFIED BY '123456';
grant all privileges on sframe_db.* to sframe@'%' identified by '123456';

/** t_demo_student 用于 demo 中的单表示例 */
CREATE TABLE IF NOT EXISTS `t_demo_student` (
  `student_id` CHAR(36) NOT NULL COMMENT '主键',
  `student_name` VARCHAR(50) NULL COMMENT '学生名',
  `real_name` VARCHAR(50) NULL COMMENT '学生真实姓名',
  `student_age` INT NULL COMMENT '学生年龄',
  `student_desc` VARCHAR(1000) NULL COMMENT '学生描述',
  PRIMARY KEY (`student_id`));

