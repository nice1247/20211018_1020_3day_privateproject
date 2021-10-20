package co.nero.prj.personal.serviceImpl;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.service.PersonalVO;
import co.nero.prj.room.service.RoomVO;

public class myStatus implements Command {

	@Override
	public void execute() {
		PersonalVO personal = new PersonalVO();
		RoomVO room = new RoomVO();
		personal.setName(LoginSt.NAME);
		personal = daops.personalSelect(personal);

		if (!personal.getAddoffer().equals("없음")) {
			room.setCliname(LoginSt.NAME);
			room = daors.roomNameSelect(room);
			System.out.println("\n[나의 예약정보 현황]");
			System.out.println("이름 : " + personal.getName());
			System.out.println("추가제공 : " + personal.getAddoffer());
			System.out.print(room.getRoomnum() + "번방 ");
			System.out.print(room.getRoomtype());
			System.out.println(", 객실료 : " + room.getPayment());
			System.out.println("서비스 : " + room.getAmenity());
			System.out.println("안내사항 : " + room.getInfo() + "\n");
		} else if (personal.getAddoffer().equals("없음")) {
			System.out.println("체크인 정보가 없습니다.\n");
		}

	}

}
