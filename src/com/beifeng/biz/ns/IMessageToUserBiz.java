package com.beifeng.biz.ns;


import java.util.List;

import com.beifeng.model.MessageToUser;

public interface IMessageToUserBiz {
	//查询所有
	MessageToUser queryMessageToUser(Integer id);
	
	//删除
	void delMessagetouser(Integer id);
	
	//修改是否已读
	void updateIfread(Integer id);
}
