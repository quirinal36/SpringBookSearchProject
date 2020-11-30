package jcoding.kr.book.contol;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jcoding.kr.book.service.BookInfoServiceImpl;
import jcoding.kr.book.vo.BookInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BookInfoServiceImpl bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv) {
		List<BookInfo> result = bookService.selectAll();
		
		mv.addObject("list", result);
		mv.setViewName("/home");
		
		return mv;
	}
	
}
