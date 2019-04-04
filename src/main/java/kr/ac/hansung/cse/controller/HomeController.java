package kr.ac.hansung.cse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
}
/*
 * 컨트롤러라고 설정되어있기때문에 빈으로 등록이되고
 * 리퀘스트 맵핑에서 get 메소드가  /(루트)로 들어오게되고
 * public string home()함수가 실행된다.
 * 그래서 views/home.jsp가 불린다.
 * */
