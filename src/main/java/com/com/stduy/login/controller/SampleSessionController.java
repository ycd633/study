package com.com.stduy.login.controller;

import com.com.stduy.configuration.session.SessionManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SampleSessionController {

    @Autowired
    private static SessionManager sessionManager;


    @GetMapping("/createSession")
    public static String login(HttpServletRequest request, HttpServletResponse response)
    {
        Member member = new Member();
        member.setUserId("1001");
        member.setName("test session");
        member.setEmail("jfklajsdkl@nate.com");
        member.setRole("111");


        sessionManager.createSession(member, response);

        return "/account/login";
    }

    @GetMapping("getSession")
    public Member getCookie(HttpServletRequest request, HttpServletResponse response){
        return (Member) sessionManager.getSession(request);
    }
}




@Setter
@Getter
class Member{
    String userId;

    String name;

    String email;

    String role;
}
