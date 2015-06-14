package org.me.memory.controller;

import javax.servlet.http.HttpServletRequest;
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
	//private Logger logger = Logger.getLogger(SystemController.class);
	
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/main.jsp");
		return mav;
	}
}
