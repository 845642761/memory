package org.me.user.service.impl;

import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.me.core.common.Resoult;
import org.me.core.security.MD5;
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
			MD5 md5=new MD5();
			loginUser.setStrPassword(md5.toMd5(loginUser.getStrPassword()));
			loginUserDao.save(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
			resoult.setCode(-1);
			resoult.setInfo("保存失败！");
			logger.error("保存失败！");
			return resoult;
		}
		resoult.setInfo("保存成功！");
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
		LoginUser user=new LoginUser();
		user.setStrLoginId(strLoginId);
		int size=loginUserDao.selectSize(user);
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
	public LoginUser ssoLogin(LoginUser user) {
		MD5 md5=new MD5();
		user.setStrPassword(md5.toMd5(user.getStrPassword()));
		return loginUserDao.get(user);
	}

}