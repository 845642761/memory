package org.me.user.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.user.dao.IUserDao;
import org.me.user.entity.User;
import org.me.user.service.IUserService;
import org.springframework.stereotype.Service;
/**
 * 用户信息service
 * @author: cheng_bo
 * @date: 2015年7月28日 16:40:04
 */
@Service
public class UserService implements IUserService{
	private Logger logger = Logger.getLogger(UserService.class);
	
	@Resource
	private IUserDao userDao;
	
	/**
	 * 保存
	 * @author: cheng_bo
	 * @date: 2015年7月28日 16:39:31
	 */
	@Override
	public Resoult save(User user) {
		Resoult resoult=new Resoult();
		resoult.setCode(-1);
		resoult.setName("UserService.save");
		try {
			userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("保存失败！");
			resoult.setInfo("保存失败！");
			return resoult;
		}
		resoult.setCode(0);
		resoult.setInfo("保存成功！");
		return resoult;
	}

	@Override
	public Resoult saveUpdate(User u) {
		Resoult resoult=new Resoult();
		resoult.setCode(-1);
		resoult.setName("UserService.saveUpdate");
		try {
			userDao.saveUpdate(u);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改失败！");
			resoult.setInfo("修改失败！");
			return resoult;
		}
		resoult.setCode(0);
		resoult.setInfo("修改成功！");
		return resoult;
	}

	@Override
	public User get(String strLoginId) {
		User u=new User();
		u.setStrLoginId(strLoginId);
		return userDao.get(u);
	}

}
