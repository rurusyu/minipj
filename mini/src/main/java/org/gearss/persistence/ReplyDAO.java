package org.gearss.persistence;

import java.util.List;

import org.gearss.domain.ReplyVO;


public interface ReplyDAO {

	public void create(ReplyVO vo);
	public ReplyVO read(int rno);
	public void delete(int rno);
	public List<ReplyVO> list();
	
}
