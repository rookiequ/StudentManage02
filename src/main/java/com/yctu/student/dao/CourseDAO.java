package com.yctu.student.dao;

import com.yctu.student.domain.CourseDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CourseDAO {


    /**
     * 添加课程信息
     * @param courseDO
     * @return
     */
    @Insert("INSERT INTO tb_course(" +
            "number,name,tag,credit,teacher_id,create_time,modify_time" +
            ")VALUES(" +
            "#{number},#{name},#{tag},#{credit},#{teacherId},NOW(),NOW())")
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
            "teacher_id=#{teacherId}," +
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
    @ResultMap(value = "courseTeacherMap")
    CourseDO getCourseById(Long id);


    /**
     * 获取所有课程信息
     * @return
     */
    @ResultMap(value = "courseTeacherMap")
    @Select("SELECT * FROM tb_course")
    List<CourseDO> getAllCourse();


    /**
     * 根据课程id获取课程信息包含学生信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_course WHERE id=#{id}")
    @Results(id = "courseStudentMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "number", property = "number"),
            @Result(column = "name", property = "name"),
            @Result(column = "tag", property = "tag"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime"),
            @Result(column = "id", property = "studentDOList", many = @Many(select =
                    "com.yctu.student.dao.StudentDAO.getStudentAndCourseByCid", fetchType = FetchType.LAZY))
    })
    CourseDO getCourseWithStudents(Long id);


    /**
     * 通过学生id获取学生和课程信息 多对多
     * @param id
     * @return
     */
    @ResultMap(value = "courseTeacherMap")
    @Select("SELECT * FROM tb_course c INNER JOIN tb_student_course sc ON c.id=sc.course_id AND sc.student_id=#{id}")
    CourseDO getStudentAndCourseBySid(Long id);

    /**
     * 根据老师id查询课程信息
     * @param teacherId
     * @return
     */
    @ResultMap(value = "courseTeacherMap")
    @Select("SELECT * FROM tb_course WHERE teacher_id=#{teacherId}")
    List<CourseDO> getCoursesByTeacherId(Long teacherId);


    /**
     * 一对一注解开发，根据id获取课程信息，包含老师信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_course WHERE id=#{id}")
    @Results(id = "courseTeacherMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "number", property = "number"),
            @Result(column = "name", property = "name"),
            @Result(column = "tag", property = "tag"),
            @Result(column = "credit", property = "credit"),
            @Result(column = "teacher_id", property = "teacherId", jdbcType = JdbcType.BIGINT, javaType = Long.class),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime"),
            @Result(column = "teacher_id", property = "teacherDO", one = @One(select =
                    "com.yctu.student.dao.TeacherDAO.getTeacherById", fetchType = FetchType.EAGER))
    })
    CourseDO getCourseWithTeacher(Long id);

}

