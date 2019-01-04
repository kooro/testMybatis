package com.weigram.mapper;

import com.weigram.model.User;
import com.weigram.vo.UserQueryVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public int add(User user);
    public User findUserById(int id);
    @Select("select * from user where username like '%${value}%'")
    public List<User> findUserByName(String name);
    public List<UserQueryVO> findUserByUserQuerVo(int id);
    public List<User> findUserByMap(Map<String,Object> map);
    public User findUserAndOrderInfo(int userid);

}
