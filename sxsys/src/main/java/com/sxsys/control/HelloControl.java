package com.sxsys.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloControl {
	@RequestMapping("/hello.do")
	public ModelAndView hello(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("message","hello spring mvc");
		return modelAndView;
	}
}
