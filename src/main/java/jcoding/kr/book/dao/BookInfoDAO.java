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
}
