package org.me.note.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言簿回复
 * @author cheng_bo
 * @date 2015年6月25日 16:13:19
 */
public class NoteBack implements Serializable{

	private static final long serialVersionUID = 1L;

	private int nId;			//id
	private String strId;		//noteId
	private String tNote;		//内容
	private Date dtTime;		//回复时间
	private int nState;			//状态,0-待审核,1-正常,2-禁用
	
	public NoteBack() {
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
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

	public Date getDtTime() {
		return dtTime;
	}

	public void setDtTime(Date dtTime) {
		this.dtTime = dtTime;
	}
	
}
