package org.me.memory.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.memory.entity.Books;
/**
 * IBooksService
 * @author cheng_bo
 * @date 2015年6月14日 23:33:26
 */
public interface IBooksService {
	public void save(String id,Books b);	//添加
	public Books get(String id,HashMap<Object, Object> hm);	//查询结果集
	public void saveUpdate(String id,Books b);	//更新
	public ArrayList<Books> getByRange(String id,HashMap<Object, Object> hm);	//查询结果集
}
