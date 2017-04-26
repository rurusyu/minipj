package org.gearss.persistence;

import java.util.List;

import org.gearss.domain.ImgVO;

public interface ImgDAO {
	
	public void create(ImgVO vo);
	public ImgVO read(int ino);
	public void update(ImgVO vo);
	public void delete(int ino);
	public List<ImgVO> list();

	
	
}
