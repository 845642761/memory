package org.me.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 菜单
 * @author: cheng_bo
 * @date: 2015年7月3日 12:00:13
 */
public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String strId;//主键(uuid)
	private String strPid;//父级id
	private String strName;//名称
	private int nLevel;//级别
	private String strURL;//url
	private int nStatus=0;//状态 : 0:开启  1:关闭
	private int nHasChild;//是否有子级: 0:无  1:有
	private Date dtCreateTime;//创建时间
	private Date dtUpdateTime;//修改时间
	
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrPid() {
		return strPid;
	}
	public void setStrPid(String strPid) {
		this.strPid = strPid;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public int getnLevel() {
		return nLevel;
	}
	public void setnLevel(int nLevel) {
		this.nLevel = nLevel;
	}
	public String getStrURL() {
		return strURL;
	}
	public void setStrURL(String strURL) {
		this.strURL = strURL;
	}
	public int getnStatus() {
		return nStatus;
	}
	public void setnStatus(int nStatus) {
		this.nStatus = nStatus;
	}
	public int getnHasChild() {
		return nHasChild;
	}
	public void setnHasChild(int nHasChild) {
		this.nHasChild = nHasChild;
	}
	public Date getDtCreateTime() {
		return dtCreateTime;
	}
	public void setDtCreateTime(Date dtCreateTime) {
		this.dtCreateTime = dtCreateTime;
	}
	public Date getDtUpdateTime() {
		return dtUpdateTime;
	}
	public void setDtUpdateTime(Date dtUpdateTime) {
		this.dtUpdateTime = dtUpdateTime;
	}
}
