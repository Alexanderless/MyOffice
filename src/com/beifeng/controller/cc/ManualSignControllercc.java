package com.beifeng.controller.cc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.cc.IManualSignBizcc;
import com.beifeng.model.ManualSign;
import com.beifeng.model.UserInfo;

@Controller
@RequestMapping("/")
public class ManualSignControllercc {
	@Autowired
	private IManualSignBizcc iManualSignBiz;
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param String userId
	 * 根据创建者查询其签卡
	 * 
	 */

	@RequestMapping("queryManByUserId")
	public ModelAndView queryManByUserId(Integer signId){
		System.out.println(signId);
		ManualSign manualSign=iManualSignBiz.queryManByUserId(signId);
		/*System.out.println("==============="+userId);
		System.out.println("==============="+list);*/
		System.out.println(manualSign);
		ModelAndView mv=new ModelAndView("cc/sign");
		mv.addObject("manualSign", manualSign);
		return mv;
		
	}
	/**
	 * @author candy
	 * @param ManualSign
	 * 插入数据
	 * 
	*/
	
	@RequestMapping("insertManualSign")
	public String insertManualSign(HttpServletRequest request, ManualSign manualSign){
		String signTime=request.getParameter("signTime");
		System.out.println(signTime);
		System.out.println(manualSign);
		iManualSignBiz.insertManualSign(manualSign);
		System.out.println(manualSign.getSignId());
		return "redirect:queryManByUserId.do?signId="+manualSign.getSignId();
		
	}
	
	/**
	 * @author candy
	 * 
	 * 转到manualsign.jsp页面
	 * 
	*/
	@RequestMapping("goAdd")
	public ModelAndView goAdd(){
		ModelAndView mv=new ModelAndView("cc/manualsign");
		return mv;
	}
}
