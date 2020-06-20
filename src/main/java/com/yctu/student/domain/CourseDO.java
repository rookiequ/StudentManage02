package com.yctu.student.domain;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName CourseDO
 * @Description 课程实体类
 * @Author qlq
 * @Date 2020-06-16 17:14
 */
public class CourseDO implements Serializable {


    private Long id;

    private String number;

    private String name;

    private int tag;

    private double credit;

    private Long teacherId;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;
    /** 一个课程对应多个学生 多对多 */
    private List<StudentDO> studentDOList;



    private int num;
    /** 一个课程对应一个老师 多对一 */
    private TeacherDO teacherDO;
    /** 一个课程对应多个成绩 一对多 */
    private List<GradeDO> gradeDOList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<StudentDO> getStudentDOList() {
        return studentDOList;
    }

    public void setStudentDOList(List<StudentDO> studentDOList) {
        this.studentDOList = studentDOList;
    }

    public TeacherDO getTeacherDO() {
        return teacherDO;
    }

    public void setTeacherDO(TeacherDO teacherDO) {
        this.teacherDO = teacherDO;
    }

    public List<GradeDO> getGradeDOList() {
        return gradeDOList;
    }

    public void setGradeDOList(List<GradeDO> gradeDOList) {
        this.gradeDOList = gradeDOList;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CourseDO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", tag=" + tag +
                ", credit=" + credit +
                ", teacherId=" + teacherId +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", studentDOList=" + studentDOList +
                ", num=" + num +
                ", teacherDO=" + teacherDO +
                ", gradeDOList=" + gradeDOList +
                '}';
    }
}
