package org.me.user.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import org.me.user.dao.IUserDao;
import org.me.user.entity.User;
import org.me.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	@Resource
	private IUserDao userDao;
	
	@Override
	public void save(User user) {
		userDao.save(user);
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
		int size=userDao.selectSize(hm);
		if(size<=0)
			return false;
		else
			return true;
	}

	@Override
	public void saveUpdate(User u) {
		userDao.saveUpdate(u);
	}

	@Override
	public User get(HashMap<Object, Object> hm) {
		return userDao.get(hm);
	}

}
