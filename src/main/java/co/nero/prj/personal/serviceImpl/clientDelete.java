package co.nero.prj.personal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.personal.service.PersonalVO;

public class clientDelete implements Command {
	PersonalVO personal = new PersonalVO();
	clientList clist = new clientList();
	boolean b = false;
	String del = null;

	@Override
	public void execute() {
		System.out.println("");
		b = false;
		del = null;
		clist.list();

		idCheck();
		if (!del.equals("")) {
			System.out.println("정말로 지우시겠습니까? (Y/N)");
			String b = scn.nextLine();
			if (b.equals("y") || b.equals("Y")) {
				personal.setId(del);
				daops.clientDelete(personal);
				System.out.println("정상적으로 삭제 되었습니다.");

			} else if (b.equals("n") || b.equals("N")) {
				System.out.println("메뉴화면으로 돌아갑니다.");
			} else {
				System.out.println("잘못 입력하셨습니다.\n메뉴화면으로 돌아갑니다.");
			}
		} else {
			System.out.println("입력하신 값이 없습니다.\n메뉴화면으로 돌아갑니다.");
		}

	}

	private void idCheck() {
		List<PersonalVO> personals = new ArrayList<PersonalVO>();
		personals = daops.personalSelectList();

		while (!b) {
			System.out.println("[지우실 고객의 ID를 입력해주세요.]");
			del = scn.nextLine();
			int check = 0;
			for (PersonalVO vo : personals) {
				if (del.equals(vo.getId()))
					check = 1;
			}
			if (check == 1) {
				System.out.print("");
				personal.setId(del);
				b = true;
			} else {
				System.out.println("\n존재하지 않는 ID입니다.");
			}
		}

	}

}
