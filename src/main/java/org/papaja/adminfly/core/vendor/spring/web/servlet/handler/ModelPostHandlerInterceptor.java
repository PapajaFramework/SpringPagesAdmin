package org.papaja.adminfly.core.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.data.AvailableLocales;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelPostHandlerInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) {
        view.addObject("_test", "hello");
        view.addObject("locales", AvailableLocales.LOCALES);
    }

}
