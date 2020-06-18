package com.yctu.student.dao;

import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface TeacherDAO {

    /**
     * 添加老师信息
     * @param teacherDO
     * @return
     */
    @Insert("INSERT INTO tb_teacher(" +
            "number,password,name,college,sex,create_time,modify_time" +
            ")VALUES(" +
            "#{number},#{password},#{name},#{college},#{sex},NOW(),NOW())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
    Long addTeacher(TeacherDO teacherDO);


    /**
     * 修改老师信息
     * @param teacherDO
     */
    @Update("UPDATE tb_teacher SET " +
            "number=#{number}," +
            "password=#{password}," +
            "name=#{name}," +
            "college=#{college}," +
            "sex=#{sex}," +
            "modify_time=NOW() " +
            "WHERE id=#{id}")
    void updateTeacher(TeacherDO teacherDO);


    /**
     * 根据id删除老师信息
     * @param id
     */
    @Delete("DELETE FROM tb_teacher WHERE id=#{id}")
    void deleteTeacher(Long id);

    /**
     * 根据id获取老师信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_teacher WHERE id=#{teacherId}")
    @Results(id = "teacherMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "number", property = "number"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "college", property = "college"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime")
    })
    TeacherDO getTeacherById(Long teacherId);

    /**
     * 获取所有老师信息
     * @return
     */
    @ResultMap(value = "teacherMap")
    @Select("SELECT * FROM tb_teacher")
    List<TeacherDO> getAllTeacher();


    /**
     * 根据学院查询老师信息
     * @param college
     * @return
     */
    @ResultMap(value = "teacherMap")
    @Select("SELECT * FROM tb_teacher WHERE college=#{college}")
    List<TeacherDO> getTeachersByCollege(String college);

    /**
     * 根据性别获取老师信息
     * @param sex
     * @return
     */
    @ResultMap(value = "teacherMap")
    @Select("SELECT * FROM tb_teacher WHERE sex=#{sex}")
    List<TeacherDO> getTeachersBySex(String sex);



    /**
     * 根据账号获取老师信息
     * @param number
     * @return
     */
    @ResultMap(value = "teacherMap")
    @Select("SELECT * FROM tb_teacher WHERE number=#{number}")
    TeacherDO getTeacherByNumber(String number);

    /**
     * 通过账号和密码进行登录
     * @param number
     * @param password
     * @return
     */
    @ResultMap(value = "teacherMap")
    @Select("SELECT * FROM tb_teacher WHERE number=#{number} AND password=#{password}")
    TeacherDO getTeacherByNumberAndPassword(@Param("number") String number, @Param("password") String password);


    /**
     * 根据id查询老师信息，包含课程信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_teacher WHERE id=#{id}")
    @Results(id = "teacherCourseMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "number", property = "number"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "college", property = "college"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime"),
            @Result(column = "id", property = "courseDOList", many = @Many(select =
            "com.yctu.student.dao.CourseDAO.getCoursesByTeacherId", fetchType = FetchType.LAZY))
    })
    TeacherDO getTeacherWithCourses(Long id);
}

