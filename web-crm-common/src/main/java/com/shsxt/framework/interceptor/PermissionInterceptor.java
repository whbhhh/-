package com.shsxt.framework.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shsxt.framework.constant.VerifyType;
import com.shsxt.framework.permission.handler.PermissionAbstractHandlerChain;
import com.shsxt.framework.permission.handler.PermissionHandlerChainStaticFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shsxt.framework.permission.Permission;

/**
 * 权限拦截器
 * 
 * @author Mr.YongGan.Zhang
 *
 */
public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {// 判断是否是拦截的方法
			HandlerMethod hm = (HandlerMethod) handler;
			Method method = hm.getMethod();// 获取到拦截的方法
			// 获取方法上的注解
			Permission permission = method.getAnnotation(Permission.class);
			if (permission != null) {//  进入权限判断
				VerifyType verifyType = permission.verifyType();
				String[] verifyValue = permission.verifyValue();
				PermissionAbstractHandlerChain chain = PermissionHandlerChainStaticFactory.createPermissionWithNone();
				boolean handlerChain = chain.cherkPermissionHandleChain(request,verifyType,verifyValue);
				if (!handlerChain){
					request.getRequestDispatcher("index.shtml").forward(request,response);
				}
				return handlerChain;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
