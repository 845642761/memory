package org.me.user.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.me.core.common.BaseController;
import org.me.core.common.Resoult;
import org.me.core.util.UserUtils;
import org.me.user.entity.LoginUser;
import org.me.user.entity.User;
import org.me.user.service.ILoginUserService;
import org.me.user.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户Controller
 * @author: cheng_bo
 * @date: 2015年7月28日 17:58:57
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;
	@Resource
	private ILoginUserService loginUserService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/login.jsp");
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
	@ResponseBody
	public Resoult saveLoginUser(LoginUser user){
		String strLoginId = user.getStrLoginId();
		String strPassword = user.getStrPassword();
		Resoult resoult=new Resoult();
		resoult.setName("UserController.saveLoginUser");
		resoult.setCode(-1);
		if(StringUtils.isEmpty(strLoginId)){
			resoult.setInfo("请输入用户名！");
			return resoult;
		}
		if(StringUtils.isEmpty(strPassword)){
			resoult.setInfo("请输入密码！");
			return resoult;
		}
		
		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(loginIdIsExit){
			resoult.setInfo("用户帐号已存在！");
			return resoult;
		}

		user.setnState(0);
		resoult=loginUserService.save(user);
		return resoult;
	}
	
	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @throws IOException 
	 * @date:2015年5月26日 10:23:42
	 */
	@RequestMapping("/loginIdIsExit")
	@ResponseBody
	public Resoult loginIdIsExit(LoginUser user){
		String strLoginId=user.getStrLoginId();
		Resoult resoult=new Resoult();
		resoult.setName("UserController.loginIdIsExit");
		resoult.setCode(-1);
		
		if(!StringUtils.hasText(strLoginId))
		{
			resoult.setInfo("请输入用户帐号！");
			return resoult;
		}
		
		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(loginIdIsExit){
			resoult.setInfo("用户帐号已存在！");
			return resoult;
		}
		resoult.setCode(0);
		resoult.setInfo("帐号可以使用！");
		return resoult;
	}
	
	/**
	 * 用户登录
	 * @author cheng_bo
	 * @date 2015年6月5日 17:00:42
	 */
	@RequestMapping("/ssoLogin")
	@ResponseBody
	public Resoult ssoLogin(LoginUser lUser,HttpServletRequest request){
		String strLoginId = lUser.getStrLoginId();
		String strPassword = lUser.getStrPassword();
		Resoult resoult=new Resoult();
		resoult.setName("UserController.ssoLogin");
		resoult.setCode(-1);
		
		if(StringUtils.isEmpty(strLoginId)){
			resoult.setInfo("请输入用户名！");
			return resoult;
		}
		
		if(StringUtils.isEmpty(strPassword)){
			resoult.setInfo("请输入密码！");
			return resoult;
		}
		
		boolean loginIdIsExit=this.loginUserService.loginIdIsExit(strLoginId);
		if(!loginIdIsExit){
			resoult.setInfo("用户帐号不存在！");
			return resoult;
		}
		
		LoginUser loginUser=loginUserService.ssoLogin(lUser);
		if(loginUser==null){
			resoult.setInfo("密码错误！");
			return resoult;
		}

		HttpSession session=request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		User user=userService.get(strLoginId);
		if(user!=null){
			session.setAttribute("user", user);
			resoult.setCode(0);
		}else{
			session.setAttribute("isExitUserInfo", false);
			resoult.setCode(1);
		}
		return resoult;
	}
	
	/**
	 * 添加或修改用户信息
	 * @author cheng_bo
	 * @date 2015年6月8日 15:11:19
	 */
	@RequestMapping("/editUserInfo")
	public ModelAndView editUserInfo(User user) {
		ModelAndView mav=new ModelAndView("/user/editUserInfo.jsp");
		if(StringUtils.hasText(user.getStrLoginId())){
			User u=userService.get(user.getStrLoginId());
			if(u==null){
				mav.addObject("error", "暂无用户信息！");
				return mav;
			}
			mav.addObject("user",u);
			return mav;
		}
		return mav;
	}
	
	/**
	 * 保存用户信息
	 * @author cheng_bo
	 * @date 2015年6月8日 15:49:41
	 */
	@RequestMapping("/saveUserInfo")
	public ModelAndView saveUserInfo(HttpServletRequest request,User user) {
		HttpSession session=request.getSession(false);
		ModelAndView mav=new ModelAndView();
		String strLoginId=user.getStrLoginId();
		Resoult resoult=null;
		if(StringUtils.hasText(strLoginId)){
			resoult=userService.saveUpdate(user);
			mav.setViewName("/user/editUserInfo.do?strLoginId="+user.getStrLoginId());
		}else {
			LoginUser sessionUser=new UserUtils().getLoginUser(request);
			if(userService.get(sessionUser.getStrLoginId()) != null){
				user.setStrLoginId(sessionUser.getStrLoginId());
				resoult=userService.saveUpdate(user);
				mav.setViewName("/user/editUserInfo.do?strLoginId="+sessionUser.getStrLoginId());
			}else {
				user.setStrLoginId(sessionUser.getStrLoginId());
				resoult=userService.save(user);
				mav.setViewName("redirect:/system/main.do");
			}
		}
		
		if(resoult.getCode()!=0){
			mav.addObject("error", resoult.getInfo());
			return mav;
		}
		session.removeAttribute("isExitUserInfo");
		session.setAttribute("user", user);
		return mav;
	}
	
	/**
	 * 修改自己信息
	 * @author: cheng_bo
	 * @date: 2015年7月28日 17:04:07
	 */
	@RequestMapping("/updateMyInfo")
	public ModelAndView updateMyInfo(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/user/editUserInfo.jsp");
		User user=new UserUtils().getUser(request);
		if(user==null){
			mav.addObject("error", "请登录后修改！");
			mav.setViewName("/user/login.do");
			return mav;
		}
		User u=userService.get(user.getStrLoginId());
		if(u==null){
			mav.addObject("error", "暂无用户信息！");
			return mav;
		}
		mav.addObject("userInfo", u);
		return mav;
	}
}
