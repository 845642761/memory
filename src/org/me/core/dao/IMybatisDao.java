package org.me.core.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * IbatisDao
 * @author cheng_bo
 * @param <T>
 * @date:2015年5月21日 17:17:36
 */
public interface IMybatisDao<T> {
	public void save(String id,T t);	//添加
	public void delete(String id,T t);	//删除
	public int selectSize(String id,HashMap<Object, Object> hm);	//查询结果集大小
	public ArrayList<T> getByRange(String id,HashMap<Object, Object> hm);	//查询结果集大小
	public T get(String id,HashMap<Object, Object> hm);	//查询对象
	public void saveUpdate(String id,T t);	//更新
}
