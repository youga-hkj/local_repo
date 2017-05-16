package com.project.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description: 测试拦截�?</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-22下午4:11:44
 * @version 1.0
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

	//在执行handler之前来执行的
	//用于用户认证校验、用户权限校�?
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("HandlerInterceptor1...preHandle");
		
		//如果返回false表示拦截不继续执行handler，如果返回true表示放行
		return false;
	}
	//在执行handler返回modelAndView之前来执�?
	//如果�?��向页面提供一些公�?的数据或配置�?��视图信息，使用此方法实现 从modelAndView入手
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor1...postHandle");
		
	}
	//执行handler之后执行此方�?
	//作系�?统一异常处理，进行方法执行�?能监控，在preHandle中设置一个时间点，在afterCompletion设置�?��时间，两个时间点的差就是执行时长
	//实现 系统 统一日志记录
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptor1...afterCompletion");
	}

}
