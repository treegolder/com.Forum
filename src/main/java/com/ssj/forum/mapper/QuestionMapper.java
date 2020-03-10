package com.ssj.forum.mapper;

import com.ssj.forum.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    /**
     * 保存问题
     * @param question
     */
    void insertQuestion(Question question);

    /**
     * 查询所有问题
     * @param beginPage
     * @param pageCount
     * @param title
     * @return
     */
    List<Question> selectAll(@Param("beginPage") Integer beginPage, @Param("pageCount") Integer pageCount, @Param("title") String title);

    /**
     * 查询记录总数
     * @param title
     * @return
     */
    Integer getTotal(@Param("title") String title);

    /**
     * 根据主键查询问题
     * @param id
     * @return
     */
    Question selectOneByPrimaryKey(Integer id);

}
