package com.webpro.virtual_learning.converter.httprequest_dto.mapper;

import com.webpro.virtual_learning.dto.LessonDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class LessonHttpRequestDTOMapper extends BaseHttpRequestDTOMapper<LessonDTO>{

    public LessonDTO mapToDTO(HttpServletRequest request) {
        LessonDTO lessonDto = new LessonDTO();
        try {
            lessonDto.setId(Long.parseLong(request.getParameter("id")));
        } catch(Exception ex) {
            lessonDto.setId(null);
        }
        lessonDto.setTitle(request.getParameter("title"));
        lessonDto.setDescription(request.getParameter("description"));
        lessonDto.setVideo(request.getParameter("video"));
        lessonDto.setClassId(Long.parseLong(request.getParameter("classId")));
        String[] requestQuestionIds = request.getParameterValues("questionIds");
        if (requestQuestionIds != null) {
            List<Long> questionIds = new ArrayList<>();
            for (String questionId: requestQuestionIds)
                questionIds.add(Long.parseLong(questionId));
            lessonDto.setQuestionIds(questionIds);
        }
        else
            lessonDto.setQuestionIds(null);

        return lessonDto;
    }
}
