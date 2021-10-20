package co.nero.prj.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.nero.prj.comm.Command;
import co.nero.prj.comm.LoginSt;
import co.nero.prj.personal.serviceImpl.UserCreate;
import co.nero.prj.personal.serviceImpl.clientDelete;
import co.nero.prj.personal.serviceImpl.clientList;
import co.nero.prj.personal.serviceImpl.clientUpdate;
import co.nero.prj.personal.serviceImpl.htLogin;
import co.nero.prj.personal.serviceImpl.myStatus;
import co.nero.prj.personal.serviceImpl.resInfo;
import co.nero.prj.personal.serviceImpl.roomState;
import co.nero.prj.room.serviceImpl.checkIn;
import co.nero.prj.room.serviceImpl.checkOut;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Command> map = new HashMap<String, Command>();

	public Menu() {
		map.put("roomState", new roomState());
		map.put("clientList", new clientList());
		map.put("resInfo", new resInfo());
		map.put("checkIn", new checkIn());
		map.put("myStatus", new myStatus());
		map.put("checkOut", new checkOut());
		map.put("htLogin", new htLogin());
		map.put("UserCreate", new UserCreate());
		map.put("clientUpdate", new clientUpdate());
		map.put("clientDelete", new clientDelete());
	}

	private void adminTitle() {
		System.out.println("[호텔 관리 목록]");
		System.out.println("1. 객실 현황");
		System.out.println("2. 고객 관리");
		System.out.println("3. 예약 정보");
		System.out.println("4. 메뉴나가기");
		System.out.println("[원하는 작업 번호를 선택하세요.]");
	}

	private void clientTitle() {
		System.out.println(LoginSt.NAME + "님 저희 호텔에 방문해 주신 것을 진심으로 감사드립니다.");
		System.out.println("1. 예약하기");
		System.out.println("2. 나의 예약정보보기");
		System.out.println("3. 체크아웃");
		System.out.println("4. 메뉴 나가기");
		System.out.println("[원하는 작업 번호를 선택하세요.]");
	}
	
	private void clientRUDTitle() {
		System.out.println("\n[고객 관리 창입니다.]");
		System.out.println("1. 전체 고객 리스트");
		System.out.println("2. 고객 정보 수정");
		System.out.println("3. 고객 정보 삭제");
		System.out.println("4. 메뉴 나가기");
		System.out.println("[원하는 작업 번호를 선택하세요.]");
	}
	
	private void loginTitle() {
		System.out.println("[호텔 메인 화면입니다.]");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
	}
	
	private void loginManagement() {
		while (true) {
			loginTitle();
			String key = sc.nextLine();
			if (key.equals("1")) {
				executeRun("htLogin");
				break;
			} else if (key.equals("2")) {
				executeRun("UserCreate");
			} else if (key.equals("3")) {
				close();
				System.exit(0);
				break;
			} else {
				System.out.println("!!! 잘못된 값을 입력하셨습니다.\n");
			}
		}
	}

	private void adminManagement() {
		while (true) {
			adminTitle();
			String key = sc.nextLine();
			if (key.equals("1")) {
				executeRun("roomState");
			} else if (key.equals("2")) {
				clientRUD();
			} else if (key.equals("3")) {
				executeRun("resInfo");
			} else if (key.equals("4")) {
				close();
				break;
			} else {
				System.out.println("!!! 잘못된 값을 입력하셨습니다.\n");
			}
		}
	}
	
	private void clientRUD() {
		while (true) {
			clientRUDTitle();
			String key = sc.nextLine();
			if (key.equals("1")) {
				executeRun("clientList");
			} else if (key.equals("2")) {
				executeRun("clientUpdate");
			} else if (key.equals("3")) {
				executeRun("clientDelete");
			} else if (key.equals("4")) {
				System.out.println("관리자 메뉴로 돌아갑니다.\n");
				break;
			} else {
				System.out.println("!!! 잘못된 값을 입력하셨습니다.\n");
			}
		}
	}

	private void clientManagement() {
		while (true) {
			clientTitle();
			String key = sc.nextLine();
			if (key.equals("1")) {
				executeRun("checkIn");
			} else if (key.equals("2")) {
				executeRun("myStatus");
			} else if (key.equals("3")) {
				executeRun("checkOut");
			} else if (key.equals("4")) {
				close();
				break;
			} else {
				System.out.println("!!! 잘못된 값을 입력하셨습니다.\n");
			}
		}
	}

	private void executeRun(String string) {
		Command command = map.get(string);
		command.execute();

	}

	public void login() {
		loginManagement();
	}
	
	public void run() {
		if (LoginSt.AUTHOR.equals("ADMIN")) {
			System.out.println("\n[" + LoginSt.NAME + "님 어서오십시오.]");
			adminManagement();
		} else {
			System.out.println("\n[" + LoginSt.NAME + "님 환영합니다.]");
			clientManagement();
		} 
	}

	private void close() {
		System.out.println("===시스템을 종료합니다.===");
		sc.close();
		Command.scn.close();
	}

}
