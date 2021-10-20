package co.nero.prj.room.serviceImpl;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.service.PersonalVO;
import co.nero.prj.room.service.RoomVO;

public class checkOut implements Command {

	@Override
	public void execute() {
		PersonalVO personal = new PersonalVO();
		personal.setName(LoginSt.NAME);
		personal = daops.personalSelect(personal);
		RoomVO room = new RoomVO();
		room.setCliname(LoginSt.NAME);
		daors.roomNameSelect(room);

		if (room.getCliname() != null && !personal.getAddoffer().equals("없음")
				&& room.getCliname().equals(LoginSt.NAME)) {
			System.out.println("\n체크아웃 하시겠습니까? (Y/N)");
			String b = scn.nextLine();
			if (b.equals("y") || b.equals("Y")) {
				daors.roomDelete(room);
				daops.personalDelete(personal);
				System.out.println("정상적으로 체크아웃 되었습니다.\n");

			} else if (b.equals("n") || b.equals("N")) {
				System.out.println("메뉴화면으로 돌아갑니다.\n");
			} else {
				System.out.println("잘못 입력하셨습니다.\n메뉴화면으로 돌아갑니다.\n");
			}
		} else {
			System.out.println("체크아웃 할 방이 없습니다.\n");
		}
	}
}
