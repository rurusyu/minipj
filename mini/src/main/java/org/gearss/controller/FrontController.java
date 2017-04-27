package org.gearss.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.gearss.service.ImgService;
import org.gearss.service.ReplyService;
import org.springframework.stereotype.Controller;
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
	public void writeGET(){
		logger.info("write..");
	}
	
	@PostMapping("/re")
	
	
	@GetMapping("/read")
	public void read(){
		logger.info("read..");
	}
	
	@GetMapping("/reply")
	public void reply(){
		logger.info("reply..");
	}
}
