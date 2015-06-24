package org.me.memory.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.me.core.util.DateUtils;
import org.me.memory.entity.LoginUser;
import org.me.memory.entity.User;
import org.me.memory.service.ILoginUserService;
import org.me.memory.service.IUserService;
import org.me.memory.util.UserUtils;
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
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/login.html");
	}
	
	@RequestMapping("/regist")
	public ModelAndView regist(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/regist.jsp");
	}
	
	/**
	 * 注册登录用户
	 * @author cheng_bo
	 * @date 2015年6月5日 21:38:30
	 */
	@RequestMapping("/save")
	public void saveLoginUser(HttpServletRequest request,HttpServletResponse response){
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
			loginUserService.save("org.me.memory.entity.LoginUser.save", loginUser);
			logger.debug("LoginUser.save ok!");
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
				logger.info("loginUser is not exit!");
				writer.write("用户帐号不存在！");
				return;			
			}
			HashMap<Object, Object> hm=new HashMap<Object, Object>();
			hm.put("strLoginId", strLoginId);
			hm.put("strPassword", strPassword);
			LoginUser loginUser=loginUserService.ssoLogin("org.me.memory.entity.LoginUser.ssoLogin", hm);
			if(loginUser==null){
				logger.info("密码错误！");
				writer.write("密码错误！");
				return;
			}

			HttpSession session=request.getSession();
			session.setAttribute("user", loginUser);
			
			HashMap<Object, Object> hmo=new HashMap<Object, Object>();
			hmo.put("strLoginId", strLoginId);
			User user=userService.get("org.me.memory.entity.User.get", hmo);
			if(user!=null)
				session.setAttribute("user", user);
			
			if(!userService.userInfoIsExit(strLoginId)){
				logger.debug("no user info!");
				writer.write("addInfo");
				session.setAttribute("isExitUserInfo", false);
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
	
	/**
	 * 添加用户信息
	 * @author cheng_bo
	 * @date 2015年6月8日 15:11:19
	 */
	@RequestMapping("/addUserInfo")
	public String addUserInfo() {
		return "user/addUserInfo.jsp";
	}
	
	/**
	 * 保存用户信息
	 * @author cheng_bo
	 * @date 2015年6月8日 15:49:41
	 */
	@RequestMapping("/saveUserInfo")
	public ModelAndView saveUserInfo(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		ModelAndView mav=new ModelAndView("/user/addUserInfo.do");
		String strLoginId=request.getParameter("strLoginId");
		if(StringUtils.isEmpty(strLoginId)){
			mav.addObject("error", "strLoginId is null!");
			logger.debug("strLoginId is null!");
			return mav;
		}
		if(userService.userInfoIsExit(strLoginId)){
			logger.debug("user info exit!");
			mav.addObject("error", "user info exit!");
			return mav;
		}
		User user=new User();
		user.setStrLoginId(strLoginId);
		user.setDtBirthday(new DateUtils().forMatDate(request.getParameter("dtBirthday")));
		user.setStrName(request.getParameter("strName"));
		user.setnSex(Integer.parseInt(request.getParameter("nSex")));
		user.setStrMobile(request.getParameter("strMobile"));
		user.setStrPhone(request.getParameter("strPhone"));
		user.setStrEmail(request.getParameter("strEmail"));
		user.setStrQQ(request.getParameter("strQQ"));
		user.setStrWeChar(request.getParameter("strWeChar"));
		user.setStrProvinceCode(request.getParameter("strProvinceCode"));
		user.setStrProvinceName(request.getParameter("strProvinceName"));
		user.setStrCityCode(request.getParameter("strCityCode"));
		user.setStrCityName(request.getParameter("strCityName"));
		user.setStrHeadURL(request.getParameter("strHeadURL"));
		user.setStrAddress(request.getParameter("strAddress"));
		userService.save("org.me.memory.entity.User.save", user);
		mav.setViewName("/system/main.do");
		session.removeAttribute("isExitUserInfo");
		session.setAttribute("user", user);
		logger.debug("saveUserInfo successful!");
		return mav;
	}
	
	@RequestMapping("/updateUserInfo")
	public ModelAndView updateUserInfo(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/user/updateUserInfo.jsp");
		User loginUser=new UserUtils().getLoginUser(request);
		if(loginUser==null){
			logger.debug("no user login!");
			mav.addObject("error", "请登录后修改！");
			mav.setViewName("/user/login.do");
			return mav;
		}
		String strLoginId=loginUser.getStrLoginId();
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("strLoginId", strLoginId);
		User u=userService.get("org.me.memory.entity.User.get", hm);
		if(u==null){
			logger.debug("no userInfo!");
			mav.addObject("error", "暂无用户信息！");
			mav.setViewName("user/addUserInfo.jsp");
			return mav;
		}
		mav.addObject("userInfo", u);
		return mav;
	}
	
	/**
	 * 保存修改后的用户信息
	 * @author cheng_bo
	 * @date 2015年6月10日 14:05:34
	 */
	@RequestMapping("/saveUpdateUserInfo")
	public ModelAndView saveUpdateUserInfo(User u,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("redirect:/user/updateUserInfo.do");
		User loginUser=new UserUtils().getLoginUser(request);
		if(loginUser==null){
			logger.debug("no user login!");
			mav.addObject("error", "请登录后修改！");
			mav.setViewName("/user/login.do");
			return mav;
		}
		u.setStrLoginId(loginUser.getStrLoginId());
		userService.saveUpdate("org.me.memory.entity.User.update", u);
		logger.debug("saveUpdateUserInfo successful!");
		return mav;
	}
}
