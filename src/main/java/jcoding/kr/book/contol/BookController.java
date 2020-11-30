package jcoding.kr.book.contol;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import jcoding.kr.book.service.BookInfoService;
import jcoding.kr.book.service.BookInfoServiceImpl;
import jcoding.kr.book.vo.BookInfo;
import jcoding.kr.book.vo.PhotoInfo;

@Controller
@RequestMapping(value="/book")
public class BookController {
  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  
  @Autowired
  BookInfoServiceImpl bookService;
  
  @RequestMapping(value="/list")
  public ModelAndView getListView(ModelAndView mv,
      BookInfo info) {
//    BookUtil util = new BookUtil();
//    List<BookInfo> list = util.getBookList(info.getTitle(), "", "", "");
	List<BookInfo> list = bookService.selectAll();
	
    logger.info("list size: " + list.size());
    mv.addObject("books", list);
    mv.setViewName("/book/list");
    return mv;
  }
  
  @RequestMapping(value="/detail/{id}")
  public ModelAndView getDetailView(ModelAndView mv, 
		  @PathVariable(value="id")String id) {
	  BookInfo info = new BookInfo();
	  info.setId(Integer.parseInt(id));
	  
	  info = bookService.selectOne(info);
	  
	  mv.addObject("book", info);
	  mv.setViewName("/book/detailView");
	  return mv;
  }
  
  @RequestMapping(value="/update")
  public ModelAndView getUpdateView(ModelAndView mv,
		  @RequestParam(value="id")String id) {
	  BookInfo info = new BookInfo();
	  info.setId(Integer.parseInt(id));
	  
	  info = bookService.selectOne(info);
	  
	  mv.addObject("book", info);
	  mv.setViewName("/book/insertForm");
	  return mv;
  }
  
  /**
   * 책 정보를 입력하는 화면을 구성하기 위한 메소드
   * @param mv
   * @return
   */
  @RequestMapping(value="/insert", method = RequestMethod.GET)
  public ModelAndView getInsertView(ModelAndView mv) {
	  mv.setViewName("/book/insertForm");
	  return mv;
  }
  
  /**
   * 책 정보를 전달받아서 DB에 저장하는 함수
   * @param info
   * @return
   */
  @ResponseBody
  @RequestMapping(value="/insert", method = RequestMethod.POST)
  public String insertBook(BookInfo info) {
	  int result = 0;
	  
	  logger.info(info.toString());
	  if(info.getId() > 0) {
		  // 수정하기 화면에서 넘어왔을 경우
		  result = bookService.update(info);
	  }else {
		  // id 값이 없다면 새로 입력하는 단계
		  result = bookService.insert(info);
	  }
	  JSONObject json = new JSONObject();
	  json.put("result", result);
	  return json.toString();
  }
  @ResponseBody
  @RequestMapping(value="/delete")
  public String deleteBook(BookInfo info) {
	  JSONObject json = new JSONObject();
	  int result = bookService.delete(info);
	  json.put("result", result);
	  return json.toString();
  }
  @RequestMapping(value="/add")
  public ModelAndView getAddView(ModelAndView mv) {
	  mv.setViewName("/book/add");
	  return mv;
  }
}
