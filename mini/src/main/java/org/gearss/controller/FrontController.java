package org.gearss.controller;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.gearss.domain.Criteria;
import org.gearss.domain.ImgVO;
import org.gearss.domain.PageMaker;
import org.gearss.service.ImgService;
import org.gearss.service.ReplyService;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping(name = "/write", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String writePOST(ImgVO vo, Model model,@RequestParam("fileName") MultipartFile file) throws Exception{

		
		logger.info("222222222222222222");
		service.regist(vo);
		model.addAttribute("result", "success");
		
		System.out.println("getName : " +file.getName());
		System.out.println("getOriginalFileName : " +file.getOriginalFilename());
		System.out.println("size : " + file.getSize());
		
		UUID uid = UUID.randomUUID();
		
		String uidStr = uid.toString();
		String saveName = uidStr+"_"+file.getOriginalFilename();
		String thumbName = uidStr+"_s_"+file.getOriginalFilename();
		
		IOUtils.copy(file.getInputStream(), new FileOutputStream("C:\\zzz\\upload\\"+saveName));
		
		BufferedImage src = ImageIO.read(file.getInputStream());
		
		BufferedImage thumb = Scalr.resize(src, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		ImageIO.write(thumb, "jpg", new FileOutputStream("C:\\zzz\\upload\\"+thumbName));
		
		return "redirect:/picboard/main";
		
	}
	
	
	@GetMapping("/read")
	public void readGET(@ModelAttribute("cri") Criteria cri, Model model, @RequestParam("ino") int ino){
		
		logger.info("read..");
	
		ImgVO vo = service.read(ino);
		model.addAttribute("list",vo);
		
	}
	
	@GetMapping("/reply")
	public void reply(){
		logger.info("reply..");
	}
	
	@PostMapping("/del")
	public void delete(ImgVO vo, Model model){
		
		service.remove(vo.getIno());
		
	}
	
	@GetMapping("/update")
	public void update(Model model,@RequestParam("ino") int ino)throws Exception{
		
		System.out.println(ino);
		ImgVO vo = service.read(ino);
		System.out.println(vo);
		model.addAttribute("list",vo);
		
	}
	@PostMapping("/update")
	public void updatePost(ImgVO vo, Model model,@RequestParam("fileName") MultipartFile file){
		logger.info(vo);
		service.modify(vo);
		
		
		
	}
	
	
}
