package org.me.note.dao;

import java.util.ArrayList;
import java.util.HashMap;
import org.me.note.entity.NoteBack;

/**
 * 留言簿回复Dao接口
 * @author cheng_bo
 * @date 2015年6月25日 16:39:41
 */
public interface INoteBackDao {
	public int save(NoteBack nb);		//保存
	public NoteBack get(HashMap<Object, Object> hm);		//获取
	public ArrayList<NoteBack> getByRange(HashMap<Object, Object> hm);		//条件查询
}
