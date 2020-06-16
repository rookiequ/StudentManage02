package com.yctu.student.dao;

import com.yctu.student.domain.StudentDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentDAO {


    /**
     * 获取所有学生信息
     * @return
     */
    @Select("select * from tb_student")
    @Results(id = "studentMap", value = {
            @Result(id = true, column = "id", property = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(column = "number", property = "number"),
            @Result(column = "password", property = "password"),
            @Result(column = "name", property = "name"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "major", property = "major"),
            @Result(column = "college", property = "college"),
            @Result(column = "classroom", property = "classroom"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "entry_time", property = "entryTime"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime")
    })
    List<StudentDO> getAllStudent();

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE id=#{id}")
    StudentDO getStudentById(Long id);

    /**
     * 根据学号获取学生信息
     * @param number
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE number=#{number}")
    StudentDO getStudentByNumber(int number);

    /**
     * 根据姓名获取学生信息
     * @param name
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE name=#{name}")
    StudentDO getStudentByName(String name);

    /**
     * 根据电话获取学生信息
     * @param phone
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE phone=#{phone}")
    StudentDO getStudentByPhone(String phone);

    /**
     * 根据学院获取学生信息
     * @param college
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE college=#{college}")
    List<StudentDO> getStudentsByCollege(String college);

    /**
     * 根据专业获取学生信息
     * @param major
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE major=#{major}")
    List<StudentDO> getStudentsByMajor(String major);

    /**
     * 根据班级获取学生信息
     * @param classroom
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE classroom=#{classroom}")
    List<StudentDO> getStudentsByClassroom(String classroom);

    /**
     * 根据性别获取学生信息
     * @param sex
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE sex=#{sex}")
    List<StudentDO> getStudentsBySex(String sex);

    /**
     * 根据入学日期查询学生信息
     * @param entryTime
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE entry_time=#{entryTime}")
    List<StudentDO> getStudentsByEntryTime(LocalDate entryTime);

    /**
     * 根据生日获取学生信息
     * @param birthday
     * @return
     */
    @ResultMap(value = "studentMap")
    @Select("SELECT * FROM tb_student WHERE birthday=#{birthday}")
    List<StudentDO> getStudentsByBirthday(LocalDate birthday);

    /**
     * 添加学生信息
     * @param studentDO
     * @return
     */
    @Insert("INSERT INTO tb_student(" +
            "number,password,name,sex,major,classroom,college,phone,birthday,entry_time,create_time,modify_time" +
            ")VALUES(" +
            "#{number},#{password},#{name},#{sex},#{major},#{classroom},#{college},#{phone},#{birthday},#{entryTime},NOW(),NOW())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Long.class)
    Long addStudent(StudentDO studentDO);


    /**
     * 修改学生信息
     * @param studentDO
     */
    @Update("UPDATE tb_student SET " +
            "number=#{number}," +
            "password=#{password}," +
            "name=#{name}," +
            "sex=#{sex}," +
            "major=#{major}," +
            "classroom=#{classroom}," +
            "college=#{college}," +
            "phone=#{phone}," +
            "birthday=#{birthday}," +
            "entry_time=#{entryTime}," +
            "modify_time=NOW() " +
            "WHERE id=#{id}")
    void updateStudent(StudentDO studentDO);


    /**
     * 根据id删除学生信息
     * @param id
     */
    @Delete("DELETE FROM tb_student WHERE id=#{id}")
    void deleteStudentById(Long id);
}

