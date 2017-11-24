package cn.itlaobing.springboot.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class ApplicationErrorController extends BasicErrorController {
	private Log log=LogFactory.getLog(ApplicationErrorController.class);
	public ApplicationErrorController(ErrorAttributes errorAttributes,
   		 ServerProperties serverProperties,
   		 List<ErrorViewResolver> errorViewResolvers) {
		super(errorAttributes,serverProperties.getError(),errorViewResolvers);
	}
	@RequestMapping(produces = "text/html")
	@Override
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=super.errorHtml(request, response);
		log.info("errorHtml>>>错误....");
		//自定义代码
		return mv;
	}
	@RequestMapping
	@ResponseBody
	@Override
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		ResponseEntity<Map<String, Object>> responseEntity=super.error(request);
		log.info("error>>>错误....");
		//自定义代码
		return responseEntity;
	}
}
