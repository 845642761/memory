package org.me.system.controller;

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
	public ModelAndView main (HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/main.html");
		return mav;
	}
	
	@RequestMapping("/top")
	public ModelAndView top(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/top.html");
		return mav;
	}
	
	@RequestMapping("/footer")
	public ModelAndView footer(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/footer.html");
		return mav;
	}
	
	@RequestMapping("/left")
	public ModelAndView left (HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/left.jsp");
		return mav;
	}
	
	@RequestMapping("/right")
	public ModelAndView right(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/system/right.jsp");
		return mav;
	}
}
