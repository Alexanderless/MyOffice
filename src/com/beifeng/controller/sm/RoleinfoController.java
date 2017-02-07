package com.beifeng.controller.sm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.sm.impl.IRoleinfoBizImpl;
import com.beifeng.model.RoleInfo;

@Controller
@RequestMapping("sm/")
public class RoleinfoController {
	@Autowired
	private IRoleinfoBizImpl iRoleinfoBizImpl;
	/*
	 * 查询全部角色信息
	 */
	@RequestMapping("query")
	public ModelAndView query() {
		ModelAndView mv=new ModelAndView("sm/RoleManager");
		List<RoleInfo> list=iRoleinfoBizImpl.query();
		if(list.size()==0){
			list=null;
		}
		mv.addObject("list", list);
		return mv;
	}
	
	
	/*
	 * 根据roleId查询角色信息
	 */
	@RequestMapping("queryByroleId")
	public ModelAndView queryByroleId(Integer roleId){
		RoleInfo roleinfo= iRoleinfoBizImpl.queryByroleId(roleId);
		ModelAndView mv=new ModelAndView("sm/Roleinp");
		mv.addObject("roleinfo", roleinfo);
		return mv;		
	}
	/*
	 * 修改角色
	 */
	@RequestMapping("update")
	public ModelAndView update(RoleInfo roleinfo) {
		iRoleinfoBizImpl.update(roleinfo);
		ModelAndView mv=new ModelAndView("sm/MyJsp");
		return mv;

	}
	/*
	 * 删除角色
	 */
	@RequestMapping("delete")
	public String delete(Integer roleId) {
		RoleInfo roleinfo=iRoleinfoBizImpl.queryByroleId(roleId);
		roleinfo.setIfDelete(1);
		iRoleinfoBizImpl.update(roleinfo);
		return "redirect:query.do";
	}
}
