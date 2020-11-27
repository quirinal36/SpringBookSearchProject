package jcoding.kr.book.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhotoInfo {
	int id;
	int uploader;
	Date wdate;
	String url;
	String name;
	String thumbnailFilename;
	String newFilename;
	int size;
	int thumbnailSize;
	String thumbnailUrl;
	String contentType;
	String search;
	int orderById;
	int boardId;
}