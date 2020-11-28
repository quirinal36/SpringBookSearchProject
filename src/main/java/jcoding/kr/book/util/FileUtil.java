package jcoding.kr.book.util;

import java.io.File;

public class FileUtil {
	public static String makeUserPath() {
		String path = System.getProperty("user.dir");
		
		StringBuilder builder = new StringBuilder()
				.append(path).append(File.separator).append("tomcat")
				.append(File.separator).append("webapps").append(File.separator)
				.append("repository").append(File.separator)
				.append("upload").append(File.separator);
		
		File file = new File(builder.toString());
		file.mkdirs();
		
		final String result = file.getAbsolutePath();
		return result;
	}
}
