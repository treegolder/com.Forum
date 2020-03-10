package com.ssj.forum.service.impl;

import com.ssj.forum.entity.Answer;
import com.ssj.forum.entity.User;
import com.ssj.forum.mapper.AnswerMapper;
import com.ssj.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<Answer> findListByQuestionId(Integer id) {
        return answerMapper.selectListByQuestionId(id);
    }

    @Override
    public void save(Answer answer, HttpSession session) {
        answer.setCreatetime(new Date());
        User user = (User) session.getAttribute("user");

        if (user == null) {
            answer.setUserId(0);//匿名
        } else {
            answer.setUserId(user.getId());
        }

        System.out.println(user.getId());

        answerMapper.insertAnswer(answer);
    }
}
