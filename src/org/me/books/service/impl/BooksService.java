package org.me.books.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.me.books.dao.IBooksDao;
import org.me.books.entity.Books;
import org.me.books.service.IBooksService;
import org.springframework.stereotype.Service;

@Service
public class BooksService implements IBooksService {

	@Resource
	private IBooksDao bookDao;
	
	@Override
	public void save(Books b) {
		bookDao.save(b);
	}

	@Override
	public Books get(HashMap<Object, Object> hm) {
		return bookDao.get(hm);
	}

	@Override
	public void saveUpdate(Books b) {
		bookDao.saveUpdate(b);
	}

	@Override
	public ArrayList<Books> getByRange(HashMap<Object, Object> hm) {
		return bookDao.getByRange(hm);
	}

}
