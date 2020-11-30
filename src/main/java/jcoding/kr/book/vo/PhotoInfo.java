package jcoding.kr.book.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhotoInfo extends MultipartObject{
	String url;
	String thumbnailFilename;
	int thumbnailSize;
	String thumbnailUrl;
	String search;
	int orderById;
	int boardId;
}