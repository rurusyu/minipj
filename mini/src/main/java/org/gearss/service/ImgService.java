package org.gearss.service;

import java.util.List;

import org.gearss.domain.ImgVO;

public interface ImgService {
	
	public void regist(ImgVO vo);
	public ImgVO read(int ino);
	public void modify(ImgVO vo);
	public void remove(int ino);
	public List<ImgVO> listAll();
	
	

}
