package org.me.memory.service;

import org.me.memory.entity.User;

/*
 * userService接口
 * @author:cheng_bo
 * @date:2015年5月21日 19:48:12 
 */
public interface IUserService {
	public void add(String id,User user);	//添加
	public boolean userIsExit(String strLoginId);	//用户帐号是否已存在
}
