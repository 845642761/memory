package org.me.memory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.me.core.dao.IMybatisDao;
import org.me.memory.entity.Books;
import org.me.memory.service.IBooksService;
import org.springframework.stereotype.Service;

@Service
public class BooksService implements IBooksService {

	@Resource
	private IMybatisDao<Books> mybatisDao;
	
	@Override
	public void save(String id, Books b) {
		mybatisDao.save(id, b);
	}

	@Override
	public Books get(String id, HashMap<Object, Object> hm) {
		return mybatisDao.get(id, hm);
	}

	@Override
	public void saveUpdate(String id, Books b) {
		mybatisDao.saveUpdate(id, b);
	}

	@Override
	public ArrayList<Books> getByRange(String id, HashMap<Object, Object> hm) {
		return mybatisDao.getByRange(id, hm);
	}

}
