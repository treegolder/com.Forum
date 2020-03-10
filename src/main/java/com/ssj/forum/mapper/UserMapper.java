package com.ssj.forum.mapper;

import com.ssj.forum.entity.User;

public interface UserMapper {
    //注册，保存用户
    void insertUser(User user);

    //登录，根据登录名查询用户
     User findUserByLoginname (String loginname);
}
