package org.gearss.service;

import java.util.List;

import org.gearss.domain.ReplyVO;
import org.springframework.stereotype.Service;
@Service
public interface ReplyService {

	public void regist(ReplyVO vo);
	public ReplyVO read(int rno);
	public void remove(int rno);
	public List<ReplyVO> rlistAll();
	
	
}
