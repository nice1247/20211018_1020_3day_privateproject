package co.nero.prj.personal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.nero.prj.comm.Command;
import co.nero.prj.personal.service.PersonalVO;

public class clientList implements Command {

	@Override
	public void execute() {
		System.out.println("\n[고객명단입니다.]");
		System.out.println("ID : 이름 :      연락처      :  주소 ");
		list();
		System.out.println("[고객명단 끝]\n");
	}
	public void list() {
		List<PersonalVO> personals = new ArrayList<PersonalVO>();
		personals = daops.personalSelectList();
		for (PersonalVO vo : personals) {
			System.out.print(vo.getId() + " : ");
			System.out.print(vo.getName() + " : ");
			System.out.print(vo.getTel() + " : ");
			System.out.println(vo.getAddress());
		}
	}
}
