package org.me.note.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.note.dao.INoteDao;
import org.me.note.entity.Note;
import org.me.note.service.INoteService;
import org.springframework.stereotype.Service;

/**
 * NoteService
 * @author: cheng_bo
 * @date: 2015年6月29日 08:59:03
 */
@Service
public class NoteService implements INoteService {

	private Logger logger = Logger.getLogger(NoteService.class);
	
	@Resource
	private INoteDao noteDao;
	
	@Override
	public Resoult save(Note note) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteService.save");
		try {
			noteDao.save(note);
		} catch (Exception e) {
			logger.error("NoteService.save error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo("保存失败！");
			e.printStackTrace();
		}
		return resoult;
	}

	@Override
	public Resoult get(HashMap<Object, Object> hm) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteService.get");
		try {
			Note note=noteDao.get(hm);
			resoult.setObject(note);
		} catch (Exception e) {
			logger.error("NoteService.get error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult getByRange(HashMap<Object, Object> hm) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteService.getByRange");
		try {
			ArrayList<Note> noteList=noteDao.getByRange(hm);
			resoult.setList(noteList);
		} catch (Exception e) {
			logger.error("NoteService.getByRange error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

}
