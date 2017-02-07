package com.beifeng.controller.hr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.hr.IDepartInfoBiz;
import com.beifeng.biz.hr.IRoleAndStateBiz;
import com.beifeng.biz.hr.IUserInfoBiz;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageUserInfo;
import com.beifeng.model.RoleInfo;
import com.beifeng.model.UserInfo;
import com.beifeng.model.UserState;

@Controller
public class UserInfoHRController {
	@Autowired
	private IUserInfoBiz iUserInfoBiz;
	
	@Autowired
	private IRoleAndStateBiz iRoleAndStateBiz;
	
	@Autowired
	private IDepartInfoBiz iDepartInfoBiz;
	
	/*
	 * 分页显示
	 */
	@RequestMapping("queryFindUserInfo")
	public ModelAndView queryUserInfo(PageUserInfo pageUserInfo){
		if(pageUserInfo.getCurrentPage()<1)
			pageUserInfo.setCurrentPage(1);
		PageUserInfo puInfo = iUserInfoBiz.queryPageUserInfo(pageUserInfo);
		ModelAndView ma = new ModelAndView();
		ma.addObject("puInfo", puInfo);
		ma.setViewName("hr/UserInfo");
		return ma;
	}
	/*
	 * 删除
	 */
	@RequestMapping("delUserInfo")
	public String delUserInfo(Integer id){
		iUserInfoBiz.delUserInfo(id);
		return "forward:queryFindUserInfo.do";
	}
	/*
	 * add跳转页面
	 */
	@RequestMapping("goUserInfo")
	public ModelAndView goUserInfo(){
		List<DepartInfo> listDep = iDepartInfoBiz.queryDepartInfo();
		List<RoleInfo> listRol = iRoleAndStateBiz.queryRole();
		List<UserState> listUser = iRoleAndStateBiz.queryUserState();
		ModelAndView ma = new ModelAndView();
		ma.addObject("listDep", listDep);
		ma.addObject("listRol", listRol);
		ma.addObject("listUser", listUser);
		ma.setViewName("hr/addUserInfo");
		return ma;
	}
	/*
	 * 添加
	 */
	@RequestMapping("addUserInfo")
	public String addUserInfo(HttpServletRequest req,UserInfo userInfo) throws IOException{	
		//上传
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			String path = req.getSession().getServletContext().getRealPath("/");// 获取真实路径
			String filename = file.getOriginalFilename();// 获取文件名	
			String str = filename.substring(filename.lastIndexOf('.'),filename.length());
			filename = userInfo.getUserId() + str;
			FileOutputStream os = new FileOutputStream(path + "upload/"
					+ filename);
			os.write(file.getBytes());
			os.close();
			userInfo.setPicPath("upload/" + filename);
			iUserInfoBiz.addUserInfo(userInfo);
		}		
		return "forward:queryFindUserInfo.do";
	}
	/*
	 * 修改跳转页
	 */
	@RequestMapping("updateUserInfoURL")
	public ModelAndView updateUserInfoURL(Integer id){
		UserInfo userInfo = iUserInfoBiz.queryUserInfoById(id);
		List<DepartInfo> listDep = iDepartInfoBiz.queryDepartInfo();
		List<RoleInfo> listRol = iRoleAndStateBiz.queryRole();
		List<UserState> listUser = iRoleAndStateBiz.queryUserState();
		
		ModelAndView ma = new ModelAndView();
		ma.addObject("listDep", listDep);
		ma.addObject("listRol", listRol);
		ma.addObject("listUser", listUser);
		ma.addObject("userInfo", userInfo);
		ma.setViewName("hr/updateUserInfo");
		return ma;
	}
	/*
	 * 修改
	 */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(HttpServletRequest req,UserInfo userInfo) throws IOException{
		iUserInfoBiz.updateUserInfo(userInfo);
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			String path = req.getSession().getServletContext().getRealPath("/");// 获取真实路径
			String filename = file.getOriginalFilename();// 获取文件名	
			String str = filename.substring(filename.lastIndexOf('.'),filename.length());
			filename = userInfo.getUserId() + str;
			FileOutputStream os = new FileOutputStream(path + "upload/"
					+ filename);
			os.write(file.getBytes());
			os.close();
			userInfo.setPicPath("upload/" + filename);
			iUserInfoBiz.updateUserInfo(userInfo);
		}
		return "forward:queryFindUserInfo.do";
	}
	/*
	 * 显示详情
	 */
	@RequestMapping("showUserInfo")
	public ModelAndView showUserInfo(Integer id){
		UserInfo userInfo = iUserInfoBiz.queryUserInfoById(id);
		ModelAndView ma = new ModelAndView();
		ma.addObject("userInfo", userInfo);
		ma.setViewName("hr/ShowUserInfo");
		return ma;
	}
	/*
	 * 返回json数据
	 */
	@RequestMapping("getJSONForAdd")
	@ResponseBody
	public List<UserInfo> getJSONForAdd(Integer id){
		List<UserInfo> list = iUserInfoBiz.queryUserInfoByIdForJSON(id);
		System.out.println(list.size());//size用在集合，length用在数组
		return list;
	}
}
