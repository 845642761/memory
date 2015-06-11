package org.me.memory.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.me.core.dao.IMybatisDao;
import org.me.memory.entity.User;
import org.me.memory.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	@Resource
	private IMybatisDao<User> mybatisDao;
	
	@Override
	public void save(String id, User user) {
		mybatisDao.save(id, user);
	}

	/**
	 * 是否完善信息
	 * @author cheng_bo
	 * @date 2015年6月5日 21:34:38
	 */
	@Override
	public boolean userInfoIsExit(String strLoginId) {
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("strLoginId", strLoginId);
		int size=mybatisDao.selectSize("org.me.memory.entity.User.selectSize", hm);
		if(size<=0)
			return false;
		else
			return true;
	}

	@Override
	public void saveUpdate(String id, User u) {
		mybatisDao.saveUpdate(id, u);
	}

	@Override
	public User get(String id, HashMap<Object, Object> hm) {
		return mybatisDao.get(id, hm);
	}

}
