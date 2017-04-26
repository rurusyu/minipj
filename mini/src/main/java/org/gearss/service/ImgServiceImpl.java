package org.gearss.service;

import java.util.List;

import javax.inject.Inject;

import org.gearss.domain.ImgVO;
import org.gearss.persistence.ImgDAO;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {

	@Inject
	ImgDAO dao;

	@Override
	public void regist(ImgVO vo) {
		dao.create(vo);
	}

	@Override
	public ImgVO read(int ino) {
		return dao.read(ino);
	}

	@Override
	public void modify(ImgVO vo) {
		dao.update(vo);
	}

	@Override
	public void remove(int ino) {
		dao.delete(ino);
	}

	@Override
	public List<ImgVO> listAll() {
		return dao.list();
	}

}
