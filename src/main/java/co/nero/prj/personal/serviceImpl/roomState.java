package co.nero.prj.personal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.room.service.RoomVO;

public class roomState implements Command {

	@Override
	public void execute() {
		List<RoomVO> roomlist = new ArrayList<RoomVO>();
		roomlist = daors.roomSelectList();
		System.out.println("\n[현재 방 예약 상태입니다.]");
		for (RoomVO vo : roomlist) {
			if (vo.getCliname().equals("비어있음")) {
				System.out.println(vo.getRoomnum() + "번방은 비어있습니다.");
			} else {
				System.out.println(vo.getRoomnum() + "번방은 " + vo.getCliname() + "님이 사용중입니다.");
			}

		} System.out.println("");

	}
}
