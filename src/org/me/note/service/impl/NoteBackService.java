package org.me.note.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.note.dao.INoteBackDao;
import org.me.note.entity.NoteBack;
import org.me.note.service.INoteBackService;
import org.springframework.stereotype.Service;

/**
 * NoteBackService
 * @author: cheng_bo
 * @date: 2015年6月29日 08:59:03
 */
@Service
public class NoteBackService implements INoteBackService {

	private Logger logger = Logger.getLogger(NoteBackService.class);
	
	@Resource
	private INoteBackDao noteBackDao;
	
	@Override
	public Resoult save(NoteBack nb) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteBackService.save");
		if(nb==null){
			logger.info("NoteBack is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息保存！");
			return resoult;
		}
		try {
			noteBackDao.save(nb);
		} catch (Exception e) {
			logger.error("NoteBackService.save error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult get(HashMap<Object, Object> hm) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteBackService.get");
		if(hm!=null && hm.containsKey("strId")){
			logger.info("NoteBack.StrId is null!");
			resoult.setCode(-1);
			resoult.setInfo("选择信息查看！");
			return resoult;
		}
		try {
			NoteBack nb=noteBackDao.get(hm);
			resoult.setObject(nb);
		} catch (Exception e) {
			logger.error("NoteBackService.get error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult getByRange(HashMap<Object, Object> hm) {
		Resoult resoult=new Resoult();
		resoult.setName("NoteBackService.getByRange");
		try {
			ArrayList<NoteBack> nbList=noteBackDao.getByRange(hm);
			resoult.setList(nbList);
		} catch (Exception e) {
			logger.error("NoteBackService.getByRange error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

}
