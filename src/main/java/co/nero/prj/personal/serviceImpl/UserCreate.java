package co.nero.prj.personal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.personal.service.PersonalVO;

public class UserCreate implements Command {
	PersonalVO personal = new PersonalVO();
	boolean b = false;

	@Override
	public void execute() {
		createId();
	}

	private void createId() {
		System.out.println("[회원가입 창입니다.]");
		System.out.println("*값은 필수항목입니다 !");
		idCheck();

		System.out.print("*Password를 입력해주세요 : ");
		do {
			personal.setPassword(scn.nextLine());
			if (personal.getPassword().equals("")) {
				System.out.print("*Password를 다시 입력해주세요 : ");
			} else {
				b = true;
			}
		} while(personal.getPassword().equals(""));

		
		System.out.print("*이름을 입력해주세요 : ");
		do {
			personal.setName(scn.nextLine());
			if (personal.getName().equals("")) {
				System.out.print("*이름을 다시 입력해주세요 : ");
			} else {
				b = true;
			}
		} while(personal.getName().equals(""));
		
		System.out.print("연락처를 입력해주세요(Enter입력시 미기입) : ");
		personal.setTel(scn.nextLine());

		System.out.print("주소를 입력해주세요(Enter입력시 미기입) : ");
		personal.setAddress(scn.nextLine());

		daops.UserCreate(personal);

		System.out.println("성공적으로 회원가입하셨습니다.\n");
	}

	private void idCheck() {
		List<PersonalVO> personals = new ArrayList<PersonalVO>();
		personals = daops.personalSelectList();

		while (!b) {
			System.out.print("*ID를 입력해주세요 : ");
			String newid = scn.nextLine();
			int check = 0;
			for (PersonalVO vo : personals) {
				if (newid.equals(vo.getId()))
					check = 1;
			}
			if (check == 0) {
				System.out.print("");
				personal.setId(newid);
				b = true;
			} else {
				System.out.println("\n이미 존재하는 ID입니다.");
			}
		}

	}

}
