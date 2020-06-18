package com.yctu.student.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName TeacherDAO
 * @Description 老师实体类
 * @Author qlq
 * @Date 2020-06-16 17:01
 */
public class TeacherDO implements Serializable {


    private Long id;

    private String number;

    private String password;

    private String name;

    private String college;

    private String sex;

    private LocalDate createTime;

    private LocalDate modifyTime;
    /** 一个老师对应多个课程 一对多 */
    private List<CourseDO> courseDOList;
    /** 一个老师对应多个学生 多对多 */
    private List<StudentDO> studentDOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDate modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<CourseDO> getCourseDOList() {
        return courseDOList;
    }

    public void setCourseDOList(List<CourseDO> courseDOList) {
        this.courseDOList = courseDOList;
    }

    public List<StudentDO> getStudentDOList() {
        return studentDOList;
    }

    public void setStudentDOList(List<StudentDO> studentDOList) {
        this.studentDOList = studentDOList;
    }

    @Override
    public String toString() {
        return "TeacherDO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", sex='" + sex + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", courseDOList=" + courseDOList +
                ", studentDOList=" + studentDOList +
                '}';
    }
}
