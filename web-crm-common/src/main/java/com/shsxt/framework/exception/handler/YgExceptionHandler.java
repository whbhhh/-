package com.shsxt.framework.exception.handler;
import com.shsxt.common.util.Result;
import com.shsxt.framework.exception.YgException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常层
 */
public class YgExceptionHandler implements HandlerExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(YgExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        Result result = null;
        if (ex instanceof YgException){
            YgException ygException = (YgException)ex;
            result = Result.fail(ygException.getCode(),ygException.getMsg());
        }else {
            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("");
            }

        }
        return null;
    }
}
