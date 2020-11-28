package jcoding.kr.book.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jcoding.kr.book.vo.BookInfo;

@Repository
public class BookInfoDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	final String namespace = "bookinfo_sql";
	
	public List<BookInfo> selectAll(){
		return sqlSession.selectList(namespace + ".select-all");
	}
	
	public int insert(BookInfo info) {
		return sqlSession.insert(namespace +".insert", info);
	}
	
	public BookInfo selectOne(BookInfo info) {
		return sqlSession.selectOne(namespace +".select", info);
	}
	
	public int update(BookInfo info) {
		return sqlSession.update(namespace+".update", info);
	}
	
	public int delete(BookInfo info) {
		return sqlSession.delete(namespace +".delete", info);
	}
}
