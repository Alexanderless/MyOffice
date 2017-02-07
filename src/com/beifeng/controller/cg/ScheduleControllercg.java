package com.beifeng.controller.cg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beifeng.biz.cg.IScheduleBizcg;
import com.beifeng.model.BranchInfo;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.Schedule;
import com.beifeng.model.UserInfo;


@Controller
@RequestMapping("/")
public class ScheduleControllercg {
	
	@Autowired
	private IScheduleBizcg iScheduleBiz;
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * ���ݴ����߲�ѯ�������ճ�
	 */
	
	@RequestMapping("queryScheduleListByName")
	public ModelAndView queryScheduleListByName(String userId,HttpServletRequest request){
		if(userId==null){
			userId=(String)request.getSession().getAttribute("userId");
		}else {
			userId="1001";
		}
		System.out.println(userId);
		List<Schedule> list=iScheduleBiz.query(userId);
		ModelAndView mv=new ModelAndView("cg/schedule");
		mv.addObject("list", list);
		return mv;
		
	}
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param Integer scheduleId
	 *����ScheduleId��ѯ�ճ�
	 */
	@RequestMapping("queryScheduleById")
	public ModelAndView queryScheduleById(Integer scheduleId){
		Schedule schedule=iScheduleBiz.queryScheduleById(scheduleId);
		System.out.println(schedule);
		ModelAndView mv =new ModelAndView("cg/editschedule");
		mv.addObject("list", schedule);
		return mv;
	}
	/**
	 * @author candya
	 * @return ModelAndView
	 * @param Schedule schedule
	 * ����ճ�
	 */
	
	@RequestMapping("addScheduleList")
	public String addScheduleList(Schedule schedule){
		iScheduleBiz.addScheduleList(schedule);
		//System.out.println(schedule);
		/*ModelAndView mv=new ModelAndView("cg/index");*/
		return "redirect:queryScheduleListByName.do?userId="+schedule.getUserInfo().getUserId();
	}
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param Schedule schedule
	 * ɾ���ճ�
	 */
	@RequestMapping("delSchedule")
	public String delSchedule(Integer scheduleId){
		iScheduleBiz.delSchedule(scheduleId);
		/*ModelAndView mv=new ModelAndView("cg/index");*/
		 return "redirect:queryScheduleListByName.do";
	}
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param Integer scheduleId
	 * �޸��ճ�
	 */
	
	@RequestMapping("updateSchedule")
	public String updateSchedule(Schedule schedule){
		/*MeetingInfo mi=iMeetingInfoBiz.queryMeetInfoByName(schedule.getMeetingInfo().getMeetingName());
		schedule.setMeetingInfo(mi);*/
		iScheduleBiz.updateSchedule(schedule);
		/*ModelAndView mv=new ModelAndView("cg/index");*/
		return "redirect:queryScheduleListByName.do?userId="+schedule.getUserInfo().getUserId();
	}
	
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param String createUser
	 * ��ת�����ҳ��
	 */
	@RequestMapping("goEdit")
	public ModelAndView goEdit(String createUser){
		System.out.println(createUser);
		ModelAndView mv=new ModelAndView("cg/addschedule");
		mv.addObject("createUser", createUser);
		return mv;
	}
	/**
	 * @author candy
	 * @return ModelAndView
	 * @param Integer DepartId
	 * ��ѯ��������Ա���ճ�
	 */
	@RequestMapping("queryScheduleByMany")
	@ResponseBody
	public List<Schedule> queryScheduleByMany(HttpServletRequest request){
		Schedule schedule=new Schedule();
		DepartInfo depart=new DepartInfo();
		UserInfo user=new UserInfo();
		BranchInfo branch=new BranchInfo();
		//��ȡ������Ĳ���
		String departId=request.getParameter("departId");
		String branchId=request.getParameter("branchId");
		String userId=request.getParameter("userId");
		String createTime=request.getParameter("createTime");
		System.out.println(departId);
		System.out.println(branchId);
		System.out.println(userId);
		System.out.println(createTime);
		
		//���ò���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=sdf.parse(createTime);
			schedule.setCreateTime(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		branch.setBranchId(Integer.parseInt(branchId));
		depart.setDepartId(Integer.parseInt(departId));
		user.setUserId(userId);
		schedule.setBranchInfo(branch);
		schedule.setDepartInfo(depart);
		schedule.setUserInfo(user);
		System.out.println(schedule);
		List<Schedule> list=iScheduleBiz.queryScheduleByMany(schedule);	
		System.out.println("list************-----"+list);
		/*ModelAndView mv=new ModelAndView("cg/resultSchedule");
		mv.addObject("list",, list);*/
		return list;
		
		
	}
	

}
