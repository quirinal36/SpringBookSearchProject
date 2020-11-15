package jcoding.kr.book.contol;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jcoding.kr.book.util.BookUtil;
import jcoding.kr.book.vo.BookInfo;

@Controller
@RequestMapping(value="/book")
public class BookController {
  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  
  @RequestMapping(value="/list")
  public ModelAndView getListView(ModelAndView mv,
      BookInfo info) {
    BookUtil util = new BookUtil();
    List<BookInfo> list = util.getBookList(info.getTitle(), "", "", "");
    logger.info("list size: " + list.size());
    mv.addObject("books", list);
    mv.setViewName("/book/list");
    return mv;
  }
  /*
  @RequestMapping(value="/search")
  public ModelAndView getSearchView(
      BookInfo info,
      ModelAndView mv) {
//    BookInfo info = new BookInfo();
//    info.setTitle(query);
    mv.addObject("bookInfo", info);
    
    BookUtil util = new BookUtil();
    List<BookInfo> list = util.getBookList(info.getTitle(), "", "", "");
    mv.addObject("books", list);
    mv.setViewName("/book/list");
    return mv;
  }
  */
}
