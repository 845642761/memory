package org.me.memory.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.memory.entity.BookType;

public interface IBookTypeService {
	public void save(String id,BookType bt);	//添加
	public BookType get(String id,HashMap<Object, Object> hm);	//查询结果集
	public void saveUpdate(String id,BookType bt);	//更新
	public ArrayList<BookType> getByRange(String id,HashMap<Object, Object> hm);	//查询结果集
}
