package org.me.memory.service;

import java.util.HashMap;

import org.me.memory.entity.User;

/*
 * userService接口
 * @author:cheng_bo
 * @date:2015年5月21日 19:48:12 
 */
public interface IUserService {
	public void save(String id,User user);	//添加
	public boolean userInfoIsExit(String strLoginId);	//用户帐号信息是否已存在
	public void saveUpdate(String id,User u);	//更新
	public User get(String id,HashMap<Object, Object> hm);	//查询对象
}
