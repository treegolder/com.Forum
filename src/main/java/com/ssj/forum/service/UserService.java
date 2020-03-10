package com.ssj.forum.service;

import com.ssj.forum.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * 登录
     */
    String login(String loginname, String password, HttpSession session);
}
