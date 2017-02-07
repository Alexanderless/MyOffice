package com.beifeng.dao.hr;

import java.util.List;

import com.beifeng.model.RoleInfo;
import com.beifeng.model.UserState;

public interface IRoleAndStateDao {
	//≤È—ØRole
	List<RoleInfo> queryRole();
	
	//≤È—Ø
	List<UserState> queryUserState();
}
