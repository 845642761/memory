package org.me.books.controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.me.books.entity.BookType;
import org.me.books.entity.Books;
import org.me.books.service.IBookTypeService;
import org.me.books.service.IBooksService;
import org.me.core.common.BaseController;
import org.me.core.util.UserUtils;
import org.me.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BooksController extends BaseController{
	private Logger logger = Logger.getLogger(BooksController.class);
	
	@Resource
	private IBooksService bookService;
	@Resource
	private IBookTypeService bookTypeService;
	
	@RequestMapping("/addBook")
	public ModelAndView addBook() {
		ModelAndView mav=new ModelAndView("forward:/books/add.jsp");
		ArrayList<BookType> btList=bookTypeService.getByRange(null);
		if(btList==null){
			logger.info("BookType is null!");
			mav.addObject("error", "请先添加账单类型！");
			mav.setViewName("forward:/bookType/addBookType.do");
			return mav;
		}
		mav.addObject("BookTypes", btList);
		return mav;
	}
	
	/**
	 * 保存
	 * @author cheng_bo
	 * @date 2015年6月14日 23:31:03
	 */
	@RequestMapping("/save")
	public ModelAndView save(Books bs,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("/books/addBook.do");
		User user=new UserUtils().getUser(request);
		if(user==null){
			logger.debug("no user login!");
			mav.addObject("error", "请登录后修改！");
			return mav;
		}
		bs.setStrLoginId(user.getStrLoginId());
		bookService.save(bs);
		logger.debug("Book save successful!");
		return mav;
	}
	
	/**
	 * 获取账单列表
	 * @author cheng_bo
	 * @date 2015年6月15日 00:23:22
	 */
	@RequestMapping("/getByRange")
	public ModelAndView getByRange(HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("forward:/books/list.jsp");
		User u=new UserUtils().getUser(request);
		String strLoginId=u.getStrLoginId();
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		if(StringUtils.hasText(strLoginId)){
			hm.put("strLoginId", strLoginId);
		}
		ArrayList<Books> bsList=bookService.getByRange(hm);
		mav.addObject("bsList",bsList);
		logger.debug("books getByRange successful!");
		return mav;
	}
}
