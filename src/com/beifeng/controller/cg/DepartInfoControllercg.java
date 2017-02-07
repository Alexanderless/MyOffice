package com.beifeng.controller.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.cg.IDepartInfoBizcg;
import com.beifeng.model.DepartInfo;

@Controller
@RequestMapping("/")
public class DepartInfoControllercg {
	
	@Autowired
	private IDepartInfoBizcg iDepartInfoBiz;
	
	/**
	 * 
	 *@author candy
	 *@return ModelAndView
	 * 
	 * 
	*/
	@RequestMapping("goDepart")
	public ModelAndView goDepart(){
		ModelAndView mv=new ModelAndView("cg/departinfo");
		return mv;
	}
	/**
	 * 
	 *@author candy
	 *@return List<DepartInfo>
	 * 
	 * 
	*/
	@ResponseBody
	@RequestMapping("queryDepList")
	public List<DepartInfo> queryDepList(Integer branchId){
		List<DepartInfo> list=iDepartInfoBiz.queryDepList(branchId);
		return list;
		
		
	}
}
