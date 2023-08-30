package com.ryou.mybatis;

import com.ryou.mybatis.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class LearnMybatisService {
    public static void main(String[] args) throws IOException {
        // 记载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取SqlSession对象（执行SQL）
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL(使用非mapper接口)， namespace=AccountMapper, SQL id = selectAccount的SQL，传入参数id = 2
//        Account account = sqlSession.selectOne("AccountMapper.selectAccount", 2);
//        System.out.println(account.toString());

        // 使用mapper接口
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
        Account account1 = accountMapper.selectAccount(2);
        System.out.println(account1);

        // 释放资源
        sqlSession.close();

    }
}
