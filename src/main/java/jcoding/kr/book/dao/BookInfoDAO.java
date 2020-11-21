package jcoding.kr.book.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jcoding.kr.book.vo.BookInfo;

@Repository
public class BookInfoDAO implements DataAccess<BookInfo> {
  @Autowired
  private SqlSessionTemplate sqlSession;
  private final String namespace = "book_sql";
  
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
    return sqlSession.selectList(namespace + ".select-all");
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
