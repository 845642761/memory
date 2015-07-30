package org.me.user.dao;

import org.me.user.entity.LoginUser;

public interface ILoginUserDao {
	
	public int save(LoginUser loginUser);
	
	public int selectSize(LoginUser user);
	
	public LoginUser get(LoginUser user);
}
