package com.qf;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUser {

    @Test
    public void  testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        List<User> all = mapper.selectAll();
        //输出
        System.out.println(all);
    }

    @Test
    public void  testSelectByLike() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        List<User> user = mapper.selectByLike("师");
        //输出
        System.out.println(user);
    }

    @Test
    public void  testSelectById() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        User user = mapper.selectById(2);
        //输出
        System.out.println(user);
    }

    @Test
    public void  testInsertUser() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        //加true就会自动提交    否则需要sqlSession.commit()手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        User user = new User();
        user.setName("苗老师");
        user.setAddr("西安市");
        user.setSex("男");
        int i = mapper.insertUser(user);
        System.out.println("受影响行数为..."+i);

//        System.out.println(user);
    }


    @Test
    public void  testDelUser() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        //加true就会自动提交    否则需要sqlSession.commit()手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        int i = mapper.delUserById(4);
        System.out.println("受影响行数为..."+i);

//        System.out.println(user);
    }


    @Test
    public void  testUpdateUser() throws IOException {
        String resource = "mybatis-config.xml";
        //读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用配置信息创建出sqlSession工程
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //使用工厂来去打开一个连接
        //加true就会自动提交    否则需要sqlSession.commit()手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //使用userDao调用你要执行的方法
        User user = new User();
        user.setId(7);
        user.setSex("男");
        user.setAddr("小西安");
        user.setPass("ss");
        user.setName("高老师");
        int i = mapper.updateUser(user);
        System.out.println("受影响行数为..."+i);

//        System.out.println(user);
    }
}
