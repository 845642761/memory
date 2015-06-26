package org.me.books.entity;

import java.io.Serializable;

/**
 * 账本类型
 * @author cheng_bo
 * @date 2015年6月13日 16:01:49
 */
public class BookType implements Serializable{

	private static final long serialVersionUID = 1L;
	private int nId;
	private String strLoginId;
	private String strName;
	
	public BookType() {
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

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
}
