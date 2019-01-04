package com.weigram.dao;

import com.weigram.model.User;

public interface UserDao {
    public void save(User user);
    public User findUserById(int id);
}
