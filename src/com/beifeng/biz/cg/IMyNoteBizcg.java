package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.MyNote;
import com.beifeng.model.Schedule;

public interface IMyNoteBizcg {
	//查看个人日程
	List<MyNote> queryMyNoteList(String userId);
	//添加便签
	void addMyNote(MyNote myNote);
	//删除便签
	void delMyNote(Integer noteId);
}
