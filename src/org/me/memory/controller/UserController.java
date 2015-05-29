package org.me.memory.controller;

import java.io.IOException;
import java.io.Writer;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.me.memory.entity.LoginUser;
import org.me.memory.service.ILoginUserService;
import org.me.memory.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private IUserService userService;
	@Resource
	private ILoginUserService loginUserService;
	
	@RequestMapping("/regist")
	public ModelAndView regist(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("user/login.html");
		String strLoginId = request.getParameter("strLoginId");
		String strPassword = request.getParameter("strPassword");
		if(!StringUtils.hasText("strLoginId")){
			logger.info("strLoginId is null!");
			mav.addObject("error", "请输入用户名！");
			return mav;
		}
		if(!StringUtils.hasText("strPassword")){
			logger.info("strPassword is null!");
			mav.addObject("error", "请输入密码！");
			return mav;
		}

		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(loginIdIsExit){
			logger.debug("loginUser is exit!");
			mav.addObject("error","用户帐号已存在！");
			return mav;			
		}
		LoginUser loginUser=new LoginUser();
		loginUser.setStrLoginId(strLoginId);
		loginUser.setStrPassword(strPassword);
		loginUser.setnState(0);
		loginUserService.add("org.me.memory.entity.LoginUser.add", loginUser);
		logger.debug("LoginUser.add ok!");
		mav.setViewName("main.jsp");
		return mav;
	}
	
	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @throws IOException 
	 * @date:2015年5月26日 10:23:42
	 */
	@RequestMapping("/loginIdIsExit")
	public void loginIdIsExit(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/javascript;charset=UTF-8");
		String strLoginId=request.getParameter("strLoginId");
		Writer writer=null;
		try {
			writer= response.getWriter();
			if(!StringUtils.hasText(strLoginId))
			{
				logger.info("strLoginId is null!");
				writer.write("请输入用户帐号！");
				return;
			}
			boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
			if(loginIdIsExit){
				logger.debug("loginUser is exit!");
				writer.write("用户帐号已存在！");
				return;			
			}
			logger.debug("loginUser is not exit!");
			writer.write("ok");
		} catch (IOException e) {
			logger.error(e.getMessage());
			return;	
		}
	}
}
