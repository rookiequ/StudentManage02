package com.yctu.student.dao;

import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.TeacherDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CourseDAO {


    /**
     * 添加课程信息
     * @param courseDO
     * @return
     */
    @Insert("INSERT INTO tb_course(" +
            "number,name,tag,credit,create_time,modify_time" +
            ")VALUES(" +
            "#{number},#{name},#{tag},#{credit},NOW(),NOW())")
    @SelectKey(statement = "SELECT LAST_INSET_ID()", keyProperty = "id", keyColumn = "id", resultType = Long.class, before = false)
    Long addCourse(CourseDO courseDO);


    /**
     * 修改课程信息
     * @param courseDO
     */
    @Update("UPDATE tb_course SET " +
            "number=#{number}," +
            "name=#{name}," +
            "tag=#{tag}," +
            "credit=#{credit}," +
            "modify_time=NOW() " +
            "WHERE id=#{id}")
    void updateCourse(CourseDO courseDO);


    /**
     * 删除课程信息
     * @param id
     */
    @Delete("DELETE FROM tb_course WHERE id=#{id}")
    void deleteCourse(Long id);


    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_course WHERE id=#{id}")
    @Results(id = "courseMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "number", property = "number"),
            @Result(column = "name", property = "name"),
            @Result(column = "tag", property = "tag"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime")
    })
    CourseDO getCourseById(Long id);


    /**
     * 获取所有课程信息
     * @return
     */
    @ResultMap(value = "courseMap")
    @Select("SELECT * FROM tb_course")
    List<CourseDO> getAllCourse();





}

