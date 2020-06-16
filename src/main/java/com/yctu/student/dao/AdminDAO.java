package com.yctu.student.dao;

import com.yctu.student.domain.AdminDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO {


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


}

