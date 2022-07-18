package com.com.stduy.login.controller;

import com.com.stduy.configuration.session.SessionManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LoginController {

    @Autowired
    private SessionManager SessionManager;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        Member member = new Member();
        member.setUserId("1001");
        member.setName("test session");
        member.setEmail("jfklajsdkl@nate.com");
        member.setRole("111");

        SessionManager.createSession(member, response);

        return "redirect:/account/GoogleOTP";
    }

    @GetMapping("get")
    public Member getCookie(HttpServletRequest request, HttpServletResponse response){
        return (Member) SessionManager.getSession(request);
    }
}
