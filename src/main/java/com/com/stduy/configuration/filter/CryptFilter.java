package com.com.stduy.configuration.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
@WebFilter(urlPatterns = "/reg")
public class CryptFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Web Filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("WEB Filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        LoginWrapper loginWrapper = new LoginWrapper(httpServletRequest);
        filterChain.doFilter(loginWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

class LoginWrapper extends HttpServletRequestWrapper{

    public LoginWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String key)
    {
        String value = "";
        if(key != null && key.equals("userPwd")){
            value = getSha512(super.getParameter("userPwd"));
        }
        else
        {
            value = super.getParameter("userPwd");
        }
        return value;
    }

    private static String getSha512(String pwd)
    {
        String encPwd = "";

        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
            md.update(bytes);

            encPwd = Base64.getEncoder().encodeToString(md.digest());
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return encPwd;
    }
}