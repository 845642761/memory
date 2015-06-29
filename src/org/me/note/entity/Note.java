package org.me.note.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言簿
 * @author cheng_bo
 * @date cheng_bo
 */
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	private String strId;		//id(查询码)
	private String strTitle;	//标题
	private String strLoginId;	//发起人
	private String strLoginName;//发起人名称
	private String tNote;		//内容
	private Date dtTime;		//发起时间
	private int nState;			//状态,0-待审核,1-正常,2-禁用
	
	public Note() {
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getStrTitle() {
		return strTitle;
	}

	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}

	public String gettNote() {
		return tNote;
	}

	public void settNote(String tNote) {
		this.tNote = tNote;
	}

	public int getnState() {
		return nState;
	}

	public void setnState(int nState) {
		this.nState = nState;
	}

	public String getStrLoginId() {
		return strLoginId;
	}

	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}

	public String getStrLoginName() {
		return strLoginName;
	}

	public void setStrLoginName(String strLoginName) {
		this.strLoginName = strLoginName;
	}

	public Date getDtTime() {
		return dtTime;
	}

	public void setDtTime(Date dtTime) {
		this.dtTime = dtTime;
	}
	
}
