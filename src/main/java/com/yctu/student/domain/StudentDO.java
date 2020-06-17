package com.yctu.student.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName StudentDO
 * @Description 学生实体类
 * @Author qlq
 * @Date 2020-06-13 23:28
 */
public class StudentDO implements Serializable {


    private Long id;

    private int number;

    private String password;

    private String name;

    private String sex;

    private String major;

    private String college;

    private String classroom;

    private String phone;

    private LocalDate birthday;

    private LocalDate entryTime;

    private LocalDateTime createTime;


    private LocalDateTime modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDate entryTime) {
        this.entryTime = entryTime;
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

    
    @Override
    public String toString() {
        return "StudentDO{" +
                "id=" + id +
                ", number=" + number +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                ", classroom='" + classroom + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", entryTime=" + entryTime +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
