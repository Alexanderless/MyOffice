package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.MyNote;

public interface IMyNoteDaocg {
	//²éÑ¯ËùÓĞ±ãÇ©
	List<MyNote> queryMyNoteList(String userId);
	//Ìí¼Ó±ãÇ©
	void addMyNote(MyNote myNote);
	//É¾³ı±ãÇ©
	void delMyNote(Integer noteId);
}
