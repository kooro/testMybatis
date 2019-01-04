package com.weigram.controller;

import com.weigram.mapper.OrderMapper;
import com.weigram.mapper.UserMapper;
import com.weigram.model.OrderDetail;
import com.weigram.model.Orders;
import com.weigram.model.OrdersExt;
import com.weigram.model.User;
import com.weigram.vo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testController {
    private static SqlSession session;
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
    public void test1(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findUserById(27);
        System.out.println(user);
    }
    @Test
    public void test2(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("dddd","1",new Date(),"beijing");
        userMapper.add(user);
        System.out.println(user);
    }
    @Test
    public void test3(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> user = userMapper.findUserByName("张三");
        for (User o:user){
            System.out.println(o);
        }
    }
    @Test
    public void test4(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<UserQueryVO>  userQueryVOs= userMapper.findUserByUserQuerVo(1);
        System.out.println(userQueryVOs.size());
        for (UserQueryVO o:userQueryVOs){
            System.out.println(o.getNumber());
        }
    }

    @Test
    public void test5(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","test2");
        map.put("sex",2);
        List<User>  users= userMapper.findUserByMap(map);
        System.out.println(users.size());
        for (User o:users){
            System.out.println(o);
        }
    }
    @Test
    public void test6(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        OrdersExt ext = orderMapper.findOrderById(3);
        System.out.println(ext);
    }
    @Test
    public void test7(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Orders orders= orderMapper.findOrderById2(3);
        System.out.println(orders);
    }
    @Test
    public void test8(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Orders orders= orderMapper.findOrderById3(3);
        System.out.println(orders);
        System.out.println(orders.getOrderDetails());
    }
    @Test
    public void test9(){
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user= userMapper.findUserAndOrderInfo(1);
        System.out.println(user);
        System.out.println(user.getOrdersList());
        for(Orders o:user.getOrdersList()){
            System.out.println(o.getOrderDetails());
            for(OrderDetail d:o.getOrderDetails()){
                System.out.println(d.getItems());
            }
        }
    }

    @Test
    public void test10(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        List<Orders> orders= orderMapper.findOrderAndUserByLazyLoading();
        for(Orders o:orders){
            System.out.println(o);
            System.out.println(o.getUser());
        }
    }

}
