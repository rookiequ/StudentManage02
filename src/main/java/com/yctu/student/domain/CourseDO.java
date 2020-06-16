package com.yctu.student.domain;


import java.io.Serializable;
import java.time.LocalDateTime;

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

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;


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
        return "CourseDO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", tag=" + tag +
                ", credit=" + credit +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
