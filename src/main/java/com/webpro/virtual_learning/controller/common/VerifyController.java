package com.webpro.virtual_learning.controller.common;

import com.webpro.virtual_learning.converter.dto_entity.DTOEntityConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.HttpRequestDTOConverter;
import com.webpro.virtual_learning.converter.httprequest_dto.mapper.UserHttpRequestDTOMapper;
import com.webpro.virtual_learning.dto.UserDTO;
import com.webpro.virtual_learning.entity.BaseEntity;
import com.webpro.virtual_learning.entity.UserEntity;
import com.webpro.virtual_learning.service.IUserService;
import com.webpro.virtual_learning.utils.GoogleMailUtil;
import com.webpro.virtual_learning.utils.MyUtil;
import lombok.SneakyThrows;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/verify"})
public class VerifyController extends HttpServlet {
    @Inject
    private HttpRequestDTOConverter requestDTOConverter;

    @Inject
    private UserHttpRequestDTOMapper userHttpRequestDTOMapper;

    @Inject
    private IUserService userService;

    @SneakyThrows
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDTO userDto = (UserDTO) request.getSession().getAttribute("verificationUser_Session");
        request.setAttribute("verificationUser", userDto);

        // Get host email infor
        ResourceBundle rb = ResourceBundle.getBundle("host-email");
        String hostEmail = rb.getString("email");
        String password = rb.getString("password");
        request.setAttribute("hostEmail", hostEmail);

        // check if user is valid
        if (userDto == null) {
            response.sendRedirect("/login");
            return;
        }

        // check if it sent code
        if (userDto.getVerificationCode() != null) {
            request.getRequestDispatcher("/verify-account.jsp").forward(request, response);
            return;
        }

        // get verification code
        String verificationCode = MyUtil.generateRandomString(10).toUpperCase();
        userDto.setVerificationCode(verificationCode);
        request.getSession().setAttribute("verificationUser_Session", userDto);

        // send email
        String subject = "Virtual Learning | Verification email";
        String message =
                "Hi " + userDto.getFullName() + ", <br>" +
                        "We're excited to have you get started at Virtual Learning.<br> " +
                        "Your verification code is <strong>" + verificationCode + "</strong>. " +
                        "Please use it in order to enter at the verification textbox at verification page. Thanks for your attending. <br>" +
                        "Cheers, <br>" +
                        "<strong>Virtual Learning</strong>";
        GoogleMailUtil.sendEmail(hostEmail, password, userDto.getEmail(), subject, message);

        request.getRequestDispatcher("/verify-account.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String verificationCode = request.getParameter("verificationCode");
        UserDTO userDto = (UserDTO) request.getSession().getAttribute("verificationUser_Session");

        // check resend
        if (verificationCode.equals("resend")) {
            userDto.setVerificationCode(null);
            String message = "Resent verification code";
            response.sendRedirect("/verify?message=" + message);
            return;
        }

        // true verification code
        if (userDto.getVerificationCode().equals(verificationCode)) {
            UserEntity responseEntity = userService.save(userDto);
            //request.setAttribute("responseEntity", responseEntity);

            // save successfully
            if (responseEntity.getHttpStatus().equals(BaseEntity.HttpStatus.OK)) {
                request.getSession().setAttribute("verificationUser_Session", null);
                response.sendRedirect("/log-in?message=" + responseEntity.getMessage());
                return;
            }

            // save fail
            response.sendRedirect("/sign-up?message=" + responseEntity.getMessage());
            return;
        }

        // wrong verification code
        UserEntity responseEntity = userService.exceptionObject(new UserEntity(), "Wrong verification code. Please check again.");
        request.setAttribute("responseEntity", responseEntity);
        this.doGet(request, response);
    }
}
