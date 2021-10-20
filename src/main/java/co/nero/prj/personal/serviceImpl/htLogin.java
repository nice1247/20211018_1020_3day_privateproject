package co.nero.prj.personal.serviceImpl;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.service.PersonalVO;

public class htLogin implements Command {
	
	@Override
	public void execute() {
		PersonalVO vo = new PersonalVO();
		boolean b = false;
		System.out.println("[로그인 화면입니다.]");
		do {
			vo = new PersonalVO();
			System.out.print("ID : ");
			String lgid = scn.nextLine();
			System.out.print("Password : ");
			String lgpwd = scn.nextLine();
			vo.setId(lgid);
			vo.setPassword(lgpwd);
			

			vo = daops.loginCheck(vo);
			if (vo != null && lgid.equals(vo.getId()) && lgpwd.equals(vo.getPassword())) {
				System.out.println("로그인하셨습니다.");
				LoginSt.NAME = vo.getName();
				LoginSt.AUTHOR = vo.getAuthor();
				LoginSt.ID = vo.getId();

				b = true;

			} else {
				System.out.println("ID 또는 패스워드가 틀렸습니다.");
			}

		} while (!b);
		

	}

}
