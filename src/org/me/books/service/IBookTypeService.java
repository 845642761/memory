package org.me.books.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.me.books.entity.BookType;

public interface IBookTypeService {
	public void save(BookType bt);	//添加
	public BookType get(HashMap<Object, Object> hm);	//查询结果集
	public void saveUpdate(BookType bt);	//更新
	public ArrayList<BookType> getByRange(HashMap<Object, Object> hm);	//查询结果集
}
