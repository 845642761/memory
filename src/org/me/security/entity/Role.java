package org.me.security.entity;

import java.io.Serializable;

/**
 * 角色
 * @author: cheng_bo
 * @date: 2015年8月6日 10:21:44
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String strId;//主键id
	private String strName;//角色名称
	private String strDescription;//角色描述
	private int nState;//状态:0-正常,1-禁用
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}
	public int getnState() {
		return nState;
	}
	public void setnState(int nState) {
		this.nState = nState;
	}
}
