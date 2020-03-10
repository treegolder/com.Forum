package com.ssj.forum.service.impl;

import com.ssj.forum.entity.User;
import com.ssj.forum.mapper.UserMapper;
import com.ssj.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        userMapper.insertUser(user);

    }

    /**
     * 101表示登陆成功
     * 102表示登录失败
     * @param loginname
     * @param password
     * @return
     */
    @Override
    public String login(String loginname, String password, HttpSession session) {
        User user = userMapper.findUserByLoginname(loginname);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //用户登录成功，将【用户对象】存放到session
                session.setAttribute("user",user);
                return "101";//登录成功
            } else {
                return "102";//登录失败
            }
        } else {
            return "102";//登录失败
        }
    }
}
