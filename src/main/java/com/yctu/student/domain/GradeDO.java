package com.yctu.student.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName GradeDO
 * @Description 成绩实体类
 * @Author qlq
 * @Date 2020-06-16 17:41
 */
public class GradeDO implements Serializable {


    private Long id;

    private String number;

    private Double score;

    private Double gpa;

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

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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
        return "GradeDO{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", score=" + score +
                ", gpa=" + gpa +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
