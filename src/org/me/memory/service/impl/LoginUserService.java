package org.me.memory.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import org.me.core.dao.IMybatisDao;
import org.me.memory.entity.LoginUser;
import org.me.memory.service.ILoginUserService;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements ILoginUserService{

	@Resource
	private IMybatisDao<LoginUser> mybatisDao;
	
	@Override
	public void add(String id, LoginUser lu) {
		mybatisDao.add(id, lu);
	}

	/**
	 * 用户帐号是否已存在
	 * @author cheng_bo
	 * @date 2015年5月26日 11:03:05
	 * @param 用户帐号
	 * @return 存在：true	不存在：false
	 */
	@Override
	public boolean loginIdIsExit(String strLoginId) {
		HashMap<Object, Object> hm=new HashMap<Object, Object>();
		hm.put("strLoginId", strLoginId);
		int size=mybatisDao.selectSize("org.me.memory.entity.LoginUser.selectSize", hm);
		if(size<=0)
			return false;
		else
			return true;
	}
	
	/**
	 * 根据密码和帐号查询
	 * @author cheng_bo
	 * @date 2015年6月5日 16:55:38
	 */
	@Override
	public LoginUser ssoLogin(String id, HashMap<Object, Object> hm) {
		return mybatisDao.select(id, hm);
	}

}
