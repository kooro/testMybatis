package com.weigram.controller;

import com.weigram.dao.UserDaoImpl;
import com.weigram.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import  java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class indexController {
    private static SqlSession session;
    private static UserDaoImpl userDaoImpl = new UserDaoImpl();
    @BeforeAll
    public static void  before() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        session = sqlSessionFactory.openSession();
    }
    @AfterAll
    public static void  after(){
        session.close();
    }
    @Test
    public void test1() {
        User user = session.selectOne("findUserById",1);
        System.out.println(user);
    }
    @Test
    public void test2(){
        List<User> user = session.selectList("findUserByName","张三");
        for (User o:user){
            System.out.println(o);
        }
    }
    @Test
    public void test3(){
        User user = new User("test2","2",new Date(),"上海");
        int row = session.insert("insertUser", user);
        session.commit();
        System.out.println(row);
        System.out.println(user.getId());
    }
    @Test
    public void test4(){
        User user =  session.selectOne("findUserById",30);
//        int row = session.delete();
        int row = session.delete("deleteUser",31);
        session.commit();
        System.out.println(row);
    }
    @Test
    public void test5() throws ParseException {
        User user =  session.selectOne("findUserById",30);
        user.setUsername("alibaba");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setBirthday(format.parse("2018-8-24 12:50:20:545"));
        user.setSex("2");
        int row = session.update("updateUser",user);
        session.commit();
        System.out.println(row);
    }
    @Test
    public void test6(){
        User user = new User("test2","2",new Date(),"上海");
        int row = session.insert("insertUserReturnID", user);
        session.commit();
        System.out.println(row);
        System.out.println(user.getId());
    }
    @Test
    public void test7(){
        User user = userDaoImpl.findUserById(27);
        System.out.println(user);
    }
    @Test
    public void  test8(){

    }

}
