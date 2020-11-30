package jcoding.kr.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jcoding.kr.book.vo.BookInfo;

@Mapper
public interface BookInfoTableMapper {
	public BookInfo getBookInfo(BookInfo input);
	public List<BookInfo> getBookInfoList();
	public int insert(BookInfo input);
	public int update(BookInfo input);
	public int delete(BookInfo input);
}
