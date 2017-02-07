package com.beifeng.controller.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beifeng.biz.cg.IUserInfoBizcg;
import com.beifeng.model.UserInfo;

@Controller
@RequestMapping("/")
public class UserInfoControllercg {
	@Autowired
	private IUserInfoBizcg iUserInfoBiz;
	
	/**
	 * 
	 * @author candy
	 * @return List<UserInfo>
	 * 
	*/
	
	@ResponseBody
	@RequestMapping("queryUserInfo")
	public List<UserInfo> queryUserInfo(Integer departId){
		System.out.println(departId);
		List<UserInfo> list=iUserInfoBiz.queryUserInfo(departId);
		System.out.println("**************"+list);
		return list;
	}
}
