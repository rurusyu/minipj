package org.gearss.persistence;

import java.util.List;

import javax.inject.Inject;


import org.gearss.domain.ImgVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ImgDAOImpl implements ImgDAO {

	static final String namespace = "org.gearss.persistence.ImgDAO";
	
	@Inject
	SqlSessionTemplate session;

	@Override
	public void create(ImgVO vo) {
	session.insert(namespace+".insert",vo);	
	}

	@Override
	public ImgVO read(int ino) {
		
		return session.selectOne(namespace+".read", ino) ;
	}

	@Override
	public void update(ImgVO vo) {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int ino) {
		session.delete(namespace +".delete", ino);
		
	}

	@Override
	public List<ImgVO> list() {
		
		return session.selectList(namespace + ".getList");
	}
	
	

}
