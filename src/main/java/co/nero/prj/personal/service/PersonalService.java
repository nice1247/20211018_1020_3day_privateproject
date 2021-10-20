package co.nero.prj.personal.service;

import java.util.List;

public interface PersonalService {
	List<PersonalVO> personalSelectList();
	PersonalVO personalSelect(PersonalVO vo);
	int personalInsert(PersonalVO vo);
	int personalUpdate(PersonalVO vo);
	int personalDelete(PersonalVO vo);
	PersonalVO loginCheck(PersonalVO vo);
	int UserCreate(PersonalVO vo);
	int clientUpdate(PersonalVO vo);
	int clientDelete(PersonalVO vo);

}
