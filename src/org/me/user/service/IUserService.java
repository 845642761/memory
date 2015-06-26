package org.me.user.service;

import java.util.HashMap;

import org.me.user.entity.User;

/*
 * userService接口
 * @author:cheng_bo
 * @date:2015年5月21日 19:48:12 
 */
public interface IUserService {
	public void save(User user);	//添加
	public boolean userInfoIsExit(String strLoginId);	//用户帐号信息是否已存在
	public void saveUpdate(User u);	//更新
	public User get(HashMap<Object, Object> hm);	//查询对象
}
