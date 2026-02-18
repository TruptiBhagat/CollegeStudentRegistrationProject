package com.app.controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.CollegeStudent;
import com.app.service.CollegeService;

@Controller
public class CollegeController {

	private CollegeService cs;
	
	public CollegeController(CollegeService cs) {
		this.cs=cs;
	}
	
	
//	@PostMapping("/")
	@GetMapping("/")
	public ModelAndView entry() {
	System.out.println("entry");
	ModelAndView mav = new ModelAndView();
	mav.setViewName("index");
	return mav;
	}
	
	//@GetMapping("/saveStudent")
	@PostMapping("/saveStudent")
	public ModelAndView handleSubmitBtn(CollegeStudent csp) throws Exception {
		ModelAndView mav = new ModelAndView();
		if(cs.saveStudent(csp)) {
			mav.addObject("smsg", "record inserted ");
		}else
			mav.addObject("emsg", "not saved ");
		System.out.println("student insertion");

	mav.setViewName("index");
	return mav;
	}
	
	@GetMapping("/getData")
	public ModelAndView getAllStudsController() {
		ModelAndView mav = new ModelAndView();
		 
		mav.addObject("students", cs.getAllStuds());
		mav.setViewName("data");
		System.out.println("retriving all records");
		return mav;
	}
	@GetMapping("/delete")
	public ModelAndView delete(@Param("studentId") Integer studentId) {
		
		cs.deleteById(studentId);
		
		ModelAndView mav = new ModelAndView();
		 
		mav.addObject("students", cs.getAllStuds());
		mav.addObject("del", "data deleted succefully");
		mav.setViewName("data");
		System.out.println("retriving all records");
		return mav;
	}
}
