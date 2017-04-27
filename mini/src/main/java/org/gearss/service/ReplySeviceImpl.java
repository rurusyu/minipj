package org.gearss.service;

import java.util.List;

import javax.inject.Inject;

import org.gearss.domain.ReplyVO;
import org.gearss.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

@Service
public class ReplySeviceImpl implements ReplyService {

	@Inject
	ReplyDAO rdao;

	@Override
	public void regist(ReplyVO vo) {
		// TODO Auto-generated method stub
		rdao.create(vo);
	}

	@Override
	public ReplyVO read(int rno) {
		// TODO Auto-generated method stub
		return rdao.read(rno);
	}

	@Override
	public void remove(int rno) {
		// TODO Auto-generated method stub
		rdao.delete(rno);
	}

	@Override
	public List<ReplyVO> rlistAll() {
		// TODO Auto-generated method stub
		return rdao.list();
	}

}
