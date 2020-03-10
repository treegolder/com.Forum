package com.ssj.forum.controller;

import com.ssj.forum.entity.Answer;
import com.ssj.forum.entity.Question;
import com.ssj.forum.service.AnswerService;
import com.ssj.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/ques")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;

    @RequestMapping("/form")
    public String form(){
        return "questionForm";
    }


    @RequestMapping("/save")
    public String save(Question question, HttpSession session){

    questionService.save(question, session);

    return "redirect:/index";
    }


    @RequestMapping("/detail")
    public String detail(Integer id, Model model) {
        Question question = questionService.selectOne(id);
        //基于questionid获取该问题的回复
        List<Answer> answerList = answerService.findListByQuestionId(id);

        model.addAttribute("question",question);
        model.addAttribute("answerList",answerList);
        return "questionDetail";
    }
}
