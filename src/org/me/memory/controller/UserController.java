package org.me.memory.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.me.memory.entity.LoginUser;
import org.me.memory.service.ILoginUserService;
import org.me.memory.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private IUserService userService;
	@Resource
	private ILoginUserService loginUserService;
	
	@RequestMapping("/login")
	public String login() {
		return "user/login.html";
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "user/regist.jsp";
	}
	
	/**
	 * 注册登录用户
	 * @author cheng_bo
	 * @date 2015年6月5日 21:38:30
	 */
	@RequestMapping("/add")
	public void regist(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/javascript;charset=UTF-8");
		String strLoginId = request.getParameter("strLoginId");
		String strPassword = request.getParameter("strPassword");
		Writer writer;
		try {
			writer = response.getWriter();
			if(StringUtils.isEmpty("strLoginId")){
				logger.info("strLoginId is null!");
				writer.write("请输入用户名！");
				return;
			}
			if(StringUtils.isEmpty("strPassword")){
				writer.write("请输入密码！");
				return;
			}

			boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
			if(loginIdIsExit){
				logger.debug("loginUser is exit!");
				writer.write("用户帐号已存在！");
				return;			
			}
			
			LoginUser loginUser=new LoginUser();
			loginUser.setStrLoginId(strLoginId);
			loginUser.setStrPassword(strPassword);
			loginUser.setnState(0);
			loginUserService.add("org.me.memory.entity.LoginUser.add", loginUser);
			logger.debug("LoginUser.add ok!");
			writer.write("ok");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return;
		}
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
	
	/**
	 * 用户登录
	 * @author cheng_bo
	 * @date 2015年6月5日 17:00:42
	 */
	@RequestMapping("/ssoLogin")
	public void ssoLogin(HttpServletRequest request,HttpServletResponse response){
		String strLoginId = request.getParameter("strLoginId");
		String strPassword = request.getParameter("strPassword");
		Writer writer;
		try {
			writer = response.getWriter();
			if(StringUtils.isEmpty("strLoginId")){
				logger.info("strLoginId is null!");
				writer.write("请输入用户名！");
				return;
			}
			if(StringUtils.isEmpty("strPassword")){
				writer.write("请输入密码！");
				return;
			}

			boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
			if(!loginIdIsExit){
				logger.debug("loginUser is not exit!");
				writer.write("用户帐号不存在！");
				return;			
			}
			HashMap<Object, Object> hm=new HashMap<Object, Object>();
			hm.put("strLoginId", strLoginId);
			hm.put("strPassword", strPassword);
			LoginUser user=loginUserService.ssoLogin("org.me.memory.entity.LoginUser.ssoLogin", hm);
			if(user==null){
				writer.write("密码错误！");
				return;
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("LoginUser", user);
			
			if(!userService.userIsExit(strLoginId)){
				logger.debug("no user info!");
				writer.write("addInfo");
				return;
			}
			
			logger.debug("LoginUser.login ok!");
			writer.write("ok");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return;
		}
	}
}
