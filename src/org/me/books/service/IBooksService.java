package org.me.books.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.me.books.entity.Books;
/**
 * IBooksService
 * @author cheng_bo
 * @date 2015年6月14日 23:33:26
 */
public interface IBooksService {
	public void save(Books b);	//添加
	public Books get(HashMap<Object, Object> hm);	//查询结果集
	public void saveUpdate(Books b);	//更新
	public ArrayList<Books> getByRange(HashMap<Object, Object> hm);	//查询结果集
}
