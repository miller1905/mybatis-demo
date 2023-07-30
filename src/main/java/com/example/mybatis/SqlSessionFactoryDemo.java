package com.example.mybatis;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.mybatis.mapper.SysUserMapper;
import com.example.mybatis.model.SysUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Yazha
 */
public class SqlSessionFactoryDemo {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = getInstance();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SqlSessionFactory getInstance() throws IOException {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }

    /**
     * 从XML中提取SqlSessionFactory
     */
    public static void main(String[] args) throws IOException {
        sqlSessionFactory = SqlSessionFactoryDemo.getInstance();

        try (SqlSession session = sqlSessionFactory.openSession()) {
            SysUser sysUser = session.selectOne("com.example.mybatis.mapper.SysUserMapper.selectSysUserByUsername", "zhangsan");
            System.out.println(JSONObject.toJSONString(sysUser));
        }

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = sysUserMapper.selectSysUserByUsername("lisi");
            System.out.println(JSON.toJSONString(sysUser));

            List<SysUser> sysUserList = sysUserMapper.select();
            System.out.println(JSON.toJSONString(sysUserList));
        }
    }
}
