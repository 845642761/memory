package org.me.core.dao.impl;
import java.util.HashMap;

import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.me.core.dao.IMybatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisDao<T> implements IMybatisDao<T>{
	
	@Resource
	private SqlSession sqlSession;

	@Override
	public void save(String id,T t) {
		sqlSession.insert(id, t);
	}
	
	@Override
	public void delete(String id,T t) {
	}
	
	@Override
	public int selectSize(String id, HashMap<Object, Object> hm) {
		int size=sqlSession.selectOne(id, hm);
		return size;
	}

	@Override
	public T get(String id, HashMap<Object, Object> hm) {
		return sqlSession.selectOne(id, hm);
	}

	@Override
	public void saveUpdate(String id, T t) {
		sqlSession.update(id, t);
	}
}
