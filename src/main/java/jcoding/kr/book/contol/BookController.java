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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import jcoding.kr.book.service.BookInfoService;
import jcoding.kr.book.vo.BookInfo;
import jcoding.kr.book.vo.PhotoInfo;

@Controller
@RequestMapping(value="/book")
public class BookController {
  private static final Logger logger = LoggerFactory.getLogger(BookController.class);
  
  @Autowired
  BookInfoService bookService;
  
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
  
  @RequestMapping(value="/add")
  public ModelAndView getAddView(ModelAndView mv) {
	  mv.setViewName("/book/add");
	  return mv;
  }
  @ResponseBody
  @RequestMapping(value = "/upload/image", method = {RequestMethod.POST})
  public String uploadImage(MultipartHttpServletRequest request, 
          HttpServletResponse response) {
		JSONObject result = new JSONObject();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		logger.info("isMultipart: " + isMultipart);
		Iterator<String> itr = request.getFileNames();
		logger.info("itr: " + itr.hasNext());
		
		MultipartFile mpf;
	    if (itr.hasNext()) {
	        mpf = request.getFile(itr.next());
	        String newFilenameBase = UUID.randomUUID().toString();
	        String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
	        String newFilename = newFilenameBase + originalFileExtension;
	        
	        String srcPath = makeUserPath();
	        String contentType = mpf.getContentType();
	        
	        File newFile = new File(srcPath + File.separator + newFilename);
	        try {
	            mpf.transferTo(newFile);
	            
	            PhotoInfo photo = new PhotoInfo();
	            photo.setName(mpf.getOriginalFilename());
	            photo.setNewFilename(newFilename);
	            photo.setSize((int)mpf.getSize());
	            photo.setContentType(contentType);
	            
	            result.put("type", "image");
	            result.put("file", photo);
	            result.put("result", 1);
	        } catch(IOException e) {
	            logger.info("Could not upload file " + e.getLocalizedMessage());
	            result.put("result", 0);
	        }
	    }
	    return result.toString();
	}
	
	public String makeUserPath() {
    String path = System.getProperty("user.dir");
    
    StringBuilder builder = new StringBuilder()
            .append(path).append(File.separator).append("tomcat")
            .append(File.separator).append("webapps").append(File.separator)
            .append("repository").append(File.separator)
            .append("upload").append(File.separator);
    logger.info(builder.toString());
    File file = new File(builder.toString());
    file.mkdirs();
    
    final String result = file.getAbsolutePath();
    return result;
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
