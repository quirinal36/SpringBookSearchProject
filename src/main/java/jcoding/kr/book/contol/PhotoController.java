package jcoding.kr.book.contol;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import jcoding.kr.book.service.PhotoInfoService;
import jcoding.kr.book.util.FileUtil;
import jcoding.kr.book.vo.PhotoInfo;

@Controller
public class PhotoController {
	final Logger logger = Logger.getLogger(PhotoController.class.getSimpleName());
	@Autowired
	PhotoInfoService photoInfoService;

	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView getUploadView(ModelAndView mv) {
		mv.setViewName("/book/photoForm");
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

			String srcPath = FileUtil.makeUserPath();
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
				result.put("result", photoInfoService.insert(photo));
			} catch(IOException e) {
				logger.info("Could not upload file " + e.getLocalizedMessage());
				result.put("result", 0);
			}
		}
		return result.toString();
	}

	@RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
	public void picture(HttpServletRequest request,
			HttpServletResponse response, @PathVariable int id) {
		PhotoInfo param = new PhotoInfo();
		param.setId(id);

		PhotoInfo image = photoInfoService.selectOne(param);
		String srcPath = FileUtil.makeUserPath();
		//request.getSession().getServletContext().getRealPath("/upload");
		File imageFile = new File(srcPath+"/"+image.getNewFilename());
		response.setContentType(image.getContentType());
		response.setContentLength(image.getSize());
		try {
			InputStream is = new FileInputStream(imageFile);
			IOUtils.copy(is, response.getOutputStream());
		} catch(IOException e) {
			logger.info("Could not show picture "+id +"/" + e.getLocalizedMessage());
		}
	}
}
