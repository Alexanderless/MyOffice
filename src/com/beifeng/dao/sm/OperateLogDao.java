package com.beifeng.dao.sm;

import java.util.List;

import com.beifeng.model.OperateLog;
import com.beifeng.model.Time;

public interface OperateLogDao {
	/*
	 * 查询操作信息
	 */
	List<OperateLog> searchOpe(Time time);
	
	void delete(int[] ids);

}
