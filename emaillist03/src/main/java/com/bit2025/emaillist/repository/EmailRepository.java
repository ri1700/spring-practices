package com.bit2025.emaillist.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2025.emaillist.vo.EmailVo;

@Repository
public class EmailRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public int deleteById(Long id) {
		return sqlSession.delete("email.deleteById", id);
	}
	
	public int insert(EmailVo vo) {
		return sqlSession.insert("email.insert", vo);
	}

	public List<EmailVo> findAll() {
		return sqlSession.selectList("email.findAll");
	}

	public EmailVo findById(Long id) {
		return sqlSession.selectOne("email.findById", id);
	}		
}