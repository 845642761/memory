package org.me.user.dao;

import java.util.ArrayList;
import org.me.user.entity.User;

public interface IUserDao {

	public int save(User user);

	public int selectSize(User user);

	public int saveUpdate(User user);
	
	public User get(User user);
	
	public ArrayList<User> getByRange(User user);
	
}
