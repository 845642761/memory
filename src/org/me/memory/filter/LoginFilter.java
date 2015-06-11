package org.me.memory.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * 登录拦截器
 * @author cheng_bo
 * @date 2015年6月9日 16:03:02
 */
public class LoginFilter implements Filter {
	private Logger logger = Logger.getLogger(LoginFilter.class);
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session=request.getSession(false);
		String url=request.getRequestURI();
		if(url.contains("regist") || url.contains("login") || url.contains("ssoLogin")){
			fc.doFilter(sRequest, sResponse);
			return;
		}
		if(session ==null || session.getAttribute("user")==null){
			logger.info("no user login!");
			response.sendRedirect("/user/login.do");
			return;
		}
		if(session.getAttribute("isExitUserInfo")!=null && !url.contains("UserInfo")){
			logger.debug("no user info!");
			response.sendRedirect("/user/addUserInfo.do");
			return;
		}
		fc.doFilter(sRequest, sResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
