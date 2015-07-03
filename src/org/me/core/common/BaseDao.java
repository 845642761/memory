package org.me.core.common;

import java.util.ArrayList;

/**
 * @description: 基类
 * @author: cheng_bo
 * @date: 2015年7月3日 12:21:22
 */
public interface BaseDao<T> {
	public int save(T t);//保存
	public int del(String id);//删除
	public T get(String id);//get
	public int update(T t);//修改
	public ArrayList<T> list(T t);//查询
	public int listSize(T t);//查询列表大小(分页)
}
