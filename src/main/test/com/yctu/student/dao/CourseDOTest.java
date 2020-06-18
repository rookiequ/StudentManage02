package com.yctu.student.dao;

import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.StudentDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName CourseDOTest
 * @Description
 * @Author qlq
 * @Date 2020-06-18 22:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CourseDOTest {

    @Autowired
    private CourseDAO courseDAO;


    @Test
    public void testGetCourseWithStudent(){
        CourseDO courseWithStudent = courseDAO.getCourseWithStudents(1L);
        List<StudentDO> studentDOList = courseWithStudent.getStudentDOList();
        for (StudentDO studentDO : studentDOList) {
            System.out.println(studentDO);
        }
    }


    @Test
    public void testGetAllCourseWithTeacher(){
        List<CourseDO> courseDOList = courseDAO.getAllCourse();
        for (CourseDO courseDO : courseDOList) {
            System.out.println(courseDO.getTeacherDO());
        }
    }


    @Test
    public void testGetCourseWithTeacher(){
        CourseDO courseWithTeacher = courseDAO.getCourseWithTeacher(1L);
        System.out.println(courseWithTeacher.getTeacherDO());
    }


}
