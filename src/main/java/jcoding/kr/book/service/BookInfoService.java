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
}
