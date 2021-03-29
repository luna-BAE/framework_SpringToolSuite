package com.bit.sts07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class HomeController {
	
	String path="C:\\stsWorkspace\\upload\\";
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("upload from page...");
		
	
		return "home";
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, Model model) {
		
		logger.debug(file.getOriginalFilename());
		logger.debug(file.getContentType());
		
		// 파일이 중복될 수 있다. 있는지 없는지 검사를 할 필요없이 그냥 파일 이름 앞에 업로드된 시간을 붙이면 된다.
		// 아무리 용한 컴퓨터라도 세세한 시간까지 동일하게 업로드하는 것은 불가능하다.
		String fname = System.currentTimeMillis()+"#"+file.getOriginalFilename();
		File result = new File("C:\\stsWorkspace\\sts07\\"+fname); // 실제로 파일이 업로드될 위치와 파일 이름
		result.exists();
		
		try {
			file.transferTo(result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 데이터베이스에 저장할 때는 실제 파일명과 다시 설정된(시간이 붙어있거나 디렉토리로 표시된) 이름이 들어가야 함
		model.addAttribute("origin", file.getOriginalFilename());
		model.addAttribute("reName", fname);
		
		// 다행히 이렇게 안해도 됩니다.
//		InputStream is = null;
//		OutputStream os = null;
//		try {
//			is = file.getInputStream();
//			os = new FileOutputStream("C:\\stsWorkspace\\sts07");
//			int su = -1;
//			
//			while((su = is.read())!=-1)
//				os.write(su);
//			
//			os.close();
//			is.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return "down";
	}
	
	@RequestMapping("/down")
	public void down(String reName, HttpServletResponse res) {

		logger.debug(reName);
		File file=new File(path+reName);
		String filename=reName.substring(reName.indexOf('@')+1);
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition"
				, "attachment; filename=\""+filename+"\"");
		try(
			OutputStream os = res.getOutputStream();
			InputStream is = new FileInputStream(file);
		) {
			int su=-1;
			while((su=is.read())!=-1) os.write(su);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/down/{reName:.+}")
	public void down2(@PathVariable("reName") String reName, HttpServletResponse res) {
		logger.debug(reName);
		
		File file = new File(path+reName);
		
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition"
				, "attachment; filename=\""+reName.substring(reName.indexOf('#')+1)+"\"");
		
		try (
			InputStream is = new FileInputStream(file);
			OutputStream os = res.getOutputStream();
			){
			int su=-1;
			while((su=is.read())!=-1) os.write(su);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
	
}
