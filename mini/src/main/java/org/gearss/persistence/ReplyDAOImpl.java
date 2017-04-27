package org.gearss.persistence;

import java.util.List;

import javax.inject.Inject;

import org.gearss.domain.ReplyVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

static final String namespace = "org.gearss.persistence.ReplyDAO";
	
	@Inject
	SqlSessionTemplate session;

	@Override
	public void create(ReplyVO vo) {
		session.insert(namespace+".insert",vo);

	}

	@Override
	public ReplyVO read(int rno) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read",rno);

	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		session.delete(namespace+".delete",rno);
	}

	@Override
	public List<ReplyVO> list() {
		return session.selectList(namespace + ".getList");

	}
	
	
	

}
