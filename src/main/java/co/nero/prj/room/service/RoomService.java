package co.nero.prj.room.service;

import java.util.List;

public interface RoomService {
	List<RoomVO> roomSelectList();
	RoomVO roomSelect(RoomVO vo);
	int roomInsert(RoomVO vo);
	int roomUpdate(RoomVO vo);
	int roomDelete(RoomVO vo);
	RoomVO roomNameSelect(RoomVO vo);
	

}
