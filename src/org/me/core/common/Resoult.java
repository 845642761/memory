package org.me.core.common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @description 结果类
 * @author cheng_bo
 * @param <T>
 * @date 2015年6月24日 14:40:35
 */
public class Resoult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int code=0;	//状态   0:正常  -1:error
	private String name;	//名称
	private ArrayList<?> list;	//结果集
	private Object object;
	private int size=0;	//大小
	private String info;	//说明信息
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<?> getList() {
		return list;
	}
	public void setList(ArrayList<?> list) {
		this.list = list;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
