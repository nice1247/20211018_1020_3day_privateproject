package co.nero.prj.personal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.room.service.RoomVO;

public class resInfo implements Command {

	@Override
	public void execute() {
		System.out.println("\n[현재 예약중인 객실 상황입니다.]");
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		roomlist = daors.roomSelectList();

		boolean isFull = false;
		for (RoomVO vo : roomlist) {
			if (!vo.getCliname().equals("비어있음")) {
				vo.setCliname(vo.getCliname());
				vo = daors.roomNameSelect(vo);
				isFull = true;
				System.out.println(
						vo.getCliname() + "님이 " + vo.getRoomnum() + "번 " + vo.getRoomtype() + "룸을 사용하고 있습니다.\n");
			}
		}
		if (isFull == false) {
			System.out.println("예약된 객실이 없습니다.\n");
		}
	}
}
