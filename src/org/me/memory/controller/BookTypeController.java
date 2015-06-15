package org.me.memory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.me.memory.entity.BookType;
import org.me.memory.entity.User;
import org.me.memory.service.IBookTypeService;
import org.me.memory.util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bookType")
public class BookTypeController {
	private Logger logger = Logger.getLogger(BookTypeController.class);
	
	@Resource
	private IBookTypeService bookTypeService;
	
	@RequestMapping("addBookType")
	public ModelAndView addBookType() {
		return new ModelAndView("forward:/bookType/add.jsp");
	}
	
	/**
	 * 保存
	 * @author cheng_bo
	 * @date 2015年6月13日 16:27:27
	 */
	@RequestMapping("/save")
	public ModelAndView save(BookType bt,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/bookType/addBookType.do");
		User user=new UserUtils().getLoginUser(request);
		if(user==null){
			logger.debug("no user login!");
			mav.addObject("error", "请登录后修改！");
			return mav;
		}
		bt.setStrLoginId(user.getStrLoginId());
		bookTypeService.save("org.me.memory.entity.BookType.save", bt);
		logger.debug("BookType save successful!");
		return mav;
	}
	
	@RequestMapping("/getByRange")
	public ModelAndView getByRange(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("forward:/bookType/list.jsp");
		User u=new UserUtils().getLoginUser(request);
		String strLoginId=u.getStrLoginId();
		String strName=request.getParameter("strName");
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		if(StringUtils.hasText(strLoginId)){
			hm.put("strLoginId", strLoginId);
		}
		if(StringUtils.hasText(strName))
			hm.put("strName", strName);
		ArrayList<BookType> btList=bookTypeService.getByRange("org.me.memory.entity.BookType.getByRange", hm);
		mav.addObject("btList",btList);
		logger.debug("bookType getByRange successful!");
		return mav;
	}
	
	/**
	 * 修改用户信息页面跳转
	 * @author cheng_bo
	 * @date 2015年6月14日 23:09:16
	 */
	@RequestMapping("/updateInfo")
	public ModelAndView updateInfo(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("forward:/bookType/getByRange.do");
		String nId=request.getParameter("nId");
		if(!StringUtils.hasText(nId)){
			logger.info("BookType strLoginId is null!");
			mav.addObject("error", "请选择账单类型修改！");
			return mav;
		}
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("nId", nId);
		BookType bk=bookTypeService.get("org.me.memory.entity.BookType.get", hm);
		if(bk==null){
			logger.info("BookType not exit!");
			mav.addObject("error", "账单类型不存在！");
			return mav;
		}
		mav.addObject("BookType", bk);
		mav.setViewName("forward:/bookType/updateInfo.jsp");
		logger.debug("BookType get successful!");
		return mav;
	}
	
	/**
	 * 保存修改信息
	 * @author cheng_bo
	 * @date 2015年6月14日 22:57:29
	 */
	@RequestMapping("/saveUpdate")
	public ModelAndView saveUpdate(BookType bt) {
		ModelAndView mav=new ModelAndView("forward:/bookType/getByRange.do");
		if(bt==null){
			logger.info("BookType is null");
			mav.addObject("error","请选择账单类型修改！");
			return mav;
		}
		bookTypeService.saveUpdate("org.me.memory.entity.BookType.update", bt);
		mav.setViewName("forward:/bookType/updateInfo.do?nId="+bt.getnId());
		logger.debug("BookType saveUpdate successful!");
		return mav;
	}
}
