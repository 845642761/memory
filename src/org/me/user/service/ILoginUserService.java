package org.me.user.service;

import org.me.core.common.Resoult;
import org.me.user.entity.LoginUser;

/**
 * LoginUserService
 * @author cheng_bo
 * @date:2015年5月24日 21:43:17
 */
public interface ILoginUserService {
	public Resoult save(LoginUser user);//添加
	public boolean loginIdIsExit(String strLoginId);//用户帐号是否已存在
	public LoginUser ssoLogin(LoginUser user);//用户登录
}
