package org.me.system.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.system.entity.Menu;
import org.me.system.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description: MenuController
 * @author: cheng_bo
 * @date: 2015年7月3日 14:45:19
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController {
	private Logger logger=Logger.getLogger(MenuController.class);
	
	@Resource
	private IMenuService menuService;
	
	/**
	 * @description: 查询
	 * @author: cheng_bo
	 * @date: 2015年7月7日 11:56:47
	 */
	@RequestMapping("/list")
	public void list() {
		
	}
	
	/**
	 * @author: cheng_bo
	 * @date: 2015年7月3日 18:14:21
	 */
	@RequestMapping("/add")
	public ModelAndView add(Menu m) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuController.add");
		ModelAndView mav=new ModelAndView("/system/menu/edit.jsp");
		if(StringUtils.hasText(m.getStrId())){
			m.setStrPid(m.getStrId());
			m.setStrId("");
		}
		mav.addObject("Menu", m);
		return mav;
	}

	/**
	 * @author: cheng_bo
	 * @date: 2015年7月3日 18:15:16
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(Menu m) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuController.edit");
		ModelAndView mav=new ModelAndView("/system/menu/list.do");
		if(!StringUtils.hasText(m.getStrId())){
			logger.error("Menu id is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息修改!");
			mav.addObject("resoult", resoult);
			return mav;
		}
		resoult=menuService.get(m.getStrId());
		if(resoult.getCode()>0){
			m=(Menu) resoult.getObject();
		}else {
			logger.error(resoult.getInfo());
			mav.addObject("resoult", resoult);
			return mav;
		}
		mav.addObject("Menu", m);
		mav.setViewName("/system/menu/edit.jsp");
		return mav;
	}
	/**
	 * @description: 保存
	 * @author: cheng_bo
	 * @date: 2015年7月3日 15:30:46
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Resoult save(Menu m) {
		Resoult resoult=new Resoult();
		if(m == null){
			logger.info("Menu is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息保存！");
			return resoult;
		}
		if(StringUtils.hasText(m.getStrId())){
			resoult=menuService.update(m);
		}else {
			resoult=menuService.save(m);
		}
		return resoult;
	}
}
