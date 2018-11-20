package com.ldq.emu.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 拦截器
 * @author 叶宏杰
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * 如果没有登录，则跳转到登录页
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object userName = request.getSession().getAttribute("user");
		if(userName == null) {
			response.sendRedirect("/login.html");
			return false ;
		}
		return true; //转交给下一个拦截器
	}
}
