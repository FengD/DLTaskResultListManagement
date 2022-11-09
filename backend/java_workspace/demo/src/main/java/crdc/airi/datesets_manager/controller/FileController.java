package crdc.airi.datesets_manager.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import crdc.airi.datesets_manager.utils.Response;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/File")
@Slf4j
public class FileController {

	@Value("${localPath}")
	private String localPath;
	@Value("${serverPath}")
	private String serverPath;

	@PostMapping(value = "/upload")
	public Object uploading(@RequestParam("file") MultipartFile file) {
		Response response;
		File targetFile = new File(localPath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_");// 设置日期格式
		String date = df.format(new Date());
		String filename = localPath + date + file.getOriginalFilename();
		String fileonlinename = serverPath + date + file.getOriginalFilename();
		try (FileOutputStream out = new FileOutputStream(filename);) {
			out.write(file.getBytes());
			response = new Response(fileonlinename, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("upload failed!");
			response = new Response(null, HttpStatus.NOT_ACCEPTABLE);
		}
		log.info("upload successed!");
		return response.getResponse();
	}

//	@RequestMapping("/download")
//	public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
//		String filename = "JAVA核心知识点整理.pdf";
//		String filePath = "D:/file";
//		File file = new File(filePath + "/" + filename);
//		if (file.exists()) {
//			response.setContentType("application/octet-stream");
//			response.setHeader("content-type", "application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf8"));
//			byte[] buffer = new byte[1024];
//			// 输出流
//			OutputStream os = null;
//			try (FileInputStream fis = new FileInputStream(file);
//					BufferedInputStream bis = new BufferedInputStream(fis);) {
//				os = response.getOutputStream();
//				int i = bis.read(buffer);
//				while (i != -1) {
//					os.write(buffer);
//					i = bis.read(buffer);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
}