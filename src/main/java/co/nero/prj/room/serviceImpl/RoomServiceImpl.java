package co.nero.prj.room.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.nero.prj.comm.DataSource;
import co.nero.prj.room.service.RoomMapper;
import co.nero.prj.room.service.RoomService;
import co.nero.prj.room.service.RoomVO;

public class RoomServiceImpl implements RoomService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private RoomMapper map = sqlSession.getMapper(RoomMapper.class);

	@Override
	public List<RoomVO> roomSelectList() {
		// TODO Auto-generated method stub
		return map.roomSelectList();
	}

	@Override
	public RoomVO roomSelect(RoomVO vo) {
		// TODO Auto-generated method stub
		return map.roomSelect(vo);
	}

	@Override
	public int roomInsert(RoomVO vo) {
		// TODO Auto-generated method stub
		return map.roomInsert(vo);
	}

	@Override
	public int roomUpdate(RoomVO vo) {
		// TODO Auto-generated method stub
		return map.roomUpdate(vo);
	}

	@Override
	public int roomDelete(RoomVO vo) {
		// TODO Auto-generated method stub
		return map.roomDelete(vo);
	}

	@Override
	public RoomVO roomNameSelect(RoomVO vo) {
		// TODO Auto-generated method stub
		return map.roomNameSelect(vo);
	}

}
