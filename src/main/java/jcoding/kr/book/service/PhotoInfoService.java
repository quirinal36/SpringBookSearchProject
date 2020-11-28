package jcoding.kr.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcoding.kr.book.dao.PhotoInfoDAO;
import jcoding.kr.book.vo.PhotoInfo;

@Component
public class PhotoInfoService {
	@Autowired
	PhotoInfoDAO dao;
	
	public int insert(PhotoInfo info) {
		return dao.insert(info);
	}
	
	public PhotoInfo selectOne(PhotoInfo info) {
		return dao.selectOne(info);
	}
}
