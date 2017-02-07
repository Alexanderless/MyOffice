package com.beifeng.controller.hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.hr.IBranchInfoBiz;
import com.beifeng.biz.hr.IDepartInfoBiz;
import com.beifeng.model.BranchInfo;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;

@Controller
public class DepartInfoHRController {
	@Autowired
	private IDepartInfoBiz iDepartInfoBiz;
	@Autowired 
	private IBranchInfoBiz iBranchInfoBiz;
	
	/*
	 * 分页显示
	 */
	@RequestMapping("queryPageDepartInfo")
	public ModelAndView queryPageDepartInfo(PageDepartInfo pageDepartInfo){
		if(pageDepartInfo.getCurrentPage()<1)
			pageDepartInfo.setCurrentPage(1);
		PageDepartInfo pdepInfo = iDepartInfoBiz.queryPageDepartInfo(pageDepartInfo);
		ModelAndView ma = new ModelAndView();
		ma.addObject("pdepInfo", pdepInfo);
		ma.setViewName("hr/DepartInfo");
		return ma;
	}
	/*
	 * 删除
	 */
	@RequestMapping("delDepartInfo")
	public String delDepartInfo(Integer id){
		iDepartInfoBiz.delDepartInfo(id);
		return "forward:queryPageDepartInfo.do";
	}
	/*
	 * 添加跳转页面
	 */
	@RequestMapping("goPageURL")
	public ModelAndView goPageURL(){
		List<BranchInfo> branchlist = iBranchInfoBiz.queryBranchInfo();
		ModelAndView ma = new ModelAndView();
		ma.setViewName("hr/addDepartInfo");
		ma.addObject("branchlist", branchlist);
		return ma;
	}
	
	@RequestMapping("addDepartInfo")
	public String addDepartInfo(DepartInfo departInfo){
		if(departInfo!=null){
			iDepartInfoBiz.addDepartInfo(departInfo);
		}
		return "forward:queryDepartInfo.do";	
	}
	/*
	 * 查询显示所有信息
	 */
	@RequestMapping("getTree")
	public ModelAndView getTree(){
		List<DepartInfo> departList = iDepartInfoBiz.queryDepartInfo();
		ModelAndView ma = new ModelAndView();
		ma.addObject("departList", departList);
		ma.setViewName("hr/getTree");
		return ma;
	}
	/*
	 * getztree
	 */
	@RequestMapping("getZtree")
	public ModelAndView getZtree(HttpServletResponse response){
		String json = iDepartInfoBiz.getJson();
		System.out.println(json);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView ma = new ModelAndView("hr/ztree");
		return ma;
	}
	
	/*
	 * 修改DepartInfo跳转页面
	 */
	@RequestMapping("updateDepartURL")
	public ModelAndView updateDepartURL(Integer id){
		DepartInfo departInfo = iDepartInfoBiz.queryDepartInfoById(id);
		List<BranchInfo> branchlist = iBranchInfoBiz.queryBranchInfo();
		ModelAndView ma = new ModelAndView();
		ma.addObject("departInfo", departInfo);
		ma.addObject("branchlist", branchlist);
		ma.setViewName("hr/updateDepart");
		return ma;
	}
	
}
