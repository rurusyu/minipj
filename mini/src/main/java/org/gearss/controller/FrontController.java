package org.gearss.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.gearss.domain.ImgVO;
import org.gearss.service.ImgService;
import org.gearss.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/picboard/*")
public class FrontController {
	
	static final Logger logger = Logger.getLogger(FrontController.class);
	
	@Inject
	ImgService service;
	
	@Inject
	ReplyService rService;
	
	@GetMapping("/main")
	public void main(){
		logger.info("main..");
	}
	
	@GetMapping("/write")
	public void writeGET(ImgVO vo, Model model) throws Exception{
		logger.info("쓰기 성공적");
	}
	
	@PostMapping("/write")
	public String writePOST(ImgVO vo, Model model) throws Exception{
		
		service.regist(vo);
		model.addAttribute("result", "성공적으로 등록되었습니다.");
		
		return "redirect:/picboard/main";
		
	}
	
	
	@GetMapping("/read")
	public void read(){
		logger.info("read..");
	}
	
	@GetMapping("/reply")
	public void reply(){
		logger.info("reply..");
	}
	
	//수정 테스트!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
