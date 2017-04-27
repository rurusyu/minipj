package org.gearss.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.gearss.domain.ImgVO;
import org.gearss.persistence.ImgDAO;
import org.gearss.persistence.ReplyDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DAOTest {
	
	static final Logger logger = Logger.getLogger(DAOTest.class);
	
	@Inject
	ImgDAO dao;
	
	@Inject
	ReplyDAO rdao;
	
	@Test
	public void rlistTest(){
		
		rdao.list();
	}
	
	
	@Test
	public void listTest(){
		dao.list(null);
		
	}
	
	
	@Test
	public void deleteTest(){
		ImgVO vo = new ImgVO();
		int num = vo.setIno(5);
		
		dao.delete(num);
		
	}
	
	@Test
	public void updateTest(){
		ImgVO vo = new ImgVO();
		vo.setIno(2);
		vo.setTitleName("바지에 똥싼날");
		vo.setContent("섬균이가 바지에 응아했다");
		vo.setFilename(null);
		dao.update(vo);
	}
	
	
	@Test
	public void readTest(){
		
		ImgVO vo = new ImgVO();
		int num = vo.setIno(1);
				
		dao.read(num);
		
		
	}
	
	
	@Test
	public void createTest(){
		
		ImgVO vo = new ImgVO();
		
		vo.setTitleName("테스트네임");
		vo.setFilename("파일네임");
		vo.setContent("내용");
		
		
		dao.create(vo);
		logger.info(dao);
	}
	

}
