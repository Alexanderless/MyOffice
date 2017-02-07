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
	 * ��ҳ��ʾ
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
	 * ɾ��
	 */
	@RequestMapping("delUserInfo")
	public String delUserInfo(Integer id){
		iUserInfoBiz.delUserInfo(id);
		return "forward:queryFindUserInfo.do";
	}
	/*
	 * add��תҳ��
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
	 * ���
	 */
	@RequestMapping("addUserInfo")
	public String addUserInfo(HttpServletRequest req,UserInfo userInfo) throws IOException{	
		//�ϴ�
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			String path = req.getSession().getServletContext().getRealPath("/");// ��ȡ��ʵ·��
			String filename = file.getOriginalFilename();// ��ȡ�ļ���	
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
	 * �޸���תҳ
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
	 * �޸�
	 */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(HttpServletRequest req,UserInfo userInfo) throws IOException{
		iUserInfoBiz.updateUserInfo(userInfo);
		MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) req;
		MultipartFile file = mreq.getFile("file");
		if (file != null) {
			String path = req.getSession().getServletContext().getRealPath("/");// ��ȡ��ʵ·��
			String filename = file.getOriginalFilename();// ��ȡ�ļ���	
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
	 * ��ʾ����
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
	 * ����json����
	 */
	@RequestMapping("getJSONForAdd")
	@ResponseBody
	public List<UserInfo> getJSONForAdd(Integer id){
		List<UserInfo> list = iUserInfoBiz.queryUserInfoByIdForJSON(id);
		System.out.println(list.size());//size���ڼ��ϣ�length��������
		return list;
	}
}
