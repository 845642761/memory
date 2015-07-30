package org.me.note.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.me.core.common.Resoult;
import org.me.core.util.UserUtils;
import org.me.core.util.Uuid;
import org.me.note.entity.Note;
import org.me.note.service.INoteService;
import org.me.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * NoteController
 * @author: cheng_bo
 * @date: 2015年6月29日 10:11:25
 */
@Controller
@RequestMapping("/note")
public class NoteController {
	
	@Resource
	private INoteService noteService;
	
	/**
	 * 查询列表
	 * @author: cheng_bo
	 * @date: 2015年6月29日 17:32:50
	 */
	@RequestMapping("list")
	public ModelAndView list(Note note) {
		ModelAndView mav=new ModelAndView("forward:/note/list.jsp");
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		if(StringUtils.hasText(note.getStrId())){
			hm.put("strId", note.getStrId());
		}
		if(StringUtils.hasText(note.getStrTitle())){
			hm.put("strTitle", note.getStrTitle());
		}
		if(StringUtils.hasText(note.getStrLoginId())){
			hm.put("strLoginId", note.getStrLoginId());
		}
		if(StringUtils.hasText(note.getStrLoginName())){
			hm.put("strLoginName", note.getStrLoginName());
		}
		if(note.getnState()!=-1){
			hm.put("nState", note.getnState());
		}
		Resoult resoult=noteService.getByRange(hm);
		resoult.setObject(note);
		mav.addObject("resoult", resoult);
		return mav;
	}
	
	/**
	 * 跳转添加页面
	 * @author: cheng_bo
	 * @date: 2015年6月29日 09:46:15
	 */
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mav=new ModelAndView("forward:/note/add.jsp");
		return mav;
	}
	
	/**
	 * 保存Note
	 * @author: cheng_bo 
	 * @date: 2015年6月29日 10:08:59
	 */
	@RequestMapping("/save")
	public ModelAndView save(Note note,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView("forward:/note/add.do");
		note.setStrId(new Uuid().getUUID());
		User user=new UserUtils().getUser(request);
		note.setStrLoginName(user.getStrName());
		Resoult resoult=noteService.save(note);
		if(resoult.getCode()!=1){
			mav.addObject("error", resoult.getInfo());
		}
		return mav;
	}
}
