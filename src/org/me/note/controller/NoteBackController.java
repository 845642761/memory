package org.me.note.controller;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.note.entity.NoteBack;
import org.me.note.service.INoteBackService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * NoteBackController
 * @author: cheng_bo
 * @date: 2015年6月29日 17:31:37
 */
@Controller
@RequestMapping("/noteBack")
public class NoteBackController {
	private Logger logger=Logger.getLogger(NoteBackController.class);
	@Resource
	private INoteBackService noteBackService;
	
	/**
	 * 查询
	 * @param note
	 * @return
	 */
	@RequestMapping("list")
	public ModelAndView list(NoteBack nb) {
		ModelAndView mav=new ModelAndView("forward:/noteBack/list.jsp");
		Resoult resoult=new Resoult();
		resoult.setName("NoteBackController.list");
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		if(StringUtils.hasText(nb.getStrId())){
			hm.put("strId", nb.getStrId());
		}else {
			logger.info("请选择留言查看！");
			resoult.setCode(-1);
			resoult.setInfo("请选择留言查看！");
			mav.addObject("resoult", resoult);
			return mav;
		}
		resoult=noteBackService.getByRange(hm);
		resoult.setObject(nb);
		mav.addObject("resoult", resoult);
		return mav;
	}
	
	/**
	 * 保存NoteBack
	 * @author: cheng_bo 
	 * @date: 2015年6月29日 17:45:43
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Resoult save(NoteBack nb,HttpServletRequest request) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteBackController.save");
		if(nb==null || !StringUtils.hasText(nb.getStrId())){
			logger.info("请选择留言回复！");
			resoult.setCode(-1);
			resoult.setInfo("请选择留言回复！");
			return resoult;
		}
		resoult=noteBackService.save(nb);
		return resoult;
	}
}
