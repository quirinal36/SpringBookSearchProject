package jcoding.kr.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jcoding.kr.book.mapper.BookInfoTableMapper;
import jcoding.kr.book.serviceInterface.ServiceInterface;
import jcoding.kr.book.vo.BookInfo;

@Service
public class BookInfoServiceImpl implements ServiceInterface<BookInfo>{
	@Autowired
	BookInfoTableMapper bookInfoMapper;
	
	@Override
	public BookInfo selectOne(BookInfo input) {
		return bookInfoMapper.getBookInfo(input);
	}

	@Override
	public List<BookInfo> selectAll() {
		return bookInfoMapper.getBookInfoList();
	}

	@Override
	public int delete(BookInfo input) {
		return bookInfoMapper.delete(input);
	}

	@Override
	public int insert(BookInfo input) {
		return bookInfoMapper.insert(input);
	}

	@Override
	public int update(BookInfo input) {
		return bookInfoMapper.update(input);
	}

}
