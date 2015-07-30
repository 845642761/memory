package org.me.user.service;

import org.me.core.common.Resoult;
import org.me.user.entity.User;

/*
 * userService接口
 * @author:cheng_bo
 * @date:2015年5月21日 19:48:12 
 */
public interface IUserService {
	public Resoult save(User user);//添加
	public Resoult saveUpdate(User u);//更新
	public User get(String strLoginId);//查询对象
}
