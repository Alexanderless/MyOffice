package com.beifeng.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beifeng.biz.login.IUserInfoBiz;
import com.beifeng.model.UserInfo;

@Controller
public class UserInfoController {
	@Autowired
	private IUserInfoBiz iUserInfoBiz;
	
	@RequestMapping("queryUserInf")
	public String queryUserInfo(UserInfo userInfo){
		UserInfo user= iUserInfoBiz.query(userInfo);		
		if(user.getRoleInfo().getRoleId()==1){
			return "redirect:myoffice/index.html";
		}
		else{
			return "redirect:myoffice/index1.html";
		}		
	}
	
	@RequestMapping("getJson")
	@ResponseBody
	public List<UserInfo> getJson(UserInfo userInfo){
		List<UserInfo> list = iUserInfoBiz.getJson(userInfo);
		return list;
	}
	
}
