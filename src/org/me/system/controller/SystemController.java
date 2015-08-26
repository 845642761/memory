package org.me.system.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.me.core.util.UserUtils;
import org.me.security.entity.Permission;
import org.me.security.service.ISecurityService;
import org.me.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理Controller
 * @author cheng_bo
 * @date 2015年6月9日 14:18:48
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	@Resource
	private ISecurityService securityService;
	
	@RequestMapping("/main")
	public ModelAndView main (HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/main.jsp");
		User user=new UserUtils().getUser(request);
		List<Permission> menuList=securityService.getPermissionsByLoginId(user.getStrLoginId(), 0, 0);
		
		HashMap<String, List<Permission>> hm=new HashMap<String, List<Permission>>();
		for (Permission p : menuList) {
			String id=p.getStrId();
			Permission p1=new Permission();
			p1.setStrPId(id);
			p1.setnType(0);
			p1.setnLevel(-1);
			p1.setnState(-1);
			hm.put(id, securityService.getPermissionsByRange(p1));
		}

		mav.addObject("menuList",menuList);
		mav.addObject("menuMap",hm);
		return mav;
	}
}
