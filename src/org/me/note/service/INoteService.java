package org.me.note.service;

import java.util.HashMap;
import org.me.core.common.Resoult;
import org.me.note.entity.Note;

/**
 * NoteService
 * @author: cheng_bo
 * @date: 2015年6月29日 08:52:27
 */
public interface INoteService {
	public Resoult save(Note note);//保存
	public Resoult get(HashMap<Object, Object> hm);//获取
	public Resoult getByRange(HashMap<Object, Object> hm);//条件查询
}
