package com.yctu.student.dao;

import com.yctu.student.domain.AdminDO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO {


    /**
     * 根据id获取管理员信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM tb_admin WHERE id=#{id}")
    @Results(id = "adminMap", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, javaType = Long.class, id = true),
            @Result(column = "account", property = "account"),
            @Result(column = "password", property = "password"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "modify_time", property = "modifyTime")
    })
    AdminDO getAdminById(Long id);

    /**
     * 注册管理员账号
     * @param adminDO
     * @return
     */
    @Insert("INSERT INTO tb_admin(" +
            "account, password, create_time, modify_time" +
            ")VALUES(" +
            "#{account}, #{password}, NOW(), NOW())")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", keyColumn = "id", before = false, resultType = Long.class)
    Long addAdmin(AdminDO adminDO);


    /**
     * 修改管理员信息（密码，账号）
     * @param adminDO
     */
    @Update("UPDATE tb_admin SET " +
            "account=#{account}," +
            "password=#{password}," +
            "modify_time=NOW() " +
            "WHERE id=#{id}")
    void updateAdmin(AdminDO adminDO);


    /**
     * 根据账号和密码获取管理员信息
     * @param account
     * @param password
     * @return
     */
    @ResultMap(value = "adminMap")
    @Select("SELECT * FROM tb_admin WHERE account=#{account} AND password=#{password}")
    AdminDO getAdminByAccountAndPassword(@Param("account") String account, @Param("password") String password);


}

