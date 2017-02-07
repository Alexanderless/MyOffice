package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IMyNoteBizcg;
import com.beifeng.dao.cg.IMyNoteDaocg;
import com.beifeng.model.MyNote;
import com.beifeng.model.Schedule;
@Service
public class IMyNoteBizImplcg implements IMyNoteBizcg{
	
	@Autowired
	private IMyNoteDaocg iMyNoteDao;
	//��ѯ���б�ǩ
	@Override
	public List<MyNote> queryMyNoteList(String userId) {
		
		return iMyNoteDao.queryMyNoteList(userId);	
	}
	//��ӱ�ǩ
	@Override
	public void addMyNote(MyNote myNote) {
		iMyNoteDao.addMyNote(myNote);
		
	}
	
	//ɾ����ǩ
	@Override
	public void delMyNote(Integer noteId) {
		iMyNoteDao.delMyNote(noteId);
		
	}

	
	
}
