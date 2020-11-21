package jcoding.kr.book.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jcoding.kr.book.dao.BookInfoDAO;
import jcoding.kr.book.vo.BookInfo;

@Component("BookService")
public class BookService implements DataService<BookInfo> {
  @Autowired
  private BookInfoDAO dao;
  
  @Override
  public int insert(BookInfo input) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int update(BookInfo input) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(BookInfo input) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<BookInfo> select() {
    return dao.select();
  }

  @Override
  public List<BookInfo> select(BookInfo input) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BookInfo selectOne(BookInfo input) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int count(BookInfo input) {
    // TODO Auto-generated method stub
    return 0;
  }

}
