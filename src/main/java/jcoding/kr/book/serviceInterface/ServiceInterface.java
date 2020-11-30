package jcoding.kr.book.serviceInterface;

import java.util.List;

public interface ServiceInterface<T> {
	public List<T> selectAll();
	public T selectOne(T input);
	public int delete(T input);
	public int insert(T input);
	public int update(T input);
}
