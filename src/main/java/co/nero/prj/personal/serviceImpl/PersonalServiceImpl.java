package co.nero.prj.personal.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nero.prj.comm.DataSource;
import co.nero.prj.personal.service.PersonalMapper;
import co.nero.prj.personal.service.PersonalService;
import co.nero.prj.personal.service.PersonalVO;

public class PersonalServiceImpl implements PersonalService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private PersonalMapper map = sqlSession.getMapper(PersonalMapper.class);

	@Override
	public List<PersonalVO> personalSelectList() {
		// TODO Auto-generated method stub
		return map.personalSelectList();
	}

	@Override
	public PersonalVO personalSelect(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.personalSelect(vo);
	}

	@Override
	public int personalInsert(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.personalInsert(vo);
	}

	@Override
	public int personalUpdate(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.personalUpdate(vo);
	}

	@Override
	public int personalDelete(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.personalDelete(vo);
	}

	@Override
	public PersonalVO loginCheck(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.loginCheck(vo);
	}

	@Override
	public int UserCreate(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.UserCreate(vo);
	}

	@Override
	public int clientUpdate(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.clientUpdate(vo);
	}

	@Override
	public int clientDelete(PersonalVO vo) {
		// TODO Auto-generated method stub
		return map.clientDelete(vo);
	}

}
