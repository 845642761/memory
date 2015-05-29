package org.me.memory.service;

import org.me.memory.entity.User;

/*
 * userService接口
 * @author:cheng_bo
 * @date:2015年5月21日 19:48:12 
 */
public interface IUserService {
	public void add(String id,User u);	//添加
	public void delet(String id,User u);	//删除
}
