package org.me.note.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.note.entity.Note;

/**
 * 留言簿Dao接口
 * @author cheng_bo
 * @date 2015年6月25日 16:14:04
 */
public interface INoteDao {
	public int save(Note note);		//保存
	public Note get(HashMap<Object, Object> hm);		//获取
	public ArrayList<Note> getByRange(HashMap<Object, Object> hm);		//条件查询
}
