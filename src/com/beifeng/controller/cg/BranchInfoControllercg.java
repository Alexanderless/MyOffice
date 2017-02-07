package com.beifeng.controller.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beifeng.biz.cg.IBranchInfoBizcg;
import com.beifeng.model.BranchInfo;

@Controller
@RequestMapping("/")
public class BranchInfoControllercg {
	
	@Autowired
	private IBranchInfoBizcg iBranchInfoBiz;
	
	@ResponseBody
	@RequestMapping("queryBranch")
	public List<BranchInfo> queryBranch(){
		List<BranchInfo> list=iBranchInfoBiz.queryBranch();
		return list;
	}
	
}
