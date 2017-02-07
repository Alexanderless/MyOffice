package com.beifeng.biz.sm;

import java.util.List;

import com.beifeng.model.Loginlog;
import com.beifeng.model.Time;

public interface ILoginlogBiz {
	List<Loginlog> query(Time time);
	
	void delete(int[] ids);

}
