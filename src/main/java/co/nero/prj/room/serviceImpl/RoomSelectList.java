package co.nero.prj.room.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.room.service.RoomVO;

public class RoomSelectList implements Command {

	@Override
	public void execute() {
		List<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms = daors.roomSelectList();

		for (RoomVO vo : rooms) {
			if (vo.getCliname().equals("비어있음")) {
				System.out.print("[" + vo.getCliname() + "] ");
				System.out.print(vo.getRoomnum() + " : ");
				System.out.print(vo.getRoomtype() + " : ");
				System.out.print(vo.getPayment() + " : ");
				System.out.print(vo.getAmenity() + " : ");
				System.out.println(vo.getInfo());
			}
		}
	}
}
