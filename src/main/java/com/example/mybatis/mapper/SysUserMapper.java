package com.example.mybatis.mapper;

import com.example.mybatis.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author miller
 */
@Mapper
public interface SysUserMapper {

    SysUser selectSysUserByUsername(@Param("username") String username);

    @Select("select * from sys_user")
    List<SysUser> select();
}
