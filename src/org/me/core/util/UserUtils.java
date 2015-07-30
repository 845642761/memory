package org.me.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.me.user.entity.LoginUser;
import org.me.user.entity.User;

/**
 * user工具
 * @author cheng_bo
 * @date 2015年6月10日 13:49:09
 */
public class UserUtils {
	
	/**
	 * 获取当前登录用户
	 * @author cheng_bo
	 * @date 2015年6月10日 13:53:12
	 */
	public User getUser(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("user")==null){
			return null;
		}
		return (User) session.getAttribute("user");
	}
	
	/**
	 * 获取当前登录用户(LoginUser)
	 * @autho: cheng_bo
	 * @date: 2015年7月29日 15:21:24
	 */
	public LoginUser getLoginUser(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("loginUser")==null){
			return null;
		}
		return (LoginUser) session.getAttribute("loginUser");
	}
}
