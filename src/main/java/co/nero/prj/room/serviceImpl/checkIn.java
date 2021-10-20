package co.nero.prj.room.serviceImpl;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.service.PersonalAddOffer;
import co.nero.prj.personal.service.PersonalVO;
import co.nero.prj.room.service.RoomVO;

public class checkIn implements Command {
	RoomVO room = new RoomVO();
	PersonalVO personal = new PersonalVO();
	RoomSelectList rs = new RoomSelectList();
	PersonalAddOffer pao = new PersonalAddOffer();

	@Override
	public void execute() {
		boolean b = false;

		personal.setName(LoginSt.NAME);
		personal = daops.personalSelect(personal);

		if (personal.getAddoffer() != null && personal.getAddoffer().equals("없음")) {
			System.out.println("\n[객실 목록입니다.]");
			rs.execute();
			System.out.println("[투숙하실 방의 번호를 입력해주세요.]");
			
			while (!b) {
				try {
					String input = scn.nextLine();
					int n = Integer.parseInt(input);
					room.setRoomnum(n);
					if (1 <= n && n <= 10) {
						room = daors.roomSelect(room);
						System.out.println("선택하신 " + room.getRoomnum() + "번 " + room.getRoomtype() + "방으로 예약합니다.");
						room.setCliname(LoginSt.NAME);
						daors.roomUpdate(room);
						pao.execute();
						b = true;
					} else {
						System.out.println("없는 방입니다.\n비어있는 방의 번호를 입력해주세요.");
					}

				} catch (Exception e) {
					System.out.println("잘못된 값을 입력하였습니다.\n비어있는 방의 번호를 입력해주세요.");
				}
			}

//			
//			try {
//				System.out.println("[투숙하실 방의 번호를 입력해주세요.]");
//				int n;
//				n = scn.nextInt();
//				System.out.println(n + "#@$@$");
//				scn.nextLine();
//				room.setRoomnum(n);
//				if (n > 10 && n < 1) {
//					room = daors.roomSelect(room);
//					System.out.println("선택하신 " + room.getRoomnum() + "번 " + room.getRoomtype() + "방으로 예약합니다.");
//					room.setCliname(LoginSt.NAME);
//					daors.roomUpdate(room);
//					pao.execute();
//				} else {
//					System.out.println("비어있는 방의 번호를 입력해주세요.\n");
//				}
//			} catch (InputMismatchException e) {
////				e.printStackTrace();
//				System.out.println(">>>>>비어있는 방의 번호를 입력해주세요.\n");
//			}

		} else {
			System.out.println("이미 예약하신 객실이 있습니다.");
			System.out.println("메뉴화면으로 돌아갑니다.\n");
		}
	}
}
