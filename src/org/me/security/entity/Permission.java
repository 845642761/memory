package org.me.security.entity;

import java.io.Serializable;

/**
 * 权限
 * @author: cheng_bo
 * @date: 2015年8月6日 10:23:37
 */
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String strId;//主键Id
	private String strName;//权限名称
	private String strPId;//父级主键
	private int nLevel;//级别
	private int nType;//类型 0-菜单,1-按钮
	private String strPermission;//权限标识
	private String strDescription;//权限描述
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
	public String getStrPId() {
		return strPId;
	}
	public void setStrPId(String strPId) {
		this.strPId = strPId;
	}
	public int getnLevel() {
		return nLevel;
	}
	public void setnLevel(int nLevel) {
		this.nLevel = nLevel;
	}
	public int getnType() {
		return nType;
	}
	public void setnType(int nType) {
		this.nType = nType;
	}
	public String getStrPermission() {
		return strPermission;
	}
	public void setStrPermission(String strPermission) {
		this.strPermission = strPermission;
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
