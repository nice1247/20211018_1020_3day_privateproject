package co.nero.prj.comm;

import java.util.Scanner;

import co.nero.prj.personal.service.PersonalService;
import co.nero.prj.personal.serviceImpl.PersonalServiceImpl;
import co.nero.prj.room.service.RoomService;
import co.nero.prj.room.serviceImpl.RoomServiceImpl;

public interface Command {
	public PersonalService daops = new PersonalServiceImpl();
	public RoomService daors = new RoomServiceImpl();
	public void execute();
	public Scanner scn = new Scanner(System.in);

}
