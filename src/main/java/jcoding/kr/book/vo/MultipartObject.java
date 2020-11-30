package jcoding.kr.book.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipartObject {
	int id;
	int uploader;
	Date wdate;
	String name;
	String newFilename;
	int size;
	String contentType;
}
