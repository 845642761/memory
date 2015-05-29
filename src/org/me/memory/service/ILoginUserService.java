package org.me.memory.service;

import org.me.memory.entity.LoginUser;

/**
 * LoginUserService
 * @author cheng_bo
 * @date:2015年5月24日 21:43:17
 */
public interface ILoginUserService {
	public void add(String id,LoginUser lu);	//添加
	public boolean loginIdIsExit(String strLoginId);		//用户帐号是否已存在
}
