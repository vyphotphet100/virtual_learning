package com.webpro.virtual_learning.converter;

import com.webpro.virtual_learning.dto.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetDTOConverter {
    public BaseDTO toDTO(ResultSet rs, Class tClass) {
        if (tClass == RoleDTO.class) {
            RoleDTO roleDto = new RoleDTO();
            try {
                roleDto.setId(rs.getLong("id"));
                roleDto.setCode(rs.getString("code"));
                return roleDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == UserDTO.class) {
            UserDTO userDto = new UserDTO();
            try {
                userDto.setUsername(rs.getString("username"));
                userDto.setPassword(rs.getString("password"));
                userDto.setFullName(rs.getString("full_name"));
                userDto.setEmail(rs.getString("email"));
                userDto.setBirthday(rs.getDate("birthday"));
                userDto.setPhone(rs.getString("phone"));
                userDto.setAvatar(rs.getString("avatar"));
                userDto.setRoleCode(rs.getString("role_code"));
                return userDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == ClassDTO.class) {
            ClassDTO classDto = new ClassDTO();
            try {
                classDto.setId(rs.getLong("id"));
                classDto.setName(rs.getString("name"));
                classDto.setDescription(rs.getString("description"));
                classDto.setPassword(rs.getString("password"));
                classDto.setAuthorUsername(rs.getString("author_username"));
                classDto.setSubjectId(rs.getLong("subject_id"));
                return classDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == DoDTO.class) {
            DoDTO doDto = new DoDTO();
            try {
                doDto.setUsername(rs.getString("username"));
                doDto.setQuestionId(rs.getLong("question_id"));
                return doDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == JoinDTO.class) {
            JoinDTO joinDto = new JoinDTO();
            try {
                joinDto.setUsername(rs.getString("username"));
                joinDto.setClassId(rs.getLong("class_id"));
                return joinDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == LessonDTO.class) {
            LessonDTO lessonDto = new LessonDTO();
            try {
                lessonDto.setId(rs.getLong("id"));
                lessonDto.setTitle(rs.getString("title"));
                lessonDto.setDescription(rs.getString("description"));
                lessonDto.setVideo(rs.getString("video"));
                lessonDto.setClassId(rs.getLong("class_id"));
                return lessonDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == QuestionDTO.class) {
            QuestionDTO questionDto = new QuestionDTO();
            try {
                questionDto.setId(rs.getLong("id"));
                questionDto.setContent(rs.getString("content"));
                questionDto.setOption(rs.getString("option"));
                questionDto.setCorrect(rs.getInt("correct"));
                questionDto.setLessonId(rs.getLong("lesson_id"));
                return questionDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if (tClass == SubjectDTO.class) {
            SubjectDTO subjectDto = new SubjectDTO();
            try {
                subjectDto.setId(rs.getLong("id"));
                subjectDto.setName(rs.getString("name"));
                return subjectDto;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
