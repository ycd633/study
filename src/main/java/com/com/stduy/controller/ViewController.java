package com.com.stduy.controller;

import com.com.stduy.dto.testDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @GetMapping("/")
    @ApiOperation(value="메인화면", notes = "기본페이지", response = testDto.class)
    public String index()
    {
        return "index";
    }


    @GetMapping("/account/google")
    @ApiOperation(value="구글OTP인증", notes = "구글 OTP 2차 인증 페이지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "페이지 호출 성공"),
            @ApiResponse(code = 401, message = "로그인 실패로 인한 권한 미흡")
    })
    public String googleOTP(Model model, HttpServletRequest servletRequest)
    {
        
        return "/account/GoogleOTP";
    }

    @GetMapping("/account/login")
    public String login()
    {
        return "/account/login";
    }

    @GetMapping("/reg")
    public String reg()
    {
        return "/account/login";
    }
}
