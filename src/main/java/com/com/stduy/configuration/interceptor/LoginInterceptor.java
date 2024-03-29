package com.com.stduy.configuration.interceptor;

import com.com.stduy.configuration.session.SessionManager;
import com.com.stduy.users.model.vo.UserVo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();

        UserVo uservo = (UserVo) session.getAttribute(SessionManager.SESSION_COOKIE_NAME);
        if(ObjectUtils.isEmpty(uservo)){
            response.sendRedirect("/account/login");
            return false;
        }else{
            session.setMaxInactiveInterval(30*60);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }
}
