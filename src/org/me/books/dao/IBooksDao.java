package org.me.books.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.books.entity.Books;

public interface IBooksDao {
	
	public int save(Books book);
	
	public int saveUpdate(Books book);
	
	public Books get(HashMap<Object, Object> hm);
	
	public ArrayList<Books> getByRange(HashMap<Object, Object> hm);
	
}
