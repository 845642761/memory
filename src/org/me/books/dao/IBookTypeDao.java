package org.me.books.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.books.entity.BookType;

public interface IBookTypeDao {
	
	public int save(BookType bt);
	
	public int saveUpdate(BookType bt);
	
	public BookType get(HashMap<Object, Object> hm);
	
	public ArrayList<BookType> getByRange(HashMap<Object, Object> hm);
	
}
