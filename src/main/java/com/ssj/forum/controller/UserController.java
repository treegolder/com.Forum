package com.ssj.forum.controller;

import com.ssj.forum.entity.User;
import com.ssj.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
   @Autowired
    private UserService userService;

    //登录页面
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }
    //注册页面
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }
    //登录请求
    @ResponseBody
    @RequestMapping("/login")
    public String login(String loginname, String password, HttpSession session) {
       String flag = userService.login(loginname, password,session);
//       if (flag.equals("101")) {
//           session.setAttribute("user",loginname);
//       }
       return flag;
    }
    //注册请求
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user) {
        user.setCreatetime(new Date());
        userService.register(user);

        return "success";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //清空session
        session.invalidate();
        return "redirect:/index";
    }

}
