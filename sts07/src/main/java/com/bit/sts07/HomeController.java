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
		
		// ������ �ߺ��� �� �ִ�. �ִ��� ������ �˻縦 �� �ʿ���� �׳� ���� �̸� �տ� ���ε�� �ð��� ���̸� �ȴ�.
		// �ƹ��� ���� ��ǻ�Ͷ� ������ �ð����� �����ϰ� ���ε��ϴ� ���� �Ұ����ϴ�.
		String fname = System.currentTimeMillis()+"#"+file.getOriginalFilename();
		File result = new File("C:\\stsWorkspace\\sts07\\"+fname); // ������ ������ ���ε�� ��ġ�� ���� �̸�
		result.exists();
		
		try {
			file.transferTo(result);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// �����ͺ��̽��� ������ ���� ���� ���ϸ�� �ٽ� ������(�ð��� �پ��ְų� ���丮�� ǥ�õ�) �̸��� ���� ��
		model.addAttribute("origin", file.getOriginalFilename());
		model.addAttribute("reName", fname);
		
		// ������ �̷��� ���ص� �˴ϴ�.
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
