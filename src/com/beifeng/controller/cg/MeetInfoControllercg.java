package com.beifeng.controller.cg;

import java.util.List;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.cg.IMeetingInfoBizcg;
import com.beifeng.model.MeetingInfo;


@Controller
@RequestMapping("/")
public class MeetInfoControllercg {
	
	@Autowired
	private IMeetingInfoBizcg iMeetingInfoBiz;
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param String meetingName
	 * 
	 * 
	*/
	@RequestMapping("queryMeetInfoByName")
	public ModelAndView queryMeetInfoByName(String meetingName){
		MeetingInfo meetingInfo=iMeetingInfoBiz.queryMeetInfoByName(meetingName);
		System.out.println(meetingInfo);
		ModelAndView mv=new ModelAndView("cg/index");
		
		return mv;
		
	}
	/**
	 * @author candy
	 * @return ModelAndView
	 * 
	 * 
	*/
	@ResponseBody
	@RequestMapping("queryMeetInfo")
	public List<MeetingInfo> queryMeetInfo(){
		List<MeetingInfo> list=iMeetingInfoBiz.queryMeetInfo();
		//System.out.println(list.get(1));
		return list;
	}
	
}
