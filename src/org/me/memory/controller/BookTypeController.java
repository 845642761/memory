package org.me.memory.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setAttribute("btList", btList);
		logger.debug("bookType getByRange successful!");
		return mav;
	}
}
