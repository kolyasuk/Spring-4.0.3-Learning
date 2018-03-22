package iful.edu.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import iful.edu.spring.objects.User;

@Component
public class CheckUserInterceptor extends HandlerInterceptorAdapter {

	long time;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		request.setAttribute("startTime", System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		long time = Long.valueOf(request.getAttribute("startTime").toString());

		request.getSession().setAttribute("endTime", System.currentTimeMillis() - time);
		User user = (User) request.getSession().getAttribute("user");

		if (user != null && !user.isAdmin()) {
			response.sendRedirect(request.getContextPath() + "/failed");
		}
	}

}
