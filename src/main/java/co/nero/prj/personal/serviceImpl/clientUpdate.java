package co.nero.prj.personal.serviceImpl;

import co.nero.prj.comm.Command;
import co.nero.prj.personal.service.PersonalVO;

public class clientUpdate implements Command {
	PersonalVO personal = new PersonalVO();
	boolean b = false;

	@Override
	public void execute() {
		System.out.print("수정할 고객의 ID를 입력해주세요 : ");
		personal.setId(scn.nextLine());
		
		System.out.print("수정할 이름을 입력하세요 : ");
		do {
			personal.setName(scn.nextLine());
			if (personal.getName().equals("")) {
				System.out.print("필수입력사항입니다.\n이름을 다시 입력해주세요 : ");
			} else {
				b = true;
			}
		} while(personal.getName().equals(""));
		
		System.out.print("수정할 비밀번호를 입력하세요 : ");
		do {
			personal.setPassword(scn.nextLine());
			if (personal.getPassword().equals("")) {
				System.out.print("필수입력사항입니다.\nPassword를 다시 입력해주세요 : ");
			} else {
				b = true;
			}
		} while(personal.getPassword().equals(""));
		
		System.out.print("수정할 연락처를 입력하세요 : ");
		personal.setTel(scn.nextLine());
		
		System.out.print("수정할 주소를 입력하세요 : ");
		personal.setAddress(scn.nextLine());
		
		daops.clientUpdate(personal);

	}

}
