package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.MyNote;
import com.beifeng.model.Schedule;

public interface IMyNoteBizcg {
	//�鿴�����ճ�
	List<MyNote> queryMyNoteList(String userId);
	//��ӱ�ǩ
	void addMyNote(MyNote myNote);
	//ɾ����ǩ
	void delMyNote(Integer noteId);
}
