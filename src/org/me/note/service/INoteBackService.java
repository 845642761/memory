package org.me.note.service;

import java.util.HashMap;
import org.me.core.common.Resoult;
import org.me.note.entity.NoteBack;

/**
 * NoteBackService
 * @author: cheng_bo
 * @date: 2015年6月29日 08:56:31
 */
public interface INoteBackService {
	public Resoult save(NoteBack nb);//保存
	public Resoult get(HashMap<Object, Object> hm);//获取
	public Resoult getByRange(HashMap<Object, Object> hm);//条件查询
}
