package com.bit.sts06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.h2.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bit.sts06.model.DeptDao;
import com.bit.sts06.model.entity.DeptVo;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping(value = "/dept")
	@ResponseBody 
	public List<DeptVo> list() {
		
		List<DeptVo> list=null;
		try(
			SqlSession session=sqlSessionFactory.openSession();
				){
			list=session.getMapper(DeptDao.class).selectAll();
		}
		return list;
	}
	
	@PostMapping("/dept")
	public ResponseEntity add(DeptVo bean) {
		System.out.println(bean);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
