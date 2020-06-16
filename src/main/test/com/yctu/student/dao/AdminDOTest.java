package com.yctu.student.dao;

import com.yctu.student.domain.AdminDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName AdminDOTest
 * @Description 对AdminDO实体类进行crud测试
 * @Author qlq
 * @Date 2020-06-16 15:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AdminDOTest {

    @Autowired
    private AdminDAO adminDAO;


    @Test
    public void testAddAdmin(){
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount("quliqing");
        adminDO.setPassword("quliqing");
        Long id = adminDAO.addAdmin(adminDO);
        System.out.println(id);
    }

    @Test
    public void testUpdateAdmin(){
        AdminDO adminDO = new AdminDO();
        adminDO.setAccount("zzq");
        adminDO.setPassword("zzq");
        adminDO.setId(2L);
        adminDAO.updateAdmin(adminDO);
    }

}
