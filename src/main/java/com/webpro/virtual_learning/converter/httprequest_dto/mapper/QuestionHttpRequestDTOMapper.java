package com.webpro.virtual_learning.converter.httprequest_dto.mapper;

import com.webpro.virtual_learning.dto.QuestionDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class QuestionHttpRequestDTOMapper extends BaseHttpRequestDTOMapper<QuestionDTO>{

    public QuestionDTO mapToDTO(HttpServletRequest request) {
        QuestionDTO questionDto = new QuestionDTO();
        try {
            questionDto.setId(Long.parseLong(request.getParameter("id")));
        } catch (Exception ex) {
            questionDto.setId(null);
        }
        questionDto.setContent(request.getParameter("content"));
        questionDto.setOption(request.getParameter("option"));
        questionDto.setLessonId(Long.parseLong(request.getParameter("lessonId")));
        questionDto.setCorrect(Integer.parseInt(request.getParameter("correct")));
        String[] requestUsernames = request.getParameterValues("usernames");
        if (requestUsernames != null) {
            List<String> usernames = new ArrayList<>();
            for (String username : requestUsernames)
                usernames.add(username);
            questionDto.setUsernames(usernames);
        }

        return questionDto;
    }
}
