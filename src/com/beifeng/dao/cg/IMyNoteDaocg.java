package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.MyNote;

public interface IMyNoteDaocg {
	//��ѯ���б�ǩ
	List<MyNote> queryMyNoteList(String userId);
	//��ӱ�ǩ
	void addMyNote(MyNote myNote);
	//ɾ����ǩ
	void delMyNote(Integer noteId);
}
