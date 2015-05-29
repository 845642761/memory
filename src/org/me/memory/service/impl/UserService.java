package org.me.memory.service.impl;

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
	public void add(String id,User u) {
		mybatisDao.add(id,u);
	}

	@Override
	public void delet(String id,User u) {
		
	}

}
