package org.me.user.dao;

import java.util.HashMap;
import org.me.user.entity.LoginUser;

public interface ILoginUserDao {
	
	public int save(LoginUser loginUser);
	
	public int selectSize(HashMap<Object, Object> hm);
	
	public LoginUser get(HashMap<Object, Object> hm);
}
