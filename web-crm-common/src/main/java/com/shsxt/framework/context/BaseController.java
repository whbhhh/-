package com.shsxt.framework.context;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    /**
     * 获取上下文路径
     * @param request
     */
    @ModelAttribute
    public void preMethod(HttpServletRequest request){
        request.setAttribute("ctx", request.getContextPath());
    }
}
