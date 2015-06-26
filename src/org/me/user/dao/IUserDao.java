package org.me.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.user.entity.User;

public interface IUserDao {

	public int save(User user);

	public int selectSize(HashMap<Object, Object> hm);

	public int saveUpdate(User user);
	
	public User get(HashMap<Object, Object> hm);
	
	public ArrayList<User> getByRange(HashMap<Object, Object> hm);
	
}
