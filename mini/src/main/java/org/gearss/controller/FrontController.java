package org.gearss.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.gearss.domain.Criteria;
import org.gearss.domain.ImgVO;
import org.gearss.domain.PageMaker;
import org.gearss.service.ImgService;
import org.gearss.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public void main(@ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		
		logger.info("main..");
		
		List<ImgVO> list = service.listAll(cri);
		model.addAttribute("list",list);
		model.addAttribute("pageMaker",new PageMaker(cri, service.getCount(cri)));
	
		
	}
	
	@GetMapping("/write")
	public void writeGET(ImgVO vo, Model model) throws Exception{
		logger.info("쓰기 성공적");
	}
	
	@PostMapping("/write")
	public String writePOST(ImgVO vo, Model model) throws Exception{
		logger.info("222222222222222222");
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
	
	@PostMapping("/del")
	public void delete(ImgVO vo, Model model){
		
		service.remove(vo.getIno());
		
	}
	
	
}
