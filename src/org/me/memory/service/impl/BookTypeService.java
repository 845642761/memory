package org.me.memory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import org.me.core.dao.IMybatisDao;
import org.me.memory.entity.BookType;
import org.me.memory.service.IBookTypeService;
import org.springframework.stereotype.Service;

/**
 * BookTypeService
 * @author cheng_bo
 * @date 2015年6月13日 16:16:05
 */
@Service
public class BookTypeService implements IBookTypeService{
	
	@Resource
	private IMybatisDao<BookType> mybatisDao;
	
	@Override
	public void save(String id, BookType bt) {
		mybatisDao.save(id, bt);
	}

	@Override
	public BookType get(String id, HashMap<Object, Object> hm) {
		return mybatisDao.get(id, hm);
	}

	@Override
	public void saveUpdate(String id, BookType bt) {
		mybatisDao.saveUpdate(id, bt);
	}

	@Override
	public ArrayList<BookType> getByRange(String id, HashMap<Object, Object> hm) {
		return mybatisDao.getByRange(id, hm);
	}
}
