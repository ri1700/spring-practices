package com.bit2025.emaillist.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmaillogRepository {
	@Autowired
	private SqlSession sqlSession;

	public int insert() {
		return sqlSession.insert("emaillog.insert");
	}

	public int update() {
		return sqlSession.update("emaillog.update");
	}

	public int update(String regDate) {
		return sqlSession.update("emaillog.updateByRegDate", regDate);
	}
}