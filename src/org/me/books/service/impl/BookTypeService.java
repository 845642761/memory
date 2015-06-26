package org.me.books.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.me.books.dao.IBookTypeDao;
import org.me.books.entity.BookType;
import org.me.books.service.IBookTypeService;
import org.springframework.stereotype.Service;

/**
 * BookTypeService
 * @author cheng_bo
 * @date 2015年6月13日 16:16:05
 */
@Service
public class BookTypeService implements IBookTypeService{
	
	@Resource
	private IBookTypeDao bookTypeDao;
	
	@Override
	public void save(BookType bt) {
		bookTypeDao.save(bt);
	}

	@Override
	public BookType get(HashMap<Object, Object> hm) {
		return bookTypeDao.get(hm);
	}

	@Override
	public void saveUpdate(BookType bt) {
		bookTypeDao.saveUpdate(bt);
	}

	@Override
	public ArrayList<BookType> getByRange(HashMap<Object, Object> hm) {
		return bookTypeDao.getByRange(hm);
	}
}
