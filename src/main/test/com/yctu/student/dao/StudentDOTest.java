package com.yctu.student.dao;

import com.yctu.student.dao.StudentDAO;
import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.utils.SHA256Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName StudentDOTest
 * @Description 对StudentDO实体类的crud的测试
 * @Author qlq
 * @Date 2020-06-16 00:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentDOTest {


    @Autowired
    private StudentDAO studentDAO;

    @Test
    public void testGetStudentById(){
        StudentDO studentById = studentDAO.getStudentById(1L);
        System.out.println(studentById);
    }

    @Test
    public void testGetStudentsByEntryTime(){
        List<StudentDO> studentsByEntryTime = studentDAO.getStudentsByEntryTime(LocalDate.of(2020, 6, 15));
        for (StudentDO studentDO : studentsByEntryTime) {
            System.out.println(studentDO);
        }
    }

    @Test
    public void testAddStudent(){
        StudentDO studentDO = new StudentDO();
        studentDO.setNumber("17233620");
        studentDO.setPassword("123456");
        studentDO.setName("李彦霖");
        studentDO.setPhone("13212345678");
        studentDO.setClassroom("176");
        studentDO.setCollege("信工元");
        studentDO.setSex("男");
        studentDO.setMajor("软件工程");
        studentDO.setBirthday(LocalDate.now());
        studentDO.setEntryTime(LocalDate.now());
        studentDAO.addStudent(studentDO);
    }


    @Test
    public void testUpdateStudent(){
        StudentDO studentDO = new StudentDO();
        studentDO.setId(5L);
        studentDO.setNumber("17263830");
        studentDO.setPassword(SHA256Util.SHA256("123456"));
        studentDO.setName("周子钦");
        studentDO.setPhone("1321234567");
        studentDO.setClassroom("176班");
        studentDO.setCollege("信息工程学院");
        studentDO.setSex("男");
        studentDO.setMajor("软件工程");
        studentDO.setBirthday(LocalDate.now());
        studentDO.setEntryTime(LocalDate.now());
        studentDAO.updateStudent(studentDO);
    }

    @Test
    public void testGetAllStudent(){
        List<StudentDO> studentDOList = studentDAO.getAllStudent();
        for (StudentDO studentDO : studentDOList) {
            System.out.println(studentDO);
        }
    }


    @Test
    public void testGetStudentByNumber(){
        StudentDO studentByNumber = studentDAO.getStudentByNumber("17263630");
        System.out.println(studentByNumber);
    }

    @Test
    public void testGetStudentByName(){
        StudentDO studentByName = studentDAO.getStudentByName("王丹");
        System.out.println(studentByName);
    }

    @Test
    public void testGetStudentByPhone(){
        StudentDO studentByPhone = studentDAO.getStudentByPhone("1321234567");
        System.out.println(studentByPhone);
    }

    @Test
    public void testGetStudentsByCollege(){
        List<StudentDO> studentsByCollege = studentDAO.getStudentsByCollege("信息工程学院");
        for (StudentDO studentDO : studentsByCollege) {
            System.out.println(studentDO);
        }
    }

    @Test
    public void testGetStudentsByMajor(){
        List<StudentDO> studentsByMajor = studentDAO.getStudentsByMajor("软件工程");
        for (StudentDO studentDO : studentsByMajor) {
            System.out.println(studentDO);
        }
    }

    @Test
    public void testGetStudentsByClassroom(){
        List<StudentDO> studentsByClassroom = studentDAO.getStudentsByClassroom("176");
        for (StudentDO studentDO : studentsByClassroom) {
            System.out.println(studentDO);
        }
    }

    @Test
    public void testGetStudentsBySex(){
        List<StudentDO> studentsBySex = studentDAO.getStudentsBySex("女");
        for (StudentDO studentDO : studentsBySex) {
            System.out.println(studentDO);
        }
    }

    @Test
    public void testGetStudentsByBirthday(){
        List<StudentDO> studentsByBirthday = studentDAO.getStudentsByBirthday(LocalDate.now());
        for (StudentDO studentDO : studentsByBirthday) {
            System.out.println(studentDO);
        }
    }


    @Test
    public void testDeleteStudentById(){
        studentDAO.deleteStudentById(10L);
    }


    @Test
    public void testGetStudentsBySearch(){
        StudentDO studentDO = new StudentDO();
        studentDO.setCollege("信息工程学院");
        studentDO.setSex("");
        List<StudentDO> studentDOList = studentDAO.getStudentsBySearch(studentDO);
        for (StudentDO aDo : studentDOList) {
            System.out.println(aDo);
        }
    }


    @Test
    public void testGetStudentWithCourses(){
        StudentDO studentWithCourses = studentDAO.getStudentWithCourses(5L);
        List<CourseDO> courseDOList = studentWithCourses.getCourseDOList();
        for (CourseDO courseDO : courseDOList) {
            System.out.println(courseDO);
        }
    }


}