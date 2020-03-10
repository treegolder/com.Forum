package com.ssj.forum.controller;

import com.ssj.forum.entity.Answer;
import com.ssj.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ans")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @RequestMapping("/save")
    public String saveAns(Answer answer, HttpSession session) {

    answerService.save(answer,session);


        System.out.println("zjssd");
        return "redirect:/ques/detail?id=" + answer.getQuestionId();
    }
}
