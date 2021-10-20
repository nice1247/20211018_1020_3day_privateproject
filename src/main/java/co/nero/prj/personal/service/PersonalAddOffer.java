package co.nero.prj.personal.service;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.serviceImpl.PersonalServiceImpl;

public class PersonalAddOffer implements Command {
	PersonalService personalService = new PersonalServiceImpl();
	PersonalVO personal = new PersonalVO();

	@Override
	public void execute() {
		personal.setName(LoginSt.NAME);
		personal = personalService.personalSelect(personal);
		System.out.println("추가로 선택하실 것이 있습니까?");
		System.out.println("1. 디너 뷔페   2. 헬스장 이용   3. 수영장 이용");
		System.out.println("추가 이용 하지 않으시려면 아무키나 입력해주세요.");

		while (true) {
			String key = scn.nextLine();
			if (key.equals("1")) {
				personal.setAddoffer("디너 뷔페");
				System.out.println("디너 뷔페를 선택하셨습니다.\n");
				break;
			} else if (key.equals("2")) {
				personal.setAddoffer("헬스장 이용");
				System.out.println("헬스장을 선택하셨습니다.\n");
				break;
			} else if (key.equals("3")) {
				personal.setAddoffer("수영장 이용");
				System.out.println("수영장을 선택하셨습니다.\n");
				break;
			} else {
				personal.setAddoffer("추가이용 없음");
				System.out.println("추가이용을 선택하지 않으셨습니다.\n");
				break;
			}
		}
		
		
//		if (skey != "") {
//			int key = Integer.parseInt(skey);
//			switch (key) {
//			case 1:
//				personal.setAddoffer("디너 뷔페");
//				System.out.println("디너 뷔페를 선택하셨습니다.\n");
//				break;
//			case 2:
//				personal.setAddoffer("헬스장 이용");
//				System.out.println("헬스장을 선택하셨습니다.\n");
//				break;
//			case 3:
//				personal.setAddoffer("수영장 이용");
//				System.out.println("수영장을 선택하셨습니다.\n");
//				break;
//			default:
//				personal.setAddoffer("추가이용 없음");
//				System.out.println("추가이용을 선택하지 않으셨습니다.\n");
//				break;
//			}
//		} else if (skey.equals("")){
//			personal.setAddoffer("추가이용 없음");
//			System.out.println("추가이용을 선택하지 않으셨습니다.\n");
//		}

		daops.personalInsert(personal);

	}

}
