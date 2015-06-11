package org.me.memory.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.me.memory.entity.User;

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
	public User getLoginUser(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session==null || session.getAttribute("user")==null){
			return null;
		}
		return (User) session.getAttribute("user");
	}
}
