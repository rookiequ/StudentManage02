package com.yctu.student.dao;


import com.yctu.student.controller.TeacherController;
import com.yctu.student.controller.impl.TeacherControllerImpl;
import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TeacherDOTest{
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void testAddTeacher(){
        TeacherDO teacherDO=new TeacherDO();
        teacherDO.setCollege("信工");
        teacherDO.setName("张三");
        teacherDO.setNumber("123456");
        teacherDO.setCreateTime(LocalDate.now());
        teacherDO.setModifyTime(LocalDate.now());
        teacherDO.setPassword("123456");
        teacherDO.setSex("男");
        teacherDAO.addTeacher(teacherDO);
        }





    @Test
    public void testAddTeacherService(){
        TeacherDO teacherDO=new TeacherDO();
        teacherDO.setCollege("信工");
        teacherDO.setName("张三");
        teacherDO.setNumber("123456789");
        teacherDO.setCreateTime(LocalDate.now());
        teacherDO.setModifyTime(LocalDate.now());
        teacherDO.setPassword("123456");
        teacherDO.setSex("男");
        System.out.println(teacherService.addTeacher(teacherDO).getMsg());
    }

    @Test
    public void testdeleteTeacher(){
        teacherDAO.deleteTeacher(2L);

    }

    @Test
    public void testgetTeacherByid(){
        System.out.println(teacherDAO.getTeacherById(5L));

    }




    @Test
    public void testgetAllTeacher(){

        System.out.println(teacherService.getAllTeacher(1,1).getModule());
    }


    @Test
    public void testgetAllTeacherByNumberAndPassword(){

        System.out.println(teacherService.getTeacherByNumberAndPassword("123456","123456").isSuccess());
    }

    @Test
    public void testTeacherCon(){
        TeacherControllerImpl teacherControllerImpl =new TeacherControllerImpl() ;
        TeacherDO teacherDO=new TeacherDO();
        teacherDO.setCollege("信工");
        teacherDO.setName("张三");
        teacherDO.setNumber("12346");
        teacherDO.setCreateTime(LocalDate.now());
        teacherDO.setModifyTime(LocalDate.now());
        teacherDO.setPassword("123456");
        teacherDO.setSex("男");
        System.out.println(teacherControllerImpl.addTeacher(teacherDO));


    }


    @Test
    public void testGetTeacherWithCourses(){
        TeacherDO teacherWithCourses = teacherDAO.getTeacherWithCourses(3L);
        List<CourseDO> courseDOList = teacherWithCourses.getCourseDOList();
        for (CourseDO courseDO : courseDOList) {
            System.out.println(courseDO);
        }
    }
}