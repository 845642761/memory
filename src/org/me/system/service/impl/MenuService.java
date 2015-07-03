package org.me.system.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.core.util.Uuid;
import org.me.system.dao.IMenuDao;
import org.me.system.entity.Menu;
import org.me.system.service.IMenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description: MenuService
 * @author: cheng_bo
 * @date: 2015年7月3日 13:59:46
 */
@Service
public class MenuService implements IMenuService{
	private Logger logger = Logger.getLogger(MenuService.class);
	@Resource
	private IMenuDao menuDao;
	
	@Override
	public Resoult save(Menu t) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuService.save");
		if(t==null){
			logger.error("Menu is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息保存！");
			return resoult;
		}
		try {
			/**
			 * 如果是父级添加子级
			 */
			if(StringUtils.hasLength(t.getStrPid())){
				Menu parent=menuDao.get(t.getStrPid());
				if(parent.getnHasChild()==0){
					parent.setnHasChild(1);
				}
				menuDao.update(parent);
				t.setnLevel(parent.getnLevel()+1);
			}else {
				t.setnLevel(0);
				t.setStrPid("0");
				t.setnHasChild(0);
			}
			t.setStrId(new Uuid().getUUID());
			menuDao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuService.save error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult get(String id) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuService.get");
		if(!StringUtils.hasText(id)){
			logger.error("id is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息查看！");
			return resoult;
		}
		try {
			resoult.setObject(menuDao.get(id));
		} catch (Exception e) {
			logger.error("MenuService.get error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult del(String id) {
		return null;
	}

	@Override
	public Resoult update(Menu t) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuService.update");
		if(t==null){
			logger.error("Menu is null!");
			resoult.setCode(-1);
			resoult.setInfo("请选择信息修改！");
			return resoult;
		}
		try {
			menuDao.update(t);
		} catch (Exception e) {
			logger.error("MenuService.update error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}

	@Override
	public Resoult list(Menu t) {
		Resoult resoult=new Resoult();
		resoult.setName("MenuService.list");
		try {
			resoult.setList(menuDao.list(t));
		} catch (Exception e) {
			logger.error("MenuService.list error:"+e.getMessage()+"==>cause:"+e.getCause());
			resoult.setCode(-1);
			resoult.setInfo(e.getMessage());
		}
		return resoult;
	}
}
