package org.me.user.service.impl;

import java.util.HashMap;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.user.dao.ILoginUserDao;
import org.me.user.entity.LoginUser;
import org.me.user.service.ILoginUserService;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService implements ILoginUserService{

	private Logger logger = Logger.getLogger(LoginUserService.class);
	@Resource
	private ILoginUserDao loginUserDao;
	
	@Override
	public Resoult save(LoginUser loginUser) {
		Resoult resoult=new Resoult();
		resoult.setName("LoginUserService.save");
		try {
			loginUserDao.save(loginUser);
			resoult.setInfo("LoginUserService.save successful!");
		} catch (Exception e) {
			resoult.setCode(1);
			resoult.setInfo(e.getMessage());
			logger.error("LoginUserService.save Error:"+e.getMessage()+"---->cause:"+e.getCause());
			return resoult;
		}
		logger.debug("LoginUserService.save successful!");
		return resoult;
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
		int size=loginUserDao.selectSize(hm);
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
	public LoginUser ssoLogin(HashMap<Object, Object> hm) {
		return loginUserDao.get(hm);
	}

}
