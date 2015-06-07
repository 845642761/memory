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
	public void add(String id, User user) {
		mybatisDao.add(id, user);
	}

	/**
	 * 是否完善信息
	 * @author cheng_bo
	 * @date 2015年6月5日 21:34:38
	 */
	@Override
	public boolean userIsExit(String strLoginId) {
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("strLoginId", strLoginId);
		int size=mybatisDao.selectSize("org.me.memory.entity.User.selectSize", hm);
		if(size<=0)
			return false;
		else
			return true;
	}

}
