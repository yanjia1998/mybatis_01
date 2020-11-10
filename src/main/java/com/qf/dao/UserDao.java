package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    List<User> selectAll();

    User selectById(@Param("id") Integer id);
    List<User>  selectByLike(@Param("name")String name);

    int insertUser(User user);


    int delUserById(@Param("id")Integer id);


    int  updateUser(User user);
}
