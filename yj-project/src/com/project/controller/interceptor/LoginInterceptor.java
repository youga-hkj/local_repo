package com.project.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <p>Title: HandlerInterceptor1</p>
 * <p>Description: 用户身份认证拦截�?/p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-22下午4:11:44
 * @version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {

	//在执行handler之前来执行的
	//用于用户认证校验、用户权限校�?
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//得到请求的url
		String url = request.getRequestURI();
		
		//判断是否是公�?地址
		//实际�?��中需要公�?地址配置在配置文件中
		//...
		if(url.indexOf("login.action")>=0){
			//如果是公�?地址则放�?
			return true;
		}
		
		//判断用户身份在session中是否存�?
		HttpSession session = request.getSession();
		String usercode = (String) session.getAttribute("usercode");
		//如果用户身份在session中存在放�?
		if(usercode!=null){
			return true;
		}
		//执行到这里拦截，跳转到登陆页面，用户进行身份认证
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		
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
