package jcoding.kr.book.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jcoding.kr.book.vo.PhotoInfo;

@Repository
public class PhotoInfoDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	final String namespace = "photoinfo_sql";
	
	public int insert(PhotoInfo input) {
		return sqlSession.insert(namespace+".insert", input);
	}
	
	public PhotoInfo selectOne(PhotoInfo input) {
		return sqlSession.selectOne(namespace+".select", input);
	}
}
