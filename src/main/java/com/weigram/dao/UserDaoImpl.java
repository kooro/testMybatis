package com.weigram.dao;

import com.weigram.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoImpl implements UserDao {
    private static SqlSession session;

    public UserDaoImpl() {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        session.update("updateUser", user);
        session.commit();
        session.close();
    }

    @Override
    public User findUserById(int id) {
        User user = session.selectOne("findUserById", id);
        session.close();
        return user;
    }
}
