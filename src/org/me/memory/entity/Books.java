package org.me.memory.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 账单
 * @author cheng_bo
 * @date 2015年6月13日 16:05:37
 */
public class Books implements Serializable{

	private static final long serialVersionUID = 1L;
	private int nId;
	private String strLoginId;
	private int nTypeId;
	private float fMoney;
	private String strNote;
	private String strAddress;
	private Date dtTime;

	public Books() {
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getStrLoginId() {
		return strLoginId;
	}

	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}

	public int getnTypeId() {
		return nTypeId;
	}

	public void setnTypeId(int nTypeId) {
		this.nTypeId = nTypeId;
	}

	public float getfMoney() {
		return fMoney;
	}

	public void setfMoney(float fMoney) {
		this.fMoney = fMoney;
	}

	public String getStrNote() {
		return strNote;
	}

	public void setStrNote(String strNote) {
		this.strNote = strNote;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	public Date getDtTime() {
		return dtTime;
	}

	public void setDtTime(Date dtTime) {
		this.dtTime = dtTime;
	}
}
