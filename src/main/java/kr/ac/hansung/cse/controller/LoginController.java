package kr.ac.hansung.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	//에러내용이 항상있는게 아니니까 required=false라고 해줌
	//그 에러를 model에 저장함
	public String login(@RequestParam(value="error", required=false) String error, 
						@RequestParam(value="logout", required=false) String logout, 
						Model model) {
		//에러가 발생하면
		if(error !=null) {
			//모델에 errorMsg라는 키와 값을 넣음
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		
		//에러 발생안하면 -> 성공적 로그인
		if(logout !=null) {
			//모델에 logoutMsg라는 키와 값을 넣음
			model.addAttribute("logoutMsg", "you have been logged out successfully");
		}
		
		
		return "login";
	}

}
