package cn.itlaobing.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(Model model){
		String msg="Hello spring boot!";
		model.addAttribute("msg",msg);
		return "hello";
	}
}
