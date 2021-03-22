package com.bit.sts02.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.entity.DeptVo;

@Controller
@RequestMapping("/dept/")
public class DeptController {

	@Autowired
	DeptDao deptDao; // 필드에 오토와이어를 붙이면 자동으로 세터를 만들어서 세터해줌
	
//	@Autowired
//	public void setDeptDao(DeptDao deptDao) {
//		this.deptDao = deptDao;
//	}
	
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@RequestParam int deptno, String dname, String loc) { // RequestParam은 어노테이션 생략 가능
		
		deptDao.insertOne(new DeptVo(deptno, dname, loc));
		
		return "redirect:list";
	}
	
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(
//			@RequestParam("deptno") int deptno,
//			@RequestParam("dname") String dname, 
//			@RequestParam("loc") String loc) {
//		
//		deptDao.insertOne(new DeptVo(deptno, dname, loc));
//		
//		return "redirect:list";
//	} // 아래처럼 하면 리퀘스트를 받아야 하니까 이것처럼 그냥 어노테이션 파람으로 받으면 됩니다.
	
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(HttpServletRequest req) throws UnsupportedEncodingException {
//		
//		req.setCharacterEncoding("utf-8");
//		deptDao.insertOne(new DeptVo(
//				Integer.parseInt(req.getParameter("deptno"))
//				,req.getParameter("dname")
//				,req.getParameter("loc")
//				));
//		
//		return "redirect:list";
//	}
	
	@RequestMapping(value = "dept", method = RequestMethod.GET)
	public void one(@RequestParam("idx") int deptno, Model model) {
		
		model.addAttribute("bean", deptDao.selectOne(deptno));
		
	}
	
//	@RequestMapping(value = "dept", method = RequestMethod.GET)
//	public void one(HttpServletRequest req) {
//		
//		req.setAttribute("bean", deptDao.selectOne(Integer.parseInt(req.getParameter("idx"))));
//		
//	}

	@RequestMapping(value = "dept", method = RequestMethod.POST)
	public String edit(@ModelAttribute DeptVo bean) throws UnsupportedEncodingException { // 2버전에서 커맨드로 받았던 것처럼 이것도 가능합니다.
				
		deptDao.updateOne(bean);
		
		return "redirect:dept?idx="+bean.getDeptno();
		
	} // 아래처럼 다 쓰기 귀찮잖아요? 그래서 이렇게 씁니다
	
//	@RequestMapping(value = "dept", method = RequestMethod.POST)
//	public String edit(int deptno, String dname, String loc) throws UnsupportedEncodingException {
//		
//		// req.setCharacterEncoding("utf-8"); // 여기서 겟파라미터가 안 되니까 엔코딩이 소용이 없습니다.
//		
//		DeptVo bean = new DeptVo(deptno, dname, loc);
//		
//		deptDao.updateOne(bean);
//		
//		return "redirect:dept?idx="+bean.getDeptno();
//		
//	}
	
//	@RequestMapping(value = "dept", method = RequestMethod.POST)
//	public String edit(HttpServletRequest req) {
//		
//		try {
//			req.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		DeptVo bean = new DeptVo(
//				Integer.parseInt(req.getParameter("deptno"))
//				,req.getParameter("dname")
//				,req.getParameter("loc")
//				);
//		
//		deptDao.updateOne(bean);
//		
//		return "redirect:dept?idx="+bean.getDeptno();
//		
//	}
	
	@RequestMapping(value = "dept/{deptno}", method = RequestMethod.POST) // 파라미터가 아니라 패스 밸리어블로 넘어감
	// 겟방식일 경우 값이 주소창에 모두 나오므로 보안성이 떨어져 공격이 가능해짐
	public String delete(@PathVariable("deptno") int deptno) { // 이름이 같으면 어노테이션 인자 생략 가능 
		deptDao.deleteOne(deptno);
		return "redirect:../list";
	}
	
}
