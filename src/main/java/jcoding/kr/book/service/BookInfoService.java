package jcoding.kr.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcoding.kr.book.dao.BookInfoDAO;
import jcoding.kr.book.vo.BookInfo;

@Component("BookInfoService")
public class BookInfoService {
	@Autowired
	BookInfoDAO dao;
	
	public List<BookInfo> selectAll(){
		return dao.selectAll();
	}
	
	public int insert(BookInfo input) {
		return dao.insert(input);
	}
	
	public BookInfo selectOne(BookInfo input) {
		return dao.selectOne(input);
	}
	
	public int update(BookInfo input) {
		return dao.update(input);
	}
	
	public int delete(BookInfo input) {
		return dao.delete(input);
	}
}
